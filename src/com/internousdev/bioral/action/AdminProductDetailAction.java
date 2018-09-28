package com.internousdev.bioral.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.bioral.dao.ProductInfoDAO;
import com.internousdev.bioral.dto.MCategoryDTO;
import com.internousdev.bioral.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminProductDetailAction extends ActionSupport implements SessionAware {
	private int productId;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
	private ProductInfoDAO productInfoDAO = new ProductInfoDAO();
	private String categoryId;
	private String message;
	private String deleteFlg;
	private Map<String, Object> session;

	public String execute() throws SQLException {

		String result = ERROR;

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		productInfoDTO = productInfoDAO.getProductInfo(productId);

		session.put("id", productInfoDTO.getId());
		session.put("productId", productInfoDTO.getProductId());
		session.put("categoryId", productInfoDTO.getCategoryId());
		session.put("productName", productInfoDTO.getProductName());
		session.put("productNameKana", productInfoDTO.getProductNameKana());
		session.put("imageFilePath", productInfoDTO.getImageFilePath());
		session.put("imageFileName", productInfoDTO.getImageFileName());
		session.put("price", productInfoDTO.getPrice());
		session.put("releaseCompany", productInfoDTO.getReleaseCompany());
		session.put("releaseDate", productInfoDTO.getReleaseDate());
		session.put("productDescription", productInfoDTO.getProductDescription());
		session.put("registDate", productInfoDTO.getRegistDate());
		session.put("updateDate", productInfoDTO.getUpdateDate());

		List<Integer> productCountList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		session.put("productCountList", productCountList);

		productInfoDtoList = productInfoDAO.getProductInfoListByCategoryId(productInfoDTO.getCategoryId(),
				productInfoDTO.getProductId(), 0, 3);

		Iterator<ProductInfoDTO> iterator = productInfoDtoList.iterator();

		if (!(iterator.hasNext())) {
			productCountList = null;
		}

		if (!productInfoDtoList.isEmpty() || productCountList == null) {
			session.put("productInfoDtoList", productInfoDtoList);
			result = SUCCESS;
		}

		return result;
	}

	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public List<ProductInfoDTO> getProductInfoDtoList() {
		return productInfoDtoList;
	}

	public void setProductInfoDtoList(List<ProductInfoDTO> productInfoDtoList) {
		this.productInfoDtoList = productInfoDtoList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public ProductInfoDAO getProductInfoDAO() {
		return productInfoDAO;
	}

	public void setProductInfoDAO(ProductInfoDAO productInfoDAO) {
		this.productInfoDAO = productInfoDAO;
	}
}
