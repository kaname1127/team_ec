<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/admin.css">
</head>
<body>

	<div id="left">
		<jsp:include page="adminHeader.jsp" />
	</div>

	<div id="right">
		<div id="contents-data">
			<h1>ユーザー情報更新画面（管理者）</h1>

			<s:if test="!#session.familyNameErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.familyNameErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!#session.firstNameErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.firstNameErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!#session.familyNameKanaErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.familyNameKanaErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!#session.firstNameKanaErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.firstNameKanaErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!#session.emailErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.emailErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!session.loginIdErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.loginIdErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!#session.passwordErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.passwordErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
			</s:if>
			<s:if test="!#session.loginIdDuplicationErrorMessageList.isEmpty()">
				<div class="error">
					<div class="error-message">
						<s:iterator value="#session.loginIdDuplicationErrorMessageList">
							<s:property />
							<br>
						</s:iterator>
					</div>
				</div>
			</s:if>

			<s:form action="UserUpdateConfirmAction">

				<table class="vertical-list-table">
					<tr>
						<th scope="row">姓</th>
						<td><s:textfield name="familyName"
								value="%{#session.familyName}" label="姓" placeholder="姓"
								class="txt" /></td>
					</tr>
					<tr>
						<th scope="row">名</th>
						<td><s:textfield name="firstName"
								value="%{#session.firstName}" label="名" placeholder="名"
								class="txt" /></td>
					</tr>
					<tr>
						<th scope="row">姓ふりがな</th>
						<td><s:textfield name="familyNameKana"
								value="%{#session.familyNameKana}" label="姓ふりがな"
								placeholder="姓ふりがな" class="txt" /></td>
					</tr>
					<tr>
						<th scope="row">名ふりがな</th>
						<td><s:textfield name="firstNameKana"
								value="%{#session.firstNameKana}" label="名ふりがな"
								placeholder="名ふりがな" class="txt" /></td>
					</tr>
					<tr>
						<th scope="row">性別</th>
						<td><s:radio name="sex" list="%{#session.sexList}"
								value="%{#session.sexList}" label="性別" placeholder="性別" /></td>
					</tr>
					<tr>
						<th scope="row">メールアドレス</th>
						<td><s:textfield name="email" value="%{#session.email}"
								label="メールアドレス" placeholder="メールアドレス" class="txt" /></td>
					</tr>
					<tr>
						<th scope="row">ログインID</th>
						<td><s:textfield name="loginId" value="%{#session.userId}"
								label="ログインID" placeholder="ログインID" class="txt" /></td>
					</tr>
					<tr>
						<th scope="row">パスワード</th>
						<td><s:password name="password" value="" label="パスワード"
								placeholder="パスワード" class="txt" /></td>
					</tr>
					<tr>
						<th scope="row">権限</th>
						<td><s:radio name="status" list="%{#session.statusList}"
								value="%{#session.statusList}" label="権限" placeholder="権限" /></td>
					</tr>

				</table>



				<div class="edit_btn_box">
					<s:submit value="更新確認" class="button_base edit_btn" />
				</div>

			</s:form>
		</div>
		<footer>
			<jsp:include page="adminFooter.jsp" />
		</footer>
	</div>
</body>
</html>