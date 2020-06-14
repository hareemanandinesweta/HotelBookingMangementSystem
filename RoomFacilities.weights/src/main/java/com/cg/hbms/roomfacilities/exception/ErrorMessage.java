package com.cg.hbms.roomfacilities.exception;

/********************************************************************************************************************************
- File Name        : ErrorMessage
- Author           : Anand Soni	
- Creation Date    : 11-06-2020
- Description      : This is an ErrorMessage class which is
					 provide status code and error message on API web development tool.  . 
 ********************************************************************************************************************************/ 

public class ErrorMessage {
	
	private int statusCode;
	private String errorMessage;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	

}
