package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void main(String[] args) {
		MenuItemDaoCollectionImplTest menuCheck = new MenuItemDaoCollectionImplTest();
		menuCheck.testGetMenuItemListAdmin();
		menuCheck.testGetMenuItemListCustomer();
		menuCheck.testModifyMenuItem();

	}

	public void testGetMenuItemListAdmin() {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemListAdmin = menuItemDao.getMenuItemListAdmin();
		System.out.println(menuItemListAdmin);

	}

	public void testGetMenuItemListCustomer() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemListCustomer = menuItemDao.getMenuItemListCustomer();
		System.out.println(menuItemListCustomer);

	}

	public void testModifyMenuItem() {

		MenuItem menuCheck = new MenuItem(1, "Cheese Sandwich", (float) 99.00, true,
				DateUtil.convertToDate("15/03/2017"), "Main Course", true);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(menuCheck);
		MenuItem menuItem = menuItemDao.getMenuItem(1);
		System.out.println(menuItem);

	}

	public void testGetMenuItem() {

	}

}
