package calculator;

import java.util.Scanner;

public class InputController {

    public static InputString getInputString(){
       Scanner scanner = new Scanner(System.in);
        return new InputString(scanner.nextLine());
    }
}
