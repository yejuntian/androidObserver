package observer.longzhu.com.androidobserver.db.observerbale;

import observer.longzhu.com.androidobserver.bean.IBean;

/**
 * Created by tianyejun on 2018/1/14.
 */

public class DBObservable<T extends IBean> extends Observable<T> {

    private static DBObservable observable;

    private DBObservable() {

    }

    public static DBObservable getInstance() {
        if (observable == null) {
            synchronized (DBObservable.class) {
                observable = new DBObservable();
            }
        }
        return observable;
    }
}
