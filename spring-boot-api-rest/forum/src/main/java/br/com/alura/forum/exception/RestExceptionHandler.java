package br.com.alura.forum.exception;

import br.com.alura.forum.controller.dto.ErrorFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    /* @ExceptionHandler({Exception.class})
     protected ResponseEntity handleException(Exception ex) {
         ApiError apiError = new ApiError(ex);
         if(ex instanceof TransactionSystemException) apiError.setStatus(HttpStatus.CONFLICT);
         if(ex instanceof MethodArgumentNotValidException) {
             apiError.setStatus(HttpStatus.BAD_REQUEST);
             apiError.setMessage("Invalid Validation");
         }
         return ResponseEntity.status(apiError.getStatus()).body(apiError);
     }*/
//    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
//    @ExceptionHandler({MethodArgumentNotValidException.class})
//    protected List<ErrorFormDto> handleValidationException(MethodArgumentNotValidException ex) {
//        List<ErrorFormDto> errorsForm = new ArrayList<>();
//        var locale = LocaleContextHolder.getLocale();
//        var fieldErrors = ex. getFieldErrors();
//        fieldErrors.forEach(fieldError -> {
//
//            String message = messageSource.getMessage(fieldError, locale);
//
//            errorsForm.add(
//                    new ErrorFormDto(fieldError.getField(), fieldError.getObjectName(), fieldError.getDefaultMessage(), fieldError.getRejectedValue())
//            );
//        });
//
//        /*return ResponseEntity.badRequest().body(errorsForm);*/
//        return errorsForm;
//    }

}
