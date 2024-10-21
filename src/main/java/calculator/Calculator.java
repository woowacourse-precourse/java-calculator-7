package calculator;
import java.util.ArrayList;

public class Calculator {
    private Parser parser = Parser.getInstance();

    public  int calculateSum(String input){

        ArrayList<Integer> parsedNums = parser.parseNums(input);

        return parsedNums
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

    }
}
