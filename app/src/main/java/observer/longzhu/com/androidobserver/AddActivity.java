package observer.longzhu.com.androidobserver;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import observer.longzhu.com.androidobserver.bean.UserBean;
import observer.longzhu.com.androidobserver.db.imp.UserDao;

public class AddActivity extends AppCompatActivity {
    private Button button;
    private EditText mContent;
    private int count;
    UserDao userDao = new UserDao(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        button = getView(R.id.add_data);
        mContent = getView(R.id.content);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mContent.getText().toString();
                if (!TextUtils.isEmpty(content)) {
                    saveData();
                }
            }
        });

    }

    public <T extends View> T getView(int id) {
        return (T) findViewById(id);
    }

    public void saveData() {
        UserBean userBean = new UserBean(count++, mContent.getText().toString());
        userDao.templateInsert(this, userBean);
//        Intent intent = new Intent();
//        intent.putExtra("user", userBean);
//        setResult(500, intent);
        finish();
    }
}
