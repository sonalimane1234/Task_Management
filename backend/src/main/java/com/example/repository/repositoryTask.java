package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.task;


@Repository
public interface repositoryTask extends JpaRepository<task,Integer>  {
	List<task> findByFirstname(String firstTask);
}
