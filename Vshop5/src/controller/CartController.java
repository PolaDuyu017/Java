package controller;

import javax.servlet.http.HttpSession;

import logic.Cart;
import logic.Item;
import logic.ItemSet;
import logic.Shop;
import logic.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import utils.WebConstants;

@Controller
public class CartController {
	
	@Autowired
	private Shop shopService;
	
	@RequestMapping(value = "cart/cartAdd")
	public ModelAndView add(Integer itemId, Integer quantity, HttpSession session){
		
		Item selectItem = this.shopService.getItemByItemId(itemId);
		
		Cart cart = (Cart)session.getAttribute(WebConstants.CART_KEY);
		if(cart ==null){
			cart = this.shopService.getCart();
			session.setAttribute(WebConstants.CART_KEY, cart);
		}
		
		cart.push(new ItemSet(selectItem, quantity));
		
		ModelAndView modelAndView = new ModelAndView("cart/cart");
		modelAndView.addObject("message", selectItem.getItemName()+"을(를)"+quantity+"개 카트에 추가 했습니다.");
		modelAndView.addObject("cart", cart);
		
		User loginUser = (User)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser!=null){
			modelAndView.addObject("loginUser", loginUser);
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "cart/cartClear")
	public ModelAndView clear(HttpSession session){
		Cart cart = (Cart)session.getAttribute(WebConstants.CART_KEY);
		if(cart ==null){
			cart = this.shopService.getCart();
			session.setAttribute(WebConstants.CART_KEY, cart);
		}
		
		cart.clearAll();
		
		ModelAndView modelAndView = new ModelAndView("cart/cart");
		modelAndView.addObject("message", "카트를 비웠습니다.");
		
		User loginUser = (User)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser!=null){
			modelAndView.addObject("loginUser", loginUser);
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "cart/cartConfirm")
	public ModelAndView confirm(HttpSession session){
		Cart cart = (Cart)session.getAttribute(WebConstants.CART_KEY);
		if(cart ==null){
			cart = this.shopService.getCart();
			session.setAttribute(WebConstants.CART_KEY, cart);
		}
		
		ModelAndView modelAndView = new ModelAndView("cart/cart");
		modelAndView.addObject("cart", cart);
		
		User loginUser = (User)session.getAttribute(WebConstants.USER_KEY);
		if(loginUser!=null){
			modelAndView.addObject("loginUser", loginUser);
		}
		
		return modelAndView;
	}
}
