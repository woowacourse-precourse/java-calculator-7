package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Application app = new Application();
        String input = app.userInputManager();
        int Result = app.InputSeparator(input);
        app.outputManager(Result);
    }
    public String userInputManager(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
    public void outputManager(int result){
        System.out.println("결과 : " + result);
    }
    public int InputSeparator(String userInput) {
        int sum = 0;
        String defaultDelimiter = "[,:]";

        if (userInput.isEmpty()) {
            return 0;
        }

        String numbers = userInput.trim();

        if (numbers.startsWith("//")) {
            int newLineIndex = numbers.indexOf("\\n");
            if (newLineIndex == -1) {
                throw new IllegalArgumentException("잘못된 값입니다.");
            }

            String customDelimiter = numbers.substring(2, newLineIndex);
            if(customDelimiter.isEmpty() || customDelimiter.contains(",") || customDelimiter.contains(":")){
                throw new IllegalArgumentException("잘못된 값입니다.");
            }
            numbers = numbers.substring(newLineIndex + 2);

            String[] delimiters = new String[]{customDelimiter, ",", ":"};

            for (String delim : delimiters) {
                numbers = numbers.replace(delim, ",");
            }
        }

        String[] nums = numbers.split(defaultDelimiter);

        for (String num : nums) {
            if (isParse(num)) {
                int value = Integer.parseInt(num);
                if (value <= 0) {
                    throw new IllegalArgumentException("잘못된 값입니다.");
                }
                sum += value;
            } else {
                throw new IllegalArgumentException("잘못된 값입니다.");
            }
        }
        return sum;
    }
    public boolean isParse(String inputStr){
        try
        {
            Integer.parseInt(inputStr);
            return true;
        }
        catch (IllegalArgumentException e)
        {
            return false;
        }
    }
}
