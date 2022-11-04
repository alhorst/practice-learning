package com.techelevator;

public class Television {
    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    public Television(){}
    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public boolean isOn() {
        return isOn;
    }

    public void turnOff() {
        if (isOn == true) {
            isOn = false;
        }
    }

    public void turnOn() {
        if (isOn == false) {
            isOn = true;
            this.currentChannel = 3;
            this.currentVolume = 2;
        }
    }

    public void changeChannel(int newChannel) {
        if (isOn == true) {
            this.currentChannel = newChannel;
        }
    }

    public void channelUp(){
        if (isOn == true) {
            if (currentChannel < 18) {
                currentChannel += 1;
            }
            else {
                currentChannel = 3;
            }
        }
    }

    public void channelDown() {
        if (isOn == true) {
            if (currentChannel > 3) {
                currentChannel -= 1;
            }
            else {
                currentChannel = 18;
            }
        }
    }
    public void raiseVolume() {
        if (isOn == true) {
            if(currentVolume < 10) {
                currentVolume += 1;
            }
        }
    }
    public void lowerVolume(){
        if(isOn == true) {
            if(currentVolume > 0) {
                currentVolume -= 1;
            }
        }
    }
}
