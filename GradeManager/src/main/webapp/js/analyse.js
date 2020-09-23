layui.use(['laytpl','layer', 'form', 'laydate', 'element','jquery'], function () {
    var element = layui.element;
    var laytpl = layui.laytpl;
    var form = layui.form
    var laydate = layui.laydate
	var $=layui.jquery
	var layer=layui.layer
    
    var lessonId=getUrlParams('lessonId');
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //数据获取区域
    $.ajax({
		url: '/lesson/getLessonScore',
		type: 'post',
		data: {"lessonId":lessonId},
		dataType : 'JSON',
		success: function (data) {
			 //////////////////////////////////表1
		    var getTpl = demo.innerHTML
		        , view = document.getElementById('view');
		    laytpl(getTpl).render(data, function (html) {
		        view.innerHTML = html;
		    });
		    ///////////////////////////////////////////表2
		    var data2 = {
		        "quality_analyse": data.remark1
		        , "score_analyse": data.remark2
		        , "effect_analyse": data.remark3
		    }
		    var getTpl2 = demo2.innerHTML
		        , view2 = document.getElementById('view2');
		    laytpl(getTpl2).render(data2, function (html) {
		        view2.innerHTML = html;
		    });
		    ///////////////////////////
		    Highcharts.chart('container', {
		        chart: {
					type: 'line'
		        },
		        title: {
		            text: ' '
		        },
		        xAxis: {
		            categories: ['优秀','良好','中等','及格','不及格']
		        },
		        yAxis: {
		            title: {
		                text: '人数(人)'
		            }
		        },
		        plotOptions: {
		            line: {
		                dataLabels: {
		                    enabled: true
		                },
		                enableMouseTracking: true
		            }
		        },
		        series: [{
		            name: "成绩分析",
		            data: data.chart_data
		        }]
		    });
		    ///////////////////////////////////修改表单

		    form.val("update_analyse", { //formTest 即 class="layui-form" 所在元素属性 lay-filter="" 对应的值
		        "examOrigin": data.origin
		        , "examTime": data.examTime
		        , "examWay": data.examWay
		        , "remark1": data.remark1
		        , "remark2": data.remark2
		        , "remark3": data.remark3
		    });
		    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		    //监听提交
		    form.on('submit(formDemo)', function (data) {
		    	$(data.field).attr("lessonId",lessonId);
		    	console.log(data.field);
		    	 $.ajax({
		    			url: '/lesson/updateLesson',
		    			type: 'post',
		    			data: data.field,
		    			dataType : 'JSON',
		    			success: function (data2) {
		    				if(data2==true) location.reload();
		    			}});
		        return false;
		    });

		    ///////////////////////////////////////////////////////////////
		    laydate.render({
		        elem: '#examTime'
		    });
		}
	});
});
function preview()
{
        bdhtml=window.document.body.innerHTML;//获取当前页的html代码
        sprnstr="<!-- printTableStart -->";//设置打印开始区域
        eprnstr="<!-- printTableEnd -->";//设置打印结束区域
        prnhtml=bdhtml.substring(bdhtml.indexOf(sprnstr)+24); //从开始代码向后取html
        prnhtml=prnhtml.substring(0,prnhtml.indexOf(eprnstr));//从结束代码向前取html
        window.document.body.innerHTML=prnhtml;
        window.print();
        window.document.body.innerHTML=bdhtml;
}
function getUrlParams(name) { // 不传name返回所有值，否则返回对应值
    var url = window.location.search;
    if (url.indexOf('?') == 1) { return false; }
    url = url.substr(1);
    url = url.split('&');
    var name = name || '';
    var nameres;
    // 获取全部参数及其值
    for(var i=0;i<url.length;i++) {
        var info = url[i].split('=');
        var obj = {};
        obj[info[0]] = decodeURI(info[1]);
        url[i] = obj;
    }
    // 如果传入一个参数名称，就匹配其值
    if (name) {
        for(var i=0;i<url.length;i++) {
            for (const key in url[i]) {
                if (key == name) {
                    nameres = url[i][key];
                }
            }
        }
    } else {
        nameres = url;
    }
    // 返回结果
    return nameres;
}