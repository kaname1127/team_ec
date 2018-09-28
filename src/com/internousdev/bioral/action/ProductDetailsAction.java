package com.internousdev.bioral.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.bioral.dao.ProductInfoDAO;
import com.internousdev.bioral.dto.MCategoryDTO;
import com.internousdev.bioral.dto.ProductInfoDTO;
import com.internousdev.bioral.dto.ReviewInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailsAction extends ActionSupport implements SessionAware {

	private int productId;
	private String categoryId;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
	private Map<String, Object> session;

	public String execute() {

		String result = ERROR;

		// レビュー投稿後のみ、画面再表示用の処理
		session.put("nameErrorMessageList", null);
		session.put("titleErrorMessageList", null);
		session.put("commentErrorMessageList", null);
		session.put("reviewName", null);
		session.put("reviewTitle", null);
		session.put("reviewPoint", null);
		session.put("reviewComment", null);
		if (productId == 0) {
			productId = Integer.parseInt(session.get("productId").toString());
		}
		// ここまで

		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();
		productInfoDTO = productInfoDAO.getProductInfo(productId);

		// レビューリストを取得してセッションへ格納します
		ArrayList<ReviewInfoDTO> reviewInfoDTOList = productInfoDAO.getReviewInfo(productId);
		if (reviewInfoDTOList.size() == 0) {
			session.put("reviewList", null);
		}else {
			session.put("reviewList", reviewInfoDTOList);
		}
		// ここまで

		session.put("id", productInfoDTO.getId());
		session.put("productId", productInfoDTO.getProductId());
		session.put("productName", productInfoDTO.getProductName());
		session.put("productNameKana", productInfoDTO.getProductNameKana());
		session.put("imageFilePath", productInfoDTO.getImageFilePath());
		session.put("imageFileName", productInfoDTO.getImageFileName());
		session.put("price", productInfoDTO.getPrice());

		session.put("releaseCompany", productInfoDTO.getReleaseCompany());
		session.put("releaseDate", productInfoDTO.getReleaseDate());
		session.put("productDescription", productInfoDTO.getProductDescription());

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

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDtoList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDtoList) {
		this.mCategoryDtoList = mCategoryDtoList;
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

}
