package MyApplication.UserModels;

import MyApplication.User.System_user;

import java.util.ArrayList;

public interface Uer_system {
    boolean createAccount(String SQl,System_user system_user);
    ArrayList<System_user> login(String SQL);
}
