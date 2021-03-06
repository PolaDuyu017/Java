package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<ItemSet> itemList = new ArrayList<ItemSet>();
	
	public List<ItemSet> getItemList(){
		return this.itemList;
	}
	
	public boolean isEmpty(){
		if(this.itemList == null || this.itemList.isEmpty()){
			return true;
		}
		return false;
	}
	
	public void push(ItemSet pushedItemSet){
		
		boolean itemExistInCart = false;
		
		Item pushedItem = pushedItemSet.getItem();
		int pushedItemId = pushedItem.getItemId().intValue();
		
		for(ItemSet cartItemSet : this.itemList){
			Item cartItem = cartItemSet.getItem();
			int cartItemId = cartItem.getItemId().intValue();
			
			if(cartItemId == pushedItemId){
				cartItemSet.addQuantity(pushedItemSet.getQuantity());
				itemExistInCart = true;
				break;
			}
		}
		if (!itemExistInCart) {
			this.itemList.add(pushedItemSet);
		}
	}
	
	
	public void clearAll(){
		this.itemList = new ArrayList<ItemSet>();
	}
}	
