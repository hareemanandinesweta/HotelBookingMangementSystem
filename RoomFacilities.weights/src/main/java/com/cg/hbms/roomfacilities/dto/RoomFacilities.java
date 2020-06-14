package com.cg.hbms.roomfacilities.dto;

/****************************************************************************************************************************
- File Name        : RoomFacilities
- Author           : Anand Soni
- Creation Date    : 11-06-2020
- Description      : This is a model class which encapsulates the data and helps to share it among different classes.
 ****************************************************************************************************************************/

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;



@Component
public class RoomFacilities {

	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public String getBedType() {
		return bedType;
	}
	public void setBedType(String bedType) {
		this.bedType = bedType;
	}
	public String getFoodAndDrink() {
		return foodAndDrink;
	}
	public void setFoodAndDrink(String foodAndDrink) {
		this.foodAndDrink = foodAndDrink;
	}
	public String getWashroomFacilities() {
		return washroomFacilities;
	}
	public void setWashroomFacilities(String washroomFacilities) {
		this.washroomFacilities = washroomFacilities;
	}
	public String getMediaAndTechnology() {
		return mediaAndTechnology;
	}
	public void setMediaAndTechnology(String mediaAndTechnology) {
		this.mediaAndTechnology = mediaAndTechnology;
	}
	public String getAirConditioner() {
		return airConditioner;
	}
	public void setAirConditioner(String airConditioner) {
		this.airConditioner = airConditioner;
	}
	public String getWifi() {
		return wifi;
	}
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	private int roomId;
	@NotNull(message = "Bed Type is mandatory")
	@NotBlank(message = "Bed Type is mandatory")
	private String bedType;
	@NotNull(message = "Food And Drink is mandatory")
	@NotBlank(message = "Food And Drink is mandatory")
	private String foodAndDrink;
	private String washroomFacilities;
	private String mediaAndTechnology;
	private String airConditioner;
	private String wifi;
    private String cleaning;
	public String getCleaning() {
		return cleaning;
	}
	public void setCleaning(String cleaning) {
		this.cleaning = cleaning;
	}

}
