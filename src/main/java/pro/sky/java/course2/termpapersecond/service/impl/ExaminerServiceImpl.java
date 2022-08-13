package pro.sky.java.course2.termpapersecond.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.termpapersecond.exceptions.LotOfQuestionException;
import pro.sky.java.course2.termpapersecond.question.Question;
import pro.sky.java.course2.termpapersecond.service.ExaminerService;
import pro.sky.java.course2.termpapersecond.service.QuestionService;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount <= 0 || amount > questionService.getAll().size()){
            throw new LotOfQuestionException();
        }
        Set<Question> result = new HashSet<>(amount);
        while (result.size() < amount) {
            result.add(questionService.getRandomQuestion());
        }
        return result;
    }
}
