package com.cg.hbms.roomfacilities.service;
/****************************************************************************************************************************
- File Name        : RoomFacilitiesServiceImpl
- Author           : Anand Soni
- Creation Date    : 11-06-2020
- Description      : This is a service class which contains the business logic of Room Facilities Service
 ****************************************************************************************************************************/

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.hbms.roomfacilities.dao.RoomFacilitiesRepository;
import com.cg.hbms.roomfacilities.dao.RoomFacilitiesEntity;
import com.cg.hbms.roomfacilities.exception.FacilitiesAlreadyExistException;
import com.cg.hbms.roomfacilities.exception.RoomIdNotFoundException;
import com.cg.hbms.roomfacilities.dto.RoomFacilities;
@Service
public class RoomFacilitiesServiceImpl implements RoomFacilitiesService{
	
	@Autowired 
	private RoomFacilitiesRepository roomFacilitiesRepo;
		
	
	/****************************************************************************************************************************
	 - Method Name      : getFacilitiesByRoomId
	 - Input Parameters : roomId
	 - Return type      : RoomFacilitiesEntity
	 - Author           : Anand Soni
	 - Creation Date    : 11-06-2020
	 - Description      : Fetching the all facilities of the room from the database by room Id.
	  ****************************************************************************************************************************/ 
	@Override
	public RoomFacilitiesEntity getFacilitiesByRoomId(int roomId) throws RoomIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<RoomFacilitiesEntity> optional = roomFacilitiesRepo.findById(roomId);
		if(optional.isPresent()) {
		RoomFacilitiesEntity entity = optional.get();	
		return entity;
	}else {
		throw new RoomIdNotFoundException("RoomId is not available");
	}
	}
	
	
	/****************************************************************************************************************************
	 - Method Name      : getAllRoomFacilities
	 - Input Parameters : void
	 - Return type      : List<RoomFacilitiesEntity>
	 - Author           : Anand Soni
	 - Creation Date    : 11-06-2020
	 - Description      : Fetching the all room facilities information from the database.
	  ****************************************************************************************************************************/ 
	@Override
	public List<RoomFacilitiesEntity> getAllRoomFacilities() throws RoomIdNotFoundException{
		// TODO Auto-generated method stub
        if(!isRepositoryNotNull()) {
			
			LOGGER.error("Problem with connectivity with service to DAO layer");
			throw new RoomIdNotFoundException("Sorry for the inconvinience, currently database is down!");
			
		}
		List<RoomFacilitiesEntity> entityList=roomFacilitiesRepo.findAll();
		return entityList;
	}
	
	
	/****************************************************************************************************************************
	 - Method Name      : deleteFacilitiesByRoomId
	 - Input Parameters : roomId
	 - Return type      : String
	 - Author           : Anand Soni
	 - Creation Date    : 11-06-2020
	 - Description      : Deleting the all facilities of the room from the database by room Id.
	  ****************************************************************************************************************************/
	@Override
	public String deleteFacilitiesByRoomId(int roomId) throws RoomIdNotFoundException  {
		// TODO Auto-generated method stub
		Optional<RoomFacilitiesEntity> optional = roomFacilitiesRepo.findById(roomId);
		if(optional.isPresent()) {
			RoomFacilitiesEntity entity= optional.get();
			roomFacilitiesRepo.delete(entity);
			return "Facilities of room deleted successfully";
		}
		else {
		throw new RoomIdNotFoundException("Facilities can't remove because " +roomId+" is no present in roomId list");
		}	
	}
	
	
	/****************************************************************************************************************************
	 - Method Name      : addFacilitiesForRoom
	 - Input Parameters : RoomFacilitiesEntity
	 - Return type      : String
	 - Author           : Anand Soni
	 - Creation Date    : 11-06-2020
	 - Description      : Inserting the room facilities for room into the database.
	  ****************************************************************************************************************************/ 
	@Override
	public String addFacilitiesForRoom(RoomFacilitiesEntity entity) throws FacilitiesAlreadyExistException {
	Optional<RoomFacilitiesEntity> optional = roomFacilitiesRepo.findById(entity.getRoomId());
	if (!optional.isPresent()) {
		roomFacilitiesRepo.saveAndFlush(entity);
		return "Facilities for Room Id: "+entity.getRoomId()+" added successfuly";
	}
	else {
		throw new FacilitiesAlreadyExistException("Facilities of the room ID: "+entity.getRoomId()+" already exist");
	}
	}
	
	
	/****************************************************************************************************************************
	 - Method Name      : updateFacilitiesByRoomId
	 - Input Parameters : roomId, RoomFacilities
	 - Return type      : String
	 - Author           : Anand Soni
	 - Creation Date    : 11-06-2020
	 - Description      : Updating the facilities of room into the database.
	  ****************************************************************************************************************************/
	@Override
	public String updateFacilitiesByRoomId(int roomId, RoomFacilities model) throws RoomIdNotFoundException {
		// TODO Auto-generated method stub
		Optional<RoomFacilitiesEntity> optional = roomFacilitiesRepo.findById(roomId);
		if(optional.isPresent()) {
		RoomFacilitiesEntity entity = optional.get();
		entity.setRoomId(model.getRoomId());
		entity.setAirConditioner(model.getAirConditioner());
		entity.setBedType(model.getBedType());
		entity.setFoodAndDrink(model.getFoodAndDrink());
		entity.setMediaAndTechnology(model.getMediaAndTechnology());
		entity.setWashroomFacilities(model.getWashroomFacilities());
		entity.setWifi(model.getWifi());
		entity.setCleaning(model.getCleaning());
		
		roomFacilitiesRepo.save(entity);
		return "Facilities of Room ID: "+roomId+", updated successfully!";
	}else {
		throw new RoomIdNotFoundException(" Room ID: "+roomId+" not found.");
	}
	}
	

	
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RoomFacilitiesServiceImpl.class);
	
	
	public boolean isRepositoryNotNull() {
		boolean flag = false;

		if (roomFacilitiesRepo!= null) {
			flag = true;
			
		}
		return flag;
	}
}





