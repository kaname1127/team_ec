package com.internousdev.bioral.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.bioral.dao.CartInfoDAO;
import com.internousdev.bioral.dao.DestinationInfoDAO;
import com.internousdev.bioral.dao.MCategoryDAO;
import com.internousdev.bioral.dao.ReviewDAO;
import com.internousdev.bioral.dao.UserInfoDAO;
import com.internousdev.bioral.dto.CartInfoDTO;
import com.internousdev.bioral.dto.DestinationInfoDTO;
import com.internousdev.bioral.dto.MCategoryDTO;
import com.internousdev.bioral.dto.ReviewInfoDTO;
import com.internousdev.bioral.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAllSelectAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

	private List<MCategoryDTO> mCategoryAllDtoList = new ArrayList<MCategoryDTO>();
	private List<UserInfoDTO> userInfoAllDtoList = new ArrayList<UserInfoDTO>();
	private List<DestinationInfoDTO> DestinationInfoAllDtoList = new ArrayList<DestinationInfoDTO>();
	private List<CartInfoDTO> CartInfoAllDtoList = new ArrayList<CartInfoDTO>();
	private List<ReviewInfoDTO> ReviewInfoAllDtoList = new ArrayList<ReviewInfoDTO>();

	public String execute() {

		String result = ERROR;

		try {

			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryAllDtoList = mCategoryDao.getMCategoryList();
			session.put("mCategoryAllDtoList", mCategoryAllDtoList);

			UserInfoDAO UserInfoDao = new UserInfoDAO();
			userInfoAllDtoList = UserInfoDao.userList();
			session.put("UserInfoAllDtoList", userInfoAllDtoList);

			DestinationInfoDAO DestinationInfoDao = new DestinationInfoDAO();
			DestinationInfoAllDtoList = DestinationInfoDao.getDestinationInfoAllList();
			session.put("DestinationInfoAllDtoList", DestinationInfoAllDtoList);

			CartInfoDAO CartInfoDao = new CartInfoDAO();
			CartInfoAllDtoList = CartInfoDao.getCartInfoAllDtoList();
			session.put("CartInfoAllDtoList", CartInfoAllDtoList);

			ReviewDAO ReviewDao = new ReviewDAO();
			ReviewInfoAllDtoList = ReviewDao.getReviewInfoList();
			session.put("ReviewInfoAllDtoList", ReviewInfoAllDtoList);

			result = SUCCESS;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<MCategoryDTO> getmCategoryAllDtoList() {
		return mCategoryAllDtoList;
	}

	public void setmCategoryAllDtoList(List<MCategoryDTO> mCategoryAllDtoList) {
		this.mCategoryAllDtoList = mCategoryAllDtoList;
	}

	public List<UserInfoDTO> getUserInfoAllDtoList() {
		return userInfoAllDtoList;
	}

	public void setUserInfoAllDtoList(List<UserInfoDTO> userInfoAllDtoList) {
		this.userInfoAllDtoList = userInfoAllDtoList;
	}

	public List<DestinationInfoDTO> getDestinationInfoAllDtoList() {
		return DestinationInfoAllDtoList;
	}

	public void setDestinationInfoAllDtoList(List<DestinationInfoDTO> destinationInfoAllDtoList) {
		DestinationInfoAllDtoList = destinationInfoAllDtoList;
	}

	public List<CartInfoDTO> getCartInfoAllDtoList() {
		return CartInfoAllDtoList;
	}

	public void setCartInfoAllDtoList(List<CartInfoDTO> cartInfoAllDtoList) {
		CartInfoAllDtoList = cartInfoAllDtoList;
	}

	public List<ReviewInfoDTO> getReviewInfoAllDtoList() {
		return ReviewInfoAllDtoList;
	}

	public void setReviewInfoAllDtoList(List<ReviewInfoDTO> reviewInfoAllDtoList) {
		ReviewInfoAllDtoList = reviewInfoAllDtoList;
	}

}
