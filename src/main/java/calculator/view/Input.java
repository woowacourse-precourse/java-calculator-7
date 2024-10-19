package calculator.view;

import java.util.Scanner;

public class Input {

    private Scanner scanner = new Scanner(System.in);

    public String scan() {
        return scanner.nextLine();
    }
}
