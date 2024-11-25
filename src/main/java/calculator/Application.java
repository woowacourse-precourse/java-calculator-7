package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private String res;
    private String delimiters = ",:";
    static String input;

    public static void main(String[] args) {

        // 프로그램 실행
        input = Console.readLine();  // Console API로부터 입력값 읽기
        Application app = new Application();
        app.run();
        System.out.println(app.output());
    }

    public void run() {
        addDelimiter();
        int calRes = cal();
        res = "결과 : " + calRes;
    }

    public String output() {
        return res;
    }

    private void addDelimiter() {
        if (input.startsWith("//")) {
            int delimiterEnd = input.indexOf("\\n");
            if (delimiterEnd != -1) {
                String customDelimiter = input.substring(2, delimiterEnd);
                delimiters += customDelimiter;
                input = input.substring(delimiterEnd + 2);
            } else {
                throw new IllegalArgumentException("wrong type.");
            }
        }
    }

    private int cal() {
        String[] tokens = input.split("[" + delimiters + "]");
        int ans = 0;
        for (String token : tokens) {
            if (!token.isEmpty()) {
                int num = Integer.parseInt(token);
                if (num < 0) { throw new IllegalArgumentException("negative num detected."); }
                ans += num;
            }
        }
        return ans;
    }
}
