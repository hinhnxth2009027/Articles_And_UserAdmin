package MyApplication.User;

public class System_user {
    private int ID;
    private String fullname;
    private String email;
    private String password;
    private String phoneNumber;
    private String salt;
    private String createAt;
    private int status;


    public System_user(){}


    public System_user(int ID, String fullname, String email, String password, String phoneNumber, String salt, String createAt, int status) {
        this.ID = ID;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.salt = salt;
        this.createAt = createAt;
        this.status = status;
    }


    public System_user(String fullname, String email, String password, String phoneNumber, String salt, String createAt) {
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.salt = salt;
        this.createAt = createAt;
    }




    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}