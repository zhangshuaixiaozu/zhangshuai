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
            window.location.href = "";
        }else if(event === "input1"){//正考录入
            window.location.href = "";
        }else if(event === "input2"){//补考录入
            window.location.href = "";
        }else if(event === "input3"){//清考录入
            window.location.href = "";
        }else if(event === "analyse"){//成绩分析
            window.location.href = "";
        }else if(event === "revocation"){//成绩撤回
            layer.confirm("<textarea placeholder='撤销理由' id='textarea1' style='width: 100%; height: 100%'></textarea>",{
                btn: ['撤回','删除','取消'] //按钮
            }, function(){
                layer.msg($("#textarea1").val());
            });
        }
            });
    console.info(Number("123")+123);
});