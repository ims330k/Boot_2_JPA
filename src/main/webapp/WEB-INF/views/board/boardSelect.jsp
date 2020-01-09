<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/nav.jsp"></c:import>
<div class="contents">
	<h1>Title :${vo.title}</h1>
	<h1>Writer:${vo.writer}</h1>
	<h1>Contents : ${vo.contents}</h1>
	<c:forEach items="${vo.noticeFilesVOs}" var="file">
		<h3>${file.fname}</h3>
	</c:forEach>

</div>

</body>
</html>