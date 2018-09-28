package com.internousdev.bioral.action;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.bioral.dao.CreateProductCompleteDAO;
import com.internousdev.bioral.dao.MCategoryDAO;
import com.internousdev.bioral.dto.MCategoryDTO;
import com.internousdev.bioral.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateProductConfirmAction extends ActionSupport implements SessionAware {

	private String productName;
	private String productNameKana;
	private String productDescription;
	private String price;
	private String imageFileName;
	private String imageFilePath;
	private String releaseCompany;
	private Date releaseDate;

	private File userImage;
	private String userImageContentType;
	private String userImageFileName;

	private List<String> productNameErrorMessageList = new ArrayList<String>();
	private List<String> productNameKanaErrorMessageList = new ArrayList<String>();
	private List<String> productDescriptionErrorMessageList = new ArrayList<String>();
	private List<String> priceErrorMessageList = new ArrayList<String>();
	private List<String> releaseCompanyErrorMessageList = new ArrayList<String>();
	private List<String> releaseDateErrorMessageList = new ArrayList<String>();

	private List<String> userImageFileNameErrorMessageList = new ArrayList<String>();

	private int categoryId;
	private List<String> categoryIdList = new ArrayList<String>();
	private Map<String, Object> session;

	public String execute() throws SQLException {
		String result = ERROR;

		InputChecker inputChecker = new InputChecker();

		if (releaseDate == null) {
			releaseDateErrorMessageList.add("発売年月日を入力してください。yyyy/mm/ddで入力します。");
		} else {
			String releaseDate_str = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(releaseDate);
			session.put("releaseDate", releaseDate_str);
		}

		session.put("productName", productName);
		session.put("productNameKana", productNameKana);
		session.put("productDescription", productDescription);
		session.put("price", price);
		session.put("imageFileName", imageFileName);
		session.put("imageFilePath", imageFilePath);
		session.put("releaseCompany", releaseCompany);
		session.put("categoryId", categoryId);
		session.put("userImageFileName", userImageFileName);
		session.put("Status", 0);

		/* ファイルアップロード処理
		 * 画像ファイルの場合で.jpeg画像のみで通り、ファイルサイズは3MBまで。それ以外にはエラー表示。
		 * 何も入れてない場合は「画像ファイルを挿入してください。」と表示。
		 */

		if (!(userImage == null)) {
			long fileMaxSize = 3145728;// 3MB
			String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("images");
			System.out.println("Image Location:" + filePath);
			File fileToCreate = new File(filePath, userImageFileName);
			userImageFileNameErrorMessageList = inputChecker.doCheck("画像ファイル", userImageFileName, 1, 50, true, true,
					true, true, true, true, true, false);

			if (!(isImageFile(userImageContentType))) {
				userImageFileNameErrorMessageList.add("画像ファイルが異なります。jpegのみ挿入出来ます。");
				result = ERROR;
			}
			if (userImage.length() > fileMaxSize) {
				userImageFileNameErrorMessageList.add("3MBより大きい画像ファイルは挿入出来ません。");
				result = ERROR;
			}

			try {
				FileUtils.copyFile(userImage, fileToCreate);
				session.put("image_file_name", userImageFileName);
				session.put("image_file_path", "./images");
				session.put("image_flg", userImageFileName);
				System.out.println(session.get("image_file_name"));
				System.out.println(session.get("image_file_path"));

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			userImageFileName = "";
			userImageFileNameErrorMessageList.add("画像ファイルを挿入してください。");
			result = ERROR;
		}

		// mCategoryDtoListを使って、categoryIdを表示された名前で取ってくる。
		MCategoryDAO mCategoryDAO = new MCategoryDAO();
		MCategoryDTO mCategoryDTO = mCategoryDAO.getMCategory(categoryId);
		// ユーザーID, status をセッションに格納
		// putされたcategoryIdをメソッド内でセレクトし、categoryNameをsession内に保存する。
		session.put("categoryName", mCategoryDTO.getCategoryName());

		productNameErrorMessageList = inputChecker.doCheck("商品名", productName, 1, 32, true, true, true, true, true,
				true, true, false);
		productNameKanaErrorMessageList = inputChecker.doCheck("商品名ふりがな", productNameKana, 1, 32, false, false, true,
				false, false, false, true, false);
		productDescriptionErrorMessageList = inputChecker.docheck3("商品詳細", productDescription, 1, 200, true, true, true,
				true, true, true, true);
		priceErrorMessageList = inputChecker.docheck2("価格", price, 1, 8, false, false, false, true, false, false,
				false, false);
		releaseCompanyErrorMessageList = inputChecker.doCheck("発売会社名", releaseCompany, 1, 16, true, true, true, true,
				true, true, true, false);

		CreateProductCompleteDAO createProductCompleteDAO = new CreateProductCompleteDAO();

		// 同じ内容の商品がすでに存在していないか確認して結果を返す
		if (createProductCompleteDAO.checkProductInfo(productName)) {
			productNameErrorMessageList.add("同じ商品名で登録出来ません。");
		}
		if (createProductCompleteDAO.checkProductInfo2(productNameKana)) {
			productNameKanaErrorMessageList.add("同じ商品名のふりがなで登録は出来ません。");
		}

		if (productNameErrorMessageList.size() == 0 && productNameKanaErrorMessageList.size() == 0
				&& productDescriptionErrorMessageList.size() == 0 && priceErrorMessageList.size() == 0
				&& releaseCompanyErrorMessageList.size() == 0 && userImageFileNameErrorMessageList.size() == 0
				&& releaseDateErrorMessageList.size() == 0) {
			result = SUCCESS;
		} else {
			session.put("productNameErrorMessageList", productNameErrorMessageList);
			session.put("productNameKanaErrorMessageList", productNameKanaErrorMessageList);
			session.put("productDescriptionErrorMessageList", productDescriptionErrorMessageList);
			session.put("priceErrorMessageList", priceErrorMessageList);
			session.put("releaseCompanyErrorMessageList", releaseCompanyErrorMessageList);
			session.put("releaseDateErrorMessageList", releaseDateErrorMessageList);
			session.put("userImageFileNameErrorMessageList", userImageFileNameErrorMessageList);
			result = ERROR;
		}

		return result;
	}

	private boolean isImageFile(String extension) {

		return (extension.equals("image/jpeg"));
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
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

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {
		this.userImageFileName = userImageFileName;
	}

	public List<String> getProductNameErrorMessageList() {
		return productNameErrorMessageList;
	}

	public void setProductNameErrorMessageList(List<String> productNameErrorMessageList) {
		this.productNameErrorMessageList = productNameErrorMessageList;
	}

	public List<String> getProductNameKanaErrorMessageList() {
		return productNameKanaErrorMessageList;
	}

	public void setProductNameKanaErrorMessageList(List<String> productNameKanaErrorMessageList) {
		this.productNameKanaErrorMessageList = productNameKanaErrorMessageList;
	}

	public List<String> getProductDescriptionErrorMessageList() {
		return productDescriptionErrorMessageList;
	}

	public void setProductDescriptionErrorMessageList(List<String> productDescriptionErrorMessageList) {
		this.productDescriptionErrorMessageList = productDescriptionErrorMessageList;
	}

	public List<String> getPriceErrorMessageList() {
		return priceErrorMessageList;
	}

	public void setPriceErrorMessageList(List<String> priceErrorMessageList) {
		this.priceErrorMessageList = priceErrorMessageList;
	}

	public List<String> getReleaseCompanyErrorMessageList() {
		return releaseCompanyErrorMessageList;
	}

	public void setReleaseCompanyErrorMessageList(List<String> releaseCompanyErrorMessageList) {
		this.releaseCompanyErrorMessageList = releaseCompanyErrorMessageList;
	}

	public List<String> getReleaseDateErrorMessageList() {
		return releaseDateErrorMessageList;
	}

	public void setReleaseDateErrorMessageList(List<String> releaseDateErrorMessageList) {
		this.releaseDateErrorMessageList = releaseDateErrorMessageList;
	}

	public List<String> getUserImageFileNameErrorMessageList() {
		return userImageFileNameErrorMessageList;
	}

	public void setUserImageFileNameErrorMessageList(List<String> userImageFileNameErrorMessageList) {
		this.userImageFileNameErrorMessageList = userImageFileNameErrorMessageList;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public List<String> getCategoryIdList() {
		return categoryIdList;
	}

	public void setCategoryIdList(List<String> categoryIdList) {
		this.categoryIdList = categoryIdList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
//
//
// public String execute() {
// String result = SUCCESS;
//
// if (!(categoryId.equals("")) && !(productId.equals("")) &&
// !(productName.equals(""))
// && !(productNameKana.equals("")) && !(productDescription.equals("")) &&
// !(price.equals(""))
// && !(imageFilePath.equals("")) && !(imageFileName.equals("")) &&
// !(releaseDate.equals(""))
// && !(releaseCompany.equals(""))) {
// session.put("categoryId", categoryId);
// session.put("productId", productId);
// session.put("productName", productName);
// session.put("productNameKana", productNameKana);
// session.put("productDescription", productDescription);
// session.put("price", price);
// session.put("imageFilePath", imageFilePath);
// session.put("imageFileName", imageFileName);
// session.put("releaseDate", releaseDate);
// session.put("releaseCompany", releaseCompany);
//
// // 選択した画像ファイル名をコンソールに表示する
// System.out.println(imageFileName);
//
// // 選択した画像ファイルをサーバーに保存する
// String filePath =
// ServletActionContext.getServletContext().getRealPath("/").concat("images/");
//
// System.out.println("Image Location: " + filePath);
//
// CommonUtility commonUtility = new CommonUtility();
// imageFileName = commonUtility.getRamdomValue() + imageFileName;
//
// // サーバー上に保存した画像をimageフォルダにコピーする
// File fileToCreate = new File(filePath, imageFileName);
// try {
// FileUtils.copyFile(imageFileName, fileToCreate);
// session.put("imageFileName", imageFileName);
// session.put("imageFilePath", "./images/" + imageFileName);
// session.put("image_flg", imageFileName);
// } catch (IOException e) {
// e.printStackTrace();
// }
//
// } else {
// setErrorMessage("未入力の項目があります。");
// result = ERROR;
// }
// return result;
// }
//
// public String getId() {
// return id;
// }
//
// public void setId(String id) {
// this.id = id;
// }
//
// public String getProductId() {
// return productId;
// }
//
// public void setProductId(String productId) {
// this.productId = productId;
// }
//
// public String getProductName() {
// return productName;
// }
//
// public void setProductName(String productName) {
// this.productName = productName;
// }
//
// public String getProductNameKana() {
// return productNameKana;
// }
//
// public void setProductNameKana(String productNameKana) {
// this.productNameKana = productNameKana;
// }
//
// public String getProductDescription() {
// return productDescription;
// }
//
// public void setProductDescription(String productDescription) {
// this.productDescription = productDescription;
// }
//
// public String getCategoryId() {
// return categoryId;
// }
//
// public void setCategoryId(String categoryId) {
// this.categoryId = categoryId;
// }
//
// public String getPrice() {
// return price;
// }
//
// public void setPrice(String price) {
// this.price = price;
// }
//
// public String getImageFilePath() {
// return imageFilePath;
// }
//
// public void setImageFilePath(String imageFilePath) {
// this.imageFilePath = imageFilePath;
// }
//
// public String getImageFileName() {
// return imageFileName;
// }
//
// public void setImageFileName(String imageFileName) {
// this.imageFileName = imageFileName;
// }
//
// public Date getReleaseDate() {
// return releaseDate;
// }
//
// public void setReleaseDate(Date releaseDate) {
// this.releaseDate = releaseDate;
// }
//
// public String getReleaseCompany() {
// return releaseCompany;
// }
//
// public void setReleaseCompany(String releaseCompany) {
// this.releaseCompany = releaseCompany;
// }
//
// public String getErrorMessage() {
// return errorMessage;
// }
//
// public void setErrorMessage(String errorMessage) {
// this.errorMessage = errorMessage;
// }
//
// public Map<String, Object> getSession() {
// return session;
// }
//
// public void setSession(Map<String, Object> session) {
// this.session = session;
// }
//
// }
