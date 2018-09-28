package com.internousdev.bioral.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.bioral.dto.ProductInfoDTO;
import com.internousdev.bioral.dto.ReviewInfoDTO;
import com.internousdev.bioral.util.DBConnector;

public class ProductInfoDAO {

	public List<ProductInfoDTO> getProductInfoList() {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();

		String sql = "SELECT * FROM product_info";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ProductInfoDTO productInfoDto = new ProductInfoDTO();
				productInfoDto.setId(resultSet.getInt("id"));
				productInfoDto.setProductId(resultSet.getInt("product_id"));
				productInfoDto.setProductName(resultSet.getString("product_name"));
				productInfoDto.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDto.setProductDescription(resultSet.getString("product_description"));
				productInfoDto.setCategoryId(resultSet.getInt("category_id"));
				productInfoDto.setPrice(resultSet.getInt("price"));
				productInfoDto.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDto.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDto.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDto.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDto.setStatus(resultSet.getInt("status"));
				productInfoDto.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDto.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productInfoDtoList;
	}

	public ProductInfoDTO getProductInfo(int productId) {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();

		String sql = "SELECT * FROM product_info WHERE product_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productInfoDTO;
	}

	public ArrayList<ReviewInfoDTO> getReviewInfo(int productId) {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		ArrayList<ReviewInfoDTO> reviewInfoDtoList = new ArrayList<ReviewInfoDTO>();

		String sql = "SELECT * FROM review_info WHERE product_id = ? ORDER BY point DESC, insert_date DESC";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, productId);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ReviewInfoDTO reviewInfoDTO = new ReviewInfoDTO();
				int point;
				String pointStar ="";

				reviewInfoDTO.setId(resultSet.getInt("id"));
				reviewInfoDTO.setProductId(resultSet.getInt("product_id"));
				reviewInfoDTO.setUserName(resultSet.getString("user_name"));
				reviewInfoDTO.setTitle(resultSet.getString("title"));
//				DBから取得した評価点数を星マークに変換
				point = resultSet.getInt("point");
				int i = 1;
				 while (i <= 5) {
					if (i <= point) {
						pointStar +="★";
					}else {
						pointStar +="☆";
					}
					 i++;
				}
				 reviewInfoDTO.setPoint(pointStar);
//				 ここまで
				reviewInfoDTO.setReviewComment(resultSet.getString("review_comment"));
				reviewInfoDTO.setInsertDate(resultSet.getDate("insert_date"));
				reviewInfoDtoList.add(reviewInfoDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return reviewInfoDtoList;
	}

	public List<ProductInfoDTO> getProductInfoListByCategoryId(int categoryId, int productId, int limitOffset,
			int limitRowCount) {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();

		String sql = "select * from product_info where category_id=? and product_id not in(?) order by rand() limit ?,?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, categoryId);
			preparedStatement.setInt(2, productId);
			preparedStatement.setInt(3, limitOffset);
			preparedStatement.setInt(4, limitRowCount);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productInfoDtoList;
	}

	public List<ProductInfoDTO> getProductInfoListAll(String[] keywordsList) {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();

		String sql = "SELECT * FROM product_info WHERE";
		boolean initializeFlag = true;

		for (String keyword : keywordsList) {

			if (initializeFlag) {
				sql += " (product_name LIKE '%" + keyword + "%' OR product_name_kana LIKE '%" + keyword + "%')";
				initializeFlag = false;

			} else {
				sql += " AND (product_name LIKE '%" + keyword + "%' OR product_name_kana LIKE '%" + keyword + "%')";
			}
		}

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productInfoDtoList;
	}

	public List<ProductInfoDTO> getProductInfoListByKeywords(String[] keywordsList, String categoryId) {

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();

		String sql = "SELECT * FROM product_info WHERE";
		boolean initializeFlag = true;

		for (String keyword : keywordsList) {

			if (initializeFlag) {
				sql += " category_id =" + categoryId + " AND (product_name LIKE '%" + keyword
						+ "%' OR product_name_kana LIKE '%" + keyword + "%')";
				initializeFlag = false;

			} else {
				sql += " AND (product_name LIKE '%" + keyword + "%' OR product_name_kana LIKE '%" + keyword + "%')";
			}
		}

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setId(resultSet.getInt("id"));
				productInfoDTO.setProductId(resultSet.getInt("product_id"));
				productInfoDTO.setProductName(resultSet.getString("product_name"));
				productInfoDTO.setProductNameKana(resultSet.getString("product_name_kana"));
				productInfoDTO.setProductDescription(resultSet.getString("product_description"));
				productInfoDTO.setCategoryId(resultSet.getInt("category_id"));
				productInfoDTO.setPrice(resultSet.getInt("price"));
				productInfoDTO.setImageFilePath(resultSet.getString("image_file_path"));
				productInfoDTO.setImageFileName(resultSet.getString("image_file_name"));
				productInfoDTO.setReleaseDate(resultSet.getDate("release_date"));
				productInfoDTO.setReleaseCompany(resultSet.getString("release_company"));
				productInfoDTO.setStatus(resultSet.getInt("status"));
				productInfoDTO.setRegistDate(resultSet.getDate("regist_date"));
				productInfoDTO.setUpdateDate(resultSet.getDate("update_date"));
				productInfoDtoList.add(productInfoDTO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return productInfoDtoList;
	}

	public int deleteProductInfo(String productId) {
		// 商品情報を削除するメソッドです。

		DBConnector dbConnector = new DBConnector();
		Connection connection = dbConnector.getConnection();
		int res = 0;

		String sql = "DELETE FROM product_info WHERE product_id = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, productId);

			res = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

}
