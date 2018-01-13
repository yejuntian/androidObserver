package observer.longzhu.com.androidobserver.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by tianyejun on 2018/1/13.
 */

public class MyDataBaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "test.db";

    public MyDataBaseHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table t_user(id int , name varchar(20))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
