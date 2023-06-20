package br.com.divMasterExceptionHandle;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.divMasterException.ExceptionResponsess;
import br.com.divMasterException.unsupportedMathOperatioExceptio;


@RestController
@ControllerAdvice
public class customizedResponseEntityExceptionHandle extends ResponseEntityExceptionHandler {


	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponsess>handleAllException(Exception ex, WebRequest request) {
		ExceptionResponsess exceptionResponse = new ExceptionResponsess( LocalDateTime.now(), 
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(unsupportedMathOperatioExceptio.class)
	public final ResponseEntity<ExceptionResponsess>handleBADRequestException(Exception ex, WebRequest request) {
		ExceptionResponsess exceptionResponse = new ExceptionResponsess(LocalDateTime.now(), 
				ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

}
