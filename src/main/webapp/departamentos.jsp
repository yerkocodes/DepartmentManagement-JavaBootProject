<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- importamos bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>

	<div class="container-fluid bg-dark">

		<!-- HEADER -->
		<jsp:include page="layouts/header.jsp"></jsp:include>

		<!-- NAVBAR -->
		<jsp:include page="layouts/navBar.jsp"></jsp:include>

		<div class="container text-white" style="margin-top: 30px">
			<div class="row">
				<div class="col-sm-12">
					<h2 class="fw-bold">Consulta</h2>
				</div>
			</div>

			<div class="row">
				<div class="col-sm-12">
					<div id="tabla">
						<br>
						<table class="table table-sm table-dark">
							<thead>
								<tr>
									<th scope="col">Numero Departamento</th>
									<th scope="col">Nombre Departamento</th>
									<th scope="col">Ubicacion</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${departamentos}" var="temp">
									<tr>
										<td><c:out value="${temp.getNumDepto()}"></c:out></td>
										<td><c:out value="${temp.getNombreDepto()}"></c:out></td>
										<td><c:out value="${temp.getUbicacionDepto()}"></c:out></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!-- FOOTER -->
	<jsp:include page="layouts/footer.jsp"></jsp:include>
	
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>
</body>
</html>