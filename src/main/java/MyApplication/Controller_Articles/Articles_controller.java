package MyApplication.Controller_Articles;
import MyApplication.Articles.System_articles;
import MyApplication.ArticlesModels.Articles_Models;
import MyApplication.User.System_user;
import MyApplication.User_menu.User_menu;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Articles_controller {
    Calendar calendar = Calendar.getInstance();
    Scanner scanner = new Scanner(System.in);
    User_menu user_menu = new User_menu();
    Articles_Models articles_models = new Articles_Models();
    String SQL_AddArticle = "insert into articles (Url,title,thumbnail,description,content,createAt,createBy) values (?,?,?,?,?,?,?)";
    String SQL_getArticle = "select *from articles";

    public void addArticles(){
        System.out.println("vui lòng nhập vào URL bạn muốn crow data");
        String URL = scanner.nextLine();
        Connection connection = Jsoup.connect(URL);
        Document document = null;
        try {
            document = connection.get();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("đường dẫn khỏi tạo bị lỗi");
            return;
        }
        Elements title = document.select("h1.title-detail");
        Elements description = document.select("p.description");
        Elements thumbnail = document.select("div.fig-picture img");
        Elements content = document.select(".fck_detail");
        String tl = title.text();
        String desc = description.text();
        String tn = thumbnail.get(0).attr("src");
        String ct = content.text();
        System_user system_user = user_menu.login(2).get(0);
        String createBy = system_user.getFullname();
        String createAt = calendar.getTime().toString();
        System_articles system_articles = new System_articles(URL,tl,tn,desc,ct,createAt,createBy);
        articles_models.PostArticle(SQL_AddArticle,system_articles);
    }

    public void getAllArticles(){
        ArrayList<System_articles> allArticles = articles_models.GetArticles(SQL_getArticle);
        for (int i = 0; i < allArticles.size(); i++) {
            System_articles article = allArticles.get(i);
            article.showArticles();
        }
    }
}