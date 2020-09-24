package com.GradeManager.app.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GradeManager.app.bean.ScoreShow;
import com.GradeManager.app.bean.Student;
import com.GradeManager.app.service.LoginService;
import com.GradeManager.app.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService std;
	@Autowired
	private HttpSession session;

	@RequestMapping("student/score")
	public List<ScoreShow> student(String term, String term2) {
		Student student = (Student) session.getAttribute("user");
		String sId = student.getsId();

		List<ScoreShow> std2 = std.getScore(term, term2, sId);
		for (int i = 0; i < std2.size(); i++) {
			if (std2.get(i).getSupplementScore() > 60) {
				std2.get(i).setSupplementScore(60.0);
			}
			if (std2.get(i).getClearScore() > 60) {
				std2.get(i).setClearScore(60.0);
				;
			}
			if (std2.get(i).getSupplementScore() == -1) {
				std2.get(i).setJudgeCcore(std2.get(i).getUsualProportion() * std2.get(i).getUsualScore()
						+ std2.get(i).getNormalScore() * (1.0 - std2.get(i).getUsualProportion()));
				std2.get(i).setScore(((double) ((int) ((std2.get(i).getJudgeCcore()) * 10))) / 10 + "");

			} else if ((std2.get(i).getClearScore() == -1) && (std2.get(i).getSupplementScore() != -1)) {
				std2.get(i).setJudgeCcore(std2.get(i).getSupplementScore());
				std2.get(i)
						.setScore(std2.get(i).getUsualProportion() * std2.get(i).getUsualScore()
								+ std2.get(i).getNormalScore() * (1.0 - std2.get(i).getUsualProportion()) + "/"
								+ std2.get(i).getSupplementScore());
			} else if (std2.get(i).getClearScore() != -1) {
				std2.get(i).setJudgeCcore(std2.get(i).getClearScore());
				std2.get(i)
						.setScore(std2.get(i).getUsualProportion() * std2.get(i).getUsualScore()
								+ std2.get(i).getNormalScore() * (1.0 - std2.get(i).getUsualProportion()) + "/"
								+ std2.get(i).getSupplementScore() + "/" + std2.get(i).getClearScore());
			}

		}
		return std2;
	}

}
