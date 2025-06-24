package com.example.uploadingfiles.model;

public class StorageProperties {

	/**
	 * Folder location for storing files
	 */
	private String location = "";

	public StorageProperties(String location) {
		this.location = location;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
