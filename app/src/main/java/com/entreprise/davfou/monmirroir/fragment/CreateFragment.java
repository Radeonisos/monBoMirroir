package com.entreprise.davfou.monmirroir.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.entreprise.davfou.monmirroir.R;
import com.entreprise.davfou.monmirroir.rest.ApiInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by davidfournier on 06/05/2017.
 */

public class CreateFragment extends Fragment {

    ApiInterface apiInterface;
    Button btnAddUser;
    EditText edit_nom, edit_prenom, edit_age, edit_ulr1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_create, container, false);
    }

    public static CreateFragment newInstance() {
        return new CreateFragment();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnAddUser = (Button) view.findViewById(R.id.btnAddUser);
        edit_nom = (EditText) view.findViewById(R.id.edit_nom);
        edit_prenom = (EditText) view.findViewById(R.id.edit_prenom);
        edit_age = (EditText) view.findViewById(R.id.edit_age);
        edit_ulr1 = (EditText) view.findViewById(R.id.edit_ulr1);



        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        apiInterface = new Retrofit.Builder()
                .baseUrl(ApiInterface.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(ApiInterface.class);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUer();
            }
        });


    }



    private void addUer(){
        final ProgressDialog progress = new ProgressDialog(getContext());
        progress.setTitle("En cours");
        progress.setMessage("En cours d'envoi...");
        progress.setCancelable(false);
        progress.show();


        Call<String> call = apiInterface.createUser(edit_nom.getText().toString(),edit_prenom.getText().toString(),Integer.parseInt(edit_age.getText().toString()),edit_ulr1.getText().toString(),true);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                progress.dismiss();

                System.out.println("response :"+response.message());
                new AlertDialog.Builder(getContext())
                        .setTitle("Réussi")
                        .setMessage("Nouvel utilisateur correctement enregistré")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {
                progress.dismiss();
                System.out.println("response :"+t.toString());

                new AlertDialog.Builder(getContext())
                        .setTitle("Erreur")
                        .setMessage("Le nouvel utilisateur n'a pas pu être enregistrée, vérifier vôtre connexion.")
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .show();
            }
        });
    }


}
