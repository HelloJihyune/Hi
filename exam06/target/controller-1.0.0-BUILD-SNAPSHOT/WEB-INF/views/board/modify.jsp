<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Modify</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form role="form" action="/board/modify" method="post">
					<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum}"/>'>
        			<input type='hidden' name='amount' value='<c:out value="${cri.amount}"/>'>
        			<input type='hidden' name='type' value='<c:out value="${cri.type }"/>'>
        			<input type='hidden' name='keyword' value='<c:out value="${cri.keyword }"/>'>
					<div class="form-group">
				  	  <label>Bno</label>
				  	  <input class="form-control" name="bno"
				  	  		value='<c:out value="${board.bno}"/>' readonly="readonly">
				  	</div>
					<div class="form-group">
				  	  <label>Title</label> <input class="form-control" name="title"
				  	  		value='<c:out value="${board.title}" />'>
				  	</div>
				  	<div class="form-group">
				  	  <label>Text area</label>
				  	  <textarea class="form-control" rows="3" name="content"><c:out value="${board.content}" /></textarea>
				  	</div>
				  	<div class="form-group">
				  	  <label>Writer</label> <input class="form-control" name="writer"
				  	  		value='<c:out value="${board.writer}" />' readonly="readonly">
				  	</div>
				  	<div class="form-group">
					  <label>RegDate</label> 
					  <input class="form-control" name='regDate'
					    value='<fmt:formatDate pattern = "yyyy/MM/dd" value = "${board.regDate}" />'  readonly="readonly">            
					</div>
					<div class="form-group">
					  <label>Update Date</label> 
					  <input class="form-control" name='updateDate'
					    value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate}" />'  readonly="readonly">            
					</div>
					<!-- class btn-default : CSS의 차이 -->
				  	<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
				  	<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
				  	<button type="submit" data-oper='list' class="btn btn-info">List</button>
				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<script type="text/javascript">
$(document).ready(function() {
	  var formObj = $("form");

	  $('button').on("click", function(e){	// 3개의 submit 버튼을 구분해서 처리한다.
	    e.preventDefault(); 
	    var operation = $(this).data("oper");	// jsp data-oper attribute의 값을 가져온다.
	    console.log(operation);
	    if(operation === 'remove') {
	      formObj.attr("action", "/board/remove");
	    } else if(operation === 'list'){
	      //move to list
	      //self.location = "/board/list";
	      //return;
	      // 확장성(페이징, 검색 기능)을 고려해서 form으로 동작하도록 변경
	      //formObj.attr("action", "/board/list").attr("method","get");	
	      //formObj.empty();       	// 여러 가지 input 태그의 값을 제거
	    	formObj.attr("action", "/board/list").attr("method","get");
		    var pageNumTag = $("input[name='pageNum']").clone();
		    var amountTag = $("input[name='amount']").clone();
		    var keywordTag = $("input[name='keyword']").clone();	// 검색 관련
		    var typeTag = $("input[name='type']").clone(); 
		    formObj.empty();	// input 태그를 모두 없애 버리기 때문에 복사를 해놓고 다시 추가한다.
		    formObj.append(pageNumTag);
		    formObj.append(amountTag);
		    formObj.append(keywordTag);					// 검색 관련
		    formObj.append(typeTag);
	    }
	    formObj.submit();	// remove, modify
	  });
});
</script>
<%@ include file="../includes/footer.jsp"%>