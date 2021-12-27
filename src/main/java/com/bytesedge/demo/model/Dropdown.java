package com.bytesedge.demo.model;

public class Dropdown {

	private Long id;
	
	private String value;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Dropdown [id=" + id + ", value=" + value + "]";
	}
	
}
