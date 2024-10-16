package calculator.view;

public class OutputView {
    private static final String INPUT_NUMBERS = "덧셈할 문자열을 입력해 주세요.";
    private static final String GAME_RESULT = "결과 : ";
    public void printInputNumbers(){
        System.out.println(INPUT_NUMBERS);
    }
    public void printGameResult(int result){
        System.out.println(GAME_RESULT+result);
    }
}
