package com.cg.hbms.roomfacilities.service;

/****************************************************************************************************************************
- File Name        : RoomFacilitiesService
- Author           : Anand Soni
- Creation Date    : 11-06-2020
- Description      : This is Service interface which contains all requirements for Room Facilities Service. 
 ****************************************************************************************************************************/ 

import java.util.List;

import com.cg.hbms.roomfacilities.dao.RoomFacilitiesEntity;
import com.cg.hbms.roomfacilities.exception.FacilitiesAlreadyExistException;
import com.cg.hbms.roomfacilities.exception.RoomIdNotFoundException;
import com.cg.hbms.roomfacilities.dto.RoomFacilities;

public interface RoomFacilitiesService {
	

	 RoomFacilitiesEntity getFacilitiesByRoomId(int roomId) throws RoomIdNotFoundException ;

     String addFacilitiesForRoom(RoomFacilitiesEntity entity) throws FacilitiesAlreadyExistException;
	
	 String deleteFacilitiesByRoomId(int roomId) throws RoomIdNotFoundException ;
	
	 String updateFacilitiesByRoomId(int roomId, RoomFacilities dto) throws RoomIdNotFoundException;

     List<RoomFacilitiesEntity> getAllRoomFacilities() throws RoomIdNotFoundException;
	
	
}
