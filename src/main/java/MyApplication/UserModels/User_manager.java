package MyApplication.UserModels;

import MyApplication.User.System_user;

import java.sql.*;
import java.util.ArrayList;

public class User_manager implements Uer_system{
    public static ArrayList<System_user> users = new ArrayList<>();
    public final String Url = "jdbc:mysql://localhost:3306/User";
    public final String username = "root";
    public final String password = "nguyenxuanhjnh";

    static Connection conn = null;

    public Connection connection(){
        try {
            if (conn == null){
                conn = DriverManager.getConnection(Url,username,password);
                System.out.println("connected");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }

        return conn;
    }



    @Override
    public boolean createAccount(String SQl,System_user system_user) {
        try {
            PreparedStatement preparedStatement = connection().prepareStatement(SQl);
            preparedStatement.setString(1,system_user.getFullname());
            preparedStatement.setString(2,system_user.getEmail());
            preparedStatement.setString(3,system_user.getPassword());
            preparedStatement.setString(4,system_user.getPhoneNumber());
            preparedStatement.setString(5,system_user.getSalt());
            preparedStatement.setString(6,system_user.getCreateAt());
            preparedStatement.execute();
            return true;
        } catch (SQLException throwables) {
            return false;
        }
    }

    public String checklogin(String email){
        try {
            PreparedStatement preparedStatement = connection().prepareStatement("select * from User where email = ?");
            preparedStatement.setString(1,email);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()!=false){
                String pass = rs.getString("salt");
                return pass;
            }
        } catch (SQLException throwables) {
            return "ghff2213sewer4323rersreww433resresres";
        }
        return "ghff2213sewer4323rersreww433resresres";
    }

    @Override
    public ArrayList<System_user> login(String SQL){
        ArrayList<System_user> users = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection().prepareStatement(SQL);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()==true){
                int ID = rs.getInt("ID");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String phoneNumber = rs.getString("phoneNumber");
                String salt = rs.getString("salt");
                String createAt = rs.getString("createAt");
                int status = rs.getInt("status");
                users.add(0,new System_user(ID,fullname,email,password,phoneNumber,salt,createAt,status));
                return users;
            }return null;
        } catch (SQLException throwables) {
            return null;
        }
    }
}
