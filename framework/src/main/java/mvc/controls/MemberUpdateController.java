package mvc.controls;

import java.util.Map;

import mvc.annotation.Component;
import mvc.bind.DataBinding;
import mvc.dao.MySqlMemberDao;
import mvc.vo.Member;

@Component("/member/update.do")
public class MemberUpdateController implements Controller, DataBinding{

	MySqlMemberDao memberDao;

	public MemberUpdateController setMemberDao(MySqlMemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}

	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[]{
				"no", Integer.class,
				"member", mvc.vo.Member.class
		};
	}
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
//		MemberDao memberDao = (MemberDao)model.get("memberDao");
	    
		Member member = (Member)model.get("member");
	    if (member.getEmail() == null) { 
	      Integer no = (Integer)model.get("no");
	      Member detailInfo = memberDao.selectOne(no);
	      model.put("member", detailInfo);
	      return "/member/MemberUpdateForm.jsp";

	    } else { 
	      memberDao.update(member);
	      return "redirect:list.do";
	    }
	}

}
