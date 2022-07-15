<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
	integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<style type="text/css">
.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	text-align: center;
	border-radius: .25rem .25rem 0 0;
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#"> <img
				src="https://getbootstrap.com//docs/5.0/assets/brand/bootstrap-logo.svg"
				alt="" width="30" height="24" class="d-inline-block align-text-top">
				Navbar Bootstrap 5 &#128512;
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
						role="button" data-bs-toggle="dropdown" aria-expanded="false">
							Dropdown </a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
							<c:forEach items="${categories}" var="c">
								<li><a class="dropdown-item" href="#">${c}</a></li>
							</c:forEach>
						</ul></li>
					<li class="nav-item"><a class="nav-link disabled" href="#"
						tabindex="-1" aria-disabled="true">Disabled</a></li>
				</ul>
				
				<c:url value="/" var="action" />
				<form action="${action}" class="d-flex">
					<input class="form-control me-2" type="search" name="kw" placeholder="Search"
						aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Search</button>
				</form>
			</div>
		</div>
	</nav>
	<section>
		<div class="container">
			<h1>Hello World!!</h1>
			<div class="mb-3"></div>

			<label for="exampleDataList" class="form-label">Datalist
				example</label> <input class="form-control" list="datalistOptions"
				id="exampleDataList" placeholder="Type to search...">
			<datalist id="datalistOptions">
				<option value="San Francisco">
				<option value="New York">
				<option value="Seattle">
				<option value="Los Angeles">
				<option value="Chicago">
			</datalist>
			<!-- Card img -->
			<div class="row">
				<c:forEach items="${products}" var="p">

					<div class="col-md-3 col-xs-12">
						<div class="card mb-3" style="max-width: 540px;">
							<div class="row g-0">
								<div class="col-md-4">
									<img
										src="https://res.cloudinary.com/dhyyyqwaf/image/upload/v1657857087/t%E1%BA%A3i_xu%E1%BB%91ng_1_tnjsx6.jpg"
										class="img-fluid rounded-start" alt="...">
								</div>
								<div class="col-md-8">
									<div class="card-body">
										<h5 class="card-title">${p}</h5>
										<p class="card-text">This is a wider card with supporting
											text below as a natural lead-in to additional content.</p>
										<p class="card-text">
											<small class="text-muted">Last updated 3 mins ago</small>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
	<footer class="footer bg-warning text-white">
		<p>Qliphort Shell &copy; 2022</p>
		<p>
			<a href="mailto:hege@example.com">nhoangkiet35@gmail.com</a>
		</p>
	</footer>
</body>
</html>