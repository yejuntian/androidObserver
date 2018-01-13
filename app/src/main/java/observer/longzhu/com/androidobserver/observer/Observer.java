package observer.longzhu.com.androidobserver.observer;


import observer.longzhu.com.androidobserver.observerable.Observable;

/**
 * 观察者
 * 拉模式和推模式兼容
 */

public interface Observer<T> {
    public void update(Observable<T> observable, T data);
}
