package MyApplication.Articles;

public class System_articles {
    private int ID;
    private String Url;
    private String title;
    private String thumbnail;
    private String description;
    private String content;
    private String createAt;
    private String createBy;
    private int status;

    public System_articles() {
    }

    public System_articles(String url, String title, String thumbnail, String description, String content, String createAt, String createBy) {
        Url = url;
        this.title = title;
        this.thumbnail = thumbnail;
        this.description = description;
        this.content = content;
        this.createAt = createAt;
        this.createBy = createBy;
    }

    public System_articles(int ID, String url, String title, String thumbnail, String description, String content, String createAt, String createBy, int status) {
        this.ID = ID;
        Url = url;
        this.title = title;
        this.thumbnail = thumbnail;
        this.description = description;
        this.content = content;
        this.createAt = createAt;
        this.createBy = createBy;
        this.status = status;
    }

    public void showArticles() {
        String status;
        if (this.status == 1) {
            status = "Active";
        } else if (this.status == 0) {
            status = "De Active";
        } else {
            status = "Remove";
        }
        System.out.printf("ID : %d \t URL : %s \t Title : %s \t Thumbnail : %s \t Description : %s \t Create At : %s\t Create By : %s \t Status : %s\n\n", this.ID, this.Url, this.title, this.thumbnail, this.description, this.createAt, this.createBy, status);
        String[] contents = this.content.split(",");
        for (int i = 0; i < contents.length; i++) {
            System.out.println(contents[i]);
        }
        System.out.println("\n\n");
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
