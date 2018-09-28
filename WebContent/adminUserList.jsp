<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/admin.css">
<title>ユーザー一覧</title>

</head>
<body>
	<div id="left">
		<jsp:include page="adminHeader.jsp" />
	</div>

	<div id="right">
		<div id="contents-data">
			<div id="top">
				<h2>ユーザー一覧</h2>
			</div>
			<div>
				<s:if test="userInfoDTO == null">
					<h3>ユーザー情報がありません。</h3>
				</s:if>
				<s:else>
					<h3>登録されているユーザーは以下の通りです。</h3>
					<h4>詳細を確認する場合は、画面右端の確認ボタンをクリックして下さい。</h4>

					<table class="horizontal-list-table">

						<thead>
							<tr>
								<th>ID</th>
								<th>ユーザーID</th>
								<th>姓</th>
								<th>名</th>
								<th>姓かな</th>
								<th>名かな</th>
								<th>性別</th>
								<th>権限</th>
								<th>メールアドレス</th>
								<th>登録日</th>
								<th>更新日</th>
								<th>詳細</th>
							</tr>
						</thead>

						<tbody>
							<s:iterator value="userInfoDTO">
								<s:form action="AdminUserDetailAction" id="form-user-info-list">
									<tr>
										<td><s:property value="id" /></td>
										<td><s:property value="userId" /></td>
										<td><s:property value="familyName" /></td>
										<td><s:property value="firstName" /></td>
										<td><s:property value="familyNameKana" /></td>
										<td><s:property value="firstNameKana" /></td>
										<td><s:if test="sex==0">男性</s:if> <s:if test="sex==1">女性</s:if>

										</td>
										<td><s:if test="status==0">一般ユーザー</s:if> <s:if
												test="status==1">管理者</s:if></td>

										<td><s:property value="email" /></td>
										<td><s:property value="registDate" /></td>
										<td><s:property value="updateDate" /></td>
										<td><input type="hidden" name="userId"
											value=<s:property value="userId"/>> <s:submit
												value="確認" /></td>
									</tr>
								</s:form>
							</s:iterator>
						</tbody>
					</table>
				</s:else>

			</div>
		</div>
		<footer>
			<jsp:include page="adminFooter.jsp" />
		</footer>
	</div>

</body>

</html>
