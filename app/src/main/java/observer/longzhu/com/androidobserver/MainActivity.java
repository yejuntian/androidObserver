package observer.longzhu.com.androidobserver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import observer.longzhu.com.androidobserver.bean.UserBean;
import observer.longzhu.com.androidobserver.db.imp.UserDao;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ListView mListView;
    private List<UserBean> userBeanList = new ArrayList<>();
    UserDao userDao = new UserDao(this);
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = getView(R.id.add_data);
        mListView = getView(R.id.listView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, AddActivity.class), 500);
            }
        });

        adapter = new Adapter(this);
        List<UserBean> userList = userDao.query(this);
        userBeanList.addAll(userList);
        adapter.setData(userBeanList);
        mListView.setAdapter(adapter);
    }

    public <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //更新UI
        //第一种方案：查询数据库（效率低）
        //第二种方案将user对象传递过来
        UserBean user = (UserBean) data.getSerializableExtra("user");
        userBeanList.add(user);
        adapter.setData(userBeanList);
    }

}
