package bookstore.common;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTemplate {
	public static <T> List<T> query(String sql, RowCallBackHandler<T> handler){
		return query(sql,null,handler);
	}
	
	public static <T> List<T> query(String sql, PreparedStatementSetter setter, RowCallBackHandler<T> handler){
		ResultSet rs = null;
		List<T> list = null;
		try {
			rs = query(sql,setter);
			if(handler != null) {
				list = new ArrayList<>();
				while(rs.next()) {
					list.add(handler.processRow(rs));
				}
			}
		} catch (SQLException e) {
			throw new jdbcTemplateException(e);
		}finally {
			DBUtil.release(rs);
		}
		return list;
	}
	
	public static <T> T singleQuery(String sql,RowCallBackHandler<T> handler){
		return singleQuery(sql,null,handler);
	}
	
	public static <T> T singleQuery(String sql, PreparedStatementSetter setter, RowCallBackHandler<T> handler){
		ResultSet rs = null;
		try {
			rs = query(sql,setter);
			if(handler != null && rs.next()) {
				return handler.processRow(rs);
			}
		} catch (SQLException e) {
			throw new jdbcTemplateException(e);
		}finally {
			DBUtil.release(rs);
		}
		return null;
	}	
	
	private static ResultSet query(String sql, PreparedStatementSetter setter) throws SQLException {
		PreparedStatement pstmt = ConnectionManager.getConnection().prepareStatement(sql);
		if(null != setter)
			setter.setValues(pstmt);
		return pstmt.executeQuery();
	}
	
	public static int[] batch(String sql, PreparedStatementSetter...setters) {
		PreparedStatement pstmt = null;
		try {
			pstmt = ConnectionManager.getConnection().prepareStatement(sql);
			for (PreparedStatementSetter setter : setters)
				setter.setValues(pstmt);
			return pstmt.executeBatch();
		} catch (SQLException e) {
			throw new jdbcTemplateException(e);
		} finally {
			DBUtil.release(pstmt);
		}
	}

	public static int update(String sql, PreparedStatementSetter setter) {
		PreparedStatement pstmt = null;
		try {
			pstmt = ConnectionManager.getConnection().prepareStatement(sql);
			if (setter != null) {
				setter.setValues(pstmt);
			}
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.release(pstmt);
		}
		return 0;
	}
	
	public static class jdbcTemplateException extends RuntimeException{

		public jdbcTemplateException() {
			super();
		}

		public jdbcTemplateException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
			super(arg0, arg1, arg2, arg3);
		}

		public jdbcTemplateException(String arg0, Throwable arg1) {
			super(arg0, arg1);
		}

		public jdbcTemplateException(String arg0) {
			super(arg0);
		}

		public jdbcTemplateException(Throwable arg0) {
			super(arg0);
		}
		
	}

	public static interface PreparedStatementSetter {
		void setValues(PreparedStatement pstmt) throws SQLException;
	}

	public static interface RowCallBackHandler<T> {
		T processRow(ResultSet rs) throws SQLException;
	}
}
