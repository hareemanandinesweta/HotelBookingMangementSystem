package com.cg.hbms.roomfacilities.exception;

/****************************************************************************************************************************
- File Name        : RoomIdNotFoundException
- Author           : Anand Soni
- Creation Date    : 11-06-2020
- Description      : This is an RoomIdNotFoundException class which is
					 used to handle the Exception in Room Facilities Service.
 ****************************************************************************************************************************/ 

public class RoomIdNotFoundException extends Exception{
	
	public RoomIdNotFoundException(String msg) {
		super(msg);
	}

}
