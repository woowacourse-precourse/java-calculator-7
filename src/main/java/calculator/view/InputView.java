package calculator.view;
import camp.nextstep.edu.missionutils.Console;
public class InputView {
    //TODO 입력 화면 구현

    //입력과 화면 출력을 구분
    public void printInputView() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
    }

    public String getInput() {
        return Console.readLine();
    }


}
