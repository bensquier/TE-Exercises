package com.techelevator;

public class Television {
	
	private boolean isOn = false;
	private int currentChannel = 3;
	private int currentVolume = 2;
	
	public boolean isOn() {
		return isOn;
	}
	public int currentChannal() {
		return currentChannel;
	}
	public int currentVolume() {
		return currentVolume;
	}
	public boolean getIsOn() {
		return this.isOn;
	}
	public int getCurrentChannel() {
		return this.currentChannel;
	}
	public int getCurrentVolume() {
		return this.currentVolume;
	}
	public void turnOff() {
		if(isOn) {
			this.isOn = false;
		}
	}
	public void turnOn() {
		if(!isOn) {
			this.isOn = true;
			this.currentChannel = 3;
			this.currentVolume = 2;
		}
	}
	public void changeChannel(int newChannel) {
		if(isOn) {
			if(newChannel <= 18 && newChannel >= 3) {
				this.currentChannel = newChannel;
			}
		}
	}
	public void channelUp() {
		if(isOn) {
			if(currentChannel + 1 <= 18) {
				this.currentChannel++;
			} else {
				this.currentChannel = 3;
			}
		}
	}
	public void channelDown() {
		if(isOn) {
			if((currentChannel - 1) >= 3) {
				this.currentChannel -= 1;
			} else {
				this.currentChannel = 18;
			}
		}
	}
	public void raiseVolume() {
		if(isOn) {
			if((currentVolume + 1) <= 10) {
				this.currentVolume += 1;
			}
		}
	}
	public void lowerVolume() {
		if(isOn) {
			if((currentVolume -1) >= 0 ) {
				this.currentVolume -= 1;
			}
		}
	}
}
