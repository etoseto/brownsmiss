
(function(){

	var businessData ={list:[]}; 
	var app = new Vue({
		el:'#content',
		data:businessData
	})
	var url = location.search;
	if (url.indexOf("?") != -1) {  
	      var str = url.substr(1); 
	     $.ajax({
		url:"http://localhost:8080/item/business.action",
		data:{"id":str},
		dataType : "json",
		async:"false",
		success:function(result){
			if(result != null){
				businessData.list = result;
				console.log(businessData[0]);
			}
			
		}
	})
 	}
}())