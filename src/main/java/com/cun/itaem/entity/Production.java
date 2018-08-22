package com.cun.itaem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "t_production")
public class Production {

	@Id
	@GeneratedValue
	@ApiModelProperty(value = "作品id")
	private Integer id;

	@ApiModelProperty(value = "作品名称")
	@Column(length = 200)
	private String name;

	@ApiModelProperty(value = "作品介绍")
	@Column(length = 200)
	private String description;

	@ApiModelProperty(value = "图片路径，后台根据传来的图片自动生成，不用用户输入")
	@Column(length = 200)
	private String path;

	@ApiModelProperty(value = "时间")
	private Date date;

	@ApiModelProperty(value = "作品链接")
	@Column(length = 200)
	private String link;

	@ApiModelProperty(value = "是否展示：1展示  0隐藏")
	private Integer tag;

	public Integer getTag() {
		return tag;
	}

	public void setTag(Integer tag) {
		this.tag = tag;
	}


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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
}
