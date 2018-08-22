package com.cun.itaem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "t_direction")
public class Direction {

	@Id
	@GeneratedValue
	@ApiModelProperty(value = "方向id")
	private Integer id;

	@ApiModelProperty(value = "方向名称") 
	@Column(length = 200)
	private String name;

	@ApiModelProperty(value = "图片路径，后台根据传来的图片自动生成，不用用户输入") 
	@Column(length = 200)
	private String path;

	@ApiModelProperty(value = "方向描述") 
	@Column(length = 200)
	private String description;

	@ApiModelProperty(value = "时间")
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
