package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	@Override
	public List<MenuItem> getMenuItemListAdmin() {

		Connection connection = ConnectionHandler.getConnection();
		List<MenuItem> menulist = new ArrayList<>();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement("select * from menu");
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				long id = rs.getLong(1);
				String dish = rs.getString(2);
				long price = rs.getLong(3);
				boolean active = rs.getBoolean(4);
				Date dateofLaunch = rs.getDate(5);
				String category = rs.getString(6);
				boolean freeDelivery = rs.getBoolean(7);
				MenuItem menu = new MenuItem(id, dish, price, active, new java.util.Date(dateofLaunch.getTime()),
						category, freeDelivery);
				menulist.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menulist;

	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> menulist = new ArrayList<>();
		String sql = "select * from menu where active=1 and dateOfLaunch < CURDATE()";
		PreparedStatement statement;
		try {
			statement = con.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				long id = rs.getLong(1);
				String dish = rs.getString(2);
				long price = rs.getLong(3);
				boolean active = rs.getBoolean(4);
				Date dateofLaunch = rs.getDate(5);
				String category = rs.getString(6);
				boolean freeDelivery = rs.getBoolean(7);
				MenuItem menu = new MenuItem(id, dish, price, active, new java.util.Date(dateofLaunch.getTime()),
						category, freeDelivery);
				menulist.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return menulist;

	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		Connection con = ConnectionHandler.getConnection();
		String sql = "update menu set name=?,price=?,active=?,dateOfLaunch=?,category=?,freeDelivery=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, menuItem.getName());
			ps.setFloat(2, menuItem.getPrice());
			ps.setBoolean(3, menuItem.isActive());
			ps.setDate(4, new java.sql.Date(menuItem.getDateOfLaunch().getTime()));
			ps.setString(5, menuItem.getCategory());
			ps.setBoolean(6, menuItem.isFreeDelivery());
			ps.setLong(7, menuItem.getId());

			int rs = ps.executeUpdate();
			System.out.println("Total record updated: " + rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		MenuItem menuitem = null;
		try {
			String sql = "select * from menu where id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, menuItemId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long id = rs.getLong(1);
				String dish = rs.getString(2);
				long price = rs.getLong(3);
				boolean active = rs.getBoolean(4);
				Date dateofLaunch = rs.getDate(5);
				String category = rs.getString(6);
				boolean freeDelivery = rs.getBoolean(7);
				menuitem = new MenuItem(id, dish, price, active, new java.util.Date(dateofLaunch.getTime()), category,
						freeDelivery);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return menuitem;
	}

}
