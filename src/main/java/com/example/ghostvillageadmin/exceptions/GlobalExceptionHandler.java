package com.example.ghostvillageadmin.exceptions;


import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
@RequiredArgsConstructor
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public void handleException(Exception ex) throws Exception {
		List<Class<? extends Exception>> ignores = Arrays.asList(
			NotFoundException.class,
			ClientAbortException.class,
			MethodArgumentTypeMismatchException.class,
			BadRequestException.class
		);

		ex.printStackTrace();
		throw ex;
	}

	/**
	 * MethodArgumentNotValidException 에 대한 전역 message 처리
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, Object> errorMap = new LinkedHashMap<>();
		errorMap.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		errorMap.put("status", 400);
		errorMap.put("error", "MethodArgumentNotValidException");
		ex.getBindingResult().getAllErrors().stream().findAny().ifPresent(x -> errorMap.put("message", x.getDefaultMessage()));
		return ResponseEntity.badRequest().body(errorMap);
	}

	@ExceptionHandler(value = {ConstraintViolationException.class})
	protected ResponseEntity<Map<String, Object>> handleConstraintViolation(ConstraintViolationException ex) {
		Map<String, Object> errorMap = new LinkedHashMap<>();
		errorMap.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		errorMap.put("status", 400);
		errorMap.put("error", "ConstraintViolationException");
		errorMap.put("message", "Please check your enter");

		Map<String, Object> errorFieldMap = new HashMap<>();
		for (ConstraintViolation<?> constraintViolation : ex.getConstraintViolations()) {
			String field = constraintViolation.getPropertyPath() != null ? constraintViolation.getPropertyPath().toString() : "";
			String defaultMessage = constraintViolation.getMessage();
			errorFieldMap.put(field, defaultMessage);
		}
		errorMap.put("reason", errorFieldMap);
		return ResponseEntity.badRequest().body(errorMap);
	}
}
