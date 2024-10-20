package calculator;

public class Application {
    public static void main(String[] args) {
        InputString inputString = new InputString();
        StringCheck stringCheck = new StringCheck();
        SplitString splitString = new SplitString();
        AddNum addNum = new AddNum();

        String input = inputString.input();
        String separators = stringCheck.checkSeparator(input);
        String[] splitNum = splitString.splitString(input, separators);
        int answer = addNum.add(splitNum);

        System.out.println("결과 : " + answer);
    }
}