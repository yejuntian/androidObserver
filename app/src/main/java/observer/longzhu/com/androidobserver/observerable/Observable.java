package observer.longzhu.com.androidobserver.observerable;

import java.util.ArrayList;

import observer.longzhu.com.androidobserver.observer.Observer;

/**
 * Created by tianyejun on 2018/1/13.
 */

public class Observable<T> {

    protected final ArrayList<Observer<T>> mObservers = new ArrayList<Observer<T>>();

    public void registerObserver(Observer<T> observer) {
        if (observer == null) {
            throw new IllegalArgumentException("The observer is null.");
        }
        synchronized (mObservers) {
            if (mObservers.contains(observer)) {
                throw new IllegalStateException("Observer " + observer + " is already registered.");
            }
            mObservers.add(observer);
        }
    }

    public void unregisterObserver(Observer<T> observer) {
        if (observer == null) {
            throw new IllegalArgumentException("The observer is null.");
        }
        synchronized (mObservers) {
            int index = mObservers.indexOf(observer);
            if (index == -1) {
                throw new IllegalStateException("Observer " + observer + " was not registered.");
            }
            mObservers.remove(index);
        }
    }


    public void unregisterAll() {
        synchronized (mObservers) {
            mObservers.clear();
        }
    }

    public void notifyObserver(Observable<T> observable, T data) {
        synchronized (mObservers) {
            for (Observer<T> observer : mObservers) {
                observer.update(observable, data);
            }
        }
    }
}
