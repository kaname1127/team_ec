package com.internousdev.bioral.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.bioral.util.DBConnector;
import com.internousdev.bioral.util.DateUtil;

public class ProductUpdateCompleteDAO {
	private DateUtil dateUtil = new DateUtil();

	public int productDetailUpdate(int productid, String productName, String productNameKana, String productDescription,
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

}
