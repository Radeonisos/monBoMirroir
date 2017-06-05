package com.entreprise.davfou.monmirroir.presentation.view.utils;

import android.content.Context;

/**
 * Created by davidfournier on 04/06/2017.
 */

public class ProgressDialog {


    public ProgressDialog() {
    }


    public static android.app.ProgressDialog getProgress(String tilte, String message, Context context){

        final android.app.ProgressDialog progress = new android.app.ProgressDialog(context);
        progress.setTitle(tilte);
        progress.setMessage(message);
        progress.setCancelable(false);


        return progress;


    }
}
