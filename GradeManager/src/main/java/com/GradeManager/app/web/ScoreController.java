package com.GradeManager.app.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GradeManager.app.bean.Classs;
import com.GradeManager.app.bean.Lesson;
import com.GradeManager.app.bean.Score;
import com.GradeManager.app.service.ClasssService;
import com.GradeManager.app.service.LessonService;
import com.GradeManager.app.service.ScoreService;

import ch.qos.logback.core.joran.action.ActionUtil.Scope;

@RestController
public class ScoreController {
	@Autowired
	private ScoreService sco;
	@RequestMapping("score/delScore")
	public boolean  delScore(int lessonId){
		return  sco.delScore(lessonId);
	}
	@Autowired
	private ClasssService cl;
	@Autowired
	private LessonService les;
	@RequestMapping("lesson/updateLesson")//修改成绩分析
	/**
	 * 
	 * @param lessonId：授课号
	 * @param examOrigin：试题来源
	 * @param examTime：考试时间
	 * @param examWay：考试方式
	 * @param remark1：分析1
	 * @param remark2：分析2
	 * @param remark3：分析3
	 * @return
	 */
	public boolean updateLesson(int lessonId,String examOrigin,String examTime,String examWay,String remark1,String remark2,String remark3)
	{   
		int eo=0;
		if(examOrigin.equals("自主命题")) eo=0;
		else if(examOrigin.equals("试题库")) eo=1;
		else eo=2;
		return les.updateLesson(lessonId,examTime,eo,examWay,remark1,remark2,remark3);
		
	}
	
	@RequestMapping("lesson/getLessonScore")
	/**
	 * 处理所有读出的成绩并进行统计分析，是生成前端重要数据的主要算法
	 * @param lessonId：授课号
	 * @return
	 */
	public Map getLessonScore(int lessonId)
	{
		System.out.print("----------------------------"+lessonId);
		Map res = new HashMap<>();
		List<Score> scorelist=sco.getLessonScore(lessonId);//获取该课程的所有学生成绩
		List<Classs> classsList=cl.getClasss(String.format("%d", lessonId));//获取该课程的所有对应班级
		Lesson _lesson=les.getLesson(lessonId);//获取该课程的相关信息（包括可能已经填写的分析）
		///////对成绩进行统计分析
		int A=0,B=0,C=0,D=0,E=0,temp;
		float max=0,min=100,sum=0,avg=0;
		for(int i=0;i<scorelist.size();i++)
		{
			temp=scorelist.get(i).getNormalScore();
			if(temp>max) max=temp;
			if(temp<min) min=temp;
			sum+=temp;
			if(temp<60) E++;
			else if(temp<70) D++;
			else if(temp<80) C++;
			else if(temp<90) B++;
			else A++;
		}
		res.put("title",_lesson.getSchoolYear());//学年
		res.put("num", _lesson.getTerm());//学期
		res.put("cname", _lesson.getCourse().getCourseName());//课程名
		res.put("period", 36);//课程学时
		res.put("examway", _lesson.getExamWay());//考试方式
		String cla="";
		for(int i=0;i<classsList.size()-1;i++)
		{
			cla+=classsList.get(i).getcId()+",";
		}
		cla+=classsList.get(classsList.size()-1).getcId();
		res.put("classs", cla);//考试班级
		res.put("exam_date",_lesson.getExamTime());//考试日期
		
		String origin;//试题来源
		if(_lesson.getExamOrigin()==0) origin="自主命题";
		else if(_lesson.getExamOrigin()==1) origin="试题库";
		else origin="其它";
		res.put("origin",origin);
		
		float amount=_lesson.getExamStuNum();
		res.put("student_amount", _lesson.getExamStuNum());//考试人数
		res.put("tname", _lesson.getTeacher().gettName());//教师名
		res.put("school", _lesson.getTeacher().gettSchoolName());//学院名
		res.put("tposition", "讲师");//教师职位
		//各个等级人数及百分比
		res.put("E_num",E);
	    res.put("D_num",D);
	    res.put("C_num",C);
	    res.put("B_num",B);
	    res.put("A_num",A);
	    res.put("E_percent",(float)(Math.round(E*100.0/amount*100))/100);
	    res.put("D_percent",(float)(Math.round(D*100.0/amount*100))/100);
	    res.put("C_percent",(float)(Math.round(C*100.0/amount*100))/100);
	    res.put("B_percent",(float)(Math.round(B*100.0/amount*100))/100);
	    res.put("A_percent",(float)(Math.round(A*100.0/amount*100))/100);
	    //最高成绩
	    res.put("max_score",max);
	    //最低成绩
	    res.put("min_score",min);
	    //平均成绩
	    avg=(float)(Math.round(sum/amount*100))/100;
	    res.put("avg_score",avg);
	    
	    sum=0;
	    for(int i=0;i<scorelist.size();i++)
		{
	    	temp=scorelist.get(i).getNormalScore();
			sum+=(avg-temp)*(avg-temp);
		}
	    sum=(float) Math.pow(sum/amount, 0.5);
	    res.put("std", (float)(Math.round(sum*100))/100);//标准差
	    
	    int data[]=new int[5];
	    data[0]=A;
	    data[1]=B;
	    data[2]=C;
	    data[3]=D;
	    data[4]=E;
	    
	    res.put("chart_data",data);//传给折现统计图的数据
	    //赋值给表单的数据
	    res.put("examOrigin",_lesson.getExamOrigin());
	    res.put("examTime",_lesson.getExamTime());
	    res.put("examWay",_lesson.getExamWay());
	    res.put("remark1",_lesson.getRemark1());
	    res.put("remark2",_lesson.getRemark2());
	    res.put("remark3",_lesson.getRemark3());
		return res;
	}
	
	@RequestMapping("score/listScore")//获取该课程的所有学生成绩
	public List<HashMap<String, Object>> listScore(int lessonId){
		
		return sco.listScore(lessonId);
	
	}
}
