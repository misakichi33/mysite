<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>

<link rel="stylesheet"href="./css/style.css">
<script src="./js/javascript.js"></script>


<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet">

</head>
<body>
<h1>✧˖°どこつぶめいん°˖✧</h1>

<p><span><c:out value="${loginUser.name}"/>さん、ろぐいんちゅう・・・</span></p><br>
<a href="/docoTsubu/Logout"
	class="btn btn-border-shadow btn-border-shadow--color"
	style="padding:4px;margin:0 30px 0 0;">ろぐあうと</a>
<a href="/docoTsubu/Main"
	class="btn btn-border-shadow btn-border-shadow--color"
	style="padding:12px">更新</a>

<form action="/docoTsubu/Main" method="post">
<input type="text"
		name="text"
		placeholder="なんでもつぶやいちゃいなよYOU!!"
		style="width: 500px; height: 80px;margin:50px;border-width:5px;"><br>

<div>
<c:if test="${not empty errorMsg}">
	<p class="box">${errorMsg}</p>
</c:if>
</div>

<button type="submit"class="btn btn-border-shadow btn-border-shadow--color"style="margin:5px;padding:20px"> つぶやく</button>

</form>

<c:forEach var="mutter" items="${mutterList}">
	<p><c:out value="${mutter.userName }"/>:
		<c:out value="${mutter.text }"/>
	</p>

</c:forEach>

<jsp:include page="/footer.jsp"/>
</body>
</html>