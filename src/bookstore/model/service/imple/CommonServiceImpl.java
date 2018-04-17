package bookstore.model.service.imple;

import java.io.Serializable;
import java.util.List;

import bookstore.model.service.ICommonService;

@SuppressWarnings("rawtypes")
public abstract class CommonServiceImpl<T extends Serializable> implements ICommonService {

	@Override
	public List<T> findAll() {
		return null;
	}

	@Override
	public Serializable findById(int id) {
		return null;
	}

	@Override
	public int save(Serializable t) {
		return 0;
	}

	@Override
	public List findByConditions(String... conditions) {
		return null;
	}
		
}
