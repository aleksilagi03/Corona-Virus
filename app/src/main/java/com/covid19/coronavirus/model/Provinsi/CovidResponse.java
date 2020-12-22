package com.covid19.coronavirus.model.Provinsi;

import com.google.gson.annotations.SerializedName;

public class CovidResponse{

	@SerializedName("attributes")
	private Attributes attributes;


	public Attributes getAttributes() {
		return attributes;
	}

	public void setAttributes(Attributes attributes) {
		this.attributes = attributes;
	}
}