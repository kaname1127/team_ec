package com.internousdev.bioral.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.bioral.util.DBConnector;
import com.internousdev.bioral.util.DateUtil;

public class CreateProductCompleteDAO {
	private DateUtil dateUtil = new DateUtil();

	public int createProduct(int productid, String productName, String productNameKana, String productDescription,
			int categoryId, int price, String releaseCompany, String releaseDate, int Status, String imageFilePath,
			String imageFileName) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count = 0;
		String sql = "insert into product_info(product_id, product_name, product_name_kana, product_description,"
				+ "category_id ,price ,release_company, release_date, status, image_file_path, image_file_name,  regist_date, update_date)"
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productid);
			preparedStatement.setString(2, productName);
			preparedStatement.setString(3, productNameKana);
			preparedStatement.setString(4, productDescription);
			preparedStatement.setInt(5, categoryId);
			preparedStatement.setInt(6, price);
			preparedStatement.setString(7, releaseCompany);
			preparedStatement.setString(8, releaseDate);
			preparedStatement.setInt(9, Status);
			preparedStatement.setString(10, imageFilePath);
			preparedStatement.setString(11, imageFileName);
			preparedStatement.setString(12, dateUtil.getDate());
			preparedStatement.setString(13, dateUtil.getDate());
			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return count;
	}

	public static int getMaxProductId() {

		int maxProductId = -1;

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT MAX(product_id) AS id FROM product_info";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				maxProductId = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return maxProductId;
	}

	public boolean checkProductInfo(String productName) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select id from product_info where product_name = ?";
		boolean Result = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, productName);
			ResultSet rs = ps.executeQuery();
			Result = rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return Result;

	}

	public boolean checkProductInfo2(String productNameKana) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "select id from product_info where product_name_kana = ?";
		boolean Result = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, productNameKana);
			ResultSet rs = ps.executeQuery();
			Result = rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return Result;

	}

	public boolean checkProductInfo3(int productId, String productName) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "select id from product_info where  product_id != ? and product_name = ?";
		boolean Result = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ps.setString(2, productName);
			ResultSet rs = ps.executeQuery();
			Result = rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return Result;

	}

	public boolean checkProductInfo4(int productId, String productNameKana) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		// product idが同じ物でない場合。そしてproductName_kanaで選択する
		String sql = "select id from product_info where  product_id != ? and product_name_kana = ?";
		boolean Result = false;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ps.setString(2, productNameKana);
			ResultSet rs = ps.executeQuery();
			Result = rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return Result;

	}

	// 管理者変更・編集機能時に使われるメソッド
	// AdminEditDetailsCompleteAction で使用。
	public int updateProductInfo(int productid, String productName, String productNameKana, String productDescription,
			int categoryId, int price, String releaseCompany, String releaseDate, String imageFilePath,
			String imageFileName) throws SQLException {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count = 0;

		String sql = "UPDATE product_info SET " + "product_name=? , " + "product_name_kana=? , "
				+ "product_description=? , " + "category_id=? , " + "price=? , " + "release_company=? , "
				+ "release_date=? , " + "image_file_path=? , " + "image_file_name=? , " + "regist_date=? , "
				+ "update_date=? " + "WHERE product_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productName);
			preparedStatement.setString(2, productNameKana);
			preparedStatement.setString(3, productDescription);
			preparedStatement.setInt(4, categoryId);
			preparedStatement.setInt(5, price);
			preparedStatement.setString(6, releaseCompany);
			preparedStatement.setString(7, releaseDate);
			preparedStatement.setString(8, imageFilePath);
			preparedStatement.setString(9, imageFileName);
			preparedStatement.setString(10, dateUtil.getDate());
			preparedStatement.setString(11, dateUtil.getDate());
			preparedStatement.setInt(12, productid);
			count = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return count;
	}

	// 管理者機能商品削除時に使われるメソッド
	public int delete(String productId) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int count = 0;
		String sql = "delete from product_info where product_id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productId);

			count = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// product_idを使用してその商品が存在しているかをBooleanで返すメソッド
	public boolean checkExist(int product_id) throws SQLException {
		boolean result = false;
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		String sql = "select * from product_info where product_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, product_id);
			ResultSet rs = preparedStatement.executeQuery();
			result = rs.next();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return result;
	}

}