package observer.longzhu.com.androidobserver.db.observer.imp;

import observer.longzhu.com.androidobserver.bean.IBean;
import observer.longzhu.com.androidobserver.bean.UserBean;
import observer.longzhu.com.androidobserver.db.observer.DBObserver;
import observer.longzhu.com.androidobserver.db.observerbale.Observable;

/**
 * 具体观察者
 */

public class DBUserObserver extends DBObserver<UserBean> {


    @Override
    public void update(Observable<IBean> observable, IBean data) {

    }
}
