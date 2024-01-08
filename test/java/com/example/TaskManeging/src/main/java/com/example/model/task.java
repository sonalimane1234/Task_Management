package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class task {
	@Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	 private String firsttask;
	 private String lasttask;
	 
	 private int time;
	public int getId() {
		return id;
	}
		public String getFirsttask() {
			return firsttask;
		}
		public void setFirsttask(String firstname) {
			this.firsttask = firstname;
		}
		public String getLasttask() {
			return lasttask;
		}
		public void setLasttask(String lasttask) {
			this.lasttask = lasttask;
		}
		
		public int getTime() {
			return time;
		}
		public void setPrice(int price) {
			time = time;
		}
		public void setId(int id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return "Task [id=" + id + ", firsttask=" + firsttask + ", lasttask=" + lasttask + ", Time=" + time + "]";
		
	}
	
}
