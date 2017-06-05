package com.entreprise.davfou.monmirroir.metier.executeurs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.transition.Explode;
import android.widget.Toast;

import com.entreprise.davfou.monmirroir.data.rest.baseDeDonnee.model.User;
import com.entreprise.davfou.monmirroir.data.rest.clientWs.ClientRetrofit;
import com.entreprise.davfou.monmirroir.data.rest.methodeRest.ApiInterface;
import com.entreprise.davfou.monmirroir.presentation.view.activity.login.LoginSuccessActivity;
import com.entreprise.davfou.monmirroir.presentation.view.utils.ProgressDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by davidfournier on 04/06/2017.
 */

public class ConnectUser {

    Context context;
    Activity activityReference;
    android.app.ProgressDialog progressDialog;

    public ConnectUser(Context context,Activity activityReference) {
        this.context=context;
        this.activityReference=activityReference;
    }


    public String connect(String nom,String prenom){
        progressDialog = ProgressDialog.getProgress("test","test",context);
        progressDialog.show();
        ApiInterface apiInterface=ClientRetrofit.getClient();

        Call<User> call = apiInterface.connectUser(nom,prenom);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                progressDialog.dismiss();
                System.out.println("user : "+response.code());
                System.out.println("user : "+response.raw().toString());


                if(response.body().getNom().equals("error")){
                    System.out.println("erreur");
                    Toast.makeText(context,"Aucun user trouvé",Toast.LENGTH_SHORT).show();
                }else{




                Explode explode = new Explode();
                explode.setDuration(500);

                activityReference.getWindow().setExitTransition(explode);
                activityReference.getWindow().setEnterTransition(explode);
                ActivityOptionsCompat oc2 = ActivityOptionsCompat.makeSceneTransitionAnimation(activityReference);
                Intent i2 = new Intent(activityReference.getApplicationContext(), LoginSuccessActivity.class);
                activityReference.startActivity(i2, oc2.toBundle());}

            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                progressDialog.dismiss();
                System.out.println("call : "+t.getMessage().toString());
                System.out.println("response :"+t.toString());


            }
        });





        return "non";


    }
}
