package com.entreprise.davfou.monmirroir.metier.executeurs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.transition.Explode;
import android.widget.Toast;

import com.entreprise.davfou.monmirroir.data.rest.clientWs.ClientRetrofit;
import com.entreprise.davfou.monmirroir.data.rest.methodeRest.ApiInterface;
import com.entreprise.davfou.monmirroir.presentation.view.activity.login.LoginSuccessActivity;
import com.entreprise.davfou.monmirroir.presentation.view.utils.ProgressDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by davidfournier on 05/06/2017.
 */

public class RegisterUser {
    Context context;
    Activity activityReference;
    android.app.ProgressDialog progressDialog;

    public RegisterUser(Context context,Activity activityReference) {
        this.context=context;
        this.activityReference=activityReference;
    }

    public String register(String nom,String prenom,int age,String url1,boolean meteo){
        progressDialog = ProgressDialog.getProgress("test","test",context);
        progressDialog.show();
        ApiInterface apiInterface= ClientRetrofit.getClient();

        Call<String> call = apiInterface.createUser(nom,prenom,age,url1,meteo);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                progressDialog.dismiss();

                Explode explode = new Explode();
                explode.setDuration(500);

                activityReference.getWindow().setExitTransition(explode);
                activityReference.getWindow().setEnterTransition(explode);
                ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(activityReference);
                Intent i2 = new Intent(context, LoginSuccessActivity.class);
                activityReference.startActivity(i2, oc2.toBundle());
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                progressDialog.dismiss();
                System.out.println("response :"+t.toString());

                Toast.makeText(context,"Erreur lors de la création de l'utilisateur",Toast.LENGTH_SHORT).show();

            }
        });





        return "non";


    }
}

