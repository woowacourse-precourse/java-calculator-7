package calculator;


public class View {
    public void calView(){
        Input input = new Input();

        String inputStr;
        String[] tokens;

        System.out.println("덧셈할 문자열을 입력해 주세요");
        inputStr = input.inputCal();
        tokens = input.inputSplit();
        System.out.println("결과 : "+input.sumToken());
    }


}
