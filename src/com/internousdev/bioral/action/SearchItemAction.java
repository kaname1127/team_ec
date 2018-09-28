package com.internousdev.bioral.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.bioral.dao.MCategoryDAO;
import com.internousdev.bioral.dao.ProductInfoDAO;
import com.internousdev.bioral.dto.MCategoryDTO;
import com.internousdev.bioral.dto.PaginationDTO;
import com.internousdev.bioral.dto.ProductInfoDTO;
import com.internousdev.bioral.util.InputChecker;
import com.internousdev.bioral.util.Pagination;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware {
	private int errorMessageFlg;
	private String categoryId;
	private String keywords;
	private int pageNo;
	private List<MCategoryDTO> mCategoryDtoList = new ArrayList<MCategoryDTO>();
	private List<String> keywordsErrorMessageList = new ArrayList<String>();
	private List<ProductInfoDTO> productInfoDtoList = new ArrayList<ProductInfoDTO>();
	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;
		session.remove("errorMessageFlg");


		System.out.println("カテゴリID" + categoryId);

		if (categoryId == null) {
			errorMessageFlg =1;
			session.put("errorMessageFlg", errorMessageFlg);
			categoryId ="1";
		}

		System.out.println("カテゴリID" + categoryId);

		InputChecker inputChecker = new InputChecker();
		if (keywords == null) {
			keywords = "";
		}
		keywordsErrorMessageList = inputChecker.doCheck("検索ワード", keywords, 0, 16, true, true, true, true, false, true,
				true, false);
		System.out.println("キーワード" + keywords);
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		switch (categoryId) {
		case "1":
			if (errorMessageFlg == 0) {
				errorMessageFlg = 2;
				session.put("errorMessageFlg", errorMessageFlg);
			}
			errorMessageFlg =2;
			productInfoDtoList = productInfoDAO.getProductInfoListAll(keywords.replaceAll("　", " ").split(" "));
			for (ProductInfoDTO a : productInfoDtoList) {
				System.out.println("リスト１ " + a.getProductName());
			}
			result = SUCCESS;
			break;

		default:
			errorMessageFlg =2;
			session.put("errorMessageFlg", errorMessageFlg);
			productInfoDtoList = productInfoDAO.getProductInfoListByKeywords(keywords.replaceAll("　", " ").split(" "),
					categoryId);
			for (ProductInfoDTO a : productInfoDtoList) {
				System.out.println("リスト２ " + a.getProductName());
			}
			result = SUCCESS;
			break;
		}
		Iterator<ProductInfoDTO> iterator = productInfoDtoList.iterator();
		if (!(iterator.hasNext())) {
			productInfoDtoList = null;
		}
		session.put("keywordsErrorMessageList", keywordsErrorMessageList);

		if (!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDtoList", mCategoryDtoList);
		}

		if (!(productInfoDtoList == null)) {
			Pagination pagination = new Pagination();
			PaginationDTO paginationDTO = new PaginationDTO();
			if (pageNo == 0) {
				paginationDTO = pagination.initialize(productInfoDtoList, 9);
			} else {
				paginationDTO = pagination.getPage(productInfoDtoList, 9, pageNo);
			}

			session.put("productInfoDtoList", paginationDTO.getCurrentProductInfoPage());
			session.put("totalPageSize", paginationDTO.getTotalPageSize());
			session.put("currentPageNo", paginationDTO.getCurrentPageNo());
			session.put("totalRecordSize", paginationDTO.getTotalRecordSize());
			session.put("startRecordNo", paginationDTO.getStartRecordNo());
			session.put("endRecordNo", paginationDTO.getEndRecordNo());
			session.put("previousPage", paginationDTO.isHasPreviousPage());
			session.put("previousPageNo", paginationDTO.getPreviousPageNo());
			session.put("nextPage", paginationDTO.isHasNextPage());
			session.put("nextPageNo", paginationDTO.getNextPageNo());

			System.out.println(paginationDTO.getCurrentProductInfoPage());

		} else {
			session.put("productInfoDtoList", null);
		}
		return result;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
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

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public List<String> getKeywordsErrorMessageList() {
		return keywordsErrorMessageList;
	}

	public void setKeywordsErrorMessageList(List<String> keywordsErrorMessageList) {
		this.keywordsErrorMessageList = keywordsErrorMessageList;
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

	public int getErrorMessageFlg() {
		return errorMessageFlg;
	}

	public void setErrorMessageFlg(int errorMessageFlg) {
		this.errorMessageFlg = errorMessageFlg;
	}


}