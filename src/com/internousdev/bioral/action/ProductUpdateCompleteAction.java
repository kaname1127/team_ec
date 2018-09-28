package com.internousdev.bioral.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.bioral.dao.ProductUpdateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductUpdateCompleteAction extends ActionSupport implements SessionAware {

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
	private Map<String, Object> session;

	public String execute() throws SQLException {
		String result = ERROR;

		ProductUpdateCompleteDAO productUpdateCompleteDAO = new ProductUpdateCompleteDAO();

		// セッションに格納された商品情報をupdateProductInfoメソッドで実行する
		int count = productUpdateCompleteDAO.productDetailUpdate(Integer.parseInt(session.get("productId").toString()),
				session.get("productName").toString(), session.get("productNameKana").toString(),
				session.get("productDescription").toString(), Integer.parseInt(session.get("categoryId").toString()),
				Integer.parseInt(session.get("price").toString()), session.get("releaseCompany").toString(),
				session.get("releaseDate").toString(), session.get("image_file_path").toString(),
				session.get("image_file_name").toString());

		// 実行が全部成功したら、セッションに格納されたデータをはずす
		if (count > 0) {
			session.remove("productName");
			session.remove("puroductNameKana");
			session.remove("productDescription");
			session.remove("categoryId");
			session.remove("price");
			session.remove("releaseCompany");
			session.remove("releaseDate");
			session.remove("Status");
			session.remove("image_file_path");
			session.remove("image_file_name");
			session.remove("image_flg");
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
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

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
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

	// public String getUpdateMessage() {
	// return updateMessage;
	// }
	//
	// public void setUpdateMessage(String updateMessage) {
	// this.updateMessage = updateMessage;
	// }

}
