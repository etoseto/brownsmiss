//图片轮播js
	var box = document.getElementById('box');
	var uls = document.getElementsByTagName('ul');
	var imgs = uls[0].getElementsByTagName('li');
	var btns = uls[1].getElementsByTagName('li');
	var play = null;
	var i = index=0;
	//控制图片的出现
	function show(a){
		for(i=0;i<btns.length;i++){
			btns[i].className="";
			btns[a].className="current";
		}
		for(i=0;i<imgs.length;i++){
			imgs[i].style.opacity=0;
			imgs[i].style.visibility="hidden";
			imgs[i].style.transition="all 1s linear";
			imgs[a].style.opacity=1;
			imgs[a].style.visibility="visible";
			// 实现过渡,使点击效果实现

		}
	}
	//鼠标在按钮上切换图片
	for(i=0;i<btns.length;i++){
		btns[i].index=i;
		btns[i].onmouseover=function(){
			show(this.index);
			clearInterval(play);
		}
	}
	//图片自动播放
	function autoPlay(){
		play=setInterval(function(){
			index++;
			index>=imgs.length && (index=0);
			show(index);
		},3000)
	}
	autoPlay();
	//鼠标移入移出效果
	box.onmouseover=function(){
		clearInterval(play);
	}
	box.onmouseout=function(){
		autoPlay();
	}
