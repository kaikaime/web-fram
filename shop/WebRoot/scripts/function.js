window.onload = function(){
	showChater();
	scrollChater();
}
window.onscroll = scrollChater;
window.onresize = scrollChater;

function FocusItem(obj)
{
	obj.parentNode.parentNode.className = "current";
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	msgBox.innerHTML = "";
	msgBox.className = "";
}

function CheckItem(obj)
{
	obj.parentNode.parentNode.className = "";
	var msgBox = obj.parentNode.getElementsByTagName("span")[0];
	switch(obj.name) {
		case "userName":
			if(obj.value == "") {
				msgBox.innerHTML = "用户名不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
		case "passWord":
			if(obj.value == "") {
				msgBox.innerHTML = "密码不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
		case "rePassWord":
			if(obj.value == "") {
				msgBox.innerHTML = "确认密码不能为空";
				msgBox.className = "error";
				return false;
			} else if(obj.value != document.getElementById("passWord").value) {
				msgBox.innerHTML = "两次输入的密码不相同";
				msgBox.className = "error";
				return false;
			}
			break;
		case "veryCode":
			if(obj.value == "") {
				msgBox.innerHTML = "验证码不能为空";
				msgBox.className = "error";
				return false;
			}
			break;
	}
	return true;
}

function checkForm(frm)
{
	var els = frm.getElementsByTagName("input");
	for(var i=0; i<els.length; i++) {
		if(typeof(els[i].getAttribute("onblur")) == "function") {
			if(!CheckItem(els[i])) return false;
		}
	}
	return true;
}

function showChater()
{
	var _chater = document.createElement("div");
	_chater.setAttribute("id", "chater");
	var _dl = document.createElement("dl");
	var _dt = document.createElement("dt");
	var _dd = document.createElement("dd");
	var _a = document.createElement("a");
	_a.setAttribute("href", "#");
	_a.onclick = openRoom;
	_a.appendChild(document.createTextNode("在线聊天"));
	_dd.appendChild(_a);
	_dl.appendChild(_dt);
	_dl.appendChild(_dd);
	_chater.appendChild(_dl);
	document.body.appendChild(_chater);
}
////////////////////////////////////////http://www.cnblogs.com/sofiawang/articles/1544631.html
function openRoom()
{
	window.open("chat-room.jsp","chater","status=no,scrollbars=no,toolbar=no,menubar=no,location=no,width=600,height=400");
}

function scrollChater()
{
	var chater = document.getElementById("chater");
	var scrollTop = document.documentElement.scrollTop;
	var scrollLeft = document.documentElement.scrollLeft;
	chater.style.left = scrollLeft + document.documentElement.clientWidth - 92 + "px";
	chater.style.top = scrollTop + document.documentElement.clientHeight - 25 + "px";
}

function inArray(array, str)
{
	for(a in array) {
		if(array[a] == str) return true;
	}
	return false;
}

function setCookie(name,value)
{
  var Days = 30;
  var exp  = new Date();
  exp.setTime(exp.getTime() + Days*24*60*60*1000);
  document.cookie = name + "="+ escape(value) +";expires="+ exp.toGMTString();
}

function getCookie(name)
{
  var arr = document.cookie.match(new RegExp("(^| )"+name+"=([^;]*)(;|$)"));
  if(arr != null) return unescape(arr[2]); return null;
}

function delCookie(name)
{
  var exp = new Date();
  exp.setTime(exp.getTime() - 1);
  var cval=getCookie(name);
  if(cval!=null) document.cookie=name +"="+cval+";expires="+exp.toGMTString();
}

function goBuy(id, price)
{
	var newCookie = "";
	var oldCookie = getCookie("product");
	if(oldCookie) {
		if(inArray(oldCookie.split(","), id)) {
			newCookie = oldCookie;
		} else {
			newCookie = id + "," + oldCookie;
		}
	} else {
		newCookie = id;
	}
	setCookie("product", newCookie);
	location.href = "shopping.jsp";
}

function delShopping(id)
{
	var tr = document.getElementById("product_id_"+ id);
	var oldCookie = getCookie("product");
	if(oldCookie) {
		var oldCookieArr = oldCookie.split(",");
		var newCookieArr = new Array();
		for(c in oldCookieArr) {
			var cookie = parseInt(oldCookieArr[c]);
			if(cookie != id) newCookieArr.push(cookie);
		}
		var newCookie = newCookieArr.join(",");
		setCookie("product", newCookie);
	}
	if(tr) tr.parentNode.removeChild(tr);
}

function reloadPrice(id, status)
{
	alert("jdjf");
	var price = document.getElementById("price_id_" + id).getElementsByTagName("input")[0].value;
	var priceBox = document.getElementById("price_id_" + id).getElementsByTagName("span")[0];
	var number = document.getElementById("number_id_" + id);
	alert("price: "+price+" priceBox: "+priceBox+" number: "+number);
	//表示向上加
	if(status)
	{
		if(number.value>=1)
		{
			number.value++;
			if(number.value>100)
			{
				alert("至多输入商品数量100个.....   ok!");
				number.value=100;
			}
				priceBox.innerHTML = "￥" + price * number.value;
				return true;
		}
		else
		{
			alert("数量最少为1.....Ok!");
			number.value=1;
			priceBox.innerHTML = "￥" + price * number.value;
			return false;
		}
	}
	//表示向下减
	else if(!status)
	{
		if(number.value<2)
		{
			return false;
		}else
		{
			number.value--;
			if(number.value<1)
			{
				alert("至少输入商品数量1个.....   ok!");
			}
			priceBox.innerHTML = "￥" + price * number.value;
		}
	}
	else
	{
		alert("至少输入商品数量1个.....   ok!");
		priceBox.innerHTML = "￥" + price * number.value;
	}
}

//自动调整价格
function autoReloadPrice(id)
{
	var price = document.getElementById("price_id_" + id).getElementsByTagName("input")[0].value;
	var priceBox = document.getElementById("price_id_" + id).getElementsByTagName("span")[0];
	var number = document.getElementById("number_id_" + id);
	//如果输入小于1个数量就提示用户，请输入正确的值
	if(/^[0-9]{1,3}$/.test(number.value))
	{
		if(number.value<1)
		{
			alert("至少输入商品数量1个.....   ok!");
			number.value=1;
		}if(number.value>100)
		{
			alert("至多输入商品数量100个.....   ok!");
			number.value=100;
		}
		priceBox.innerHTML = "￥" + price * number.value;
	}
	else 
	{
		alert("请输入商品数量.....   ok!");
		number.value=1;
		priceBox.innerHTML = "￥" + price * number.value;
		return false;
	}
}
////////////////////////////
function reloadPrices(id, status)
{
	var price = document.getElementById("price_id_" + id).getElementsByTagName("input")[0].value;
	var priceBox = document.getElementById("price_id_" + id).getElementById("spans");
	var number = document.getElementById("number_id_" + id);
	alert("price: "+price+" priceBox: "+priceBox+" number: "+number);
	//表示向上加
	if(status)
	{
		if(number.value>=1)
		{
			number.value++;
			if(number.value>100)
			{
				alert("至多输入商品数量100个.....   ok!");
				number.value=100;
			}
				priceBox.innerHTML = "￥" + price * number.value;
				return true;
		}
		else
		{
			alert("数量最少为1.....Ok!");
			number.value=1;
			priceBox.innerHTML = "￥" + price * number.value;
			return false;
		}
	}
	//表示向下减
	else if(!status)
	{
		if(number.value<2)
		{
			return false;
		}else
		{
			number.value--;
			if(number.value<1)
			{
				alert("至少输入商品数量1个.....   ok!");
			}
			priceBox.innerHTML = "￥" + price * number.value;
		}
	}
	else
	{
		alert("至少输入商品数量1个.....   ok!");
		priceBox.innerHTML = "￥" + price * number.value;
	}
}

//自动调整价格
function autoReloadPrices(id)
{
	var price = document.getElementById("price_id_" + id).getElementsByTagName("input")[0].value;
	var priceBox = document.getElementById("price_id_" + id).getElementsByTagName("span")[0];
	var number = document.getElementById("number_id_" + id);
	//如果输入小于1个数量就提示用户，请输入正确的值
	if(/^[0-9]{1,3}$/.test(number.value))
	{
		if(number.value<1)
		{
			alert("至少输入商品数量1个.....   ok!");
			number.value=1;
		}if(number.value>100)
		{
			alert("至多输入商品数量100个.....   ok!");
			number.value=100;
		}
		priceBox.innerHTML = "￥" + price * number.value;
	}
	else 
	{
		alert("请输入商品数量.....   ok!");
		number.value=1;
		priceBox.innerHTML = "￥" + price * number.value;
		return false;
	}
}




