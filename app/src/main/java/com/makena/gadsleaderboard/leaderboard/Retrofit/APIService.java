package com.makena.gadsleaderboard.leaderboard.Retrofit;

import com.makena.gadsleaderboard.leaderboard.models.LearningHours;
import com.makena.gadsleaderboard.leaderboard.models.LearningScore;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class APIService {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://gadsapi.herokuapp.com";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public interface GetDataService {

        @GET("/api/hours")
        Call<List<LearningHours>> getTopHours();

        @GET("/api/skilliq")
        Call<List<LearningScore>> getTopSkillIq();
    }
}
