package MyApplication.ArticlesModels;

import MyApplication.Articles.System_articles;
import MyApplication.UserModels.User_manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Articles_Models implements ArticlesModels{
    Connection connection = new User_manager().connection();
    @Override
    public boolean PostArticle(String SQL, System_articles system_articles) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setString(1,system_articles.getUrl());
            preparedStatement.setString(2,system_articles.getTitle());
            preparedStatement.setString(3,system_articles.getThumbnail());
            preparedStatement.setString(4,system_articles.getDescription());
            preparedStatement.setString(5,system_articles.getContent());
            preparedStatement.setString(6,system_articles.getCreateAt());
            preparedStatement.setString(7,system_articles.getCreateBy());
            preparedStatement.execute();
            System.out.println("thêm mới thành công");
            return true;
        } catch (SQLException throwables) {
            System.out.println("thêm mới thất bại vui lòng kiểm tra lại thông tin đầu nhập");
            return false;
        }
    }


    @Override
    public ArrayList<System_articles> GetArticles(String SQL) {
        ArrayList<System_articles> system_articles = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()==true){
                int ID = rs.getInt("ID");
                String Url = rs.getString("Url");
                String title = rs.getString("title");
                String thumbnail = rs.getString("thumbnail");
                String description = rs.getString("description");
                String content = rs.getString("content");
                String createAt = rs.getString("createAt");
                String createBy = rs.getString("createBy");
                int status = rs.getInt("status");
                System_articles systemArticle = new System_articles(ID,Url,title,thumbnail,description,content,createAt,createBy,status);
                system_articles.add(systemArticle);
            }
            return  system_articles;
        } catch (SQLException throwables) {
            System.out.println("không tìm thấy thông tin nào trong cơ sở dữ liệu");
            return null;
        }
    }
}
