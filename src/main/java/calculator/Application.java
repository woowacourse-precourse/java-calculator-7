package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현f

        try {
            System.out.println("write add.");
            String input1 = camp.nextstep.edu.missionutils.Console.readLine();
            Test1.add(input1);
            String input2 = camp.nextstep.edu.missionutils.Console.readLine();
            Test2.custom(input2);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(1); // 애플리케이션 종료
        }
    }
}
