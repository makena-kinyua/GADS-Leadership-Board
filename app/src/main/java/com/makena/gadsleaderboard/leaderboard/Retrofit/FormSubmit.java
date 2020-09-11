package com.makena.gadsleaderboard.leaderboard.Retrofit;


import com.makena.gadsleaderboard.leaderboard.models.LearningHours;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class FormSubmit {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://docs.google.com/forms/d/e/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public interface SubmitService {

        @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
        @FormUrlEncoded
        Call<Void> postResult(
                @Field("entry.1824927963") String firstname,
                @Field("entry.1877115667") String lastname,
                @Field("entry.2006916086") String email,
                @Field("entry.284483984") String link

        );
    }
}
