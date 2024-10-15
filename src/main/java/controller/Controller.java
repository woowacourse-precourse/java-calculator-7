package controller;

public class Controller {

    public void run() {
        System.out.println("덧셈할 문자열을 입력해주세요.");
        String property = System.getProperty("file.encoding");
        System.out.println("property = " + property);
    }
}
