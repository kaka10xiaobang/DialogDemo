package com.kaka.dialogdemo.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;
import com.kaka.dialogdemo.DialogEvent;
import com.kaka.dialogdemo.R;

/**
 * Created by kaka on 2018/3/22.
 * email:375120706@qq.com
 */

public class DialogHelper {
    //Dialog子类(此对话框可显示标题、最多三个按钮、可选择项列表或自定义布局)
    private AlertDialog mAlertDialog;
    private static Context mContext;
    private static volatile DialogHelper mInstance;
    private String[] datas;
    private DialogHelper(){
        datas=new String[]{"北京","上海","广州"};
    }

    public static DialogHelper getInstance(Context context){
        mContext=context;
        if (mInstance==null){
            synchronized (DialogHelper.class){
                if (mInstance==null){
                    mInstance=new DialogHelper();
                }
            }
        }
        return mInstance;
    }

    public  AlertDialog createEasyDialog(){
        mAlertDialog=new AlertDialog.Builder(mContext).setTitle("这是标题")
                .setMessage("这是内容")
                .setIcon(R.mipmap.ic_launcher)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();
        return mAlertDialog;
    }

    public  AlertDialog createItemDialog(){
        mAlertDialog=new AlertDialog.Builder(mContext).setTitle("这是标题")
                .setItems(datas, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0:
                                ToastUtils.showShort(datas[0]);
                                break;
                            case 1:
                                ToastUtils.showShort((datas[1]));
                                break;
                            case 2:
                                ToastUtils.showShort((datas[2]));
                                break;
                            default:
                                break;
                        }
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();
        return mAlertDialog;
    }


    public AlertDialog createMultiChoiceDialog(){
        mAlertDialog=new AlertDialog.Builder(mContext).setTitle("这是标题")
                .setMultiChoiceItems(datas, new boolean[]{true, false,false}, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        switch (which){
                            case 0:
                                ToastUtils.showShort("isChecked="+isChecked);
                                break;
                            case 1:
                                ToastUtils.showShort("isChecked="+isChecked);
                                break;
                            default:
                                break;
                        }
                    }
                })
                .setNeutralButton("中立", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        ToastUtils.showShort("onCancel");
                    }
                })
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        ToastUtils.showShort("onDismiss");
                    }
                })
                .create();
        return mAlertDialog;
    }


    public  AlertDialog createSingleChoiceDialog(){
        mAlertDialog=new AlertDialog.Builder(mContext).setTitle("这是标题")
                .setSingleChoiceItems(datas, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();
        return mAlertDialog;
    }


    public  AlertDialog createListAdapterDialog(){
        mAlertDialog=new AlertDialog.Builder(mContext).setTitle("这是标题")
                .setItems(datas, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setAdapter(new ArrayAdapter<String>(mContext, R.layout.item,R.id.tvName,datas), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })

                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create();
        return mAlertDialog;
    }



    public  AlertDialog createDialogFragmentView(){
        final View view=View.inflate(mContext,R.layout.dialog_custom_view,null);
         mAlertDialog=new AlertDialog.Builder(mContext).setTitle("这是标题")
                .setView(view)
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mAlertDialog.dismiss();
                    }
                })

                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name=((EditText)view.findViewById(R.id.et_name)).getText().toString();
                        String pwd=((EditText)view.findViewById(R.id.et_pwd)).getText().toString();
                        RxBus.getDefault().send(new DialogEvent(name,pwd));
                    }
                })
                .create();
        return mAlertDialog;
    }





}
