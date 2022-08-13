package pro.sky.java.course2.termpapersecond.service;

import pro.sky.java.course2.termpapersecond.question.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question> getQuestions(int amount);
}
