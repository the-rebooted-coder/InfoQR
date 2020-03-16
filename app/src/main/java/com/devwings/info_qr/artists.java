package com.devwings.info_qr;

public class artists {

   public String artistGenre, artistName;

   public artists(){

   }

    public String getArtistGenre() {
        return artistGenre;
    }

    public void setArtistGenre(String artistGenre) {
        this.artistGenre = artistGenre;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public artists(String artistGenre, String artistName) {
        this.artistGenre = artistGenre;
        this.artistName = artistName;
    }
}
