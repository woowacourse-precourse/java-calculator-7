package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String str = Console.readLine();

        String[] parts = str.split("\\\\n");
        String delimiter = ",|:";
        String numbers = parts[0];

        if(numbers.startsWith("//")) {
            delimiter = delimiter + "|" + numbers.charAt(2);
            numbers = parts[1];
        }

        String[] number = numbers.split(delimiter);


    }
}
