	
    

layui.use([ 'layer', 'form', 'jquery' ], function() {
			var layer = layui.layer;
			var form = layui.form;
			var $ = layui.jquery;			
			//编写登录对话框
			  
			
			//提交表单
			form.on('submit(userlogin)', function(data) {
				console.log(data.field);
				$.post('user/login',data.field, function(flag) {
					console.log(flag);
					
					if(flag == "学生登陆成功")
						{window.location.href="./jsp/xuesheng.jsp";}
					else if(flag=="老师登陆成功"){
						
					window.location.href="./jsp/laoshi.jsp";}
					else if(flag=="管理员登陆成功"){
								window.location.href="index.jsp";
				}
					else if(flag=="登录失败"){ 
						  layer.msg('登录失败');}
					
				})

				return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
			});
			
			

		})
    
