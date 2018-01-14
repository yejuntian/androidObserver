package observer.longzhu.com.androidobserver.db.imp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import observer.longzhu.com.androidobserver.bean.UserBean;
import observer.longzhu.com.androidobserver.db.BaseDao;
import observer.longzhu.com.androidobserver.db.MyDataBaseHelper;

/**
 * Created by tianyejun on 2018/1/13.
 */

public class UserDao extends BaseDao<UserBean> {
    private Context context;
    private MyDataBaseHelper myDataBaseHelper;
    private static final String TABLE_NAME = "t_user";
    private static final String ID = "id";
    private static final String NAME = "name";

    public UserDao(Context context) {
        this.context = context;
        myDataBaseHelper = new MyDataBaseHelper(context);
    }

    @Override
    protected long insert(Context context, UserBean data) {
        SQLiteDatabase database = myDataBaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, data.getId());
        values.put(NAME, data.getName());
        return database.insert(TABLE_NAME, null, values);
    }

    @Override
    protected long delete(Context context, UserBean data) {
        SQLiteDatabase database = myDataBaseHelper.getWritableDatabase();
        return database.delete(TABLE_NAME, new String("id = ?"), new String[]{data.getId() + ""});
    }

    @Override
    protected long update(Context context, UserBean data) {
        SQLiteDatabase database = myDataBaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ID, data.getId());
        values.put(NAME, data.getName());
        return database.update(TABLE_NAME, values, new String("id = ?"), new String[]{data.getId() + ""});
    }

    @Override
    public List<UserBean> query(Context context) {
        List<UserBean> userBeanList = new ArrayList<>();
        SQLiteDatabase database = myDataBaseHelper.getWritableDatabase();
        Cursor cursor = database.query(TABLE_NAME, new String[]{ID, NAME}, null, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()){
                int id = cursor.getInt(cursor.getColumnIndex(ID));
                String name = cursor.getString(cursor.getColumnIndex(NAME));

                UserBean userBean = new UserBean();
                userBean.setId(id);
                userBean.setName(name);
                userBeanList.add(userBean);
            }
        }
        return userBeanList;
    }
}
