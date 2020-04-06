package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {

	private static HashMap<Long, Cart> userCarts = null;

	public CartDaoCollectionImpl() {

		if (userCarts == null) {
			userCarts = new HashMap<>();

		}

	}

	@Override
	public void addCartItem(long userid, long menuItemId) {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if (userCarts.containsKey(userid)) {
			Cart cart = userCarts.get(userid);
			List<MenuItem> menuItemList = cart.getMenuItemList();
			menuItemList.add(menuItem);
			cart.setMenuItemList(menuItemList);
			userCarts.put(userid,cart);
		} else {
			List<MenuItem> m = new ArrayList<>();
			Cart cart = new Cart(m, 0.0);
			List<MenuItem> menuItemList = cart.getMenuItemList();
			menuItemList.add(menuItem);
			cart.setMenuItemList(menuItemList);
			userCarts.put(userid, cart);
		}

	}

	@Override
	public List<MenuItem> getAllCartItems(long userid) throws CartEmptyException {
		Cart cart = userCarts.get(userid);
		List<MenuItem> menuItemList = cart.getMenuItemList();
		if (menuItemList.isEmpty()) {
			throw new CartEmptyException("Cart is Empty");
		} else {
			double price = (float) 0.0;
			for (MenuItem menu : menuItemList) {
				price += menu.getPrice();
			}

			cart.setTotal(price);
			return menuItemList;
		}
	}

	@Override
	public void removeCartItem(long userid, long menuItemId) {

		Cart cart = userCarts.get(userid);
		List<MenuItem> menuItemList = cart.getMenuItemList();
		Iterator iterator = menuItemList.iterator();
		while (iterator.hasNext()) {
			MenuItem m = (MenuItem) iterator.next();
			if (m.getId() == menuItemId)
				iterator.remove();
		}

	}

}
