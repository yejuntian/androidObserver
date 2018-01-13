package observer.longzhu.com.androidobserver;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import observer.longzhu.com.androidobserver.bean.UserBean;

/**
 * Created by tianyejun on 2018/1/14.
 */

public class Adapter extends BaseAdapter {
    private Context context;
    private List<UserBean> userBeanList = null;

    public Adapter(Context context) {
        this.context = context;
        userBeanList = new ArrayList<>();
    }

    public void setData(List<UserBean> list) {
        userBeanList.clear();
        userBeanList.addAll(list);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return userBeanList == null ? 0 : userBeanList.size();
    }

    @Override
    public Object getItem(int position) {
        return userBeanList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_item, null);
            viewHolder.mTv = convertView.findViewById(R.id.tv);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        UserBean userBean = userBeanList.get(position);
        if (userBean != null) {
            viewHolder.mTv.setText(userBean.getName());
        }
        return convertView;
    }

    public class ViewHolder {
        public TextView mTv;
    }
}
