package com.zjr.dto;
import lombok.Data;

@Data
public class ProjectDto {

	private Integer id;
	private String proName;
	private String detail;
	private Integer statusVal;
	private int page;
	private int size;
}
