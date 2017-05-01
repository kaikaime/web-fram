<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script type="text/javascript" src="${pageContext.request.contextPath}/jquery/jquery-3.1.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jsAddress.js"></script>  
		<script type="text/javascript" src="${pageContext.request.contextPath}/My97DatePicker/WdatePicker.js" ></script>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css" />
		 <script type="text/javascript">  
		 		$(function(){
		 			addressInit('cmbProvince', 'cmbCity', 'cmbArea');
		 			var inputPro = $(".input-conent-add");
		 			var proValue = $("#cmbProvince");
		 			var cityValue =$("#cmbCity");
		 			var areat = $("#cmbArea");
		 			
		 			
		 			inputPro.eq(0).val(proValue.children().eq(0).val());
		 			
		 			proValue.change(function(){
		 				inputPro.eq(0).val($(this).val());
		 			});
		 			
		 			cityValue.change(function(){
		 				inputPro.eq(1).val($(this).val());
		 			});
		 			
		 			areat.change(function(){
		 				inputPro.eq(2).val($(this).val());
		 			});
		 			
		 			$(".select").change(function(){
		 					$(".input-sex").val($(this).val());
		 				});
		 			});
		 			
		 			function onSubmitUser(){
		 				//使用ajax检测当前要注册的用户是否存在!
			 			var accountRex = /^[1-9_a-zA-Z][0-9_a-zA-Z]{5,10}$/;
			 			var accounts = $(".input-content")[0];
			 			if(accountRex.test(accounts.value)== false){
			 					accounts.value="请输入正确的账号！";
			 					alert("jjsdf");
			 					return false;
			 			} 
			 		
		 			}
		 			function cancel(){
		 				window.location.href="${pageContext.request.contextPath}/login.jsp";
		 			}
		 			
		 			
               </script> 
	</head>
	<body>
		<div class="div-body-all">
			<div class="div-body-title">
				<div class="div-body-title-span">
					填写以下相关信息
				</div>
				<div class="div-body-table-all">
					<form method="post" action="${pageContext.request.contextPath }/register.do?method=register" onsubmit="return onSubmitUser();"  name="userBean">
						<div class="div-body-left-table">
							<table cellpadding="0" cellspacing="0" class="table-left-body">
							<tr>
								<td>
									<label class="div-label-flag">*</label>
									<label class="div-label-title">用户名:</label>
								</td>
								<td>
									<input type="text" class="input-content" name="accNumber"/>
								</td>
							</tr>
							<tr>
								<td>
									<label class="div-label-flag">*</label>
								<label class="div-label-title">密码:</label>
								</td>
								<td>
									<input type="text" class="input-content" name="accPass" />
								</td>
							</tr>
							<tr>
								<td>
									<label class="div-label-flag">*</label>
									<label class="div-label-title">姓名:</label>
								</td>
								<td>
									<input type="text" class="input-content" name="manNick"/>
								</td>
							</tr>
							<tr>
								<td>
									<label class="div-label-flag">*</label>
									<label class="div-label-title">性别:</label>
								</td>
								<td>
									<input type="text" class="input-content input-sex" name="manSex"/>
									<select class="select" >
										<option value="男">男</option>
										<option value="女">女</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>
									<label class="div-label-flag">*</label>
									<label class="div-label-title">身份证号:</label>
								</td>
								<td>
									<input type="text" class="input-content" name="manIdCard"/>
								</td>
							</tr>
							<tr>
								<td>
									<label class="div-label-flag">*</label>
									<label class="div-label-title">联系方式:</label>
								</td>
								<td>
									<input type="text" class="input-content" name="manTel"/>
								</td>
							</tr>
							<tr>
								<td>
									<label class="div-label-flag">*</label>
									<label class="div-label-title">注册时间:</label>
									
								</td>
								<td>
									<input type="text" class="input-content" name="regiterTime" onfocus="new WdatePicker(this)" />
								</td>
							</tr>
						</table>
						</div>
						<div class="div-body-right-table">
							<table cellpadding="0" cellspacing="0" class="table-right-body">
							<tr style="height: 50px;">
								<td colspan="2" style="text-align: center;">
									<label class="div-label-a-title">
										现住地址
									</label>
									
								</td>
							</tr>
							<tr style="height: 50px;">
								<td>
									<label class="div-label-flag">*</label>
									<label class="div-label-title">省份:</label>
								</td>
								<td>
									<input type="text" class="input-conent-add" name="manShen" />
									
								</td>
								<td class="div-right-select">
									<select id="cmbProvince" name="cmbProvince" />
								</td>
							</tr>
							<tr style="height: 50px;">
								<td>
									<label class="div-label-flag">*</label>
									<label class="div-label-title">市/县:</label>
								</td>
								<td>
									<input type="text" class="input-conent-add" name="shi" />
									  
								</td>
								<td><select id="cmbCity" name="cmbCity" /></td>
								
							</tr>
							<tr style="height: 50px;">
								<td>
									<label class="div-label-flag">*</label>
									<label class="div-label-title">区/县:</label>
								</td>
								<td>
									<input type="text" class="input-conent-add" name="xian"/>
									
								</td>
								<td>
									<select id="cmbArea" name="cmbArea" />
								</td>
							</tr>
							
							<tr>
								<td valign="top" style="padding-top: 5px;">
									<label class="div-label-flag">*</label>
									<label class="div-label-title">乡镇/街道:</label>
								</td>
								<td>
									<textarea class="div_tr_textarea" name="xiangzheng"></textarea>
								</td>
								
							</tr>
						</table>
						</div>
						<div class="div-content-footer-body">
						<input type="submit" class="div-content-button" value="提交"></input>&nbsp;
						<input type="button" class="div-content-button" value="取消" onclick="cancel()"></input>
						</div>
					</form>
				</div>
			</div>
			
		</div>
		
	</body>
</html>
