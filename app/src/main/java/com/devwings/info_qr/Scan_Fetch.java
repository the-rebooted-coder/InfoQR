package com.devwings.info_qr;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Scan_Fetch extends AppCompatActivity {

    private EditText mSearchField;
    private ImageButton mSearchBtn;
    private RecyclerView mResultList;
    private DatabaseReference mUserDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_fetch);
            mUserDatabase = FirebaseDatabase.getInstance().getReference("artists");
        mSearchField = findViewById(R.id.search_field);
        mSearchBtn = findViewById(R.id.fetch_btn);
        mResultList = findViewById(R.id.request_list);
        mResultList.setHasFixedSize(true);
        mResultList.setLayoutManager(new LinearLayoutManager(this));
        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseUserSearch();
            }
        });

        Bundle bundle = getIntent().getExtras();
//Pass Data to String Variables
        String data_1 = bundle.getString("firstdata");

        TextView textView = findViewById(R.id.textView11);

        textView.setText(data_1);




    }

    private void firebaseUserSearch() {

        FirebaseRecyclerAdapter<artists, UsersViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<artists, UsersViewHolder>(
                artists.class,
                R.layout.list_layout,
                UsersViewHolder.class,
                mUserDatabase) {
            @Override
            protected void onBindViewHolder(@NonNull UsersViewHolder holder, int position, @NonNull artists model) {

                holder.setDetails(model.getArtistName(), model.getArtistGenre());
            }

            @NonNull
            @Override
            public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                return null;
            }
        };

        mResultList.setAdapter(firebaseRecyclerAdapter);
    }


    public static class UsersViewHolder extends RecyclerView.ViewHolder{
        View mView;
        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);

            mView=itemView;
        }
        public void setDetails(String userName, String userStaus){
            TextView user_name = mView.findViewById(R.id.user_name);
            TextView user_staus = mView.findViewById(R.id.status_text);

            user_name.setText(userName);
            user_staus.setText(userStaus);
        }

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