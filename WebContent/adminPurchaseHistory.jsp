<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/admin.css">
<title>管理者商品購入履歴一覧</title>
</head>
<body>
	<div id="left">
		<jsp:include page="adminHeader.jsp" />
	</div>

	<div id="right">
		<div id="contents-data">
			<h2>商品購入履歴一覧</h2>
			<s:if test="#session.purchaseHistoryInfoDtoList.size()>0">
				<h3>全ユーザーの購入履歴は、以下の通りです。</h3>
				<table class="horizontal-list-table">

					<thead>
						<tr>
							<th><s:label value="ID" /></th>
							<th><s:label value="ユーザーID" /></th>
							<th><s:label value="商品ID" /></th>
							<th><s:label value="個数" /></th>
							<th><s:label value="金額" /></th>
							<th><s:label value="宛先情報ID" /></th>
							<th><s:label value="登録日" /></th>
							<th><s:label value="更新日" /></th>
						</tr>
					</thead>

					<tbody>
						<s:iterator value="#session.purchaseHistoryInfoDtoList">
							<tr>
								<td><s:property value="id" /></td>
								<td><s:property value="userId" /></td>
								<td><s:property value="productId" /></td>
								<td><s:property value="productCount" />個</td>
								<td><s:property value="price" />円</td>
								<td><s:property value="destinationId" /></td>
								<td><s:property value="registDate" /></td>
								<td><s:property value="updateDate" /></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:if>
			<s:else>
				<div class="info">商品の購入履歴はありません。</div>
			</s:else>
		</div>
		<footer>
			<jsp:include page="adminFooter.jsp" />
		</footer>
	</div>
</body>
</html>