package calculator;

import camp.nextstep.edu.missionutils.Console;

class Printer{}
class Extraction{}
class Calculator{}


public class Application {
    public static void main(String[] args) {
        // Printer 객체 생성
        Printer printer = new Printer();

        // 객체 생성
        Extraction extraction = new Extraction();
        Calculator calculator = new Calculator();

        String inputStr = Console.readLine();

    }

}
