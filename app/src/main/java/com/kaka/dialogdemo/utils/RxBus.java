package com.kaka.dialogdemo.utils;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by kaka on 2018/3/27.
 * email:375120706@qq.com
 */

public class RxBus {
    /**
     * 内存中默认的实例
     */
    private static volatile RxBus sDefaultInstance;

    private final Subject<Object> bus;

    /**
     * PublishSubject只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者
     */
    public RxBus() {
        bus = PublishSubject.create().toSerialized();
    }

    /**
     * 获取 RxBus的实例
     *
     * @return
     */
    public static RxBus getDefault() {
        if (sDefaultInstance == null) {
            synchronized (RxBus.class) {
                sDefaultInstance = new RxBus();
            }
        }
        return sDefaultInstance;
    }

    /**
     * 发送一个新的事件
     *
     * @param o
     */
    public void send(Object o) {
        bus.onNext(o);
    }

    /**
     * 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
     *
     * @param eventType
     * @param <T>
     * @return
     */
    public <T> Observable<T> toObservable(Class<T> eventType) {
        return bus.ofType(eventType);
    }

}
