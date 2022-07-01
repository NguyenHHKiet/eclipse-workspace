package table.dao;

import java.util.List;
import table.vo.Table;

public interface TableDao {
	List<Table> selectList() throws Exception;
	int insert(Table Table) throws Exception;
	Table selectOne(int no) throws Exception;
	int update(Table Table) throws Exception;
	int delete(int no) throws Exception;
}
