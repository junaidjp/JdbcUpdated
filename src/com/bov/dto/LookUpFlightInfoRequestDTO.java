package com.bov.dto;

public class LookUpFlightInfoRequestDTO {

	private long latitude;
	private long longitude;
	public long getLatitude() {
		return latitude;
	}
	public void setLatitude(long latitude) {
		this.latitude = latitude;
	}
	public long getLongitude() {
		return longitude;
	}
	public void setLongitude(long longitude) {
		this.longitude = longitude;
	}
	
	public String toString() {
		return "LookUpFlightInfoRequestDTO [latitude=" + latitude
				+ ", longitude=" + longitude + ", getLatitude()="
				+ getLatitude() + ", getLongitude()=" + getLongitude()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
