package com.makena.gadsleaderboard.leaderboard.adapter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makena.gadsleaderboard.R;
import com.makena.gadsleaderboard.leaderboard.models.LearningScore;

import java.net.URL;
import java.util.List;

public class SkillsIqAdapter extends RecyclerView.Adapter<SkillsIqAdapter.MyViewHolder> {

    private List<LearningScore> learnersList;
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView learner_name, learner_score;
        ImageView learner_banner;
        MyViewHolder(View view) {
            super(view);
            learner_name = view.findViewById(R.id.learner_name);
            learner_score = view.findViewById(R.id.learner_score);
            learner_banner = view.findViewById(R.id.learner_banner);
        }
    }
    public SkillsIqAdapter(List passedLearnersList) {
        this.learnersList = passedLearnersList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.skill_item, parent, false);
        return new MyViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        LearningScore learner = this.learnersList.get(position);
        holder.learner_name.setText(learner.getName());
        holder.learner_score.setText(learner.getScore() + " skill IQ Score, " + learner.getCountry());
        try {
            URL url = new URL(learner.getBadgeUrl());
            Bitmap bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            holder.learner_banner.setImageBitmap(bmp);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public int getItemCount() {
        return this.learnersList.size();
    }
}