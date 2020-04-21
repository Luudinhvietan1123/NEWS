package App;

import java.util.Date;

public class newsModel {
    private String newsLink;
    private String newsTitle;
    private String newsImg;
    private String newsTime;
    private Date newsDate;
    private String newsContent;

    public newsModel() {
    }

    public newsModel(String newsLink, String newsTitle, String newsImg, String newsTime, String newsContent){
        super();
        this.newsLink = newsLink;
        this.newsTitle= newsTitle;
        this.newsImg = newsImg;
        this.newsTime = newsTime;
        this.newsContent = newsContent;
    }

    public String getNewsLink() {
        return newsLink;
    }

    public void setNewsLink(String newsLink) {
        this.newsLink = newsLink;
    }

    public String getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg;
    }

    public String getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
}
