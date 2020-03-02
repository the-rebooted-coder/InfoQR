package com.devwings.info_qr;



import android.app.Activity;
import android.widget.ArrayAdapter;
import java.util.List;



public class ArtistList extends ArrayAdapter<Artist> {



    private Activity context;

    private List<Artist>artistList;



    public ArtistList(Activity context, List<Artist> artistList){

        super(context, R.layout.list_layout);

        this.context = context;

        this.artistList = artistList;

    }

}


