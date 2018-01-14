package observer.longzhu.com.androidobserver.db;

import android.content.Context;

import java.util.List;

import observer.longzhu.com.androidobserver.bean.IBean;
import observer.longzhu.com.androidobserver.bean.UserBean;
import observer.longzhu.com.androidobserver.db.observerbale.DBObservable;

/**
 * 使用模板设计模式进行通知更新db
 */

public abstract class BaseDao<T extends IBean> {

    public long templateInsert(Context context, T data) {
        long insert = insert(context, data);
        if (insert < 0) {
            throw new IllegalArgumentException("插入数据异常");
        }
        DBObservable.getInstance().notifyObserver(data);

        return insert;
    }

    public long templateDelete(Context context, T data) {
        long delete = delete(context, data);
        if (delete < 0) {
            throw new IllegalArgumentException("删除数据异常");
        }
        DBObservable.getInstance().notifyObserver(data);

        return delete;
    }

    public long templateUpdate(Context context, T data) {
        long update = update(context, data);
        if (update < 0) {
            throw new IllegalArgumentException("更新数据异常");
        }
        DBObservable.getInstance().notifyObserver(data);
        return update;
    }

    //插入数据
    protected abstract long insert(Context context, T data);

    //删除数据
    protected abstract long delete(Context context, T data);


    //更新数据
    protected abstract long update(Context context, T data);


    //查询数据
    protected abstract List<UserBean> query(Context context);
}
