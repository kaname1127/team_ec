<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/productList.css">
<link rel="stylesheet" href="./css/header.css">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.1.0.min.js"></script>

<script src="js/fade.js"></script>


<title>商品一覧</title>


</head>
<body class="is-hide">

	<jsp:include page="header.jsp" />

	<div id="contents2">
		<div id="contents-title">
			<h1>PRODUCTS</h1>
		</div>
		<s:if test="productInfoDtoList == null">
			<div id="info">
				<s:if test="#session.errorMessageFlg == 1">
					登録商品がありません。
				</s:if>
				<s:elseif test="#session.errorMessageFlg == 2">
					検索結果がありません。
				</s:elseif>
			</div>
		</s:if>
		<s:else>
			<div id="product-list">
				<s:iterator value="#session.productInfoDtoList">
						<div id="product-list-box">
							<ul>
								<li>
									<div id="product-name-box">
										<s:property value="productName" /><br>
									</div>
									<div id="product-name-kana-box">
										<s:property value="productNameKana" />
									</div>
									<div id="product-img-box">
											<img
											src='<s:property value="imageFilePath"/>/<s:property value="imageFileName"/>'
											class="item-image-box-200" />
									</div><br>
									<div id="product-price-box">
										 &yen;<s:property value="price" />(税込)
									</div>
								</li>
							</ul>
							<a
								href='<s:url action="ProductDetailsAction">
								<s:param name="productId" value="%{productId}"/>
								</s:url>' class="fadelink">
							</a>
						</div>
				</s:iterator>
			</div>
			<div class="pager">
				<s:iterator begin="1" end="#session.totalPageSize" status="pageNo">
					<s:if test="#session.currentPageNo == #pageNo.count">
						<s:property value="%{#pageNo.count}" />
					</s:if>
					<s:else>
						<a class="fadelink"
							href="<s:url action='SearchItemAction'><s:param name='pageNo' value='%{#pageNo.count}' /><s:param name='categoryId' value='%{categoryId}' /></s:url>"><s:property value="%{#pageNo.count}" />
						</a>
					</s:else>
				</s:iterator>
			</div>
		</s:else>
	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>