package com.example.carson_ho.toptabbar;

/**
 * Created by pclx on 2018/3/4.
 */

public class ListviewT {
    private String text;
    private int imageId;
    public ListviewT(String text,int imageId){
        this.text = text;
        this.imageId = imageId;
    }
    public String getText(){
        return text;
    }
    public int getImageId(){
        return imageId;
    }
}
