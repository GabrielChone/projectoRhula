package com.rhula.apirest.Exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource messageSource;
	@Override
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		String messagen=messageSource.getMessage(ex.getBindingResult().getAllErrors().get(0),  LocaleContextHolder.getLocale());
		return super.handleExceptionInternal(ex, messagen, headers, HttpStatus.BAD_REQUEST, request);
	}


	public ResponseEntity<Object> errrro() {
		// TODO Auto-generated method stub
		//String message=messageSource.getMessage(ex.getBindingResult().getAllErrors().get(0),  LocaleContextHolder.getLocale());
		return super.handleExceptionInternal(null, " Erro. Preencha todos dados", null, HttpStatus.BAD_REQUEST, null);
	}

	@Override
	protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub 
		return super.handleExceptionInternal(null, "ERRO. falhou ao registar", headers, HttpStatus.BAD_REQUEST, request);
	}

}
