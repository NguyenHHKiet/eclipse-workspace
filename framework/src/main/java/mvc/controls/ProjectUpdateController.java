package mvc.controls;

import java.util.Map;

import mvc.annotation.Component;
import mvc.bind.DataBinding;
import mvc.dao.ProjectDao;
import mvc.vo.Project;

@Component("/project/update.do")
public class ProjectUpdateController implements Controller, DataBinding {
	ProjectDao projectDao;
	
	public ProjectUpdateController setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}
	
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[]{
			"no", Integer.class,
			"project", mvc.vo.Project.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		Project project = (Project)model.get("project");
		
		if (project.getTitle() == null) {
			Integer no = (Integer)model.get("no");
			Project detailInfo = projectDao.selectOne(no);
			model.put("project", detailInfo);
			return "/project/ProjectUpdateForm.jsp";
		}else {
			projectDao.update(project);
			return "redirect:list.do";
		}
	}

}
