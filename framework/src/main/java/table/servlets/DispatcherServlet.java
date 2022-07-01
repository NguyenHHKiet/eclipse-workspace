package table.servlets;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import table.bind.DataBinding;
import table.bind.ServletRequestDataBinder;
import table.context.ApplicationContext;
import table.controller.Controller;
import table.listener.ContextLoaderListener;

//import mvc.bind.DataBinding;
//import mvc.bind.ServletRequestDataBinder;
//import mvc.context.ApplicationContext;
//import mvc.controls.Controller;
//import mvc.listeners.ContextLoaderListener;



// static resources 접근을 위해 확장자 url-pattern 사용
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO: 1. 요청 URL 확인
		String servletPath = request.getServletPath();
		try {
			// TODO: 2. Controller class 조회
//			ServletContext sc = this.getServletContext();
			ApplicationContext ctx = ContextLoaderListener.getApplicationContext();
			
			// TODO: 3. Controller 에게 전달할 Map 객체를 준비
			HashMap<String, Object> model = new HashMap<String, Object>();
			model.put("session", request.getSession());
			
			// TODO: 4. 요청 URL 에 따라 실행될 Controller instance 준비
//			Controller pageController = (Controller)sc.getAttribute(servletPath);
			Controller pageController = (Controller)ctx.getBean(servletPath);
			if (pageController == null) {
				throw new Exception("요청한 서비스를 찾을 수 없습니다.");
			}
			
			// TODO: 5. Controller 에게 필요한 data 를 넘겨주기 위한 binding 처리
			if (pageController instanceof DataBinding) {
				prepareRequestData(request, model, (DataBinding) pageController);
			}
			
			// TODO: 6. Controller 실행 
			String viewUrl = pageController.execute(model);
			
			// TODO: 7. Map 객체에 저장된 값을 ServletRequest 에 저장
			for (String key : model.keySet()) {
				request.setAttribute(key, model.get(key));
			}
			// TODO: 8. 응답 처리
			response.setContentType("text/html; charset=UTF-8");
			if (viewUrl.startsWith("redirect:")) {
				response.sendRedirect(viewUrl.substring(9));
				return;
			}else {
				RequestDispatcher rd = request.getRequestDispatcher(viewUrl);
				rd.include(request, response);
			}
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = 
					request.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * TODO: 5. request parameter 를 model 로 복사
	 * 
	 * @param request
	 * @param model
	 * @param dataBinding
	 * @throws Exception
	 */
	private void prepareRequestData(
			HttpServletRequest request, 
			HashMap<String, Object> model, DataBinding dataBinding)
			throws Exception {
		Object[] dataBinders = dataBinding.getDataBinders();
		String dataName = null;
		Class<?> dataType = null;
		Object dataObj = null;
		for (int i = 0; i < dataBinders.length; i += 2) {
			dataName = (String) dataBinders[i];
			dataType = (Class<?>) dataBinders[i + 1];
			dataObj = ServletRequestDataBinder.bind(request, dataType, dataName);
			model.put(dataName, dataObj);
		}
	}
}
