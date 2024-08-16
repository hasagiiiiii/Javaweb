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
		<h3>Create Product</h3>
		<p style="color: red;">${errorString}</p>
		<form method="POST" action="${pageContext.request.contextPath}/CreateProduct" enctype="multipart/form-data">
			<table class="table table-bordered">
				<tr>
					<td>Name Product</td>
					<td><input type="text" name="nameProduct"   /></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="price"  /></td>
				</tr>
				<tr>
					<td>Sale</td>
					<td><input type="text" name="sale"  /></td>
				</tr>
				<tr>
					<td>Số lượng sẵn có</td>
					<td><input type="text" name="quantityPro"  /></td>
				</tr>
				<tr>
					<td>Description</td>
					<td><textarea name="description"  rows="10" cols="100"/></textarea></td>
				</tr>
				<tr>
					<td>Ảnh</td>
					<td><input type="file" name="imgPro" accept="image/*"  /></td>
				</tr>	
				<tr>
					<td>Trademark</td>
					<td>
						<select name="trademark">
							<c:forEach items="${Tradmark}" var="Tradmark" >
								<option value="${Tradmark}">${Tradmark}</option>
							</c:forEach>
						</select>
					</td>
				</tr>		
				<tr>
					<td>Color</td>
					<td>
						<select name=colorPro>
							<c:forEach items="${Color}" var="Color" >
								<option value="${Color}">${Color}</option>
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