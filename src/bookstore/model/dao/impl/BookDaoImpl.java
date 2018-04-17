package bookstore.model.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bookstore.common.JdbcTemplate;
import bookstore.common.JdbcTemplate.PreparedStatementSetter;
import bookstore.common.JdbcTemplate.RowCallBackHandler;
import bookstore.common.JdbcTemplate.RowCallBackHandler.*;
import bookstore.model.entity.Book;

public class BookDaoImpl extends CommonDaoImpl<Book> {

	@Override
	public Book findById(int id) {
		String sql = "select * from books where id = ?";
		return JdbcTemplate.singleQuery(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setInt(1,id);	
			}
		}, createHandler());
	}
	
	private RowCallBackHandler<Book> createHandler(){
		return new RowCallBackHandler<Book>() {
			@Override
			public Book processRow(ResultSet rs) throws SQLException {
				Book book = new Book();
				book.setAuthor(rs.getString("author"));
				book.setAuhtoIntroduction(rs.getString("author_introduction"));
				book.setBookConcern(rs.getString("book_concern"));
				book.setDescription(rs.getString("description"));
				book.setGrade(rs.getInt("grade"));
				book.setId(rs.getInt("id"));
				book.setImage(rs.getString("image"));
				book.setInstruction(rs.getString("instruciton"));
				book.setIsbn(rs.getString("isbn"));
				book.setName(rs.getString("name"));
				book.setPublishingDate(rs.getTimestamp("publising_Date"));
				book.setPurchasePrice(rs.getFloat("purchase_price"));
				book.setSellingPrice(rs.getFloat("selling_price"));
				return book;
			}
		};
	}

	@Override
	public List<Book> findAll() {
		return JdbcTemplate.query("select * from books", createHandler());
	}

}
