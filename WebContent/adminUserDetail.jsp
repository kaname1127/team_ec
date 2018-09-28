<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/admin.css">
<title>ユーザー詳細画面</title>
</head>
<body>
	<div id="left">
		<jsp:include page="adminHeader.jsp" />
	</div>

	<div id="right">
		<div id="contents-data">
			<div id="top">
				<h2>ユーザー情報詳細</h2>
				<table class="vertical-list-table">
					<tr>
						<th>ID</th>
						<td><s:property value="%{#session.id}" /></td>
					</tr>
					<tr>
						<th>ユーザーID</th>
						<td><s:property value="%{#session.userId}" /></td>
					</tr>
					<tr>
						<th>姓</th>
						<td><s:property value="%{#session.familyName}" /></td>
					</tr>
					<tr>
						<th>名</th>
						<td><s:property value="%{#session.firstName}" /></td>
					</tr>
					<tr>
						<th>姓かな</th>
						<td><s:property value="%{#session.familyNameKana}" /></td>
					</tr>
					<tr>
						<th>名かな</th>
						<td><s:property value="%{#session.firstNameKana}" /></td>
					</tr>
					<tr>
						<th>性別</th>
						<td><s:property value="%{#session.sexName}" /></td>
					</tr>
					<tr>
						<th>メールアドレス</th>
						<td><s:property value="%{#session.email}" /></td>
					</tr>
					<tr>
						<th>権限</th>
						<td><s:property value="%{#session.statusName}" /></td>
					</tr>
					<tr>
						<th>登録日</th>
						<td><s:property value="%{#session.registDate}" /></td>
					</tr>
					<tr>
						<th>更新日</th>
						<td><s:property value="%{#session.updateDate}" /></td>
					</tr>
				</table>
				<div id="edit">
					<div class="edit_box">
						<a href="UserUpdateAction"><font color="#000000"><img
								class="edit_icon" src="./images/icons/update.png"><br>ユーザー更新</font></a>
					</div>

					<div class="edit_box">
						<a href="AdminUserDeleteAction"><font color="#000000"><img
								class="edit_icon" src="./images/icons/delete.png"><br>ユーザー削除</font></a>
					</div>
				</div>
			</div>
		</div>

		<footer>
			<jsp:include page="adminFooter.jsp" />
		</footer>
	</div>
</body>
</html>