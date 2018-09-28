<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<sx:head cache="false" />
<link rel="stylesheet" href="./css/admin.css">
<title>商品情報更新</title>
</head>
<body>
	<div id="left">
		<jsp:include page="adminHeader.jsp" />
	</div>

	<div id="right">
		<div id="contents-data">
			<h1>商品情報の更新</h1>

			<s:if test="!#session.productNameErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.productNameErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!#session.productNameKanaErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.productNameKanaErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!#session.productDescriptionErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.productDescriptionErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!#session.priceErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.priceErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!#session.releaseCompanyErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.releaseCompanyErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!#session.releaseDateErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.releaseDateErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!#session.userImageFileNameErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.userImageFileNameErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
			</s:if>

			<script>
				document.getElementsByName("releaseDate").value = "2018/09/01";
				document.getElementsByname("dojo.releaseDate").value = "2018/09/01";
			</script>

			<div>
				<s:form action="ProductUpdateConfirmAction" method="post"
					enctype="multipart/form-data">

					<!-- sessionでDBに登録されている情報をデフォルトで表示 -->
					<div>
						<label>商品No：</label>
						<s:property value="%{#session.productId}" escape="false" />
						<s:hidden name="productId" value="%{#session.productId}" />
					</div>


					<table class="vertical-list-table">
						<!-- 既存カテゴリから選択式にする -->
						<tr>
							<th scope="row">商品カテゴリ</th>
							<td><select name="categoryId" id="categoryId"
								class="category_select">
									<option value="2">Food</option>
									<option value="3">Drink</option>
									<option value="4">Sweets</option>
							</select> <span class="description">既存のカテゴリーから選択</span></td>
						<tr>
						<tr>
							<th scope="row">商品名</th>
							<td><s:textfield name="productName"
									value="%{#session.productName}" label="商品名" placeholder="商品名"
									class="txt" /></td>
						</tr>

						<tr>
							<th scope="row">商品名かな</th>
							<td><s:textfield name="productNameKana"
									value="%{#session.productNameKana}" label="商品名かな"
									placeholder="商品名かな" class="txt" /></td>
						</tr>

						<tr>
							<th scope="row">商品詳細</th>
							<td><s:textfield name="productDescription"
									value="%{#session.productDescription}" label="商品詳細"
									placeholder="商品詳細" class="txt" /></td>
						</tr>

						<tr>
							<th scope="row">価格</th>
							<td><s:textfield name="price" value="%{#session.price}"
									label="価格" placeholder="価格" class="txt" /></td>
						</tr>

						<tr>
							<th scope="row">発売会社</th>
							<td><s:textfield name="releaseCompany"
									value="%{#session.releaseCompany}" label="発売会社"
									placeholder="発売会社" class="txt" /></td>
						</tr>


						<tr>
							<th scope="row">発売年月日</th>
							<td><sx:datetimepicker name="releaseDate"
									value="%{#session.releaseDate}" displayFormat="yyyy/MM/dd" /><span
								class="description">カレンダーから選択できます</span></td>
						</tr>

						<tr>
							<th scope="row">画像ファイル選択</th>
							<td><s:file name="userImage" label="画像ファイル"
									placeholder="画像ファイル" class="file" /></td>
						</tr>
					</table>


					<div class="edit_btn_box">
						<s:submit value="更新確認" class="button_base edit_btn" />
					</div>


				</s:form>
			</div>
		</div>
		<footer>
			<jsp:include page="adminFooter.jsp" />
		</footer>
	</div>
</body>
</html>