package bookstore.model.service;

import java.util.WeakHashMap;

import bookstore.model.dao.impl.BookDaoImpl;
import bookstore.model.service.imple.BookServiceImpl;
import bookstore.model.service.imple.UserServiceImpl;

@SuppressWarnings("rawtypes")
public class ServiceFactory {

	private final static WeakHashMap<String,ICommonService> map = new WeakHashMap<>();
	
	public static ICommonService getService(String name) {
		ICommonService service = map.get(name);
		if(service != null)
			return service;
		return createService(name);
	}

	private synchronized static ICommonService createService(String name) {
		ICommonService service = null;
		if("book".equals(name)) {
			service = new BookServiceImpl();
			map.put(name, service);
		}
		if("user".equals(name)) {
			service = new UserServiceImpl();
			map.put(name, service);
		}
		return service;
	}
}
