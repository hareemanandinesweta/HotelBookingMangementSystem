package com.cg.hbms.roomfacilities.exception;

/*******************************************************************************************
- File Name        : Exception Controller
- Author           : Anand Soni	
- Creation Date    : 11-06-2020
- Description      : This is an ExceptionController class to handle the Exception
                       
 ************************************************************************************************************/ 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionController {

	@ExceptionHandler(RoomIdNotFoundException.class)
	public ResponseEntity<ErrorMessage> handleException(RoomIdNotFoundException e) {
		ErrorMessage error=new ErrorMessage();
		error.setStatusCode(HttpStatus.BAD_GATEWAY.value());
		error.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(error,HttpStatus.OK);
}
	
	
	@ExceptionHandler(FacilitiesAlreadyExistException.class)
	public ResponseEntity<ErrorMessage> handleException(FacilitiesAlreadyExistException e) {
		
		ErrorMessage error=new ErrorMessage();
		error.setStatusCode(HttpStatus.BAD_GATEWAY.value());
		error.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(error,HttpStatus.OK);
	
	}
}
