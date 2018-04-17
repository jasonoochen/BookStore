package bookstore.model.service.imple;

import java.io.Serializable;
import java.util.List;

import bookstore.model.dao.DaoFactory;
import bookstore.model.entity.Book;

@SuppressWarnings("unchecked")
public class BookServiceImpl extends CommonServiceImpl<Book> {

	@Override
	public List<Book> findAll() {
		return DaoFactory.getDao("book").findAll();
	}

	@Override
	public Book findById(int id) {
		return (Book) DaoFactory.getDao("book").findById(id);
	}

	
}
