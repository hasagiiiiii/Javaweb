<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create Book</title>
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	<link rel="stylesheet" href="css/main.css" type="text/css">
</head>
<body>
	<section class="container">
		<h3>Create Account</h3>
		<p style="color: red;">${errorString}</p>
		<form method="POST" action="${pageContext.request.contextPath}/CreateAccount" enctype="multipart/form-data">
			<table class="table table-bordered">
				<tr>
					<td>FirstName</td>
					<td><input type="text" name="firstName"   /></td>
				</tr>
				<tr>
					<td>LastName</td>
					<td><input type="text" name="lastName"  /></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="userName"  /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="text" name="password"  /></td>
				</tr>
				<tr>
					<td>Ảnh</td>
					<td><input type="file" name="ImgUser" accept="image/*"  /></td>
				</tr>	
				<tr>
					<td>Role</td>
					<td>
						<select name="role_id">
							<c:forEach items="${role}" var="role" >
								<option value="${role}">${role}</option>
							</c:forEach>
						</select>
					</td>
				</tr>			
				<tr>
					<td></td>
					<td>
						<input type="submit" name="Submit" class="btn btn-success" />
						<a href="Account" class="btn btn-danger">Quay lại</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>