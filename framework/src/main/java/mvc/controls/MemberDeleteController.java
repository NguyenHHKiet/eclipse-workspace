package mvc.controls;

import java.util.Map;

import mvc.annotation.Component;
import mvc.bind.DataBinding;
import mvc.dao.MySqlMemberDao;

@Component("/member/delete.do")
public class MemberDeleteController implements Controller, DataBinding{

	MySqlMemberDao memberDao;

	public MemberDeleteController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
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
//		MemberDao memberDao = (MemberDao)model.get("memberDao");
	    
	    Integer no = (Integer)model.get("no");
	    memberDao.delete(no);
	    
	    return "redirect:list.do";
	}

}
