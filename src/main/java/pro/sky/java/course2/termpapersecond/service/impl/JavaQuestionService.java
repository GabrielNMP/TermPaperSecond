package pro.sky.java.course2.termpapersecond.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.termpapersecond.exceptions.QuestionAlreadyInnException;
import pro.sky.java.course2.termpapersecond.exceptions.QuestionNotFoundException;
import pro.sky.java.course2.termpapersecond.question.Question;
import pro.sky.java.course2.termpapersecond.service.QuestionService;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions;
    private final Random random;

    public JavaQuestionService() {
        this.questions = new HashSet<>();
        this.random = new Random();
    }

    @Override
    public Question add(String question,
                        String answer) {
        Question javaQuestion = new Question(question, answer);
         if (questions.contains(javaQuestion)){
             throw  new QuestionAlreadyInnException();
         }
        questions.add(javaQuestion);
        return javaQuestion;
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)){
            throw  new QuestionAlreadyInnException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)){
            throw  new QuestionNotFoundException();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }
}
