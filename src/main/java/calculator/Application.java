package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    static StringBuilder dividers = new StringBuilder(",:");

    public static void main(String[] args) {
        String input = inputFunc();
        input = inputCheck(input);
        answerCalc(input);
    }

    //Function inputFunc()
    //Role: Input save. If null given, return blank string.
    //Parameter:
    //Return: String
    private static String inputFunc() {
        String input = "";
        //setting dividers, getting inputs
        System.out.println("덧셈할 문자열을 입력해주세요.");
        try {
            return readLine();
        } catch (java.util.NoSuchElementException e) {
            return "";
        }
    }

    //Function inputCheck()
    //Role: checks for custom divider. if given, checks whether if it is in correct format.
    //      if wrong format, throws Error.
    //      return a correct format.
    //Parameter: String
    //Return: String
    private static String inputCheck(String input) {
        if (input.startsWith("//")) {
            int newlineidx = input.indexOf("\\n");
            //not a proper format of custom divider given
            if (newlineidx == -1) {
                throw new IllegalArgumentException("No Following \\n given in input");
            }
            //changing custom divider by ,
            String customdivider = input.substring(2, newlineidx);
            dividers.append(customdivider);
            return input.substring(newlineidx + 2);
        }
        return input;
    }


    //Function answerCalc()
    //Role: from the final input, return answer
    // divide by each divider
    // use numberCalc to add up the answer
    // if there is wrong character is given (not divider, not number) -> throw error
    //Parameter: String
    //Return: void
    private static void answerCalc(String input) {
        //check whether input is 0
        if (input == null || input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }
        // changing every divider to ,
        for (int i = 0; i < dividers.length(); i++) {
            input = input.replace(dividers.charAt(i), ',');
        }
        int answer = 0;
        //parsing numbers
        StringBuilder numbers = new StringBuilder();

        for (char c : input.toCharArray()) {
            //number given
            if (Character.isDigit(c)) {
                numbers.append(c);
            }
            //divider given
            else if (c == ',') {
                answer += numberCalc(numbers);
                numbers = new StringBuilder("");
            }
            //wrong character given
            else {
                throw new IllegalArgumentException("Not a available character given");
            }
        }
        answer += numberCalc(numbers);
        // Printing out
        System.out.println("결과 : " + answer);
    }

    //Function numberCalc
    //Role: Goes through the user's input.
    //      if number, save in a numbers.
    //      if divider is given:
    //          1. wrong format: (divider two in a row, ends or starts with divider) -> throw Error
    //          2. correct format-> if divider is given, returns the number that was saved.
    //          3. if the number was negative -> throw error
    //Parameter: StringBuilder
    //Return: int
    private static int numberCalc(StringBuilder numbers) {
        if (numbers.length() == 0) {
            throw new IllegalArgumentException("Null Given");
        }
        int actualnumber = Integer.parseInt(numbers.toString());
        if (actualnumber <= 0) {
            throw new IllegalArgumentException("Negative Number");
        }
        return actualnumber;
    }
}