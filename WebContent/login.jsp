<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/inputForm.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.0.min.js"></script>
<script src="js/fade.js"></script>
<title>ログイン</title>

<!-- css実験用 -->
<style type="text/css">

/* input-formにあたる部分-------------------- */
#input-form2 {
	border-top: 2px solid rgba(0, 0, 128, 0.4);
	border-left: 2px solid rgba(0, 0, 128, 0.4);
	border-right: 2px solid rgba(0, 0, 128, 0.4);
	width: 40%;
	margin: 0 4% 0 6%;
	padding-top: 1%;
	text-align: center;
	/* background-color: rgba(0, 200, 0, 0.1); */
	border-radius: 25px 25px 0 0/25px 25px 0 0;
	text-align: center;
}

#contents-btn-set2 {
	border-left: 2px solid rgba(0, 0, 128, 0.4);
	border-right: 2px solid rgba(0, 0, 128, 0.4);
	border-bottom: 2px solid rgba(0, 0, 128, 0.4);
	width: 40%;
	margin: 0 4% 0 6%;
	padding-bottom: 2%;
	text-align: center;
	border-radius: 0 0 25px 25px/0 0 25px 25px;
}
/* -------------------------------------------------------------- */

/* ログイン保存--------------------------------- */
#keepId2 {
	display: inline-block;
	cursor: pointer;
	transition-duration: 1s;
	-webkit-transition-duration: 1s;
	font-size: 18px;
}

#keepId2:hover {
/* 文字を高速回転させる！！！ */
/* 	transform: rotateY(1440deg); */
/* 	-webkit-transform: rotateY(1440deg); */
	color: #54D7BA;
}

#keep {
	position: relative;
	margin: 0 1rem 0 0;
	cursor: pointer;
}

#keep:before {
	position: absolute;
	z-index: 1;
	top: 0.125rem;
	left: 0.1875rem;
	width: 0.75rem;
	height: 0.375rem;
	content: '';
	-webkit-transition: -webkit-transform 0.4s
		cubic-bezier(0.45, 1.8, 0.5, 0.75);
	transition: transform 0.4s cubic-bezier(0.45, 1.8, 0.5, 0.75);
	-webkit-transform: rotate(-45deg) scale(0, 0);
	transform: rotate(-45deg) scale(0, 0);
	border: 2px solid #da3c41;
	border-top-style: none;
	border-right-style: none;
}

#keep:checked:before {
	-webkit-transform: rotate(-45deg) scale(1, 1);
	transform: rotate(-45deg) scale(1, 1);
}

#keep:after {
	position: absolute;
	top: -0.125rem;
	left: 0;
	width: 1rem;
	height: 1rem;
	content: '';
	cursor: pointer;
	border: 2px solid #f2f2f2;
	background: #ffffff;
}
/* ------------------------------------- */

/* リンク------------------------------------ */
a {
	display: inline-block;
	transition-duration: 0.5s;
	font-family: Verdana, Helvetica, sans-serif;
	font-size: 18px;
	transition-duration: 0.5s;
}

a:link {
	color: rgba(60, 0, 120, 0.9);
}

a:visited {
	color: rgba(60, 0, 120, 0.9);
}

a:hover {
	color: rgba(0, 0, 255, 0.9);
	transform: translateY(-5px);
	-webkit-transform: translateY(-5px);
}

#contents-btn-set2 a{
	text-decoration: none;
}
/* ---------------------------------------------- */
</style>

<script>
	function goLoginAction() {
		document.getElementById("form").action = "LoginAction";
	}
	function goCreateUserAction() {
		document.getElementById("form").action = "CreateUserAction";
	}
	function goResetPasswordAction() {
		document.getElementById("form").action = "ResetPasswordAction";
	}
</script>
</head>
<body class="is-hide">
	<jsp:include page="header.jsp" />
	<div id="contents">
		<div id="main-box-none">
			<s:form id="form" action="LoginAction" autocomplete="new-password">
				<div id="errormessage-form">
					<s:if test="!#session.loginIdErrorMessageList.isEmpty()">
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
					<!-- nonExistsErrorMessageList追加 -->
					<s:if test="!#session.nonExistsErrorMessageList.isEmpty()">
						<div class="error">
							<div class="error-message">
								<s:iterator value="#session.nonExistsErrorMessageList">
									<s:property />
									<br>
								</s:iterator>
							</div>
						</div>
					</s:if>
				</div>
				<!--
	SAVED:<s:property value="%{#session.savedLoginId}"/>
	LOGINID:<s:property value="%{#session.loginId}"/>
-->

				<div id="input-form2">
					<h2>ログイン</h2>
					<table id="vertical-list-table">
						<tr>
							<th scope="row"><s:label value="ログインID: " /><br> <br></th>
							<s:if test="#session.savedLoginId==true">
								<td><s:textfield name="loginId" class="txt fade-background"
										size="30" placeholder="ログインID" value='%{#session.keepLoginId}'
										autocomplete="new-password" /><br> <br></td>
							</s:if>
							<s:else>
								<td><s:textfield name="loginId" class="txt fade-background"
										size="30" placeholder="8文字以下" autocomplete="new-password" /><br>
									<br></td>
							</s:else>
						</tr>
						<tr>
							<th scope="row"><s:label value="パスワード: " /><br> <br></th>
							<td><s:password name="password" class="txt fade-background"
									size="30" placeholder="16文字以下" autocomplete="new-password" /><br>
								<br></td>
						</tr>
					</table>
					<label class="box"> <s:if
							test="#session.savedLoginId==true">
							<s:checkbox name="savedLoginId" checked="checked" id="keep" />
						</s:if> <s:else>
							<s:checkbox name="savedLoginId" id="keep" />
						</s:else> <s:label value="ログインID保存" id="keepId2" for="keep" /> <br> <br>
					</label>
					<div class="submit_btn_box">
						<s:submit value="login" class="bttn-unite bttn-sm bttn-primary"
							onclick="goLoginAction();" />
					</div>
					<br> <br>
				</div>
			</s:form>
			<div class="submit_btn_box">
				<div id="contents-btn-set2">
					<a href='<s:url action="CreateUserAction" ></s:url>'
						class="fadelink bttn-unite bttn-sm bttn-primary">新規ユーザー登録</a> <a
						href='<s:url action="ResetPasswordAction"></s:url>' class="fadelink bttn-unite bttn-sm bttn-primary">パスワード再設定</a>
				</div>
			</div>
			<div id="clear"></div>
		</div>
	</div>


	<%--  ボタンver.
		<div class="submit_btn_box">
			<div id=".contents-btn-set">
				<s:form action="CreateUserAction">
					<s:submit value="新規ユーザー登録" class="submit_btn" />
				</s:form>
			</div>
		</div>
		<div class="submit_btn_box">
			<div id=".contents-btn-set">
				<s:form action="ResetPasswordAction">
					<s:submit value="パスワード再設定" class="submit_btn" />
				</s:form>
			</div>
		</div> --%>


	<footer>
		<s:include value="footer.jsp" />
	</footer>
</body>
</html>