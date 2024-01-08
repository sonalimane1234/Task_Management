package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.services.taskservice;


public class controller {
	@Autowired
	private taskservice taskservice;   
	
	//Add new customer
	@PostMapping("/addCustomer")
	public Task addCustomer(@RequestBody Task task)
	{
		return taskservice.addTask(task);		
	}
	
	//Add more than one new customers
	@PostMapping("/addTask")
	public List<Task> addAllTask(@RequestBody List<Task> task)
	{
		return taskservice.addAllTask(task);		
	}
	
	// Get  by ID
	@GetMapping("/getTaskByID/{id}")
	public Task getTaskById(@PathVariable int id)
	{
		return taskservice.getTaskByID(id);	
	}
	
	// Get  by firstname
	@GetMapping("/getTaskByName/{firstTask}")
	public List<Task> getTaskByName(@PathVariable String Taskname)
	{
		return taskservice.getTaskByName(firstTask);	
	}
	
	
	//Get All  details
		@GetMapping("/Task")
		public List<Task> getTask()
		{
			return taskservice.getTask();
			
		}
	
	// Update customer
	@PutMapping("/updateTask")
	public Task updateTask(@RequestBody Task customer)
	{
		return taskservice.updateTaskr(Task);		
	}
	
	
	
	// another delete try
	@DeleteMapping("/deleteCustomerById/{id}")
	public boolean deleteTaskByID(@PathVariable int id)
	{
			return taskservice.deleteTaskByID(id);	
		
}
}
