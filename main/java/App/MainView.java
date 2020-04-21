package App;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class MainView extends JFrame{


    private JButton sortNewsByNewest;
    private JButton sortNewsByOldest;
    private JButton reFreshAllNews;

    private JTable newsTable;
    private JScrollPane jScrollPaneNewsTable;

    private String[] columnNames = new String[]{"Time", "Title", "Image", "Content", "Link"};
    private Object news = new Object[][]{};

    public MainView (){
        initComponent();
    }

    private void initComponent(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        sortNewsByOldest = new JButton("Newest");
        sortNewsByOldest = new JButton("Oldest");
        reFreshAllNews = new JButton("Refresh");
        jScrollPaneNewsTable = new JScrollPane();
        newsTable = new JTable();

        newsTable.setModel(new DefaultTableModel((Object[][]) news, columnNames));
        jScrollPaneNewsTable.setViewportView(newsTable);
        jScrollPaneNewsTable.setPreferredSize(new Dimension(480, 300));

        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setSize(800, 400);
        panel.setLayout(layout);
        panel.add(jScrollPaneNewsTable);

        panel.add(sortNewsByNewest);
        panel.add(sortNewsByOldest);
        panel.add(reFreshAllNews);

        layout.putConstraint(SpringLayout.WEST, sortNewsByOldest, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortNewsByOldest, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, reFreshAllNews, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, reFreshAllNews, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, sortNewsByNewest, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortNewsByNewest, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneNewsTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneNewsTable, 10, SpringLayout.NORTH, panel);

        this.add(panel);
        this.setTitle("NEWS");
        this.pack();
        this.setSize(800, 420);
        sortNewsByNewest.setEnabled(true);
        sortNewsByOldest.setEnabled(true);
    }

    public Date convertStringTimeToDate(String newsTime_raw) throws ParseException {
        String time_cooked = "";
        for (int i = 31; i < newsTime_raw.length(); i++) {
            time_cooked = time_cooked + newsTime_raw.charAt(i);
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm | dd/MM/yyyy");
        return simpleDateFormat.parse(time_cooked);
    }

    public void showListNews(ArrayList<newsModel> showThisList) throws ParseException {
        int size = showThisList.size();

        Object[][] news = new Object[size][5];
        for(int i = 0; i < showThisList.size(); i++){
            news[i][0] = convertStringTimeToDate(showThisList.get(i).getNewsTime());
            news[i][1] = showThisList.get(i).getNewsTitle();
            news[i][2] = showThisList.get(i).getNewsImg();
            news[i][3] = showThisList.get(i).getNewsContent();
            news[i][4] = showThisList.get(i).getNewsLink();
        }
        newsTable.setModel(new DefaultTableModel(news, columnNames));
    }

    public void actionPerformed(ActionEvent e){
    }

    public void addSortNewsByOldestListenner(ActionListener listener){
        sortNewsByOldest.addActionListener(listener);
    }

    public void addSortNewsByNewestListener(ActionListener listener){
        sortNewsByNewest.addActionListener(listener);
    }

    public void addRefreshListListenner(ActionListener listener){
        reFreshAllNews.addActionListener(listener);
    }
}

