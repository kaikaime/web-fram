			jQuery.loadObj = function(){
				var sexObj = $(".div-sex-select");
				sexObj.change(function(){
					$(".sex").val($(this).val());
				});
				
				var deptObj=$(".div-dept-select");
				deptObj.change(function(){
					var deptVla  =$(this).val();
					$(".dept").val($(this).find("option").eq(deptVla).text());
					var classObj = $(".div-class-select");
					var classInput= $(".classt");
					jQuery.findClass(deptVla,classObj,classInput);
					classObj.change(function(){
						classInput.val($(this).find("option").eq($(this).val()).text());
					});
				});
			}
			
			
			
				jQuery.findClass = function(index,obj,mClass){
				var allArry = jQuery.gtArray();
				for(var i = 0;i<allArry.length;i++){
					if(i==index){
						obj.find("option").remove();
						var car=allArry[i];
						for(var y = 0;y<car.length;y++){
							mClass.val(car[0]);
							obj.append("<option value='"+y+"'>"+car[y]+"</option>");
						}
				    }
				}
			}
			
			
			
			jQuery.gtArray = function(){
				//添加汽车学院班级
				var shopDept =["电子商务1412","电子商务1413","电子商务1414","电子商务1415"];
				var jinmao=[];
				var jixie=[];
				var yuejin=[];
				var carArray=["汽车1312","汽车1313","汽车1314","汽车1315"];
				var shengwu=[];
				var allArry=[shopDept,jinmao,jixie,yuejin,carArray,shengwu];
				return allArry;
			}
			
			
			
			jQuery.loadRoom = function(){
				var roomObj = $(".div-select-room");
				var roomArrays = gtRoom();
				for(var i = 0;i<roomArrays.length;i++){
					roomObj.append("<option value='"+i+"'>"+roomArrays[i]+"</option>")
				}
				var roomOption = $(".div-select-option");
				var roomOptionArrays = gtRoomOption();
				for(var y = 0;y<roomOptionArrays.length;y++){
					roomOption.append("<option value='"+y+"'>"+roomOptionArrays[y]+"</option>")
				}
				roomObj.change(function(){
					var value =$(this).find("option").eq($(this).val()).text();
					roomOption.change(function(){
						var values =$(this).find("option").eq($(this).val()).text();
						$(".room").val(value+"-"+values)
					});
					
				});
			}




			function gtRoomOption(){
				var roomOption=["302室","302室"];
				return roomOption;
			}
			//学校的寝室楼
			function gtRoom(){
				var allRoom=["1栋","2栋"];
				return allRoom;
			}
