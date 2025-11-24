package com.blog.sheetal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "videos")
public class Video {
	@Id
	@Column(unique = true,  name = "video_id")	
	private String videoId;
	
	@Column(name = "title")
	private String title;
	@Column(name = "thumbnail_url")
	private String thumbnailUrl;
	@Column(name = "description")
	private String description;
	@Column(name = "published_at")
	private String publishedAt;

}
