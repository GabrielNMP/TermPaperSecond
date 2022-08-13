package pro.sky.java.course2.termpapersecond.serviceImpl;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.course2.termpapersecond.exceptions.QuestionAlreadyInnException;
import pro.sky.java.course2.termpapersecond.exceptions.QuestionNotFoundException;
import pro.sky.java.course2.termpapersecond.question.Question;
import pro.sky.java.course2.termpapersecond.service.QuestionService;
import pro.sky.java.course2.termpapersecond.service.impl.JavaQuestionService;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();

    @ParameterizedTest
    @MethodSource("q1")
    public void addExceptionTest(Question question) {
        questionService.add(question);
        assertThatExceptionOfType(QuestionAlreadyInnException.class)
                .isThrownBy(() -> questionService.add(question));
    }

    @ParameterizedTest
    @MethodSource("q1")
    public void addTest(Question question) {
        questionService.add(question);
        assertThat(questionService.getAll())
                .containsExactlyInAnyOrder(question);
    }

    @ParameterizedTest
    @MethodSource("q2")
    public void addWithAnswerExceptionTest(String question,String answer) {
        questionService.add(question, answer);
        assertThatExceptionOfType(QuestionAlreadyInnException.class)
                .isThrownBy(() -> questionService.add(new Question(question, answer)));
    }

    @ParameterizedTest
    @MethodSource("q2")
    public void addWithAnswerTest(String question, String answer) {
        questionService.add(question,answer);
        assertThat(questionService.getAll())
                .containsExactlyInAnyOrder(new Question(question, answer));
    }

    @ParameterizedTest
    @MethodSource("q1")
    public void removeTest(Question question) {
        questionService.add(question);
        questionService.remove(question);
        assertThat(questionService.getAll()).isEmpty();
    }

    @ParameterizedTest
    @MethodSource("q1")
    public void removeExceptionTest(Question question) {
        questionService.add(question);
        questionService.remove(question);
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(()-> questionService.remove(question));
    }

    @ParameterizedTest
    @MethodSource("someQuestions")
    public void getRandomQuestionTest(Set<Question> questions) {
        questions.forEach(questionService::add);
        assertThat(questionService.getAll()).hasSize(questions.size());
        assertThat(questionService.getRandomQuestion()).isIn(questionService.getAll());

    }

    public static Stream<Arguments> q1(){
        return Stream.of(
                Arguments.of(new Question("Q", "A")));
    }

    public static Stream<Arguments> q2(){
        return Stream.of(
                Arguments.of("Q", "A"));
    }

    public static Stream<Arguments> someQuestions(){
        return Stream.of(
                Arguments.of(
                        Set.of(
                                new Question("Q1", "A1"),
                                new Question("Q1", "A1"),
                                new Question("Q1", "A1")
                        )
                )
        );
    }
}
