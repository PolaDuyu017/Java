package logic;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopImpl implements Shop{
	
	@Autowired
	private UserCatalog userCatalog;
	
	@Autowired
	private ItemCatalog itemCatalog;
	
	@Override
	public void entryUser(User user) {
		this.userCatalog.entryUser(user);
	}

	@Override
	public User getUserByUserIdAndPassword(String userId, String password) {
		return this.userCatalog.getUserByUserIdAndPassword(userId, password);
	}

	@Override
	public List<Item> getItemList() {
		return this.itemCatalog.getItemList();
	}

	@Override
	public Item getItemByItemId(Integer itemId) {
		return this.itemCatalog.getItemByItemId(itemId);
	}
	
	
}
