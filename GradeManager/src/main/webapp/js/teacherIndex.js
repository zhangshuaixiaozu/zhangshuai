layui.use(["jquery","table","element","layer"],function () {
    var $ = layui.jquery;
    var table = layui.table;
    var layer = layui.layer;
    var data;
    $.ajaxSettings.async = false;
    $.ajax({
        type: "get",
        url: "/teacher/getLessons",
        success: function (obj) {
            data = obj;
        }
    });
    $.ajax({
        type: "get",
        url: "/user/getTname",
        success: function (obj) {
        	$("#tName").text("欢迎您,"+obj+"老师")
        }
    });
    
    let newData = JSON.parse(JSON.stringify(data));
    var indexTable = table.render({
        elem: "#indexTable",
        autoSort: false,
        page: true,
        cols: [[
            {field: "lessonId", title: "课程编号", sort: true,},
            {field: "courseName", title: "课程名",},
            {field: "schoolYear", title: "学年",},
            {field: "term", title: "学期",},
            {field: "scoreType", title: "分数类型",},
            {field: "usualProportion", title: "平时分占比",},
            {field: "action", title: "操作", toolbar: "#actions", width: 450},
        ]],
        data: newData
    });
    table.on("tool(indexTable)",function (obj) {
        let data = obj.data;
        console.info(data);
        let event = obj.event;
        console.info(event);

        if(event === "check"){//查看
        	window.open(`./teacherView.html?lessonId=${data.lessonId}`);
        }else if(event === "input1"){//正考录入
                window.open(`../normalInput.html?lessonId=${data.lessonId}`);
        }else if(event === "input2"){//补考录入
                window.open(`../supplementInput.html?lessonId=${data.lessonId}`);
        }else if(event === "input3"){//清考录入
                window.open(`../clearInput.html?lessonId=${data.lessonId}`);
        }else if(event === "analyse"){//成绩分析
            if (data.entered === 1){
                window.open(`../analyse.html?lessonId=${data.lessonId}`);
            }else{
                layer.msg("成绩尚未提交");
            }
        }else if(event === "revocation"){//成绩撤回
            if (data.entered === 1){
                layer.confirm("<textarea placeholder='撤销理由' id='textarea1' style='width: 100%; height: 93%'></textarea>",{
                    btn: ['撤回','删除','取消'], //按钮
                    area: ['420px', '300px'],
                }, function(){
                    $.ajax({
                        url: "/teacher/revocation",
                        type: "get",
                        data: {
                            reason: $("#textarea1").val(),
                            type: 0,
                            lessonId: data.lessonId,
                        },
                        success: function () {
                            layer.msg("成功提交撤销申请");
                        }
                    })
                }, function(){
                    $.ajax({
                        url: "/teacher/revocation",
                        type: "get",
                        data: {
                            reason: $("#textarea1").val(),
                            type: 1,
                            lessonId: data.lessonId,
                        },
                        success: function () {
                            layer.msg("成功提交撤销申请");
                        }
                    })
                }, function(){

                });
            }else{
                layer.msg("成绩尚未提交");
            }

        }
    });
    console.info(Number("123")+123);
});