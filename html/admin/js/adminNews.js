
	var newsData ={list:[],item:[]}; 
	var app = new Vue({
		el:'#app',
		data:newsData

	})
	//修改
	function editNews(event){
		console.log(event);
		var tdEle = $(event).attr("target");
		var data_id = $(tdEle).attr("data-id");
		console.log(data_id);
		$.ajax({
			url:"http://localhost:8080/news/item.action",
			data:{"id":data_id},
			dataType : "json",
			async:"false",
			success:function(result){
				console.log(result);
				if(result != null){
					newsData["item"] = result;
					console.log(newsData);
					console.log(newsData["item"]);
					var _date = new Date(newsData["item"]["time"]);
					newsData["item"]["time"] = _date.toLocaleDateString().replace(/\//g, "-")+ " " + _date.toTimeString().substr(0, 8); 
					console.log(newsData["item"]["time"]);
					if(newsData["item"]["newsdetails"] == null){
						newsData["item"]["newsdetails"] = newsData["item"]["newsname"]+"11";
					}
				}
			}
		})
	}
	//更新保存
	function updateNews(){
		console.log(JSON.stringify($('#edit_customer_form').serializeJSON()));
			

		// //这种方式最有效
		// var id = $("#edit_id").val();
		// var newsname =  $("#edit_newsname").val();
		// var author =  $("#edit_author").val();
		// var time =  $("#edit_time").val();
		// var newsdetails =  $("#edit_newsdetails").val();
		// var dataStr = {
		// 	"id":id,
		// 	"newsname":newsname,
		// 	"author":author,
		// 	"time":time,
		// 	"newsdetails":newsdetails
		// };

		// var jsonData = JSON.stringify($('#edit_customer_form').serializeJSON());
		// console.log(dataStr);


		// $.post("http://localhost:8080/news/edit.action",$("#edit_customer_form").serialize(),function(data){
		// 	if(data == "0"){
		// 		alert("客户信息更新成功！");
		// 		window.location.reload();
		// 	}else{
		// 		alert("客户信息更新失败了！");
		// 	}
			
		// });
		$.ajax({
			url:"http://localhost:8080/news/edit.action",
			data:$('#edit_customer_form').serializeJSON(),
			type:"post",
			dataType : "json",
			async:"false",
			success:function(data){
				if(data == "0"){
					alert("新闻信息更新成功！");
					window.location.reload();
				}else{
					alert("新闻信息更新失败了！");
				}
				console.log(data);
			}
		})
	 }


	//加载页面时渲染
	$.ajax({
		url:"http://localhost:8080/news/list.action",
		type:"post",
		dataType : "json",
		async:"true",
		success:function(result){
			if(result != null){
				newsData["list"] = result;
				var jsondata = JSON.stringify(newsData)
				console.log(jsondata);
				console.log(result);
				console.log(newsData.list["newsdetails"]);
				for(var i = 0;i<newsData.list.length;i++){
					var _date = new Date(newsData.list[i]["time"]);
					newsData.list[i]["time"] = _date.toLocaleDateString().replace(/\//g, "-")+ " " + _date.toTimeString().substr(0, 8); 
					console.log(newsData.list[i]["time"]);
					if(newsData.list[i]["newsdetails"] == null){
						newsData.list[i]["newsdetails"] = newsData.list[i]["newsname"]+"11";
					}
					
				}
			}
		}
	})

	//删除
	function deleteNews(event){
		var tdEle = $(event).attr("target");
		var data_id = $(tdEle).attr("data-id");
		console.log(data_id);

		if(confirm('确实要删除该条新闻吗?')) {
			$.post("http://localhost:8080/news/delete.action",{"id":data_id},function(data){
				alert("新闻删除成功！");
				window.location.reload();
			});
		}
		// $.ajax({
		// 	url:"http://localhost:8080/news/delete.action",
		// 	data:{"id":data_id},
		// 	dataType : "json",
		// 	async:"false",
		// 	success:function(result){
		// 		console.log(result);
		// 		if(result != null){
		// 			newsData["item"] = result;
		// 			console.log(newsData);
		// 			console.log(newsData["item"]);
		// 			var _date = new Date(newsData["item"]["time"]);
		// 			newsData["item"]["time"] = _date.toLocaleDateString().replace(/\//g, "-")+ " " + _date.toTimeString().substr(0, 8); 
		// 			console.log(newsData["item"]["time"]);
		// 			if(newsData["item"]["newsdetails"] == null){
		// 				newsData["item"]["newsdetails"] = newsData["item"]["newsname"]+"11";
		// 			}
		// 		}
		// 	}
		// })
	}

	//添加
	function addNews(){
		console.log("data:"+ $('#add_news_form').serializeJSON());
		$.ajax({
			url:"http://localhost:8080/news/add.action",
			data:$('#add_news_form').serializeJSON(),
			type:"post",
			dataType : "json",
			async:"false",
			success:function(data){
				if(data == "0"){
					alert("新闻信息添加成功！");
					window.location.reload();
				}else{
					alert("新闻信息添加失败了！");
				}
				console.log(data);
			}
		})
	}

