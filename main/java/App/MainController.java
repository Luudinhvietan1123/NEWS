package App;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import App.*;

public class MainController {
    private static MainView mainView;
    private static BaomoiParse baomoiParse;

    public MainController(MainView view){
        this.mainView = view;
        view.addSortNewsByNewestListener(new SortNewsByNewestListener());
        view.addSortNewsByOldestListenner(new SortNewsByOldestListener());
    }

    public MainController() {
    }

    public void showTableListNews() throws Exception {
        ArrayList<newsModel> newsTableList = baomoiParse.getNewsFromHtml();
        mainView.setVisible(true);
        mainView.showListNews(newsTableList);
    }

    static class SortNewsByNewestListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                ArrayList<newsModel> list = new ArrayList<newsModel>();
                mainView.showListNews(baomoiParse.sortListByNewest(baomoiParse.getNewsFromHtml()));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    class SortNewsByOldestListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            try {
                ArrayList<newsModel> list = new ArrayList<newsModel>();
                mainView.showListNews(baomoiParse.sortListByNewest(baomoiParse.getNewsFromHtml()));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    class RefreshAllNews implements ActionListener{
        public void actionPerformed(ActionEvent e){
        }
    }
}
