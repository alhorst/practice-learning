package com.techelevator;

public class MediaItem {
    // attributes
    private String format;
    private boolean needsPlayer;

    public MediaItem(String format, boolean needsPlayer){
        this.format = format;  // this. means this object
        this.needsPlayer = needsPlayer;
    }
}
