package com.techelevator;

public class Elevator {
	
	private int currentFloor = 1;
	private int numberOfFloors;
	private boolean doorOpen;
	
	public Elevator(int numberOfLevels) {
		this.numberOfFloors = numberOfLevels;
	}
	
	public boolean isDoorOpen() {
		if(doorOpen) {
			return true;
		}
		return false;
	}
	public int getCurrentFloor() {
		return this.currentFloor;
	}
	public int getNumberOfFloors() {
		return this.numberOfFloors;
	}
	public boolean getDoorOpen() {
		return this.doorOpen;
	}
	public void openDoor() {
		if(!doorOpen) {
			this.doorOpen = true;
		}
	}
	public void closeDoor() {
		if(doorOpen) {
			this.doorOpen = false;
		}
	}
	public void goUp(int desiredFloor) {
		if(!doorOpen) {
			if(desiredFloor > currentFloor) {
				if(desiredFloor <= numberOfFloors) {
					this.currentFloor = desiredFloor;
				}
			}
		}
	}
	public void goDown(int desiredFloor) {
		if(!doorOpen) {
			if(desiredFloor < currentFloor) {
				if(desiredFloor >= 1) {
					this.currentFloor = desiredFloor;
				}
			}
		}
	}

}
