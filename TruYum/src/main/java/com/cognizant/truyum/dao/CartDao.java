package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface CartDao {

	public void addCartItem(long userid, long menuItemId);

	public List<MenuItem> getAllCartItems(long userid) throws CartEmptyException;

	public void removeCartItem(long userid, long menuItemId);

}
