package br.com.alura.forum.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;

@Data
public class ApiError {
    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    private LocalDateTime timestamp;

    private String exception;
    private String message = "Internal Server Error";
    private String rejectedValue;
    private String object;
    private String debugMessage;
    private Collection<ApiSubError> errors = new HashSet<>();

    public ApiError() {
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(String message) {
        this();
        this.message = message;
    }

    public ApiError(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.exception = ex.getClass().getName();
        this.debugMessage = ex.getMessage();
    }

    public ApiError(Throwable ex) {
        this(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    public ApiError(HttpStatus status, String message, Throwable ex) {
        this(status, ex);
        this.message = message;
    }

    public ApiError(HttpStatus status, String message, Throwable ex, Collection<ApiSubError> errors) {
        this(status, message, ex);
        this.errors = errors;
    }

    public ApiError(HttpStatus status, String message, Throwable ex, String rejectedValue, String object) {
        this(status, message, ex);
        this.rejectedValue = rejectedValue;
        this.object = object;
    }

    public ApiError(HttpStatus status, String message, Throwable ex, String rejectedValue, String object, Collection<ApiSubError> errors) {
        this(status, message, ex, rejectedValue, object);
        this.errors = errors;
    }


}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    public ApiSubError(FieldError fieldError) {
        this.object = fieldError.getObjectName();
        this.field = fieldError.getField();
        this.rejectedValue = fieldError.getRejectedValue();
        this.message = fieldError.getDefaultMessage();
    }
    public ApiSubError(ObjectError objectError) {
        this.object = objectError.getObjectName();

        /*
        this.field = fieldError.getField();
        this.rejectedValue = fieldError.getRejectedValue();
        */
        this.message = objectError.getDefaultMessage();
    }
}