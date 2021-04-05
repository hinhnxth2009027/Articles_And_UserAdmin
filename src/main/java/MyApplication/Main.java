package MyApplication;

import MyApplication.UserModels.User_manager;
import MyApplication.User_menu.User_menu;

public class Main {
    public static void main(String[] args) {
        User_menu user_menu = new User_menu();
        User_manager user_manager = new User_manager();
        user_manager.connection();
        user_menu.Usermenu();
    }
}