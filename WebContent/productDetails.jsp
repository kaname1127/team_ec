<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width; initial-scale=1.0" />
<link rel="stylesheet" href="./css/productDetails.css">
<link rel="stylesheet" href="./css/header.css">
<link rel="stylesheet" href="./css/inputForm.css">

<!-- フェードイン・アウト効果 -->
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="js/fade.js"></script>


<title>商品詳細</title>

</head>
<body class="is-hide">
	<jsp:include page="header.jsp" />

	<div id="contents2">

		<div id="details-title">
			<h1>DETAILS</h1>
		</div>

		<div id="main-box">

			<div id="product-img-title">商品画像</div>

			<div id="product-2column-container">
				<s:form action="AddCartAction">

					<div id="product-left">
						<div id="product-img-box1">
							<img class="product-img1"
								src='<s:property value="%{#session.imageFilePath}"/>/<s:property value="%{#session.imageFileName}"/>' />
						</div>
					</div>

					<div id="product-right">
						<div id="product-details-box">
							<div id="product-box1">
								<div id="product-title1">
									<s:label value="商品名" />
								</div>
								<div id="product-value1">
									<s:property value="%{#session.productName}" />
								</div>
							</div>
							<div id="product-box1">
								<div id="product-title4">
									<s:label value="商品名ふりがな" />
								</div>
								<div id="product-value3">
									<s:property value="%{#session.productNameKana}" />
								</div>
							</div>
							<div id="product-box1">
								<div id="product-title1">
									<s:label value="発売年月日" />
								</div>
								<div id="product-value2">
									<s:property value="%{#session.releaseDate}" />
								</div>
							</div>
							<div id="product-box1">
								<div id="product-title1">
									<s:label value="発売会社名" />
								</div>
								<div id="product-value2">
									<s:property value="%{#session.releaseCompany}" />
								</div>
							</div>
							<br> <br>
							<div id="product-box1">
								<div id="product-title2">
									<s:label value="商品詳細情報" />
								</div>
								<br>
								<div id="product-value4">
									<s:property value="%{#session.productDescription}" />
								</div>
							</div>
							<br> <br>
							<div id="product-box1">
								<div id="product-title3">
									<s:label value="値段" />
								</div>
								<div id="product-value5">
									&yen;
									<s:property value="%{#session.price}" />
									(税込)
								</div>
							</div>
							<div id="product-box1">
								<div id="product-value5">
									<div id="product-title3">
										<s:label value="購入個数" />
									</div>
									<s:select name="productCount"
										list="%{#session.productCountList}" />
								</div>

							</div>
							<div id="product-box1">
								<div id="product-value6">
									<img class="cart-icon" src="./images/icons/cartplus.png">
									<s:token />
									<s:submit value="カート追加" class="bttn-unite bttn-sm bttn-primary" />
								</div>
							</div>
							<s:hidden name="productId" value="%{#session.productId}" />
							<s:hidden name="productName" value="%{#session.productName}" />
							<s:hidden name="productNameKana"
								value="%{#session.productNameKana}" />
							<s:hidden name="imageFilePath" value="%{#session.imageFilePath}" />
							<s:hidden name="imageFileName" value="%{#session.imageFileName}" />
							<s:hidden name="price" value="%{#session.price}" />
							<s:hidden name="releaseCompany"
								value="%{#session.releaseCompany}" />
							<s:hidden name="releaseDate" value="%{#session.releaseDate}" />
							<s:hidden name="productDescription"
								value="%{#session.productDescription}" />
						</div>
					</div>

				</s:form>
			</div>

			<div id="product-1column-container">
				<div id="contents-title">関連商品</div>
				<div id="reccomend-container">
					<s:iterator value="#session.productInfoDtoList">
						<div id="recomｍend-box">
							<div id="product-img-box2">
								<img
									src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'
									class="product-img2" />
							</div>
							<div id="recomｍend-box-text">
								<s:property value="productName" />
							</div>
							<a class="fadelink"
								href='<s:url action="ProductDetailsAction"><s:param name="productId" value="%{productId}" /></s:url>'></a>
						</div>
					</s:iterator>
				</div>
			</div>

			<div id="product-1column-container">
				<div id="contents-title">この商品のレビュー</div>
				<div id="topReviewList">
					<s:if test="#session.reviewList == null">
					現在まだレビューはありません
				</s:if>
					<s:else>
						<div id="topreview-title">トップレビュー</div>
						<br>
						<s:iterator value="#session.reviewList" status="st">
							<div id="review">
								<s:if test="#st.index < 1">
									<span> <img class="review-icon"
										src="./images/icons/review.png"> <span id="review-name"><s:property
												value="userName" /></span>
									</span>
									<br>
									<s:property value="point" />
									<s:property value="title" />
									<br>
									<s:property value="insertDate" />
									<br>
									<div id="review-value">
										<div id="details-property">
											<s:property value="reviewComment" />
										</div>
									</div>
								</s:if>
							</div>
						</s:iterator>
						<a href="all" onclick="OnLinkClick();">全レビューを表示</a>
					</s:else>
				</div>
			</div>

			<div id="hiddenAllReviewList">
				<div id="product-1column-container">
					<div id="allReviewList">
						<div id="allreview-title">全てのレビュー</div>
						<s:iterator value="#session.reviewList">
							<div id="review">
								<img class="review-icon" src="./images/icons/review.png">
								<s:property value="userName" />
								<br>
								<s:property value="point" />
								<s:property value="title" />
								<br>
								<s:property value="insertDate" />
								<br>
								<div id="details-property">
									<s:property value="reviewComment" />
								</div>
							</div>
						</s:iterator>
					</div>
				</div>
			</div>

			<div id="product-1column-container">
				<div id="reviewPost">
					<div id="contents-title">レビュー投稿</div>
					<br>
					<br>
					<div id="review-form">
						<s:form action="ReviewAction" class="reviewPost">
							<label id="review-title">投稿名</label>
							<br>
							<s:if test="!#session.reviewName == null">
								<s:textfield name="reviewName" placeholder="#session.reviewName" />
							</s:if>
							<s:else>
								<s:textfield name="reviewName" size="36"
									placeholder="16文字まで入力できます" />
							</s:else>
							<s:if test="!#session.nameErrorMessageList.isEmpty()">
								<div id="error">
									<div id="error-message1">
										<s:iterator value="#session.nameErrorMessageList">
											<s:property />
											<br>
										</s:iterator>
									</div>
								</div>
							</s:if>
							<br>
							<br>
							<br>
							<label id="review-title">タイトル</label>
							<br>
							<s:if test="!#session.reviewTitle == null">
								<s:textfield name="reviewTitle"
									placeholder="#session.reviewTitle" />
							</s:if>
							<s:else>
								<s:textfield name="reviewTitle" size="36"
									placeholder="50文字まで入力できます" />
							</s:else>
							<s:if test="!#session.titleErrorMessageList.isEmpty()">
								<div id="error">
									<div id="error-message1">
										<s:iterator value="#session.titleErrorMessageList">
											<s:property />
											<br>
										</s:iterator>
									</div>
								</div>
							</s:if>
							<br>
							<br>
							<br>
							<label id="review-title">本文</label>
							<br>
							<s:if test="!#session.ReviewComment == null">
								<s:textarea name="ReviewComment"
									placeholder="#session.ReviewComment" />
							</s:if>
							<s:else>
								<s:textarea name="ReviewComment" cols="42" rows="12"
									placeholder="255文字まで入力できます" />
							</s:else>
							<s:if test="!#session.commentErrorMessageList.isEmpty()">
								<div id="error">
									<div id="error-message1">
										<s:iterator value="#session.commentErrorMessageList">
											<s:property />
											<br>
										</s:iterator>
									</div>
								</div>
							</s:if>
							<br>
							<br>
							<br>
							<label id="review-title">評価</label>
							<br>
							<select name="reviewPoint">
								<option value="5"
									<s:if test="#session.reviewPoint == 5">selected="selected"</s:if>>星５</option>
								<option value="4"
									<s:if test="#session.reviewPoint == 4">selected="selected"</s:if>>星４</option>
								<option value="3"
									<s:if test="#session.reviewPoint == 3">selected="selected"</s:if>>星３</option>
								<option value="2"
									<s:if test="#session.reviewPoint == 2">selected="selected"</s:if>>星２</option>
								<option value="1"
									<s:if test="#session.reviewPoint == 1">selected="selected"</s:if>>星１</option>
							</select>
							<br>
							<br>
							<br>
							<s:hidden name="productId" value="%{#session.productId}" />
							<div id="review-send">
								<s:submit value="投稿する" class="bttn-unite bttn-sm bttn-primary" />
								<img class="send-icon" src="./images/icons/send.png">
							</div>
						</s:form>
					</div>
				</div>
			</div>

		</div>
	</div>

	<s:include value="footer.jsp" />

	<script src="js/reviewscroll.js"></script>
</body>
</html>