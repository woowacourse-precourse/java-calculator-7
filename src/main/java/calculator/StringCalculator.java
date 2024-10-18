package calculator;

import camp.nextstep.edu.missionutils.Console;

public class StringCalculator {

    public void run(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        UserInput userInput = new UserInput(input);
        String defaultDelimiter = "[,:]";
        DefaultDelimiter defaultDelimiters = new DefaultDelimiter(defaultDelimiter);
        DelimiterResult delimiterResult = new DelimiterResult(defaultDelimiters.getDefaultDelimiter());

        if(userInput.isCustom()){
            int customDelimiterEndIndex = userInput.getUserInput().indexOf("\\n");
            String customDelimiter = userInput.getUserInput().substring(2,customDelimiterEndIndex);
            String updateDelimiter = delimiterResult.getDelimiterResult().replace("]", customDelimiter + "]");
            delimiterResult = new DelimiterResult(updateDelimiter);

        }




    }

}
