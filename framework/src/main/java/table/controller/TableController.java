package table.controller;

import java.util.Map;

import table.annotation.Component;
import table.bind.DataBinding;
import table.dao.TableDao;

@Component("/table/table.do")
public class TableController implements Controller, DataBinding {

	TableDao tabledao;
	
	public TableController setTableDao(TableDao tabledao) {
		this.tabledao = tabledao;
		return this;
	}
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"table", table.vo.Table.class
		};
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
//		Table table = (Table)model.get("table");	
//		if (table.getTitle() == null) {
//			return "/project/ProjectForm.jsp";
//		} else {
//			tabledao.insert(table);
//			return "redirect:list.do";	
//		}
		return "/table/table.jsp";
	}

}
