function onloadDate(){
	strYYYY = document.form1.birthyear.outerHTML;  
	strMM = document.form1.birthmonth.outerHTML;  
	strDD = document.form1.birthday.outerHTML;  
	MonHead = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];  
	  
	//先给年下拉框赋内容  
	var y = new Date().getFullYear();  
	var str = strYYYY.substring(0, strYYYY.length - 9);  
	for (var i = (y-30); i < (y+30); i++) //以今年为准，前30年，后30年  
	{  
	str += "<option value='" + i + "'> " + i + "</option>\r\n";  
	}  
	document.form1.birthyear.outerHTML = str +"</select>";  
	  
	//赋月份的下拉框  
	var str = strMM.substring(0, strMM.length - 9);  
	for (var i = 1; i < 13; i++)  
	{  
	str += "<option value='" + i + "'> " + i + "</option>\r\n";  
	}  
	document.form1.birthmonth.outerHTML = str +"</select>";  
	  
	document.form1.birthyear.value = y;  
	document.form1.birthmonth.value = new Date().getMonth() + 1;  
	var n = MonHead[new Date().getMonth()];  
	if (new Date().getMonth() ==1 && IsPinYear(YYYYvalue)) n++;  
	writeDay(n); //赋日期下拉框  
	document.form1.birthday.value = new Date().getDate();  
	}  
	function YYYYMM(str) //年发生变化时日期发生变化(主要是判断闰平年)  
	{  
	var MMvalue = document.form1.birthmonth.options[document.form1.birthmonth.selectedIndex].value;  
	if (MMvalue == ""){birthday.outerHTML = strDD; return;}  
	var n = MonHead[MMvalue - 1];  
	if (MMvalue ==2 && IsPinYear(str)) n++;  
	writeDay(n)  
	}  
	function MMDD(str) //月发生变化时日期联动  
	{  
	var YYYYvalue = document.form1.birthyear.options[document.form1.birthyear.selectedIndex].value;  
	if (str == ""){birthday.outerHTML = strDD; return;}  
	var n = MonHead[str - 1];  
	if (str ==2 && IsPinYear(YYYYvalue)) n++;  
	writeDay(n)  
	}  
	function writeDay(n) //据条件写日期的下拉框  
	{  
	var s = strDD.substring(0, strDD.length - 9);  
	for (var i=1; i<(n+1); i++)  
	s += "<option value='" + i + "'> " + i + "</option>\r\n";  
	document.form1.birthday.outerHTML = s +"</select>";  
	}  
	function IsPinYear(year)//判断是否闰平年  
	{ return(0 == year%4 && (year%100 !=0 || year%400 == 0))
}