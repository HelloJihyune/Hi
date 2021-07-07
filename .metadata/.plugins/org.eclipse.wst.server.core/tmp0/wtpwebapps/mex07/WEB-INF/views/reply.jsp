<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성목록 수정</title>
<link rel="stylesheet" href="resources/css/reply.css">
</head>
<body>
	<div class="inputArea">
 <button type="button" id="modify_Btn" class="btn btn-warning">수정</button>
 <button type="button" id="delete_Btn" class="btn btn-danger">삭제</button>
 
 <script>
  var formObj = $("form[role='form']");
  
  $("#modify_Btn").click(function(){
   formObj.attr("action", "/admin/goods/modify");
   formObj.attr("method", "get")
   formObj.submit();
  });
  
  $("#delete_Btn").click(function(){    
   formObj.attr("action", "/admin/goods/delete");
   formObj.submit();
  });
 </script>
</div>
</body>
</html>