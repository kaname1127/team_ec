<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/admin.css">
<title>ユーザー更新内容確認</title>
</head>
<body>
	<div id="left">
		<jsp:include page="adminHeader.jsp" />
	</div>

	<div id="right">
		<div id="contents-data">
			<h2>ユーザーの更新確認</h2>
			<h3>更新する内容は、以下でよろしいですか。</h3>
			<s:form action="UserUpdateCompleteAction">
				<table class="vertical-list-table">
					<tr>
						<th scope="row"><s:label value="姓" /></th>
						<td><s:property value="familyName" /></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="名" /></th>
						<td><s:property value="firstName" /></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="姓ふりがな" /></th>
						<td><s:property value="familyNameKana" /></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="名ふりがな" /></th>
						<td><s:property value="firstNameKana" /></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="性別" /></th>
						<td><s:property value="sex" /></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="メールアドレス" /></th>
						<td><s:property value="email" /></td>
					</tr>
					<tr>
						<th scope="row"><s:label value="ログインID" />
						<td><s:property value="loginId" />
					</tr>
					<tr>
						<th scope="row"><s:label value="パスワード" />
						<td><s:property value="password" />
					</tr>
					<tr>
						<th scope="row"><s:label value="権限" /></th>
						<td><s:property value="status" /></td>
				</table>

				<div class="edit_btn_box">
					<s:submit value="更新" class="button_base edit_btn" />
				</div>

				<s:hidden name="id" value="%{#session.id}" />
				<s:hidden name="loginId" value="%{loginId}" />
				<s:hidden name="password" value="%{password}" />
				<s:hidden name="familyName" value="%{familyName}" />
				<s:hidden name="firstName" value="%{firstName}" />
				<s:hidden name="familyNameKana" value="%{familyNameKana}" />
				<s:hidden name="firstNameKana" value="%{firstNameKana}" />
				<s:if test='sex.equals("男性")'>;
				<s:hidden name="sex" value="0" />
				</s:if>
				<s:if test='sex.equals("女性")'>
					<s:hidden name="sex" value="1" />
				</s:if>
				<s:hidden name="email" value="%{email}" />
				<s:if test='status.equals("ユーザー")'>
					<s:hidden name="status" value="0" />
				</s:if>
				<s:if test='status.equals("管理者")'>
					<s:hidden name="status" value="1" />
				</s:if>
			</s:form>

			<s:form action="UserUpdateAction">
				<div class="edit_btn_box">
					<s:submit value="前の画面に戻る" class="button_base edit_btn"
						onclick="goUserUpdateAction();" />
				</div>
			</s:form>
		</div>
		<footer>
			<jsp:include page="adminFooter.jsp" />
		</footer>
	</div>
</body>
</html>