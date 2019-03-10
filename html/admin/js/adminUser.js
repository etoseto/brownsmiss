	var userData ={list:[],item:[]}; 
	var app = new Vue({
		el:'#app',
		data:userData

	})

		//加载页面时渲染
	$.ajax({
		url:"http://localhost:8080/access/list.action",
		type:"post",
		dataType : "json",
		async:"true",
		success:function(result){
			if(result != null){
				userData["list"] = result;
				var jsondata = JSON.stringify(userData)
				console.log(jsondata);
				console.log(result);
				console.log(userData.list["businessdetails"]);
				
			}
		}
	})

	//修改
	function editUser(event){
		console.log(event);
		var tdEle = $(event).attr("target");
		var data_id = $(tdEle).attr("data-id");
		console.log(data_id);
		$.ajax({
			url:"http://localhost:8080/access/getAdmin.action",
			data:{"id":data_id},
			dataType : "json",
			async:"false",
			success:function(result){
				console.log(result);
				if(result != null){
					userData["item"] = result;
					console.log(userData);
					console.log(userData["item"]);
				}	
			}
		})
	}

	//更新
	function updateNews(){
		console.log($('#edit_customer_form').serializeJSON());
		$.ajax({
			url:"http://localhost:8080/access/update.action",
			data:$('#edit_customer_form').serializeJSON(),
			type:"post",
			dataType : "json",
			async:"false",
			success:function(data){
				if(data == "0"){
					alert("用户信息更新成功！");
					window.location.reload();
				}else{
					alert("用户信息更新失败了！");
				}
				console.log(data);
			}
		})
	}

	//删除
	function deleteuser(event){
		var tdEle = $(event).attr("target");
		var data_id = $(tdEle).attr("data-id");
		console.log(data_id);

		if(confirm('确实要删除该条用户吗?')) {
			$.post("http://localhost:8080/access/delete.action",{"id":data_id},function(data){
				alert("用户删除成功！");
				window.location.reload();
			});
		}
	}	

	//添加
	function addUser(){
		var name =  $("#username").val();
		var password =  $("#password").val();
		console.log(name);
		console.log(password);
		var dataStr = {
			"name":name,
			"password":password
		};
		console.log($('#add_user_form').serializeJSON());
		$.ajax({
			url:"http://localhost:8080/access/add.action",
			data:dataStr,
			type:"post",
			dataType : "json",
			async:"false",
			success:function(data){
				if(data == "0"){
					alert("用户信息添加成功！");
					window.location.reload();
				}else{
					alert("用户信息添加失败了！");
				}
				console.log(data);
			}
		})
	}