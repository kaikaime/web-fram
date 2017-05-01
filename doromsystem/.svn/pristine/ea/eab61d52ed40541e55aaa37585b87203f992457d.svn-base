$(function(){
	//得到焦点
	$("#password").focus(function(){
		$("#left_hand").animate({
			left: "150",
			top: " -38"
		},{step: function(){
			if(parseInt($("#left_hand").css("left"))>140){
				$("#left_hand").attr("class","left_hand");
			}
		}}, 2000);
		$("#right_hand").animate({
			right: "-64",
			top: "-38px"
		},{step: function(){
			if(parseInt($("#right_hand").css("right"))> -70){
				$("#right_hand").attr("class","right_hand");
			}
		}}, 2000);
	});
	//失去焦点
	$("#password").blur(function(){
		$("#left_hand").attr("class","initial_left_hand");
		$("#left_hand").attr("style","left:100px;top:-12px;");
		$("#right_hand").attr("class","initial_right_hand");
		$("#right_hand").attr("style","right:-112px;top:-12px");
	});
	
	//校验表单
	$(".login_A").click(function(){
		var uRex =/^[1-9_a-zA-Z][1-9_a-zA-Z]{5,14}$/;//6位到15位用户名
		var pRex= /^[1-9_a-zA-Z][1-9_a-zA-Z]{5,7}$/;//6到8位
		if(!uRex.test($(".u_acc").val())){
			$(".u_acc").val("请输入6位到15位的用户名!").css("color","red");
			$(".u_acc").focus(function(){
				$(".u_acc").css("color","#000000").val("");
			});
			return false;
		}else if(!pRex.test($(".u_pass").val())){
			$(".u_pass").attr("type","text").val("请输入6位到8位的密码!").css("color","red");
			$(".u_pass").focus(function(){
				$(".u_pass").val("value","").css("color","#000000").attr("type","password");
			});
			return false;
		}else{
			//使用ajax提交到服务器上面
		}
	});
});