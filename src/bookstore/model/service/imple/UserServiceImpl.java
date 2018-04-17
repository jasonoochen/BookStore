package bookstore.model.service.imple;

import java.io.Serializable;
import java.util.List;

import bookstore.model.dao.DaoFactory;
import bookstore.model.entity.Account;

public class UserServiceImpl<> extends CommonServiceImpl<T> {

	@Override
	public Account findById(int id) {
		return (Account) DaoFactory.getDao("user").findById(id);
	}
	
	@Override
	public int save(Account t) {
		return DaoFactory.getDao("user").save(t);
	}

	public List<Account> findByConditions(String...strings conditions){
		return DaoFactory.getDao("user").findByConditions(conditions);
	}
}
