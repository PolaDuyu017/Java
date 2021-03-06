package logic;

import java.util.List;

import dao.ItemDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCatalogImpl implements ItemCatalog{
	
	@Autowired
	private ItemDao itemDao;

	@Override
	public List<Item> getItemList() {
		return this.itemDao.findAll();
	}

	@Override
	public Item getItemByItemId(Integer itemId) {
		return this.itemDao.findByPrimaryKey(itemId);
	}
	
	
}
