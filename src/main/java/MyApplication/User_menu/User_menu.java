package MyApplication.User_menu;

import MyApplication.Articles_menu.MenuArticles;
import MyApplication.Controller_Uer.User_controller;
import MyApplication.User.System_user;
import MyApplication.UserModels.User_manager;

import java.util.ArrayList;
import java.util.Scanner;

public class User_menu {
    static ArrayList<System_user> users = null;
    static User_manager uer_manager = new User_manager();
    static User_controller user_controller = new User_controller();
    static Scanner scanner = new Scanner(System.in);
    static MenuArticles menuArticles = new MenuArticles();


    public void Usermenu(){
        login(1);
    }




    public static void menu(){
        int choice;
        System.out.println("chào mừng đến với hệ thống Articles");
        while (true){
            System.out.println("chọn 1 để thêm mới admin");
            System.out.println("chọn 2 để mở menu Articles");
            System.out.println("chọn 0 để log out");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    user_controller.CreateAccount();
                    break;
                case 2:
                    menuArticles.menuArticles();
                    break;
                case 0:
                    break;
            }if (choice == 0){
                users=null;
                System.out.println("logout succes");
                login(1);
                break;
            }
        }
    }


    public static ArrayList<System_user> login(int caSe){
        while (true){
            users = user_controller.login();
            if (users!=null){
                if (caSe == 1){
                    menu();
                }
                return users;
            }
        }
    }
}
