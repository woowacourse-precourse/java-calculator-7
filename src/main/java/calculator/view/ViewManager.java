package calculator.view;


import static camp.nextstep.edu.missionutils.Console.readLine;

public class ViewManager {
    public static final String INPUT_MESSAGE= "덧셈할 문자열을 입력해 주세요.";
    public static final String RESULT_MESSAGE= "결과 : %d";

    public String printInputMessage(){
        System.out.println(INPUT_MESSAGE);
        String input = readLine();
        input = input.replace("\\n", "\n");
        return input;
    }

    public void printResult(Integer sum){
        System.out.println(String.format(RESULT_MESSAGE,sum));
    }
}
