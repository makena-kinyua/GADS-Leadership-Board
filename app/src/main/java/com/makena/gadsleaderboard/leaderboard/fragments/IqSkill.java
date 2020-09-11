package com.makena.gadsleaderboard.leaderboard.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.makena.gadsleaderboard.R;
import com.makena.gadsleaderboard.leaderboard.Retrofit.APIService;
import com.makena.gadsleaderboard.leaderboard.adapter.SkillsIqAdapter;
import com.makena.gadsleaderboard.leaderboard.models.LearningScore;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IqSkill extends Fragment {
    RecyclerView recyclerView;
    private SkillsIqAdapter skillsIqAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.skill_iq_fragment, container, false);

        recyclerView = view.findViewById(R.id.skillRecycler);
        getLearningSkills();

        return view;
    }


    public void getLearningSkills(){
        /*Create handle for the RetrofitInstance interface*/
        APIService.GetDataService service = APIService.getRetrofitInstance().create(APIService.GetDataService.class);
        Call<List<LearningScore>> call = service.getTopSkillIq();
        call.enqueue(new Callback<List<LearningScore>>() {
            @Override
            public void onResponse(Call<List<LearningScore>> call, Response<List<LearningScore>> response) {
                skillsIqAdapter=new SkillsIqAdapter(response.body());
                RecyclerView.LayoutManager manager=new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(manager);
                recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
                recyclerView.setAdapter(skillsIqAdapter);
            }

            @Override
            public void onFailure(Call<List<LearningScore>> call, Throwable t) {
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}