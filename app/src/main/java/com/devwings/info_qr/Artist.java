package com.devwings.info_qr;

public class Artist {
    String artistId;
    String artistName;
    String artistGenre;

    public Artist() {
    }

    public Artist(String artistId, String artistName, String artistGenre) {
        this.artistId = artistId;
        this.artistName = artistName;
        this.artistGenre = artistGenre;
    }

    public String getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtistGenre() {
        return artistGenre;
    }
}

/*
 _____           __          ___
 |  __ \          \ \        / (_)
 | |  | | _____   _\ \  /\  / / _ _ __   __ _ ___
 | |  | |/ _ \ \ / /\ \/  \/ / | | '_ \ / _` / __|
 | |__| |  __/\ V /  \  /\  /  | | | | | (_| \__ \
 |_____/ \___| \_/    \/  \/   |_|_| |_|\__, |___/
                                         __/ |
                                        |___/
 */