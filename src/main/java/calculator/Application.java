package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        View view = new View();
        view.printInputMessage();

        String input = Console.readLine();
        NumberList numberList = new NumberList(input);

        view.printResult(numberList.getSum());
    }
}
