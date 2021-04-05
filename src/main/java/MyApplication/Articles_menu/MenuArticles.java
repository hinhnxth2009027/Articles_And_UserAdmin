package MyApplication.Articles_menu;

import MyApplication.Controller_Articles.Articles_controller;

import java.util.Scanner;

public class MenuArticles {
    Scanner scanner = new Scanner(System.in);
    Articles_controller articles_controller = new Articles_controller();


    public void menuArticles(){
        int choice;
        while (true){
            System.out.println("chọn 1 để thêm mới Articles");
            System.out.println("chọn 2 để lấy ra tất cả Articles");
            System.out.println("chọn 0 exist");
            choice = scanner.nextInt();scanner.nextLine();
            switch (choice){
                case 1:
                    articles_controller.addArticles();
                    break;
                case 2:
                    articles_controller.getAllArticles();
                    break;
                case 0:
                    break;
            }
            if (choice == 0){
                System.out.println("đã trở về menu admin");
                break;
            }
        }
    }
}
