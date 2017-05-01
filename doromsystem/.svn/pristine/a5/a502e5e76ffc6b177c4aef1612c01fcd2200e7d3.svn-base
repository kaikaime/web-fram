jQuery.roomChange=function(){

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
			$(".rooms").val(value+"-"+values)
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