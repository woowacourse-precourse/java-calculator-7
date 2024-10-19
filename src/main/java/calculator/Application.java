package calculator;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        ReceiveInput receiveInput = new ReceiveInput();
        String input = receiveInput.HandlingInput();

        ArrayList<Integer> numberList;

        char firstChar = input.charAt(0);
        if (Character.isDigit(firstChar)) {
            StartNumber startNumber = new StartNumber();
            numberList = startNumber.readNumInput(input);
        } else if (firstChar == '/') {
            StartSlash startSlash = new StartSlash();
            numberList = startSlash.readSlashInput(input);
        } else {
            throw new IllegalArgumentException();
        }

        Calculate calculate = new Calculate();
        System.out.println("결과 : " + calculate.AddNumbers(numberList));
    }
}
