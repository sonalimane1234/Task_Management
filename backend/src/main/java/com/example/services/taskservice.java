package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;


public class taskservice {

	@Autowired
	private repositoryTask repositoryTask;  // "customerRepository" is the object of "CustomerService" class.
    
	// add customer
	

	// get all customer
	public List<Task> addAllTask(List<Task> task) {
		return repositoryTask.saveAll(task);
	}
	
    // get customer by id
	public Task getTaskByID(int id) {
		return repositoryTask.findById(id).orElse(null);
	}
  
	// get customer by name
	public List<Task> getTaskByName(String firstname) {
		return repositoryTask.findByFirstname(firstname);
	}
	
	// update customer
	public Task updateTask(Task task) {
		Task existingTEACH = repositoryTask.findById(task.getId()).orElse(null);
		if(existingTEACH == null)
		{
			return repositoryTask.save(task);
		}
		else
		{
			repositoryTask.deleteById(existingTEACH.getId());
			repositoryTask.save(task);
		}
		return task;
	}

	// delete customer
	public boolean deleteTaskByID(int id) {
		Task existingTEACH = repositoryTask.findById(id).orElse(null);
		System.out.println(existingTEACH);
		if(existingTEACH != null)
		{
			repositoryTask.deleteById(id);
			return true;
		}
		else 
		{
		return false;
		}
	}
	
	public List<Task> getTask() {
		return repositoryTask.findAll();
	}

	public Task addTask(Task task) {
		// TODO Auto-generated method stub
		return repositoryTask.save(task);
	}

	}

