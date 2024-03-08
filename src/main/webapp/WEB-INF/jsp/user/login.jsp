<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 로그인 페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div>
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<section class="d-flex justify-content-center">
			<div class="my-5">
				<input type="text" class="form-control col-12 mb-3" placeholder="ID" id="identifier">
				<input type="password" class="form-control col-12 mb-3" placeholder="Password" id="password">
				<button type="button" class="btn btn-success col-12 mb-1" id="loginBtn">로그인</button>
				<div class="text-center">
					<a href="/user/join-view">회원가입</a>
				</div>
			</div>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
		
	</div>





<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>

<script>
	$(document).ready(function(){
		
		$("#loginBtn").on("click", function(){
			
			let id = $("#identifier").val();
			let password = $("#password").val();
			
			if(id == ""){
				alert("아이디를 입력하세요");
				return;
			}
			
			if(password == ""){
				alert("비밀번호를 입력하세요");
				return;
			}
			
			$.ajax({
				type:"post"
				, url:"/user/login"
				, data:{"loginId":id, "password":password}
				, success:function(data) {
					if(data.result == "success"){
						alert("환영합니다");
						location.href = "/post/list-view";
					} else {
						alert("로그인 실패");
					}
				}
				, error:function(){
					alert("로그인 에러");
				}	
			});
		});	
	});


</script>


</body>
</html>