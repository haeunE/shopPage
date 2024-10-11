const userObject = {
	init:function(){
		$("#signup-btn").on("click",(e)=>{
			e.preventDefault();
			this.signup();
		})
		$("#login-btn").on("click",(e)=>{
			e.preventDefault();
			this.login();
		})
		$("#modify-btn").on("click",(e)=>{
			e.preventDefault();
			if(!confirm("회원정보를 수정하시겠습니까?"))
				return;
			this.modify();
		})
		$("#delete-btn").on("click",(e)=>{
			e.preventDefault();
			if(!confirm("탈퇴하시겠습니까?"))
				return;
			if(!confirm("탈퇴하시면 회원님의 정보가 영구적으로 삭제됩니다.\n그대로 탈퇴 진행하시겠습니까?"))
				return;
			userid = $("#id").val();
			$.ajax({
				type: "DELETE",
				url : "/auth/delete?id="+id
			}).done(function(response){
				alert(response.data);
				if(response.status == 200)
					location.href = "/";
			}).fail(function(response){
				console.log(error);
			})
		})
	},
	
	signup:function(){
		user = {
			userid : $("#userid").val(),
			password : $("#password").val(),
			email : $("#email").val() +"@"+$("#server").val()
		};
		$.ajax({
		   type: "POST",
		   url: "/auth/signup",
		   data: JSON.stringify(user),
		   contentType: "application/json; charset=utf-8"
		}).done(function(response) {
		   alert(response.data);
		   if(response.status == 200)			location.href = "/";
		}).fail(function(error) {
		   console.log(error);
		})  
	},
	login:function(){
		user={
			userid : $("#userid").val(),
			password : $("#password").val()
		};
		$.ajax({
			type: "POST",
			url: "/auth/login",
			data: JSON.stringify(user),
			contentType: "application/json; charset=utf-8"
		}).done(function(response) {
		   alert(response.data);
		   if(response.status == 200)
			location.href = "/";
		}).fail(function(error) {
		   console.log(error);
		})
	},
	modify:function(){
		user = {
			userid : $("#userid").val(),
			password : $("#password").val(),
			email : $("#email").val() +"@"+$("#server").val()
			};
		$.ajax({
		   type: "POST",
		   url: "/auth/userinfo",
		   data: JSON.stringify(user),
		   contentType: "application/json; charset=utf-8"
		}).done(function(response) {
		   alert(response.data);
		   if(response.status == 200)
			location.href = "/auth/userinfo";
		}).fail(function(error) {
		   console.log(error);
		}) 
	}
}
userObject.init();