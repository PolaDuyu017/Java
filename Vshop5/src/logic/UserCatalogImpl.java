package logic;

import dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCatalogImpl implements UserCatalog{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public void entryUser(User user) {
		this.userDao.create(user);
	}

	@Override
	public User getUserByUserIdAndPassword(String userId, String password) {
		return this.userDao.findByUserIdAndPassword(userId, password);
	}
}
