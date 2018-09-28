package com.internousdev.bioral.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.bioral.dao.ProductInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductUpdateAction extends ActionSupport implements SessionAware {

	private ProductInfoDAO productInfoDAO = new ProductInfoDAO();
	public Map<String, Object> session;

	public String execute() {
		return SUCCESS;
	}

	public ProductInfoDAO getProductInfoDAO() {
		return productInfoDAO;
	}

	public void setProductInfoDAO(ProductInfoDAO productInfoDAO) {
		this.productInfoDAO = productInfoDAO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
