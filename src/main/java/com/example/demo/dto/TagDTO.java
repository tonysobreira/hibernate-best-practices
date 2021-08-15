package com.example.demo.dto;

import com.example.demo.model.Tag;

public class TagDTO {

	private Long id;

	private String name;

	public TagDTO() {
	}

	public TagDTO(Tag t) {
		this.id = t.getId();
		this.name = t.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
