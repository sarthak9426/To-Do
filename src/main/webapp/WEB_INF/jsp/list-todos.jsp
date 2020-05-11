<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<h1>Your Todo's</h1>
<br>
<table class="table table-striped">
	<thead>
		<tr>
			<th>Description</th>
			<th>Target Date</th>
			<th>Is is Done?</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${todos}" var="todo">
			<tr>
				<td>${todo.desc}</td>
				<td>${todo.targetDate}</td>
				<td>${todo.done}</td>
				<td><a href="/deletetodo?id=${todo.id}" type="button" class="btn btn-warning">Delete</a>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div>
<a class="button" href="add-todo">Add a todo</a>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</div>
</body>
</html>