package com.makena.gadsleaderboard.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.makena.gadsleaderboard.R;
import com.makena.gadsleaderboard.leaderboard.adapter.LeadersAdapter;
import com.makena.gadsleaderboard.leaderboard.fragments.IqSkill;
import com.makena.gadsleaderboard.leaderboard.fragments.Learning;
import com.makena.gadsleaderboard.leaderboard.models.LearningScore;
import com.makena.gadsleaderboard.submisssion.Submission;

import java.util.List;

public class LeaderBoard extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tabLayout;
    Button submit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leader_layout);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.leader_tabs);
        submit_btn = findViewById(R.id.submit_btn);

        LeadersAdapter adapter = new LeadersAdapter(getSupportFragmentManager());
        adapter.addFragment(new Learning(), "Learning Leaders");
        adapter.addFragment(new IqSkill(), "Skill IQ Leaders");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LeaderBoard.this, Submission.class);
                startActivity(i);
            }
        });
    }

}