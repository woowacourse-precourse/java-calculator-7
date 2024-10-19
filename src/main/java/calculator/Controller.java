package calculator;


import static camp.nextstep.edu.missionutils.Console.readLine;

public class Controller {

    private static final String INPUT_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_MESSAGE = "결과 : ";

    private Service service;


    public Controller(){
        this.service = new Service();
    }

    public void run(){
        String userInput = input();
        Integer sum = service.calc(userInput);
        output(sum);
    }

    private String input(){
        System.out.println(INPUT_MESSAGE);
        String inputField = readLine();
        return service.checkCustomSeparator(inputField);
    }

    private void output(Integer result){
        System.out.print(OUTPUT_MESSAGE + result);
    }





}
