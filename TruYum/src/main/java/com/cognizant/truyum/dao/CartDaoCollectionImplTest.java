package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws CartEmptyException {
		CartDaoCollectionImplTest test= new CartDaoCollectionImplTest();
		test.testAddCartItem();
		test.testGetAllCartItems();
		test.testRemoveCartItem();

	}

	public void testAddCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 1);
		List<MenuItem> allCartItems = cartDao.getAllCartItems(1);
		System.out.println(allCartItems);

	}

	public void testGetAllCartItems() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		List<MenuItem> allCartItems = cartDao.getAllCartItems(1);
		System.out.println(allCartItems);

		

	}

	public void testRemoveCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1, 1);
		List<MenuItem> allCartItems = cartDao.getAllCartItems(1);
		System.out.println(allCartItems);

	}

}
