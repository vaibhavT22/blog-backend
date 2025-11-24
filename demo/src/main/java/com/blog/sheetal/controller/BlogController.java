package com.blog.sheetal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.sheetal.model.Video;
import com.blog.sheetal.service.BlogService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blogs")
public class BlogController {
	@Autowired
	BlogService blogService;
	
	@GetMapping("/videos")
	public List<Video> getVideos(){
		return blogService.getAllVideos();
	}
	
	@PostMapping("/videos/fetch")
	public List<Video> fetchVideos() {
		return blogService.fetchVideos();
	}
	
	@GetMapping("/videos/latest")
	public List<Video> getLatestFive() {
	    return blogService.getLatestFiveVideos();
	}
	
	@DeleteMapping("/videos/{videoId}")
	public void deleteVideo(@PathVariable String videoId) {
	    blogService.deleteVideoById(videoId);
	}
	@DeleteMapping("/videos/deleteAll")
	public void deleteAllVideos() {
	    blogService.deleteAllVideos();
	}
}
