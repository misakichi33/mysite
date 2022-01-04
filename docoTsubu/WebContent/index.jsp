<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>どこつぶ</title>

<link rel="stylesheet"href="css/style.css">

<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet">
</head>
<body>

<h1>✧˖°うぇるかむどこつぶ°˖✧</h1>

<form action="/docoTsubu/Login"method="post">
ふーあーゆー？：<input type="text" name="name"><br>
ひみつのことば：<input type="password" name="pass"><br>


<button type="submit"class="btn btn-border-shadow btn-border-shadow--color"> ろぐいん→</button>


</form>
<jsp:include page="/footer.jsp"/>
</body>
</html>