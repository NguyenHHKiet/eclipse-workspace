package mvc.controls;

import java.util.Map;

import mvc.annotation.Component;
import mvc.dao.ProjectDao;

@Component("/project/list.do")
public class ProjectListController implements Controller {
	ProjectDao projectDao;
	
	public ProjectListController setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		model.put("projects", projectDao.selectList());
		return "/project/ProjectList.jsp";
	}

}
