package observer.longzhu.com.androidobserver.db;

import android.content.Context;

import java.util.List;

import observer.longzhu.com.androidobserver.bean.UserBean;

/**
 * Created by tianyejun on 2018/1/13.
 */

public abstract class BaseDao<T> {
    //插入数据
    public abstract long insert(Context context, T data);

    //删除数据
    public abstract long delete(Context context, T data);


    //更新数据
    public abstract long update(Context context, T data);


    //查询数据
    public abstract List<UserBean> query(Context context);
}
