<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${title }</h1>
	
	<h2>${thay }</h2>
	
	<div class="container">
		<div>
			<form action="${pageContext.request.contextPath}/f/upload" method="post"
			enctype="multipart/form-data">
				<label>Upload file :</label> <input type="file" name="profileImage"/>
				<input type="submit" value="upload"/>
			</form>
		</div>
		<div>
			<p>Can client access uploaded file</p>
			<p>@see servlet-context.xml</p>
			<img alt="alt" src="${pageContext.request.contextPath}${url}">
		</div>
	</div>

	
</body>
</html>