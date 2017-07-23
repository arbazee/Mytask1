package com.example.ril.mytask1;


import android.widget.ImageView;

public class Movie {

        private String title, genre;
        private int imageId;



        public Movie() {
        }

        public Movie(String title, String genre,int imageId) {
            this.title = title;
            this.genre = genre;
            this.imageId=imageId;

        }



        public String getTitle() {
            return title;
        }

        public void setTitle(String name) {
            this.title = name;
        }

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }


    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
}

