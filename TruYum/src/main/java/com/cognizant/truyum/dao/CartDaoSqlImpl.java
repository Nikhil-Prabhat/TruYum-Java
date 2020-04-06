package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userid, long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		String sql = "insert into cart values(?,?)";
		try {
			PreparedStatement ps = con.prepareCall(sql);
			ps.setLong(1, userid);
			ps.setLong(2, menuItemId);

			int rs = ps.executeUpdate();
			System.out.println("Total rows inserted: " + rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<MenuItem> getAllCartItems(long userid) throws CartEmptyException {
		Connection con = ConnectionHandler.getConnection();
		Cart cart = new Cart(new ArrayList<MenuItem>(), 0);
		String sql = "select * from menu where id in (select menuitemid from cart where userid=?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, userid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				long id = rs.getLong(1);
				String dish = rs.getString(2);
				float price = rs.getFloat(3);
				boolean active = rs.getBoolean(4);
				Date dateofLaunch = rs.getDate(5);
				String category = rs.getString(6);
				boolean freeDelivery = rs.getBoolean(7);
				MenuItem menu = new MenuItem(id, dish, price, active, new java.util.Date(dateofLaunch.getTime()),
						category, freeDelivery);
				cart.getMenuItemList().add(menu);
				cart.setTotal(cart.getTotal() + price);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cart.getMenuItemList();
	}

	@Override
	public void removeCartItem(long userid, long menuItemId) {

		Connection con = ConnectionHandler.getConnection();
		String sql = "delete from cart where menuitemid=? and userid=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, menuItemId);
			ps.setLong(2, userid);
			int rs = ps.executeUpdate();
			System.out.println("Total rows deleted: " + rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
