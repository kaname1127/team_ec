package com.internousdev.bioral.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.bioral.dao.AdminPurchaseHistoryDAO;
import com.internousdev.bioral.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AdminPurchaseHistoryAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	private AdminPurchaseHistoryDAO adminPurchaseHistoryDAO = new AdminPurchaseHistoryDAO();
	private List<PurchaseHistoryInfoDTO> purchaseHistoryInfo = new ArrayList<PurchaseHistoryInfoDTO>();

	public String execute() throws SQLException {
		String result = SUCCESS;

		purchaseHistoryInfo = adminPurchaseHistoryDAO.getPurchaseHistoryList();
		session.put("purchaseHistoryInfoDtoList", purchaseHistoryInfo);
		return result;

	}

	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryInfo() {
		return purchaseHistoryInfo;
	}

	public void setPurchaseHistoryInfo(List<PurchaseHistoryInfoDTO> purchaseHistoryInfo) {
		this.purchaseHistoryInfo = purchaseHistoryInfo;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
