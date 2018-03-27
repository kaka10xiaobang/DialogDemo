package com.kaka.dialogdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kaka.dialogdemo.utils.DialogHelper;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    public void alertDialog(View view){
        DialogHelper.getInstance(this).createEasyDialog().show();
    }

    public void itemDialog(View view){
        DialogHelper.getInstance(this).createItemDialog().show();
    }

    public void chooseDialog(View view){
        DialogHelper.getInstance(this).createMultiChoiceDialog().show();
    }

    public void singleDialog(View view){
        DialogHelper.getInstance(this).createSingleChoiceDialog().show();
    }

    public void adapterDialog(View view){
        DialogHelper.getInstance(this).createListAdapterDialog().show();
    }

    public void customViewDialog(View view){
        DialogHelper.getInstance(this).createDialogFragmentView().show();
    }
}
