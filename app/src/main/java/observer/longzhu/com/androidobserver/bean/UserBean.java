package observer.longzhu.com.androidobserver.bean;

import java.io.Serializable;

/**
 * Created by tianyejun on 2018/1/13.
 */

public class UserBean implements Serializable {
    private int id;
    private String name;

    public UserBean() {
        super();
    }

    public UserBean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
