<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/admin.css">
<title>商品詳細</title>
</head>
<body>
	<div id="left">
		<jsp:include page="adminHeader.jsp" />
	</div>

	<div id="right">
		<div id="contents-data">
			<h1>商品詳細</h1>

			<h2>
				<s:label value="商品名：" />
				<s:property value="%{#session.productName}" />
				（
				<s:label value="かな：" />
				<s:property value="%{#session.productNameKana}" />
				）
			</h2>

			<div class="box">
				<div class="product_container">
					<div class="image_container">
						<div class="product_image_box">
							<img
								src='<s:property value="%{#session.imageFilePath}"/>/<s:property value="%{#session.imageFileName}"/>'
								width="100%" height="100%" class="product_image" /><br>
						</div>
					</div>
					<div class="product_details">
						<table class="vertical-list-table">
							<tr>
								<th scope="row"><s:label value="ID" /></th>
								<td><s:property value="%{#session.id}" /></td>
							</tr>
							<tr>
								<th scope="row"><s:label value="商品ID" /></th>
								<td><s:property value="%{#session.productId}" /></td>
							</tr>
							<tr>
								<th scope="row"><s:label value="カテゴリID" /></th>
								<td><s:property value="%{#session.categoryId}" /></td>
							</tr>
							<tr>
								<th scope="row"><s:label value="商品詳細" /></th>
								<td><s:property value="%{#session.productDescription}" /></td>
							</tr>
							<tr>
								<th scope="row"><s:label value="価格" /></th>
								<td><s:property value="%{#session.price}" />円</td>
							</tr>
							<tr>
								<th scope="row"><s:label value="発売会社名" /></th>
								<td><s:property value="%{#session.releaseCompany}" /></td>
							</tr>
							<tr>
								<th scope="row"><s:label value="発売年月日" /></th>
								<td><s:property value="%{#session.releaseDate}" /></td>
							</tr>
							<tr>
								<th scope="row"><s:label value="登録日" /></th>
								<td><s:property value="%{#session.registDate}" /></td>
							</tr>
							<tr>
								<th scope="row"><s:label value="更新日" /></th>
								<td><s:property value="%{#session.updateDate}" /></td>
							</tr>

						</table>
					</div>
				</div>
				<s:hidden name="productId" value="%{#session.productId}" />
				<s:hidden name="productName" value="%{#session.productName}" />
				<s:hidden name="productNameKana" value="%{#session.productNameKana}" />
				<s:hidden name="productDescription"
					value="%{#session.productDescription}" />
				<s:hidden name="imageFilePath" value="%{#session.imageFilePath}" />
				<s:hidden name="imageFileName" value="%{#session.imageFileName}" />
				<s:hidden name="price" value="%{#session.price}" />
				<s:hidden name="releaseCompany" value="%{#session.releaseCompany}" />
				<s:hidden name="releaseDate" value="%{#session.releaseDate}" />
			</div>

			<!-- updateとdelete -->
			<div id="edit">
				<div class="edit_box">
					<a href="ProductUpdateAction"><font color="#000000"><img
							class="edit_icon" src="./images/icons/update.png"><br>商品更新</font></a>
				</div>

				<div class="edit_box">
					<a href="AdminProductDeleteAction"><font color="#000000"><img
							class="edit_icon" src="./images/icons/delete.png"><br>商品削除</font></a>
				</div>
			</div>

			<h3>| Pick up</h3>
			<div id="recommend_box">

				<div class="recomｍend_product_details_box">
					<s:iterator value="#session.productInfoDtoList">
						<div class="recommend">
							<div class="recommend_box_img">
								<a
									href='<s:url action="AdminProductDetailAction">
										<s:param name="productId" value="%{productId}"/></s:url>'><img
									src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'
									class="item-image-box" /></a>
							</div>
							<s:property value="productName" />
							<br>
						</div>
					</s:iterator>
				</div>
			</div>
		</div>
		<footer>
			<jsp:include page="adminFooter.jsp" />
		</footer>
	</div>
</body>
</html>