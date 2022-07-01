package mvc.controls;

import java.util.Map;

import mvc.annotation.Component;
import mvc.bind.DataBinding;
import mvc.dao.ProjectDao;

@Component("/project/delete.do")
public class ProjectDeleteController implements DataBinding, Controller {
	ProjectDao projectdao;
	
	public ProjectDeleteController setProjectDao(ProjectDao projectDao) {
		this.projectdao = projectDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[]{
			"no", Integer.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		Integer no = (Integer)model.get("no");
		projectdao.delete(no);
		return "redirect:list.do";
	}
}
