	var commodityData ={list:[],item:[]}; 
	var app = new Vue({
		el:'#app',
		data:commodityData

	})

		//加载页面时渲染
	$.ajax({
		url:"http://localhost:8080/item/businessList.action",
		type:"post",
		dataType : "json",
		async:"true",
		success:function(result){
			if(result != null){
				commodityData["list"] = result;
				var jsondata = JSON.stringify(commodityData)
				console.log(jsondata);
				console.log(result);
				console.log(commodityData.list["businessdetails"]);
				for(var i = 0;i<commodityData.list.length;i++){
					if(commodityData.list[i]["businessdetails"] == null){
						commodityData.list[i]["businessdetails"] = commodityData.list[i]["businessname"]+"11";
					}
					
				}
			}
		}
	})

	//修改
	function editCommodity(event){
		console.log(event);
		var tdEle = $(event).attr("target");
		var data_id = $(tdEle).attr("data-id");
		console.log(data_id);
		$.ajax({
			url:"http://localhost:8080/item/business.action",
			data:{"id":data_id},
			dataType : "json",
			async:"false",
			success:function(result){
				console.log(result);
				if(result != null){
					commodityData["item"] = result;
					console.log(commodityData);
					console.log(commodityData["item"]);
				}	
			}
		})
	}

	//更新
	function updateCommodity(){
		console.log($('#edit_commodity_form').serializeJSON());
		$.ajax({
			url:"http://localhost:8080/item/update.action",
			data:$('#edit_commodity_form').serializeJSON(),
			type:"post",
			dataType : "json",
			async:"false",
			success:function(data){
				if(data == "0"){
					alert("商品信息更新成功！");
					window.location.reload();
				}else{
					alert("商品信息更新失败了！");
				}
				console.log(data);
			}
		})
	}

	//删除
	function deleteCommodity(event){
		var tdEle = $(event).attr("target");
		var data_id = $(tdEle).attr("data-id");
		console.log(data_id);

		if(confirm('确实要删除该条商品吗?')) {
			$.post("http://localhost:8080/item/delete.action",{"id":data_id},function(data){
				alert("商品删除成功！");
				window.location.reload();
			});
		}
	}	

	//添加
	function addCommodity(){
		console.log($('#add_commodity_form').serializeJSON());
		$.ajax({
			url:"http://localhost:8080/item/add.action",
			data:$('#add_commodity_form').serializeJSON(),
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
