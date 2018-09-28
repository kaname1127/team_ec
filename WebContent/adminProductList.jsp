<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/admin.css">
<title>商品一覧</title>
</head>
<body>

	<div id="left">
		<jsp:include page="adminHeader.jsp" />
	</div>

	<div id="right">
		<div id="contents-data">
			<h2>商品一覧</h2>
			<s:if test="productInfoDtoList == null">
				<div id="info">検索結果がありません。</div>
			</s:if>
			<s:else>
				<h3>登録されている商品は以下の通りです。</h3>
				<h4>詳細を確認する場合は、画像をクリックして下さい。</h4>
				<div id="product-list">

					<table class="horizontal-list-table">
						<thead>
							<tr>
								<th>商品ID</th>
								<th>商品画像</th>
								<th>商品名</th>
								<th>商品名かな</th>
								<th>商品詳細</th>
								<th>カテゴリID</th>
								<th>価格</th>
								<th>発売年月日</th>
								<th>発売会社</th>
								<th>登録日</th>
								<th>更新日</th>
							</tr>
						</thead>

						<tbody>
							<s:iterator value="productInfoDtoList">
								<tr>
									<td><s:property value="productId" />
									<td><a
										href='<s:url action="AdminProductDetailAction">
									<s:param name="productId" value="%{productId}"/>
									</s:url>'><img
											src='<s:property value="imageFilePath" />/<s:property value="imageFileName"/>'
											class="item-image-box-100" /></a></td>
									<td><s:property value="productName" />
									<td><s:property value="productNameKana" /></td>
									<td><s:property value="productDescription" /></td>
									<td><s:property value="categoryId" /></td>
									<td><s:property value="price" />円</td>
									<td><s:property value="releaseDate" /></td>
									<td><s:property value="releaseCompany" /></td>
									<td><s:property value="registDate" /></td>
									<td><s:property value="updateDate" /></td>
								</tr>

								<s:hidden name="productId" value="%{#productId}" />
								<s:hidden name="imageFilePath" value="%{#imageFilePath}" />
								<s:hidden name="imageFileName" value="%{#imageFileName}" />
								<s:hidden name="productName" value="%{#productName}" />
								<s:hidden name="productNameKana" value="%{#productNameKana}" />
								<s:hidden name="productDescription"
									value="%{#productDescription}" />
								<s:hidden name="categoryId" value="%{#categoryId}" />
								<s:hidden name="price" value="%{#price}" />
								<s:hidden name="releaseDate" value="%{#releaseDate}" />
								<s:hidden name="releaseCompany" value="%{#releaseCompany}" />
								<s:hidden name="registDate" value="%{#registDate}" />
								<s:hidden name="updateDate" value="%{#updateDate}" />
							</s:iterator>
						</tbody>
					</table>
				</div>
			</s:else>
		</div>
		<footer>
			<jsp:include page="adminFooter.jsp" />
		</footer>
	</div>
</body>
</html>