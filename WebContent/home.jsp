<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>bioral | オーガニック食品の通販なら | ビオラル</title>
<link rel="stylesheet" type="text/css" href="./css/home.css">
<link href="https://fonts.googleapis.com/css?family=Sedgwick+Ave" rel="stylesheet">
<script>
function go2SearchItemAction(){
	document.getElementById("categoryId").value=2;
	document.getElementById("form").action="SearchItemAction";
}
function go3SearchItemAction(){
	document.getElementById("categoryId").value=3;
	document.getElementById("form").action="SearchItemAction";
}
function go4SearchItemAction(){
	document.getElementById("categoryId").value=4;
	document.getElementById("form").action="SearchItemAction";
}
</script>

</head>

<body>
<jsp:include page="header.jsp" />

	<div id="sankaku1"></div>
    <div id="sankaku2">△</div>
    <div id="sankaku3">△</div>
    <div id="sankaku4">◇</div>

    <div id="scrollheader">
    <button id="btn1" onclick=idou("top",this) onmouseout=reset_anime(this)></button>
    <button id="btn2" onclick=idou("about_us",this) onmouseout=reset_anime(this)></button>
    <button id="btn3" onclick=idou("n1",this) onmouseout=reset_anime(this)></button>
    <button id="btn4" onclick=idou("n2",this) onmouseout=reset_anime(this)></button>
    <button id="btn5" onclick=idou("n3",this) onmouseout=reset_anime(this)></button>
    <button id="btn6" onclick=idou("end",this) onmouseout=reset_anime(this)></button>
    </div>


    <div id="top">

        <div id="textbox"><p>BIORAL</p></div>
        <div id="textbg"></div>
    <img src="./png/01.jpg">
    </div>

    <div id="about_us">
        <div id="catch">
        <div id="masking1"></div>
        <p>美味しいを毎日。</p>
        </div>
        <div id="textbox2">
            <h1>ABOUT US</h1><br>


            <h4>
                私たちbioralは<br>
                オーガニック製品を<br>
                お客様までお届けします<br>
                自然本来の恵みをあなたへ
            </h4>
        </div>
        <div id="textbg2"></div>
    <img src="./png/02.jpg" id="aboutpic">
    </div>



        <div class="category_space" id="n1">

        <p id="title1">FOOD</p>

        <div id="up1">
        <h1>自然の恵み</h1>
        <h3>
            オーガニックによって引き出した<br>
            自然本来の味をふんだんに活かした<br>
            様々な種類の食品をお客様へ。
        </h3>

		<s:form action="SearchItemAction">
		<s:hidden name="categoryId" id="categoryId" value="2"/>
        <button onclick="go2SearchItemAction();">MORE</button>
        </s:form>

        </div>

        <img src="./png/tes1_tori.jpg" id="tes1">
        </div>

        <div class="category_space" id="n2">

        <p id="title2">DRINK</p>

        <div id="up2">
        <h1>自然の爽気</h1>
        <h3>
            オーガニックによって引き出した<br>
            自然本来の味をふんだんに活かした<br>
            様々な種類の飲み物をお客様へ。
        </h3>

		<s:form action="SearchItemAction">
		<s:hidden name="categoryId" id="categoryId" value="3"/>
        <button onclick="go3SearchItemAction();">MORE</button>
        </s:form>





        </div>
        <img src="./png/tes3.jpg" id="tes2">
        </div>

        <div class="category_space" id="n3">

        <p id="title3">SWEET</p>

        <div id="up3">
        <h1>自然の甘み</h1>
        <h3>
            オーガニックによって引き出した<br>
            自然本来の味をふんだんに活かした<br>
            様々な種類のお菓子をお客様へ。
        </h3>

		<s:form action="SearchItemAction">
		<s:hidden name="categoryId" id="categoryId" value="4"/>
        <button onclick="go4SearchItemAction();">MORE</button>
        </s:form>

        </div>


        <img src="./png/tes5.jpg" id="tes3">

        </div>



    <div id="end">

        <div id="endborder">

        <img src="./png/japmap.png" id="map_pic">

        <div id="infotext">

        	<p id="title4">INFORMATION</p>

            <table id="infotable">

            	<tr>
                <th>団体名</th><td>bioral</td>
                </tr>

				<tr>
                <th>郵便番号</th><td>〒100-○×□△</td>
                </tr>

                <tr>
                <th>所在地</th><td>東京都千代田区○○-××-□□</td>
                </tr>

                <tr>
                <th>電話番号</th><td>TEL : 01-2345-6789</td>
                </tr>

                <tr>
                <th>FAX</th><td>FAX：01-2345-6789</td>
                </tr>

            </table>


        </div>

        </div>


    </div>

<div id="footer_home"><h5>Copyright 2018 Bioral all rights reserved</h5></div>

<script type="text/javascript" src="./js/home.js"></script>
</body>