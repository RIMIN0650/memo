<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모 회원가입 페이지</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
<!-- css는 client가 접근 가능한 경로여야함 -->
</head>
<body>
	
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<section class="d-flex justify-content-center">
			<div class="my-5">
				<h1 class="text-center mb-3">회원가입</h1>	
				<input type="text" class="form-control col-12 mb-3" id="identifier" placeholder="ID">
				<input type="password" class="form-control col-12 mb-3" id="password" placeholder="비밀번호">
				<input type="password" class="form-control col-12 mb-3" id="checkPwd" placeholder="비밀번호 확인">
				<input type="text" class="form-control col-12 mb-3" id="name" placeholder="이름">
				<input type="text" class="form-control col-12 mb-3" id="email" placeholder="이메일 주소">
				<button type="button" class="btn btn-success col-12" id="joinBtn">가입</button>
				<div class="text-center">
					<a href="/user/log-in">로그인</a>
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
		
		$("#joinBtn").on("click", function(){
			// 입력된 값 가져오기
			// 유효성 검사
			
			
			let id = $("#identifier").val();
			let password = $("#password").val();
			let checkPwd = $("#checkPwd").val();
			let name = $("#name").val();
			let email = $("#email").val();

			if(id == ""){
				alert("아이디를 입력하세요.");
				return;
			}
			if(password == ""){
				alert("비밀번호를 입력하세요.");
				return;
			}
			if(password != checkPwd){
				alert("비밀번호를 다시 확인하세요");
				return;
			}
			if(name == ""){
				alert("이름을 입력하세요.");
				return;
			}
			if(email == ""){
				alert("이메일을 입력하세요.");
				return;
			}
			
			$.ajax({
				type:"post"
				, url:"/user/join"
				, data:{"loginId":id, "password":password, "name":name, "email":email}
				, success:function(data){
					if(data.result == "success"){
						// 로그인 페이지로 이동
						location.href = "/user/log-in";
					} else {
						alert("회원 가입 실패");
					}
				}
				, error:function(){
					alert("회원 가입 에러");
				}
			});

		
		});
		
		
		
	});




</script>


</body>
</html>