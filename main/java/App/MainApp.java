package App;

import App.*;

public class MainApp {
    public static void main(String[] args) throws Exception{
            MainView view = new MainView();
            MainController controller = new MainController(view);
            controller.showTableListNews();
    }
}
