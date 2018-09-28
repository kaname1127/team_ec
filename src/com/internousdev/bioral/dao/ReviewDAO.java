package com.internousdev.bioral.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.internousdev.bioral.dto.ReviewInfoDTO;
import com.internousdev.bioral.util.DBConnector;

public class ReviewDAO {

	public int postReview(String product_id, String user_name, String title, String point, String review_comment) {
		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		int count = 0;
		String sql = "insert into review_info(product_id, user_name, title, point, review_comment, insert_date) values (?, ?, ?, ?, ?, now())";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, product_id);
			preparedStatement.setString(2, user_name);
			preparedStatement.setString(3, title);
			preparedStatement.setString(4, point);
			preparedStatement.setString(5, review_comment);

			count = preparedStatement.executeUpdate();
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	public List<ReviewInfoDTO> getReviewInfoList() {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		List<ReviewInfoDTO> ReviewInfoDTOList = new ArrayList<ReviewInfoDTO>();

		String sql = "select * from review_info";

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				ReviewInfoDTO ReviewInfoDTO = new ReviewInfoDTO();

				ReviewInfoDTO.setId(resultSet.getInt("id"));
				ReviewInfoDTO.setProductId(resultSet.getInt("product_id"));
				ReviewInfoDTO.setUserName(resultSet.getString("user_name"));
				ReviewInfoDTO.setTitle(resultSet.getString("title"));
				ReviewInfoDTO.setPoint(resultSet.getString("point"));
				ReviewInfoDTO.setReviewComment(resultSet.getString("review_comment"));
				ReviewInfoDTO.setInsertDate(resultSet.getDate("insert_date"));

				ReviewInfoDTOList.add(ReviewInfoDTO);

				// レビューが取得できているかコンソール出力で確認---------
				System.out.println(resultSet.getInt("id"));
				System.out.println(resultSet.getInt("product_id"));
				System.out.println(resultSet.getString("user_name"));
				System.out.println(resultSet.getString("title"));
				System.out.println(resultSet.getString("point"));
				System.out.println(resultSet.getString("review_comment"));
				System.out.println(resultSet.getDate("insert_date"));
				System.out.println("----------------------------------------------");
				// -----------------------------------------------------------
			}

			Iterator<ReviewInfoDTO> iterator = ReviewInfoDTOList.iterator(); //

			if (!(iterator.hasNext())) {
				ReviewInfoDTOList = null;
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ReviewInfoDTOList;

	}

}
