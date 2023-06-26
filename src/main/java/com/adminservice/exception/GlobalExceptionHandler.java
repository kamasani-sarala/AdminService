package com.adminservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
	public class GlobalExceptionHandler 
	{
			@ExceptionHandler
			public  ResponseEntity<ApiError> handle(Exception e) 
			{
				ApiError error= new ApiError();
				error.setError(e.getMessage());
				ResponseEntity<ApiError> resEntity= new ResponseEntity<ApiError>(error, HttpStatus.NOT_FOUND);
				return resEntity;
			}
			
			@ExceptionHandler(value = AdminNotFound.class)
		    public ResponseEntity<String> PurchasecardNotFound(AdminNotFound e) {
		        return new ResponseEntity<>("Admin Not Found", HttpStatus.NOT_FOUND);
		    }

		 

		    @ExceptionHandler(value = AdminAlreadyExist.class)
		    public ResponseEntity<String> PurchasecardNotFound(AdminAlreadyExist e) {
		        return new ResponseEntity<>("Admin Already Exists", HttpStatus.NOT_FOUND);
		    }
	}

