package com.internousdev.bioral.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.internousdev.bioral.dto.MCategoryDTO;
import com.internousdev.bioral.util.DBConnector;

//coding by kobayashi 20180906

public class MCategoryDAO {

	public List<MCategoryDTO> getMCategoryList() {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();

		List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();

		String sql = "select * from m_category";

		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				MCategoryDTO mCategoryDTO = new MCategoryDTO();

				mCategoryDTO.setId(resultSet.getInt("id"));
				mCategoryDTO.setCategoryId(resultSet.getInt("category_id"));
				mCategoryDTO.setCategoryName(resultSet.getString("category_name"));
				mCategoryDTO.setCategoryDescription(resultSet.getString("category_description"));
				mCategoryDTO.setInsertDate(resultSet.getDate("insert_date"));
				mCategoryDTO.setUpdateDate(resultSet.getDate("update_date"));

				mCategoryDtoList.add(mCategoryDTO);
			}

			Iterator<MCategoryDTO> iterator = mCategoryDtoList.iterator(); //

			if (!(iterator.hasNext())) {
				mCategoryDtoList = null;
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

		return mCategoryDtoList;

	}

	public MCategoryDTO getMCategory(int categoryId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		MCategoryDTO MCategoryDTO = new MCategoryDTO();

		String sql = "SELECT * FROM m_category WHERE category_id = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				MCategoryDTO.setCategoryName(rs.getString("category_name"));
				MCategoryDTO.setCategoryId(rs.getInt("category_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return MCategoryDTO;
	}
}
