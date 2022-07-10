<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insertImages" method = "post" enctype="multipart/form-data">
	<input type="file" name="profileImage">
	<input type = "submit" value = "upload">
</form>

	<div>
		<img src="${pageContext.request.contextPath}${url }">	
	</div>
</body>
</html>