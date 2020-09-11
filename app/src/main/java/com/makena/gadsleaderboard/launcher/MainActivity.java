package com.makena.gadsleaderboard.launcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.makena.gadsleaderboard.R;
import com.makena.gadsleaderboard.leaderboard.LeaderBoard;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView = findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               final Thread thread = new Thread(){
                   @Override
                   public void run() {
                       super.run();
                       try {
                           sleep(3000);
                           Intent i = new Intent(MainActivity.this, LeaderBoard.class);
                           startActivity(i);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
               };
               thread.start();
            }
        });
    }

}