package com.cg.hbms.roomfacilities.controller;


/****************************************************************************************************************************
- File Name        : RoomFacilities
- Author           : Anand Soni
- Creation Date    : 11-06-2020
- Description      : This is an end point controller to consume Room facilities service.
 ****************************************************************************************************************************/

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.cg.hbms.roomfacilities.dao.RoomFacilitiesEntity;
import com.cg.hbms.roomfacilities.exception.FacilitiesAlreadyExistException;
import com.cg.hbms.roomfacilities.exception.RoomIdNotFoundException;
import com.cg.hbms.roomfacilities.service.RoomFacilitiesService;
import com.cg.hbms.roomfacilities.dto.RoomFacilities;


@RestController
@Validated
public class RoomFacilitiesController {
	
	@Autowired
	private RoomFacilitiesService roomFacilitiesService;
	
	
	
	/****************************************************************************************************************************
	 - Method Name      : getFacilitiesByRoomId
	 - Input Parameters : roomId
	 - Return type      : RoomFacilitiesEntity
	 - Author           : Anand Soni
	 - Creation Date    : 11-06-2020
	 - Description      : Fetching the Room Facilities of room from the database by room Id.
	 - End point URL    : http://localhost:9090/getFacilitiesByRoomId/1001
	  ****************************************************************************************************************************/ 
	
	@GetMapping("/getFacilitiesByRoomId/{roomId}")
	public ResponseEntity <RoomFacilitiesEntity> getFacilitiesByRoomId( @PathVariable("roomId")@Min(1000) Integer roomId ) throws RoomIdNotFoundException {
		RoomFacilitiesEntity entity= roomFacilitiesService.getFacilitiesByRoomId(roomId);
		return ResponseEntity.ok(entity);	
	}
	
	/****************************************************************************************************************************
	 - Method Name      : getAllRoomFacilities
	 - Input Parameters : void
	 - Return type      : List<RoomFacilitiesEntity>
	 - Author           : Anand Soni
	 - Creation Date    : 11-06-2020
	 - Description      : Fetching the Room Facilities of rooms from the database.
	 - End point URL    : http://localhost:9090/getAllRoomFacilities
	  ****************************************************************************************************************************/ 
	
	@GetMapping("/getAllRoomFacilities")
	public List<RoomFacilitiesEntity> getAllRoomFacilities() throws RoomIdNotFoundException {
		return roomFacilitiesService.getAllRoomFacilities();
	}
	
	
	/****************************************************************************************************************************
	 - Method Name      : deleteFacilitiesByRoomId
	 - Input Parameters : roomId
	 - Return type      : ResponseEntity<String>
	 - Author           : Anand Soni
	 - Creation Date    : 11-06-2020
	 - Description      : Deleting the Room Facilities of room from the database.
	 - End point URL    : http://localhost:9090/deleteFacilitiesByRoomId/1003
	  ****************************************************************************************************************************/ 
	
	@DeleteMapping("/deleteFacilitiesByRoomId/{roomId}")
	public ResponseEntity<String> deleteFacilitiesByRoomId( @PathVariable(value = "roomId") int roomId) throws RoomIdNotFoundException{
		String msg=roomFacilitiesService.deleteFacilitiesByRoomId(roomId);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
      }
	
	
	/****************************************************************************************************************************
	 - Method Name      : addFacilitiesForRoom
	 - Input Parameters : RoomFacilitiesEntity
	 - Return type      : ResponseEntity<String>
	 - Author           : Anand Soni
	 - Creation Date    : 11-06-2020
	 - Description      : Inserting the Room Facilites entered by user into the database.
	 - End point URL    : http://localhost:9090/addFacilitiesForRoom
	  ****************************************************************************************************************************/ 
	
	@PostMapping("/addFacilitiesForRoom")
	public ResponseEntity<String> addFacilitiesForRoom(@Valid @RequestBody RoomFacilitiesEntity entity) throws FacilitiesAlreadyExistException {
		String msg= roomFacilitiesService.addFacilitiesForRoom(entity);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
		}

	
	/****************************************************************************************************************************
	 - Method Name      : updateFacilitiesByRoomId
	 - Input Parameters : roomId, RoomFacilities
	 - Return type      : ResponseEntity<String>
	 - Author           : Anand Soni
	 - Creation Date    : 11-06-2020
	 - Description      : Updating the Room Facilities in the room which is entered by user into the database.
	 - End point URL    : http://localhost:9090/updateFacilitiesByRoomId/1003
	  ****************************************************************************************************************************/ 
	
	@PutMapping("/updateFacilitiesByRoomId/{roomId}")
	public ResponseEntity<String> updateFacilitiesByRoomId(@PathVariable int roomId, @Valid @RequestBody RoomFacilities model) throws RoomIdNotFoundException {
		String msg = roomFacilitiesService.updateFacilitiesByRoomId(roomId, model);
		return new ResponseEntity<String>(msg,HttpStatus.ACCEPTED);
	}

	
	
	@ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseEntity<String> handleConstraintViolation(Exception e) {
        return new ResponseEntity<>("Excepton raise: " + e, HttpStatus.BAD_REQUEST);
    }

}
