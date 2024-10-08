<html>
<head>
<%@include file="./base.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to Product App</h1>

				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Product Name</th>
							<th scope="col">Product Description</th>
							<th scope="col">Product Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${products }" var="p">
						<tr>
							<th scope="row">${p.productId }</th>
							<td>${p.productName }</td>
							<td>${p.productDescription }</td>
							<td class="font-weight-bold">&#x20B9; ${p.productPrice }</td>
							<td><a href="delete/${p.productId }"><i class="fa-solid fa-trash-can text-danger" style="font-size: 20px;"></i></a>
								<a href="update/${p.productId }"><i class="fa-solid fa-pen-nib text-primary" style="font-size: 20px;"></i></a>
							</td>
						</tr>
					</c:forEach>
						
					</tbody>
				</table>
				
				<div class="container text-center">
					<a href="add-product" class="btn btn-outline-success">Add Product</a>
				</div>

			</div>
		</div>
	</div>

</body>
</html>
