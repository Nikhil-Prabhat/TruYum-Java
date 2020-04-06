package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void main(String[] args) {
		MenuItemDaoSqlImplTest test = new MenuItemDaoSqlImplTest();
		test.testGetMenuItemListAdmin();
		System.out.println("--------------------------------------------------");
		test.testGetMenuItemListCustomer();
		System.out.println("--------------------------------------------------");
		test.testModifyMenuItem();
		System.out.println("--------------------------------------------------");
		test.testModifyMenuItem();

	}

	public void testGetMenuItemListAdmin() {

		MenuItemDao menuitemdao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemListAdmin = menuitemdao.getMenuItemListAdmin();
		System.out.println(menuItemListAdmin);

	}

	public void testGetMenuItemListCustomer() {
		MenuItemDao menuitemdao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemListCustomer = menuitemdao.getMenuItemListCustomer();
		System.out.println(menuItemListCustomer);
	}

	public void testModifyMenuItem() {
		MenuItemDao menuitemdao = new MenuItemDaoSqlImpl();
		menuitemdao.modifyMenuItem(new MenuItem(1, "Chocolate Brownie", (float) 32.00, true,
				DateUtil.convertToDate("02/01/2022"), "Desserts", true));

	}

	public void testGetMenuItem() {
		MenuItemDao menuitemdao = new MenuItemDaoSqlImpl();
		MenuItem menuItem = menuitemdao.getMenuItem(1);
		System.out.println(menuItem);

	}

}
