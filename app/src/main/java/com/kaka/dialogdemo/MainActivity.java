package com.kaka.dialogdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.Utils;
import com.kaka.dialogdemo.utils.DialogType;
import com.kaka.dialogdemo.utils.RxBus;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    //订阅
    private Disposable mRxBus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //工具类初始化
        Utils.init(getApplication());
        //创建RxBus订阅
        mRxBus=RxBus.getDefault().toObservable(DialogEvent.class)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<DialogEvent>() {
                    @Override
                    public void accept(@NonNull DialogEvent dialogEvent) throws Exception {
                        ToastUtils.showShort(dialogEvent.toString());
                    }
                });
    }

    public void startDialog(View view){
        startActivity(new Intent(this,AlertDialogActivity.class));
    }

    public void dialogFragment(View view){
           MyDialogFragment.newInstance(DialogType.CUSTOMVIEW).show(getSupportFragmentManager(),"TEST");
    }

    @Override
    protected void onDestroy() {
        //取消订阅
        if (mRxBus != null && !mRxBus.isDisposed()) {
            mRxBus.dispose();
        }
        super.onDestroy();

    }
}
