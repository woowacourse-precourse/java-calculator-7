package calculator.view;

public class OutView {

    public void printResult(int result){
        System.out.println("결과: "+result);
    }

    public void printError(String message){
        System.out.println("오류 발생: "+message);
    }
}
