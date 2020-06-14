package com.cg.hbms.roomfacilities.dao;

/****************************************************************************************************************************
- File Name        : RoomFacilitiesEntity
- Author           : Anand Soni
- Creation Date    : 11-06-2020
- Description      : This is entity class to represent objects in Database of Room Facilities Service.
 ****************************************************************************************************************************/ 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Facilities")
public class RoomFacilitiesEntity {
	
		 
		@Id
		@NotNull(message = "Room Id cannot be null")
		@Min(1000)
		@Column(name="room_id")
		private Integer roomId;
		
		
		@Column(name="bed_type")
		@NotNull(message = "Bed Type is mandatory")
		@NotBlank(message = "Bed Type is mandatory")
		@Pattern(regexp ="(^[a-zA-Z, ]+$)", message = "Bed Type only be in alphabets.")
		private String bedType;
		
		@Column(name="food_drink")
		@NotNull(message = "Food And Drink is mandatory")
		@NotBlank(message = "Food And Drink is mandatory")
		@Pattern(regexp ="(^[a-zA-Z, ]+$)", message = "Cleaning facilities can only be in alphabets.") 
		private String foodAndDrink;
		
		@Column(name="washroom_facilities")
		@NotNull(message = "Washroom Facilities is mandatory")
		@NotBlank(message = "Washroom Facilities is mandatory")
		@Pattern(regexp ="(^[a-zA-Z, ]+$)", message = "Cleaning facilities can only be in alphabets.") 
		private String washroomFacilities;
		
		@Column(name="media_technology")
		@NotNull(message = "Media and Technology is mandatory")
		@NotBlank(message = "Media and Technology is mandatory")
		@Pattern(regexp ="(^[a-zA-Z, ]+$)", message = "Cleaning facilities can only be in alphabets.") 
		private String mediaAndTechnology;
		
		@Column(name="ac")
		@Size(min = 1, max = 3)
		@NotNull(message = "Air Conditioner availability is mandatory")
		@NotBlank(message = "Air Conditioner availability is mandatory")
		@Pattern(regexp ="(^[a-zA-Z, ]+$)", message = "AC availability only be in alphabets.")
		private String airConditioner;
		
		@Column(name="wifi")
		@NotNull(message = "Wifi availability is mandatory")
		@NotBlank(message = "Wifi availability is mandatory")
		@Size(min = 1, max = 3)
		@Pattern(regexp ="(^[a-zA-Z, ]+$)", message = "wifi availability only be in alphabets.") 
		private String wifi;
		
		@Column(name="cleaning")
		@NotNull(message = "Cleaning facilities is mandatory")
		@NotBlank(message = "Cleaning facilities is mandatory")
		@Pattern(regexp ="(^[a-zA-Z, ]+$)", message = "Cleaning facilities can only be in alphabets.") 
		private String cleaning;
		




		public String getCleaning() {
			return cleaning;
		}


		public void setCleaning(String cleaning) {
			this.cleaning = cleaning;
		}


		public RoomFacilitiesEntity(Integer roomId, String bedType, String foodAndDrink, String washroomFacilities,
				String mediaAndTechnology, String airConditioner, String wifi, String cleaning) {
			super();
			this.roomId = roomId;
			this.bedType = bedType;
			this.foodAndDrink = foodAndDrink;
			this.washroomFacilities = washroomFacilities;
			this.mediaAndTechnology = mediaAndTechnology;
			this.airConditioner = airConditioner;
			this.wifi = wifi;
			this.cleaning = cleaning;
		}


		public Integer getRoomId() {
			return roomId;
		}


		public void setRoomId(Integer roomId) {
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


		public RoomFacilitiesEntity() {
			super();
			// TODO Auto-generated constructor stub
		}
		

	}

