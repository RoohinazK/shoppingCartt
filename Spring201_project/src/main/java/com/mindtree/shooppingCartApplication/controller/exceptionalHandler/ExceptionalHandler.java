package com.mindtree.shooppingCartApplication.controller.exceptionalHandler;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.shooppingCartApplication.controller.ShoppingCartController;
import com.mindtree.shooppingCartApplication.exception.serviceException.ServiceException;


@RestControllerAdvice(assignableTypes = ShoppingCartController.class)
public class ExceptionalHandler {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<Map<String, Object>> serviceExceptionHandler(Exception e, Throwable cause) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("Body", e.getMessage());
		response.put("Messagee", HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
	}
	
}