package com.lalvani.anand.cs491interface;

/**
 * Created by Anand on 3/2/2015.
 */
public class ListItem
{
    private int imageId;
    private String time;
    private String name;

    public ListItem(int imageId, String time, String name)
    {
        this.imageId = imageId;
        this.time = time;
        this.name = name;
    }
    public int getImageId() {        return imageId; }
    public String getTime() {        return time;    }
    public String getName() {        return name;    }
}
