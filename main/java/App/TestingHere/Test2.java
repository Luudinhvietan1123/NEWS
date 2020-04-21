package App.TestingHere;

import App.newsModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Test2 {

    public static Date convertStringTimeToDate(String newsTime_raw) throws ParseException{
        String time_cooked = "";
        for(int i = 31; i < newsTime_raw.length(); i++){
            time_cooked = time_cooked + newsTime_raw.charAt(i); }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm | dd/MM/yyyy");
        return simpleDateFormat.parse(time_cooked);
    }


    public static void main(String[] args) throws IOException, ParseException {
        ArrayList<newsModel> baomoiNewsList = new ArrayList<newsModel>();
        Document newsDoc = Jsoup.connect("https://vietnammoi.vn/").get();
        Element parseThis1 = newsDoc.getElementById("__main_wrapper_content");
        Elements parseThis2 = parseThis1.getElementsByClass("news-stream clearafter");
        Element parseThis3 = parseThis2.first();
        Elements parseThis4 = parseThis3.getElementsByClass("clearafter");
        Element parseThis5 = parseThis4.first();
        Elements parseThis6 = parseThis5.children();
        for (Element parseThis7 : parseThis6){
            newsModel thisNews = new newsModel(
                    parseThis7.select("a[href]").attr("href"),
                    parseThis7.select("a[href]").attr("title"),
                    parseThis7.select("img[data-src]").attr("data-src"),
                    parseThis7.select("span[class =\"time\"]").html(),
                    parseThis7.select("a[href]").attr("href")
            );
            baomoiNewsList.add(thisNews);
        }

        Date newestNews;
        for (int i = 0; i < baomoiNewsList.size() - 1; i++) {
            newestNews = convertStringTimeToDate(baomoiNewsList.get(i).getNewsTime());
            for(int j = i + 1 ; j < baomoiNewsList.size(); j++){
                if(newestNews.compareTo(convertStringTimeToDate(baomoiNewsList.get(j).getNewsTime())) < 0){
                    newsModel sw = new newsModel(
                            baomoiNewsList.get(i).getNewsLink(),
                            baomoiNewsList.get(i).getNewsTitle(),
                            baomoiNewsList.get(i).getNewsImg(),
                            baomoiNewsList.get(i).getNewsTime(),
                            baomoiNewsList.get(i).getNewsContent()
                    );

                    baomoiNewsList.get(i).setNewsLink(baomoiNewsList.get(j).getNewsLink());
                    baomoiNewsList.get(i).setNewsTitle(baomoiNewsList.get(j).getNewsTitle());
                    baomoiNewsList.get(i).setNewsImg(baomoiNewsList.get(j).getNewsImg());
                    baomoiNewsList.get(i).setNewsTime(baomoiNewsList.get(j).getNewsTime());
                    baomoiNewsList.get(i).setNewsContent(baomoiNewsList.get(j).getNewsContent());

                    baomoiNewsList.get(j).setNewsLink(sw.getNewsLink());
                    baomoiNewsList.get(j).setNewsTitle(sw.getNewsTitle());
                    baomoiNewsList.get(j).setNewsImg(sw.getNewsImg());
                    baomoiNewsList.get(j).setNewsTime(sw.getNewsTime());
                    baomoiNewsList.get(j).setNewsContent(sw.getNewsContent());
                }
            }
        }

        for(int i = 0; i < baomoiNewsList.size(); i++){
            System.out.println(convertStringTimeToDate(baomoiNewsList.get(i).getNewsTime()));
        }
    }
}
