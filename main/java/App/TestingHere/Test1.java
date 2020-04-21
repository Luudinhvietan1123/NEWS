package App.TestingHere;

import App.newsModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import App.*;

public class Test1 {
    //Bóc thông tin từ trang vietnammoi.vn
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
        for(int i = 0; i < baomoiNewsList.size(); i ++){
            System.out.println(baomoiNewsList.get(i).getNewsTitle());
        }
    }
}
