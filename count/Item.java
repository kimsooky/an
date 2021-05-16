package com.ssaurel.count;

public class Item {
    private String imageUrl;
    private String tags;
    private int likes;
    //    private Button favBtn;
    private Boolean fav = false;

    public  Item(String imageUrl, String tags, int likes){
        this.imageUrl = imageUrl;
        this.tags = tags;
        this.likes = likes;
    }

    public String getImageUrl(){
        return  imageUrl;
    }

    public String getTags(){
        return tags;
    }

    public int getLikes(){
        return likes;
    }

//    public Button getBtn(){
//        return favBtn;
//    }

    public Boolean getFav(){
        return fav;
    }

    public void setFav(Boolean status){
        fav = status;
    }
}