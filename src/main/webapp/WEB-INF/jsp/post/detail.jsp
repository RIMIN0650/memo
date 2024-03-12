<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메모입력</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
<link rel="stylesheet" href="/static/css/style.css" type="text/css">
</head>
<body>
	<div id="wrap">
		<c:import url="/WEB-INF/jsp/include/header.jsp" />
		<section>
			<div class="input-section">
			
				<h1 class="text-center mb-3">메모입력</h1>
				<div>
					<div class="d-flex justify-content-between align-items-center mb-3">
						<label class="input-label col-1">제목</label><input type="text" class="form-control text-input col-10" id="titleInput" value="${post.title }">
					</div>
					<input type="text" class="form-control text-input" style="height:300px;" id="contentsInput" value="${post.contents  }">
					<img src="${post.imagePath }">
					
				</div>
				
			</div>
			<div class="etc-function d-flex justify-content-center align-items-center">
				<button type="button" class="btn btn-warning" id="modifyBtn">수정하기</button>				
				<button type="button" class="btn btn-danger" id="deleteBtn">삭제</button>
			</div>
			<button type="button" class="btn btn-danger" id="toListBtn">목록으로</button>
		</section>
		<c:import url="/WEB-INF/jsp/include/footer.jsp" />
		
	</div>
		
	
<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
	
	<script>
		$(document).ready(function(){
			
			$("#addFileBtn").on("click",function(){
				alert("파일 첨부 버튼 정상 작동");
			});
			
			$("#toListBtn").on("click",function(){
				location.href = "/post/list-view"
			});
			
			$("#saveBtn").on("click",function(){
				let title = $("#titleInput").val();
				let contents = $("#contentsInput").val();
				
				if(title == ""){
					alert("제목을 입력하세요");
					return;
				}
				
				if(contents == ""){
					alert("내용을 입력하세요");
					return;
				}
				
				$.ajax({
					type:"post"
					, url:"/post/create"
					, data:{"title":title, "contents":contents}
					, success:function(data){
						if(data.result == "success"){
							location.href = "/post/list-view";
						} else {
							alert("메모 저장 실패");
						}
					}
					, error:function(){
						alert("메모 저장 에러");
					}
					
					
				});
				
				
			});
			
			
		});
	</script>
	
</body>
</html>