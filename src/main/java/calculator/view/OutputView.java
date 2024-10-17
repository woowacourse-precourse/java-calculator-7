package calculator.view;

public class OutputView {
    public void askInput(){
        System.out.print("덧셈할 문자열을 입력해 주세요.");
    }

    public void printAnswer(int answer){
        System.out.print("결과 : " + answer);
    }
}
