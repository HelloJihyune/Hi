// replyService : javascript의 객체이다.
console.log("Reply Module.........");
var replyService = (function() {	// HTML 코드가 로딩이 되면 자동 실행을 위해
	/*
	function add(a, b) {		// 함수를 정의(객체의 매소드)
		var sum = a + b;
		console.log("add: " + sum);
	}
	return {
		add: add	// 변수 : 함수이름 매핑
	};
	*/
	
	function getList(param, callback, error) {
		var bno = param.bno;
		var page = param.page || 1;	// page=-1
		$.getJSON("/replies/pages/" + bno + "/" + page + ".json",
			function(data) {	// data에 댓글 목록이 실려온다. List<ReplyVO> -> ReplyPageDTO
				if(callback) {
					// callback(data);	// 댓글 목록만 가져오는 경우
					callback(data.replyCnt, data.list);	// 댓글 목록만 가져오는 경우
				}
		}).fail(function(xhr, status, err) {
			if(error) {
				error();
			}
		});
	}
	
	function displayTime(timeValue) {
		var today = new Date();
		var gap = today.getTime() - timeValue;
		var dateObj = new Date(timeValue);	// 댓글을 작성한 시간
		var str = "";

		if (gap < (1000 * 60 * 60 * 24)) {	// 단위 ms
			var hh = dateObj.getHours();
			var mi = dateObj.getMinutes();
			var ss = dateObj.getSeconds();
			return [ (hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi,
					':', (ss > 9 ? '' : '0') + ss ].join('');
		} else {
			var yy = dateObj.getFullYear();
			var mm = dateObj.getMonth() + 1; // getMonth() is zero-based
			var dd = dateObj.getDate();
			return [ yy, '/', (mm > 9 ? '' : '0') + mm, '/',
					(dd > 9 ? '' : '0') + dd ].join('');
		}
	}
	
	function add(reply, callback, error) {
		console.log("add reply............");
		$.ajax({
			type: 'post',
			url: '/replies/new',
			data: JSON.stringify(reply),
			contentType: "application/json; charset=utf-8",
			success: function(result, status, xhr) {
				if(callback) {
					callback(result);
				}
			},
			error: function(xhr, status, er) {
				if(error) {
					error(er);
				}
			}
		})
	}
	
	function get(rno, callback, error) {
		$.get("/replies/" + rno + ".json", function(result) {
			if(callback) {
				callback(result);
			}
		}).fail(function(xhr, status, err) {
			if(error) {
				error();
			}
		});
	}
	
	function update(reply, callback, error) {
		console.log("RNO: " + reply.rno);
		
		$.ajax({
			type: 'put',
			url: '/replies/' + reply.rno,
			data: JSON.stringify(reply),
			contentType: "application/json; charset=utf-8",
			success: function(result, status, xhr) {
				if(callback) {
					callback(result);
				}
			},
			error: function(xhr, status, er) {
				if(error) {
					error(er);
				}
			}
		});
	}
	
	function remove(rno, callback, error) {
		$.ajax({
			type: 'delete',
			url: '/replies/' + rno,
			success: function(deleteResult, status, xhr) {
				if(callback) {
					callback(deleteResult);
				}
			},
			error: function(xhr, status, er) {
				if(error) {
					error(er);
				}
			}
		});
	}
	
	return {
		add: add,
		update: update,
		remove: remove,
		get: get,
		getList: getList,
		displayTime: displayTime
	};
})();