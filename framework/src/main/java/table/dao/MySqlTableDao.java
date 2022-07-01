package table.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import table.annotation.Component;
import table.vo.Table;

@Component("tableDao")
public final class MySqlTableDao implements TableDao {
	DataSource ds;
	
	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public List<Table> selectList() throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt
					.executeQuery("SELECT no, titile, content, startDate, endDate, state, createDate, tags" + " FROM form_table" + " ORDER BY PNO DESC");

			ArrayList<Table> Tables = new ArrayList<Table>();

			while (rs.next()) {
				Tables.add(new Table().setNo(rs.getInt("no")).setTitle(rs.getString("titile")).setContent(rs.getString("content"))
						.setStartDate(rs.getDate("startDate")).setEndDate(rs.getDate("endDate")).setState(rs.getInt("state"))
						.setCreatedDate(rs.getDate("createDate")).setTags(rs.getString("tags")));
						
			}

			return Tables;

		} catch (Exception e) {
			throw e;

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public int insert(Table Table) throws Exception {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement("INSERT INTO form_table"
					+ "(titile, content, startDate, endDate, state, createDate, tags)" + " VALUES (?,?,?,?,0,NOW(),?)");
			stmt.setString(1, Table.getTitle());
			stmt.setString(2, Table.getContent());
			stmt.setDate(3, new java.sql.Date(Table.getStartDate().getTime()));
			stmt.setDate(4, new java.sql.Date(Table.getEndDate().getTime()));
			stmt.setString(5, Table.getTags());

			return stmt.executeUpdate();

		} catch (Exception e) {
			throw e;

		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
		}
	}

	@Override
	public Table selectOne(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(Table Table) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
