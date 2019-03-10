(function(){

	var newsData ={list:[]}; 
	var app = new Vue({
		el:'#content',
		data:newsData
	})
	$.ajax({
		url:"http://localhost:8080/news/list.action",
		dataType : "json",
		async:"true",
		success:function(result){
			if(result != null){
				newsData.list = result;
				console.log(newsData.list.length);
				for(var i = 0;i<newsData.list.length;i++){
					var _date = new Date(newsData.list[i]["time"]);
					newsData.list[i]["time"] = _date.toLocaleDateString().replace(/\//g, "-") ; 
					console.log(newsData.list[i]["time"]);
				}

			}
			
		}
	})



}())