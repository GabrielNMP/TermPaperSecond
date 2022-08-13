package pro.sky.java.course2.termpapersecond.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LotOfQuestionException extends RuntimeException{
    public LotOfQuestionException() {
    }

    public LotOfQuestionException(String message) {
        super(message);
    }

    public LotOfQuestionException(String message, Throwable cause) {
        super(message, cause);
    }

    public LotOfQuestionException(Throwable cause) {
        super(cause);
    }

    public LotOfQuestionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
