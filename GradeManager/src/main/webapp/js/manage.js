layui.use(["jquery","element","laypage","layer"],function(){
	var $ = layui.jquery;
	var element = layui.element;
	var laypage = layui.laypage
    var layer = layui.layer;
	 $.ajax({
			type:"post",
			url:"/revocation/getCount",
			data:{
				
			},
			success: function(res){
				$("#number").html("")//清空原内容
				var newText = res;
				$("#number").html($("#number").html()+newText)
			}
	 })
	 $.ajax({
			type:"post",
			url:"/revocation/getCount1",
			data:{			
			},
			success: function(res){
				$("#number1").html("")//清空原内容
				var newText = "("+res+")";
				$("#number1").html($("#number1").html()+newText)
			}
	 })
	$.ajax({
			type:"post",
			url:"/revocation/getRevocation",
			data:{				
			},
			success: function(res){
				console.info(res);
				var txt;
				$("#list").html("")//清空原内容
				res.forEach(function(item){//显示	
					console.info(item.lesson);
					if(item.revocationReason.length>44)
					{
						reasonTxT=item.revocationReason.substring(0,44)+"<a class='reasonDetail' style='color:blue' id="+item.revocationId+">...详情></a>";
					}else{
						reasonTxT=item.revocationReason;
					}
					if(item.revocationType==0)
						{
							txt="申请撤销(暂存)";
						}else{
							txt="申请撤销(删除)";
						}
					var newText = 
					  "<div class='layui-row layui-col-space15' >"+
					    "<div class='layui-col-md8'>"+
					     "<div class='layui-card'>"+
					        "<div class='layui-card-header' style='color:red'>标题  : "+
					        item.lesson.teacher.tName+txt+item.lesson.course.courseName+"相关成绩</div>"+
					        "<div class='layui-card-body' style='color:green'>申请理由  : "
					          +reasonTxT
					          +"<div class='layui-card-body'>" +
					          	"<form class='layui-form'>" +
					          		"<div> "+
					          		"<a class='layui-btn layui-btn-xs' lay-event=agree" +
					          		item.revocationType+
					          		" id="+item.revocationId +
					          		">同意</a>" +
					          		"<a class='layui-btn layui-btn-danger layui-btn-xs' lay-event='refuse' id=" +
					          		item.revocationId +
					          		">拒绝</a>" +
					          		"</div>" +
					          	"</form>"+"" +
					          "</div>"+
					        "</div>"+
					      "</div>"+
					    "</div>"+
					  "</div>";
					$("#list").html($("#list").html()+newText)					
				}); 		   
			}
		})		
		$.ajax({
			type:"post",
			url:"/revocation/getRevocation1",
			data:{				
			},
			success: function(res){
				console.info(res);
				var txt;
				var reasonTxT;
				$("#list1").html("")//清空原内容
				res.forEach(function(item){					
					if(item.revocationReason.length>44)
					{
						reasonTxT=item.revocationReason.substring(0,44)+"<a class='reasonDetail' style='color:blue' id="+item.revocationId+">...详情></a>";
					}else{
						reasonTxT=item.revocationReason;
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
				        "<div class='layui-card-header' style='color:red'>标题  : "+
				        item.lesson.teacher.tName+txt+item.lesson.course.courseName+"相关成绩</div>"+
				        "<div class='layui-card-body' style='color:orange'>申请理由  : "
				          +reasonTxT
				          +""+
				        "</div>"+
				        "<div class='layui-card-body' style='color:green'>处理  : "
				          +item.revocationReply+
				        "</div>"+
				      "</div>"+
				    "</div>"+
				  "</div>";
					$("#list1").html($("#list1").html()+newText)
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
		  $(document).on('click','.layui-btn',function(obj){
			 var id=($(this).attr('id'));
			 var revocationId= parseInt(id);
			 var event=($(this).attr('lay-event'));			 
			 if(event=='agree0')
			{
				 var revocationReply="已同意";
				 $.ajax({
						type:"post",
						url:"/revocation/getRevocationReason?revocationId="+revocationId,
						data:{						
						},
						success: function(res){
						  var lessonId=res.removeLessonId;
						  layer.confirm('是否确定同意申请', function(index){
				            	$.post('lesson/setLessonEntered', {
				            		lessonId:lessonId
				  				}, function(flag) {
				  					if(flag){
				  						$.post('/revocation/updateRevocation', {
						            		revocationId:revocationId,revocationReply:revocationReply
						  				}, function(flag) {
						  					if(flag){
						  						layer.msg('操作成功')
						  						location.reload();
						  						
						  					}else{
						  						layer.msg('操作失败');
						  					}
						  				})				  		
				  						
				  					}else{
				  						layer.msg('操作失败');
				  					}
				  				})
				  	        layer.close(index);
				  	      });	
						}	 
			})	
			}
			else if(event=='agree1')
			{
				var revocationReply="已同意";
				 $.ajax({
						type:"post",
						url:"/revocation/getRevocationReason?revocationId="+revocationId,
						data:{						
						},
						success: function(res){
						  var lessonId=res.removeLessonId;
						  layer.confirm('是否确定同意申请', function(index){
							  $.post('lesson/setLessonEntered', {
				            		lessonId:lessonId
				  				},function(flag) {				  				
				  				})
				            	$.post('score/delScore', {
				            		lessonId:lessonId
				  				}, function(flag) {
				  					if(flag){
				  						$.post('/revocation/updateRevocation', {
						            		revocationId:revocationId,revocationReply:revocationReply
						  				}, function(flag) {
						  					if(flag){
						  						layer.msg('操作成功')
						  						location.reload();
						  						
						  					}else{
						  						layer.msg('操作失败');
						  					}
						  				})				  						  						
				  					}else{
				  						layer.msg('操作失败');
				  					}
				  				})
				  	        layer.close(index);
				  	      });	
						}
				 
			})	
				 
			}			
			else if(event=='refuse')
			{
				var revocationReply = "已拒绝，";
		        layer.prompt({
		            formType: 2,
		            value: '',
		            title: '请输入不通过原因',
		            area: ['730px', '420px'],
		            btn: ['确定','取消'], //按钮，
		            btnAlign: 'c'
		        }, function(value,index){
		        	revocationReply =revocationReply+ value;
		            console.info(revocationReply);
		            layer.close(index);
		            layer.confirm('是否确定拒绝申请', function(index){
		            	$.post('/revocation/updateRevocation', {
		            		revocationId:revocationId,revocationReply:revocationReply
		  				}, function(flag) {
		  					if(flag){
		  						layer.msg('操作成功')
		  						location.reload();
		  						
		  					}else{
		  						layer.msg('操作失败');
		  					}
		  				})
		  	        layer.close(index);
		  	      });		          
		        },function (value,index) {
		        });
			}				 
		 })	 
});