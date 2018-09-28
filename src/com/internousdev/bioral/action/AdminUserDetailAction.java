package com.internousdev.bioral.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.bioral.dao.UserInfoDAO;
import com.internousdev.bioral.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserDetailAction extends ActionSupport implements SessionAware {
	private String id;
	private String selectedId;
	private String userId;
	private String password;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private String status;
	private Map<String, Object> session;

	public String execute() throws SQLException {
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		UserInfoDAO userInfoDAO = new UserInfoDAO();

		userInfoDTO = userInfoDAO.getUserInfo(userId);
		session.put("id", userInfoDTO.getId());
		session.put("userId", userInfoDTO.getUserId());
		session.put("originUserId", userInfoDTO.getUserId());
		session.put("password", userInfoDTO.getPassword());
		session.put("familyName", userInfoDTO.getFamilyName());
		session.put("firstName", userInfoDTO.getFirstName());
		session.put("familyNameKana", userInfoDTO.getFamilyNameKana());
		session.put("firstNameKana", userInfoDTO.getFirstNameKana());

		int seibetu = userInfoDTO.getSex();
		if (seibetu == 0) {
			session.put("sexName", "男性");
			session.put("sex", "0");
		}
		if (seibetu == 1) {
			session.put("sexName", "女性");
			session.put("sex", "1");
		}

		session.put("email", userInfoDTO.getEmail());

		int kengen = Integer.parseInt(userInfoDTO.getStatus());
		if (kengen == 0) {
			session.put("statusName", "一般ユーザー");
			session.put("status", "0");
		}
		if (kengen == 1) {
			session.put("statusName", "管理者");
			session.put("status", "1");
		}

		session.put("registDate", userInfoDTO.getRegistDate());
		session.put("updateDate", userInfoDTO.getUpdateDate());

		System.out.println(session.get("statusName"));
		System.out.println(session.get("sexName"));
		System.out.println("性別判定");

		String result = SUCCESS;

		return result;

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSelectedId() {
		return selectedId;
	}

	public void setSelectedId(String selectedId) {
		this.selectedId = selectedId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
