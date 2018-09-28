package com.internousdev.bioral.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.bioral.dao.ReviewDAO;
import com.internousdev.bioral.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ReviewAction extends ActionSupport implements SessionAware {

	private List<String> nameErrorMessageList = new ArrayList<String>();
	private List<String> titleErrorMessageList = new ArrayList<String>();
	private List<String> commentErrorMessageList = new ArrayList<String>();

	private String productId;
	private String reviewName;
	private String reviewTitle;
	private String reviewPoint;
	private String reviewComment;
	private Map<String, Object> session;

	public String execute() {


		// 入力情報確認用コンソール出力
		System.out.println(productId);
		System.out.println(reviewName);
		System.out.println(reviewTitle);
		System.out.println(reviewPoint);
		System.out.println(reviewComment);

		String result = ERROR;

		InputChecker inputChecker = new InputChecker();

		nameErrorMessageList = inputChecker.doCheck("投稿名", reviewName, 1, 16, true, true, true, true, true, true,
				true, false);
		titleErrorMessageList = inputChecker.doCheck("タイトル", reviewTitle, 1, 50, true, true, true, true, true, true,
				true, false);
		commentErrorMessageList = inputChecker.doCheck("本文", reviewComment, 1, 255, true, true, true, true, true,
				true, true, false);

		if (nameErrorMessageList.size() == 0
				 && titleErrorMessageList.size() == 0
				 && commentErrorMessageList.size() == 0)

		{
			session.put("nameErrorMessageList", null);
			session.put("titleErrorMessageList", null);
			session.put("commentErrorMessageList", null);

			ReviewDAO ReviewDAO = new ReviewDAO();

			int count = ReviewDAO.postReview(productId, reviewName, reviewTitle, reviewPoint, reviewComment);

			if (count > 0) {
				session.put("reviewName", null);
				session.put("reviewTitle", null);
				session.put("reviewPoint", null);
				session.put("reviewComment", null);
				result = SUCCESS;
			}

		}

		else {// エラーメッセージ判定
			session.put("nameErrorMessageList", nameErrorMessageList);
			session.put("titleErrorMessageList", titleErrorMessageList);
			session.put("commentErrorMessageList", commentErrorMessageList);
			session.put("reviewName", reviewName);
			session.put("reviewTitle", reviewTitle);
			session.put("reviewPoint", reviewPoint);
			session.put("reviewComment", reviewComment);
		}

		return result;
	}


	public String getReviewName() {
		return reviewName;
	}
	public void setReviewName(String reviewName) {
		this.reviewName = reviewName;
	}


	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}


	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}


	public String getReviewPoint() {
		return reviewPoint;
	}
	public void setReviewPoint(String reviewPoint) {
		this.reviewPoint = reviewPoint;
	}


	public String getReviewComment() {
		return reviewComment;
	}
	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}


	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
