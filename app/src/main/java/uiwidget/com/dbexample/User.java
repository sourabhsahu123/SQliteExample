package uiwidget.com.dbexample;

/**
 * Created by pc on 29-03-2018.
 */

public class User {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User()
    {

    }
    public User(int id, String fName, String lName, String mob, String email, String address) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.mob = mob;
        this.email = email;
        this.address = address;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    int id;
    String fName;
    String lName;
    String mob;
    String email;
    String address;
}
