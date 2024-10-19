package calculator;


public class View {
    Input input = new Input();
    String inputStr;
    String[] tokens;

    public void calView(){
        System.out.println("덧셈할 문자열을 입력해 주세요");
        inputStr = input.inputCal();
        System.out.println(inputStr);
        tokens = input.inputSplit();
        for(String token : tokens){
            System.out.println(token);
        }
        System.out.println("결과 : "+input.sumToken());
    }


}
