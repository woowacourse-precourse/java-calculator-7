package calculator;

import java.util.ArrayList;
import java.util.List;

public class Application {
    /** 구분자 목록 */
    public static List<String> separators = new ArrayList<>();

    public static void main(String[] args) {
        Application app = new Application();
        app.initSeparator();
    }

    private void initSeparator(){
        separators.add(",");
        separators.add(":");
    }
}