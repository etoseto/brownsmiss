(function(){
	var businessData ={list:[]}; 
	var app = new Vue({
		el:'#content',
		data:businessData
	})
	$.ajax({
		url:"http://localhost:8080/item/businessList.action",
		dataType : "json",
		async:"false",
		success:function(result){
			if(result != null){
				console.log("after:"+businessData);
				businessData.list = result;
				console.log(businessData[0]);
			}
			
		}
	})
}())