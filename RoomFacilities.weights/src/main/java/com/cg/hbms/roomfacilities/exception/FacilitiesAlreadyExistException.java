package com.cg.hbms.roomfacilities.exception;

/********************************************************************************************************************************
- File Name        : FacilitiesAlreadyExistException
- Author           : Anand Soni	
- Creation Date    : 11-06-2020
- Description      : This is an FacilitiesAlreadyExistException class which is
					 used to handle the Exception in Room facilities service . 
 ********************************************************************************************************************************/ 

public class FacilitiesAlreadyExistException extends Exception{
	

	/*****************************************************************************************************************************
	 - Method Name      : getMessage
	 - Return type      : String
	 - Author           : Anand Soni
	 - Creation Date    : 11-06-2020
	 - Description      : This method return the Error message when Exception occurs.
 	  ****************************************************************************************************************************/ 
	public FacilitiesAlreadyExistException (String msg) {
		super(msg);
	}

}
