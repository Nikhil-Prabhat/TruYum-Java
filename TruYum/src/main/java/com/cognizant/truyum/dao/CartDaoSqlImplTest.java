package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void main(String[] args) throws CartEmptyException {
		CartDaoSqlImplTest cart = new CartDaoSqlImplTest();
		cart.testAddCartItem();
		cart.testGetAllCartItem();
		cart.testRemoveCartItem();

	}

	public void testAddCartItem() {
		CartDao cartdao = new CartDaoSqlImpl();
		cartdao.addCartItem(1, 2);

	}

	public void testGetAllCartItem() throws CartEmptyException {
		CartDao cartdao = new CartDaoSqlImpl();
		List<MenuItem> allCartItems = cartdao.getAllCartItems(1);
		System.out.println(allCartItems);

	}

	public void testRemoveCartItem() {
		CartDao cartdao = new CartDaoSqlImpl();
		cartdao.removeCartItem(1, 2);

	}

}
