<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Memo List</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>

	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<section>
			<div class="container">
			<table class="table text-center">
				<thead>
					<tr>
						<th>No.</th>
						<th>제목</th>
						<th>시간</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>3</td>
						<td>중요한 메모</td>
						<td>2025-01-04</td>
						<td><button type="button" class="btn btn-danger">삭제</button></td>
					</tr>
					<tr>
						<td>2</td>
						<td>중요한</td>
						<td>2025-11-24</td>
						<td><button type="button" class="btn btn-danger">삭제</button></td>
					</tr>
					<tr>
						<td>1</td>
						<td>메모</td>
						<td>2025-08-12</td>
						<td><button type="button" class="btn btn-danger">삭제</button></td>
					</tr>
					<tr>
						<td>1</td>
						<td>메모</td>
						<td>2025-08-12</td>
						<td><button type="button" class="btn btn-danger">삭제</button></td>
					</tr>
					<tr>
						<td>1</td>
						<td>메모</td>
						<td>2025-08-12</td>
						<td><button type="button" class="btn btn-danger">삭제</button></td>
					</tr>
					
				</tbody>
			</table>
			</div>
			<div class="etc-function d-flex justify-content-end align-items-center">
				<button type="button" class="btn btn-warning" id="postBtn">글쓰기</button>
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
	</div>





<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>


<script>
	$(document).ready(function(){
		
		$("#postBtn").on("click", function(){
			location.href = "/post/post-memo";
		});
		
		
		
		
	});

</script>
</body>
</html>