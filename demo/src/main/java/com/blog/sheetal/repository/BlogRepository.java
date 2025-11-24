package com.blog.sheetal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blog.sheetal.model.Video;

public interface BlogRepository extends JpaRepository<Video, String> {
	List<Video> findTop5ByOrderByPublishedAtDesc();
}
