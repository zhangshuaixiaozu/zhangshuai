layui.use(["jquery","element","laypage","layer"],function() {
    var $ = layui.jquery;
    var element = layui.element;
    var laypage = layui.laypage
    var layer = layui.layer;
    
    $.ajax({
		type:"post",
		url:"/teacher/getMessages",
		data:{				
		},
		success: function(res){
			console.info(res);
			var txt;
			var reasonTxt;
			$("#messageList").html("")//清空原内容
			res.forEach(function(item){	
				var replyTxt;
				if(item.revocationReply =="0")
				{
					replyTxt="未处理";
				}else{
					replyTxt=item.revocationReply;
				}	
				if(item.revocationReason.length>44)
				{
					reasonTxt=item.revocationReason.substring(0,44)+"<a class='reasonDetail' style='color:blue' id="+item.revocationId+">...详情></a>";
				}else{
					reasonTxt=item.revocationReason;
				}				
				if(item.revocationType==0)
				{
					txt="申请撤销(暂存)";
				}else{
					txt="申请撤销(删除)";
				}									
			var newText = 
			  "<div class='layui-row layui-col-space15' >"+
			    "<div class='layui-col-md8' >"+
			     "<div class='layui-card'>"+
			        "<div class='layui-card-header' style='color:red'>标题  : 您"+
			        txt+item.courseName+"相关成绩</div>"+
			        "<div class='layui-card-body' style='color:orange'>申请理由  : "
			          +reasonTxt+
			        "</div>"+
			        "<div class='layui-card-body' style='color:green'>结果 : "
			          +replyTxt+
			        "</div>"+
			      "</div>"+
			    "</div>"+
			  "</div>";
				$("#messageList").html($("#messageList").html()+newText)
			}); 		   
		}
	})
	
	$(document).on('click','.reasonDetail',function(data){
		 var id=($(this).attr('id'));
		 var revocationId= parseInt(id);
		 console.info(revocationId);
		 var reason;
		 $.ajax({
				type:"post",
				url:"/revocation/getRevocationReason?revocationId="+revocationId,
				data:{						
				},
				success: function(res){
					console.info(res.revocationReason);
					reason=res.revocationReason;
					layer.open({
					    type: 1 ,
					    title: '申请撤销理由详情',   //标题
					    area:  ['730px', '420px'],   //宽高
					    shade: 0.8,   //遮罩透明度
					    content:reason,
					    btn: ['确定'], //按钮组
					    scrollbar: false ,//屏蔽浏览器滚动条
					    yes: function(index){
					        layer.close(index);
					        showToast();
					    }						    
					});
				}
		 })
		 
	 })	 
});