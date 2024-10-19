package calculator.domain.computer;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.domain.separator.Separator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Adder {

    private String inputValue;
    private String outputValue;
    private int sum = 0;
    private final Separator separator;
    private String separatedNumberString;

    public Adder() {
        this.separator = new Separator();
    }

    public void inPut() {
        try {
            inputValue = readLine();
            if (inputValue.isEmpty()) {
                System.out.println("결과 : 0");
            } else {
                outputValue = addAll(separator.separateString(inputValue)) + "";
                System.out.println("결과 : " + outputValue);
            }
        } catch (NoSuchElementException e) {
            System.out.println("결과 : 0");
        }

    }

    public int addAll(Queue<String> string) {
        System.out.println(string);
        while (!string.isEmpty()) {
            separatedNumberString = string.poll();
            try {
                if (Integer.parseInt(separatedNumberString) < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("허용되지 않은 문자가 포함되었습니다.");
            }

            sum += Integer.parseInt(separatedNumberString);
        }
        return sum;
    }

}
