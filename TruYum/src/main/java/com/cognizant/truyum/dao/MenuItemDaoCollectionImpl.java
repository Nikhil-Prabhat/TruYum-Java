package com.cognizant.truyum.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList = null;

	public MenuItemDaoCollectionImpl() {
		if (menuItemList == null) {
			menuItemList = new ArrayList<>();
			menuItemList.add(new MenuItem(1, "Sandwich", (float) 99.00, true, DateUtil.convertToDate("15/03/2017"),
					"Main Course", true));
			menuItemList.add(new MenuItem(2, "Burger", (float) 129.00, true, DateUtil.convertToDate("23/12/2017"),
					"Main Course", false));
			menuItemList.add(new MenuItem(3, "Pizza", (float) 149.00, true, DateUtil.convertToDate("21/08/2018"),
					"Main Course", false));
			menuItemList.add(new MenuItem(4, "French Fries", (float) 57.00, false, DateUtil.convertToDate("02/07/2017"),
					"Starters", true));
			menuItemList.add(new MenuItem(5, "Chocolate Brownie", (float) 32.00, true,
					DateUtil.convertToDate("02/01/2022"), "Desserts", true));

		}
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {

		return menuItemList;

	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> custMenu = new ArrayList<>();

		Date date1 = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String compDate = formatter.format(date1);
		Date currentDate = DateUtil.convertToDate(compDate);
		for (MenuItem menu : menuItemList) {
			if ((menu.getDateOfLaunch().compareTo(currentDate) < 0) && menu.isActive()) {
				custMenu.add(menu);
			}
		}

		return custMenu;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {

		for (MenuItem menu : menuItemList) {
			if (menu.getId() == menuItem.getId()) {
				menu.setName(menuItem.getName());
				menu.setPrice(menuItem.getPrice());
				menu.setActive(menuItem.isActive());
				menu.setCategory(menuItem.getCategory());
				menu.setDateOfLaunch(menuItem.getDateOfLaunch());
				menu.setFreeDelivery(menuItem.isFreeDelivery());

			}
		}

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {

		MenuItem menu1 = null;

		for (MenuItem menu : menuItemList) {
			if (menu.getId() == menuItemId) {
				menu1 = menu;
			}
		}

		return menu1;

	}

}
