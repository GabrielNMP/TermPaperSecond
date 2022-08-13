package pro.sky.java.course2.termpapersecond.serviceImpl;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.termpapersecond.exceptions.LotOfQuestionException;
import pro.sky.java.course2.termpapersecond.question.Question;
import pro.sky.java.course2.termpapersecond.service.impl.ExaminerServiceImpl;
import pro.sky.java.course2.termpapersecond.service.impl.JavaQuestionService;

import java.util.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    public void getQuestionsNegativeNest(){
        Assertions.assertThatExceptionOfType(LotOfQuestionException.class)
                .isThrownBy(() -> examinerService.getQuestions(-1));
        Assertions.assertThatExceptionOfType(LotOfQuestionException.class)
                .isThrownBy(() -> examinerService.getQuestions(1));
    }

    @Test
    public void getQuestionsPositiveNest(){
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("Q1", "A1"));
        questions.add(new Question("Q2", "A2"));
        questions.add(new Question("Q3", "A3"));
        questions.add(new Question("Q4", "A4"));
        questions.add(new Question("Q5", "A5"));

        when(javaQuestionService.getAll())
                .thenReturn(questions);

        when(javaQuestionService.getRandomQuestion())
                .thenReturn(questions.get(0),questions.get(1), questions.get(0),questions.get(2));
        assertThat(examinerService.getQuestions(2))
                .containsExactlyInAnyOrder(questions.get(0),questions.get(1));

        when(javaQuestionService.getRandomQuestion())
                .thenReturn(questions.get(0), questions.get(1),questions.get(0), questions.get(2), questions.get(1), questions.get(3));
        assertThat(examinerService.getQuestions(4))
                .containsExactlyInAnyOrder(questions.get(0),questions.get(1),questions.get(2), questions.get(3));
    }

}
