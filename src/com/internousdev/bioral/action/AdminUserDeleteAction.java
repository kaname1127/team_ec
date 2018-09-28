package com.internousdev.bioral.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.bioral.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminUserDeleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private String id;
	private String message;

	public String execute() {
		String result = ERROR;

		int res;
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		res = userInfoDAO.userDelete(session.get("id").toString());

		if (res == 1) {
			message = "正常に削除が完了しました。";
		} else {
			message = "削除に失敗しました。";
		}

		result = SUCCESS;
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getLoginId() {
		return id;
	}

	public void setLoginId(String loginId) {
		this.id = loginId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
