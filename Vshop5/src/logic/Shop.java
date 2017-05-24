package logic;

import java.util.List;

public interface Shop {
	
	void entryUser(User user);
	
	User getUserByUserIdAndPassword(String userId, String password);
	
	List<Item> getItemList();
	
	Item getItemByItemId(Integer itemId);
}
