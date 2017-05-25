package logic;

import java.sql.Timestamp;
import java.util.List;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopImpl implements Shop{
	
	@Autowired
	private UserCatalog userCatalog;
	
	@Autowired
	private ItemCatalog itemCatalog;
	
	@Autowired
	private SaleCatalog saleCatalog;;
	
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

	@Override
	public Cart getCart() {
		return new Cart();
	}

	@Override
	public Integer calculateTotalAmount(List<ItemSet> itemList) {
		
		int totalAmount = 0;
		for(ItemSet itemSet : itemList){
			int price = itemSet.getItem().getPrice().intValue();
			int quantity = itemSet.getQuantity().intValue();
			totalAmount = totalAmount+(price*quantity);
		}
		return new Integer(totalAmount);
	}

	@Override
	public void checkout(User user, Cart cart) {
		Sale sale = createSale(user, cart);
		entrySale(sale);
	}
	
	private Timestamp getCurrentTime() {
		return new Timestamp(Calendar.getInstance().getTimeInMillis());
	}
	
	private void entrySale(Sale sale){
		this.saleCatalog.entrySale(sale);
	}
	
	private Sale createSale(User user, Cart cart){return new Sale();}
	
	private Integer getNewSaleId(){
		return this.saleCatalog.getNewSaleId();
	}
	
	private SaleLine createSaleLine(Sale sale, int saleLineId, ItemSet itemSet, Timestamp currentTime){
		return new SaleLine(sale, new Integer(saleLineId), itemSet, currentTime);
	}
}
