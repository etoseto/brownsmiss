
(function(){

	var newsData ={list:[]}; 
	var app = new Vue({
		el:'#content',
		data:newsData
	})
	var url = location.search;
	if (url.indexOf("?") != -1) {  
	      var str = url.substr(1); 
	     $.ajax({
		url:"http://localhost:8080/news/item.action",
		data:{"id":str},
		dataType : "json",
		async:"false",
		success:function(result){
			if(result != null){
				newsData.list = result;
				console.log(newsData);
				var _date = new Date(newsData.list["time"]);
					newsData.list["time"] = _date.toLocaleDateString().replace(/\//g, "-") ; 
					console.log(newsData.list["time"]);
			}
			
		}
	})
 	}
}())