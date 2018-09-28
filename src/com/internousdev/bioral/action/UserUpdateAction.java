package com.internousdev.bioral.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserUpdateAction extends ActionSupport implements SessionAware {

	private String user_id;
	private String id;
	private String sex;
	private String family_name;
	private String first_name;
	private String family_name_kana;
	private String first_name_kana;
	private List<String> sexList = new ArrayList<String>();
	private String email;

	private String status;
	private List<String> statusList = new ArrayList<String>();

	private static final String USER = "ユーザー";
	private static final String ADMIN = "管理者";
	private String defaultStatusValue = USER;

	private static final String MALE = "男性";
	private static final String FEMALE = "女性";
	private String defaultSexValue = MALE;

	private Map<String, Object> session;

	public String execute() {
		String result = ERROR;

		session.remove("familyNameErrorMessageList");
		session.remove("firstNameErrorMessageList");
		session.remove("familyNameKanaErrorMessageList");
		session.remove("firstNameKanaErrorMessageList");
		session.remove("emailErrorMessageList");
		session.remove("userIdErrorMessageList");
		session.remove("passwordErrorMessageList");

		if (sex == null) {
			session.put("sex", MALE);
		} else {
			session.put("sex", String.valueOf(session.get("sex")));
		}
		sexList.add(MALE);
		sexList.add(FEMALE);

		session.put("sexList", sexList);

		if (status == null) {
			session.put("status", USER);
		} else {
			session.put("status", String.valueOf(session.get("status")));
		}
		statusList.add(USER);
		statusList.add(ADMIN);
		session.put("statusList", statusList);

		result = SUCCESS;
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getFamily_name() {
		return family_name;
	}

	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getFamily_name_kana() {
		return family_name_kana;
	}

	public void setFamily_name_kana(String family_name_kana) {
		this.family_name_kana = family_name_kana;
	}

	public String getFirst_name_kana() {
		return first_name_kana;
	}

	public void setFirst_name_kana(String first_name_kana) {
		this.first_name_kana = first_name_kana;
	}

	public List<String> getSexList() {
		return sexList;
	}

	public void setSexList(List<String> sexList) {
		this.sexList = sexList;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDefaultSexValue() {
		return defaultSexValue;
	}

	public void setDefaultSexValue(String defaultSexValue) {
		this.defaultSexValue = defaultSexValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<String> statusList) {
		this.statusList = statusList;
	}

	public String getDefaultStatusValue() {
		return defaultStatusValue;
	}

	public void setDefaultStatusValue(String defaultStatusValue) {
		this.defaultStatusValue = defaultStatusValue;
	}

}
