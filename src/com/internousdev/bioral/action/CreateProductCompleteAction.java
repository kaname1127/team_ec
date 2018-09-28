package com.internousdev.bioral.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.bioral.dao.CreateProductCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateProductCompleteAction extends ActionSupport implements SessionAware {

	private int productId;
	private String productName;
	private String productNameKana;
	private String productDescription;
	private int categoryId;
	private int price;
	private String releaseCompany;
	private String releaseDate;
	private int Status;
	private String imageFileName;
	private String imageFilePath;
	private String userImageFileName;
	private Map<String, Object> session;

	public String execute() throws SQLException {
		String result = ERROR;

		CreateProductCompleteDAO createProductCompleteDAO = new CreateProductCompleteDAO();

		int productId = CreateProductCompleteDAO.getMaxProductId() + 1;

		int count = createProductCompleteDAO.createProduct(productId, session.get("productName").toString(),
				session.get("productNameKana").toString(), session.get("productDescription").toString(),
				Integer.parseInt(session.get("categoryId").toString()),
				Integer.parseInt(session.get("price").toString()), session.get("releaseCompany").toString(),
				session.get("releaseDate").toString(), Integer.parseInt(session.get("Status").toString()),
				session.get("image_file_path").toString(), session.get("image_file_name").toString());

		if (count > 0) {
			session.remove("prouctName");
			session.remove("productNameKana");
			session.remove("productDescription");
			session.remove("categoryId");
			session.remove("price");
			session.remove("releaseCompany");
			session.remove("releaseDate");
			session.remove("Status");
			session.remove("image_file_path");
			session.remove("image_file_name");
			session.remove("image_flg");
			System.out.println("商品の追加を行いました");
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

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductNameKana() {
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int Status) {
		this.Status = Status;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}
}