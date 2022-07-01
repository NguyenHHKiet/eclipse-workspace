package mvc.controls;

import java.util.Map;

import mvc.annotation.Component;
import mvc.bind.DataBinding;
import mvc.dao.ProjectDao;
import mvc.vo.Project;

@Component("/project/add.do")
public class ProjectAddController implements Controller, DataBinding {
	ProjectDao projectDao;
	
	public ProjectAddController setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
			"project", mvc.vo.Project.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		Project project = (Project)model.get("project");
		if (project.getTitle() == null) {
			return "/project/ProjectForm.jsp";
		} else {
			projectDao.insert(project);
			return "redirect:list.do";
		}
	}

}
