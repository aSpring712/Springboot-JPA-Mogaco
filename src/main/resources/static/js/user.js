/**
 *  회원가입
 */
 
 let index = {
	// 현재 this와
	init: function() {
		$("#btn-save").on("click", ()=> { // function(){} 대신 화살표 함수 ()=>{} 사용하는 이유 : this를 바인딩하기 위해
			this.save(); // 이 this의 값은 같으나 function(){}을 사용하면 this가 window 객체가 되어버림 			
		});
	},
	
	save: function() {
		// alert('user의 save 함수 호출됨');
		let data = {  // 아래의 값 3개를 들고옴 -> javascript object
			username : $("#username").val(),
			password : $("#password").val(),
			email : $("#email").val()
		};
		//console.log(data); -> js obj
		
		// ajax 호출 시 default가 비동기 호출 -> 회원가입 외에 다른 내용들도 실행
		// ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
		// ajax가 통신을 성공하고 서버가 json을 리턴해주면 자동으로 자바 obj로 변환해줌 -> dataType: "json" 생략 가능
		$.ajax({
			type : "POST", // insert
			url : "api/user",
			data: JSON.stringify(data), // http body 데이터를 보냄! / javascript obj를 그냥 던지면 java가 못알아들음 -> json 문자열로 변환 : 
			contentType: "application/json; charset=utf-8", // http body 데이터가 어떤 타입인지(MIME) 알려줘야 함
			dataType: "json" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 String(문자열)인데, "json"이라고 적어주면 
			//생긴 것이 json이면 javascript obj로 변경해 줌
			// 함수에 parameter로 전달받을 수 있음   --->  생략가능
		}).done(function(resp){ // 성공 시
			alert("회원가입이 완료되었습니다.");
			// console.log(resp);
			location.href="/"; // 홈으로 이동
		}).fail(function(error){ // 실패 시
			alert(JSON.stringify(error));
		}); // ajax 통신을 이용해서 3개의 데이터를 json으로 변경 -> insert 요청
	}
}

index.init();

// 유효성 검사
$("#btnJoin").click(function(){
	if($("#user_Id").val() == "") {
		alert("id를 입력하세요.")
		$("#user_Id").focus();
		return false;
	}
	if($("#password").val() == "") {
		alert("비밀번호를 입력하세요.")
		$("#password").focus();
		return false;
	}
	if($("#pass_check").val() != $("#password").val()) {
		alert("비밀번호가 일치하지 않습니다.")
		$("#pass_check").val('');
		$("#pass_check").focus();
		return false;
	}
	if($("#email").val() == "") {
		alert("이메일을 입력하세요.")
		$("#email").focus();
		return false;
	} // 다 맞다면
	var data = { // data 전달
			"userId" : $("#userId").val(),
			"password" : $("#password").val(),
			"email" : $("#email").val()
	}
	$.ajax({
		type : "post",
		url : "/member/join",
		contentType : "application/json;charset=utf-8",
		data : JSON.stringify(data)
	})
	.done(function(resp) {
		if(resp=="success") {
			alert("회원가입을 축하합니다.");
			location.href="member/login";
		} else if(resp=="fail") {
			alert("아이디 중복확인하세요.");
			$("#userId").val("");
		}
	})
	.fail(function(e) {
		alert("회원가입 실패");		
	})
})

// id 중복 검사
$("#idCheckBtn").click(function(){
	if($("#userId").val() == "") { // id를 입력하지 않은 경우
		alert("id를 입력하세요.");
		$("#userId").focus();
		return false;
	} // if
	$.ajax({ // id 전달해서 중복 검사하기
		type : "get",
		url : "/member/idCheck",
		data : {"userId" : $("#userId").val()}
	})
	.done(function(resp){
		if(resp == 0) {
			$("#idcheck").html("<b style='color:blue'>사용가능한 아이디입니다.</b>");
		} else {
			$("#idcheck").html("<b style='color:red'>사용 불가능한 아이디입니다.</b>");
			$("#userId").val("");
			$("#userId").focus();
		}
	})
})