package MyApplication.Controller_Uer;
import MyApplication.User.System_user;
import MyApplication.UserModels.User_manager;
import org.apache.commons.codec.digest.DigestUtils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
public class User_controller {
    Scanner scanner = new Scanner(System.in);
    User_manager uer_manager = new User_manager();
    static ArrayList<System_user> users;
    String SQL_Create_User = "insert into User (fullname,email,password,phoneNumber,salt,createAt) values (?,?,?,?,?,?)";
    String SQL_login = "select * from User where email = '%s' and password = '%s'";
    public void CreateAccount(){
        Calendar calendar = Calendar.getInstance();
        System.out.println("vui lòng nhập vào Full Name");
        String fullname = scanner.nextLine();
        System.out.println("Vui lòng nhập email");
        String email = scanner.nextLine();
        System.out.println("vui lòng nhập password");
        String beforPassword = scanner.nextLine();
        System.out.println("nhập vào phonenumber");
        String phonenumber = scanner.nextLine();
        String[] affterPassword = hashing(beforPassword).split("~`~");
        String password = affterPassword[0];
        String salt = affterPassword[1];
        String createAt = calendar.getTime().toString();
        System_user system_user = new System_user(fullname,email,password,phonenumber,salt,createAt);
        boolean check = uer_manager.createAccount(SQL_Create_User,system_user);
        if (check==true){
            System.out.println("khởi tạo thành công");
        }else {
            System.out.println("tạo tài khoản thất bại");
        }
    }
    public ArrayList<System_user> login(){
        if (users==null){
            System.out.println("\nYÊU CẦU ĐĂMG NHẬP HỆ THỐNG ARTICLES ĐỂ TIẾP TỤC\n");
            System.out.println("vui lòng nhập email");
            String email = scanner.nextLine();
            System.out.println("vui lòng nhập password");
            String pass = scanner.nextLine();
            String salt = uer_manager.checklogin(email);
            String password =  DigestUtils.sha256Hex(pass+salt);
            String login = String.format(SQL_login,email,password);
            users = uer_manager.login(login);
        }
        if (users==null){
            System.out.println("login fales");
            System.out.println("vui lòng kiểm tra lại mật khẩu\n\n");
        }else {
            System.out.println("login succes\n");
            return users;
        }return null;
    }
    public static String hashing(String string){
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        String befoBam = string+generatedString;
        String sha256hex = DigestUtils.sha256Hex(befoBam);
        return sha256hex+"~`~"+generatedString;
    }
}
