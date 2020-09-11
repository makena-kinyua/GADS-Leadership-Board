package com.makena.gadsleaderboard.submisssion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.makena.gadsleaderboard.R;
import com.makena.gadsleaderboard.leaderboard.Retrofit.APIService;
import com.makena.gadsleaderboard.leaderboard.Retrofit.FormSubmit;
import com.makena.gadsleaderboard.leaderboard.adapter.LearnersAdapter;
import com.makena.gadsleaderboard.leaderboard.models.LearningHours;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Submission extends AppCompatActivity {

    EditText firstname, lastname, email, gitLink;
    Button submit_link;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submission);

        submit_link = findViewById(R.id.submit_link);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        email = findViewById(R.id.email);
        gitLink = findViewById(R.id.gitLink);
        progressBar = findViewById(R.id.progressBar2);

        submit_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWarning();
            }
        });
    }

    public void sendDetails(){
        progressBar.setVisibility(View.VISIBLE);
        String link = gitLink.getText().toString().trim();
        String _firstname = firstname.getText().toString().trim();
        String _lastname = lastname.getText().toString().trim();
        String _email = email.getText().toString().trim();

        FormSubmit.SubmitService service = FormSubmit.getRetrofitInstance().create(FormSubmit.SubmitService.class);
        Call<Void> call = service.postResult(_firstname, _lastname, _email, link);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                progressBar.setVisibility(View.GONE);
                showSuccess();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                //Toast.makeText(Submission.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                showError();
            }
        });
    }

    private void showError(){
        new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setContentText("Something went wrong! 🥺")
                .show();
    }
    private void showWarning(){
        new SweetAlertDialog(this, SweetAlertDialog.NORMAL_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("You cannot resubmit it! 🙂")
                .setConfirmText("Yes,submit it!")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sendDetails();
                    }
                })
                .show();
    }
    private void showSuccess(){
        new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Good job!")
                .setContentText("Well received 😃")
                .show();
    }
}