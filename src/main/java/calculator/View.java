package calculator;


public class View {
    public void calView(){
        Input input = new Input();



        System.out.println("덧셈할 문자열을 입력해 주세요");
        input.inputCal();
        input.inputSplit();
        System.out.println("결과 : "+input.sumToken());
    }


}
