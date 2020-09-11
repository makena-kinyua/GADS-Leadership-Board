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
import com.makena.gadsleaderboard.leaderboard.adapter.LearnersAdapter;
import com.makena.gadsleaderboard.leaderboard.models.LearningHours;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Learning extends Fragment {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    private LearnersAdapter learnersAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.learning_fragment, container, false);

        recyclerView = view.findViewById(R.id.learnerRecycler);
        progressBar = view.findViewById(R.id.progressBar);
        getLearningHours();
        return view;
    }


    public void getLearningHours(){
        /*Create handle for the RetrofitInstance interface*/
        APIService.GetDataService service = APIService.getRetrofitInstance().create(APIService.GetDataService.class);
        Call<List<LearningHours>> call = service.getTopHours();
        call.enqueue(new Callback<List<LearningHours>>() {
            @Override
            public void onResponse(Call<List<LearningHours>> call, Response<List<LearningHours>> response) {
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);

                learnersAdapter=new LearnersAdapter(response.body());
                RecyclerView.LayoutManager manager=new LinearLayoutManager(getActivity());
                recyclerView.setLayoutManager(manager);
                recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
                recyclerView.setAdapter(learnersAdapter);
            }

            @Override
            public void onFailure(Call<List<LearningHours>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
