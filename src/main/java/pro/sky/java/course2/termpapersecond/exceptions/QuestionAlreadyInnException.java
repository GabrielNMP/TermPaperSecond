package pro.sky.java.course2.termpapersecond.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionAlreadyInnException extends RuntimeException {
    public QuestionAlreadyInnException() {
    }

    public QuestionAlreadyInnException(String message) {
        super(message);
    }

    public QuestionAlreadyInnException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionAlreadyInnException(Throwable cause) {
        super(cause);
    }

    public QuestionAlreadyInnException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
