<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/admin.css">
<title>商品削除画面</title>
</head>

<body>

	<div id="left">
		<jsp:include page="adminHeader.jsp" />
	</div>

	<div id="right">
		<div id="contents-data">
			<h1>商品の削除</h1>
			<h3>この商品を削除してよろしいですか？</h3>

			<s:if test="#session.checkListErrorMessageList != null">
				<div class="error_c">
					<div class="error-message">
						<s:iterator value="#session.checkListErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
			</s:if>

			<s:if test="productInfoDtoList==null">
				<div class="info">商品がありません。</div>
			</s:if>

			<s:else>
				<s:form id="form" action="AdminProductDeleteCompleteAction">

					<table class="horizontal-list-table">
						<thead>
							<tr>
								<th><s:label value="商品画像" /></th>
								<th><s:label value="商品名" /></th>
								<th><s:label value="ふりがな" /></th>
								<th><s:label value="値段" /></th>
								<th><s:label value="発売会社名" /></th>
								<th><s:label value="発売年月日" /></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<s:hidden name="productId" value="%{productId}" />
								<td><img
									src='<s:property value="%{#session.imageFilePath}"/>/<s:property value="%{#session.imageFileName}"/>'
									width="150px" height="150px" class="item-image-box-200" /></td>
								<td><s:property value="%{#session.productName}" /></td>
								<td><s:property value="%{#session.productNameKana}" /></td>

								<td><s:property value="%{#session.price}" />円</td>
								<td><s:property value="%{#session.releaseCompany}" /></td>
								<td><s:property value="%{#session.releaseDate}" /></td>
							</tr>
							<s:hidden name="productName" value="%{productName}" />
							<s:hidden name="productNameKana" value="%{productNameKana}" />
							<s:hidden name="imageFileName" value="%{imageFileName}" />
							<s:hidden name="imageFilePath" value="%{imageFilePath}" />
							<s:hidden name="price" value="%{price}]" />
							<s:hidden name="releaseCompany" value="%{releaseCompany}" />
							<s:hidden name="releaseDate" value="%{releaseDate}" />
						</tbody>
					</table>


					<div class="edit_btn_box">
						<s:submit value="削除" class="button_base edit_btn" />
					</div>


				</s:form>
			</s:else>
		</div>
		<footer>
			<jsp:include page="adminFooter.jsp" />
		</footer>
	</div>
</body>
</html>