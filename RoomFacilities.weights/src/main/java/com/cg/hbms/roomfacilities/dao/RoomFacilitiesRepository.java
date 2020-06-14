package com.cg.hbms.roomfacilities.dao;

/*******************************************************************************************
- File Name        : Room Facilities Repository
- Author           : Anand Soni	
- Creation Date    : 11-06-2020
- Description      : This is an Interface of room facilities service which extends JPA repository 
                     that defines operations for Entity class (RoomFacilitiesEntity). 
                       
 ************************************************************************************************************/ 


import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.hbms.roomfacilities.dao.RoomFacilitiesEntity;


public interface RoomFacilitiesRepository extends JpaRepository<RoomFacilitiesEntity, Integer> {

	

}
