<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/admin.css">
<title>商品更新内容の確認</title>
</head>
<body>
	<div id="left">
		<jsp:include page="adminHeader.jsp" />
	</div>

	<div id="right">
		<div id="contents-data">
			<h2>商品の更新確認</h2>
			<h3>更新する内容は、以下でよろしいですか。</h3>
			<s:form action="ProductUpdateCompleteAction">
				<table class="vertical-list-table">
					<tr>
						<th scope="row"><s:label value="商品カテゴリ" /></th>
						<td><s:property value="#session.categoryId" /></td>
					</tr>

					<tr>
						<th scope="row"><s:label value="商品名" /></th>
						<td><s:property value="productName" /></td>
					</tr>

					<tr>
						<th scope="row"><s:label value="商品名ふりがな" /></th>
						<td><s:property value="productNameKana" /></td>
					</tr>

					<tr>
						<th scope="row"><s:label value="商品詳細" /></th>
						<td><div id="description">
								<s:property value="productDescription" />
							</div></td>
					</tr>

					<tr>
						<th scope="row"><s:label value="価格" /></th>
						<td><s:property value="price" /><span>円</span></td>
					</tr>

					<tr>
						<th scope="row"><s:label value="発売会社名" /></th>
						<td><s:property value="releaseCompany" /></td>
					</tr>

					<tr>
						<th scope="row"><s:label value="発売年月日" /></th>
						<td><s:property value="releaseDate" /></td>
					</tr>


					<tr>
						<th scope="row"><s:label value="画像ファイル名" /></th>
						<td><s:property value="userImageFileName" /></td>
					</tr>

					<tr>
						<th scope="row"><s:label value="画像ファイル" /></th>
						<td><img src="images/<s:property value="userImageFileName"/>"
							width="500" height="300" /></td>
					</tr>


				</table>

				<div class="edit_btn_box">
					<s:submit value="この内容で更新する" class="button_base edit_btn" />
				</div>

				<s:hidden name="productName" value="%{productName}" />
				<s:hidden name="productNameKana" value="%{productNameKana}" />
				<s:hidden name="productDescription" value="%{productDescription}" />
				<s:hidden name="price" value="%{price}" />
				<s:hidden name="imageFileName" value="%{imageFileName}" />
				<s:hidden name="imageFilePath" value="%{imageFilePath}" />
				<s:hidden name="releaseCompany" value="%{releaseCompany}" />
				<s:hidden name="releaseDate" value="%{releaseDate}" />
				<s:hidden name="categoryId" value="%{categoryId}" />
				<s:hidden name="productId" value="%{productId}" />

			</s:form>

			<s:form action="ProductUpdateAction">
				<div class="edit_btn_box">
					<s:submit value="前の画面に戻る" class="button_base edit_btn"
						onclick="goProductUpdateAction();" />
				</div>
			</s:form>

		</div>
        <footer>
            <jsp:include page="adminFooter.jsp" />
        </footer>
	</div>
</body>
</html>