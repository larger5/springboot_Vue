package com.cun.itaem.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "t_blog")
public class Blog {

	@Id
	@GeneratedValue
	@ApiModelProperty(value = "博客id") 
	private Integer id;

	@ApiModelProperty(value = "标题") 
	@Column(length = 200)
	private String title;

	@ApiModelProperty(value = "文章链接") 
	@Column(length = 200)
	private String link;

	@ApiModelProperty(value = "博客发表时间") 
	private Date date;

	@ApiModelProperty(value = "作者") 
	@Column(length = 200)
	private String author;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}



}
