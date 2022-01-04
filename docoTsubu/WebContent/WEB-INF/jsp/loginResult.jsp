<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="model.User" %>
<%
//セッションスコープからユーザー名を取得
User loginUser= (User)session.getAttribute("loginUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
<link rel="stylesheet"href="css/style.css">

<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet">

</head>
<body>
<h1>✧˖°どこつぶろぐいん°˖✧</h1>
<%if(loginUser!= null){ %>
	<p class="ログイン">つぶつぶ…やきやき…</p>
	<p><span>ようこそ  <%= loginUser.getName() %>  さん！</span></p>

	<a href="/docoTsubu/Main"class="btn btn-border-shadow btn-border-shadow--color"style="margin:100px 0 0 0;">さぁ つぶやこう！</a>


<% }else{	%>
	<p>ろぐいんに失敗しました</p>
	<a href="/docoTsubu/"class="btn btn-border-shadow btn-border-shadow--color">とっぷ→</a>
<% }%>


<jsp:include page="/footer.jsp"/>
</body>
</html>