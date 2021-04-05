package MyApplication.ArticlesModels;

import MyApplication.Articles.System_articles;

import java.util.ArrayList;

public interface ArticlesModels {
    boolean PostArticle(String SQL , System_articles system_articles);
    ArrayList<System_articles> GetArticles(String SQL);
}
