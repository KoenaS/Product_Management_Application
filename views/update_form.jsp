<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>

<div class="container mt-3">
	<div class="row">
		<div class="col-md-6 offset-md-3">
			<h1 class="text-center mb-3">Change the product details</h1>
			<form action="${pageContext.request.contextPath }/update-product" method="post">

				<input type="hidden" value="${product.productId}" name = "productId"/>
				<div class="form-group">
					<label for="productName">Product Name</label> 
					<input type="text"
							class="form-control" 
							id="productName"
							aria-describedby="emailHelp"
							name="productName" 
							placeholder="Enter the product name here"
							value="${product.productName}">
				</div>

				<div class="form-group">
					<label for="productDescription">Product Description</label>
					<textarea class="form-control" 
							   id="productDescription"
							   name="productDescription"
							   rows="5"
							   placeholder="Enter the product description here">"${product.productDescription}"</textarea>
				</div>

				<div class="form-group">
					<label for="productPrice">Product Price</label> 
					<input type="text"
						   class="form-control" 
						   id="productPrice" name="productPrice"
						   placeholder="Enter the product price here"
						   value="${product.productPrice}">
				</div>
				
				<div class="container text-center">
					<a href="${pageContext.request.contextPath }/home" class="btn btn-outline-danger">Back</a>
					<button type="submit" class="btn btn-warning">Update</button>
				</div>

			</form>
		</div>
	</div>
</div>

</body>

</html>