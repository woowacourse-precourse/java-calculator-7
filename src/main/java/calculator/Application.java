package calculator;

public class Application {
    //의존성 주입
    private final InputHandler inputhandler;
    private final StringSplitter stringsplitter;

    //의존성 주입 후 객체 생성
    public  Application(InputHandler inputhandler, StringSplitter stringsplitter) {
        this.inputhandler = inputhandler;
        this.stringsplitter = stringsplitter;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application(new InputHandler(), new StringSplitter());
        String[] input = application.run();
        for (String str : input) {
            System.out.println(str);
        }
    }

    //사용자 입력 문자열 반환
    public String[] run() {
        return stringsplitter.CustomSplitter(inputhandler.UserInput());
    }
}