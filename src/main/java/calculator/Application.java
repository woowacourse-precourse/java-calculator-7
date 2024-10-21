package calculator;

public class Application {
    public static void main(String[] args) {
            InputManger inputManger = new InputManger();
            String inputString = inputManger.input();

            InputStringManager inputStringManager = new InputStringManager();
            int[] inputList = inputStringManager.convert(inputString);

            ListAdder listAdder = new ListAdder();
            int result = listAdder.listAdd(inputList);

            System.out.println("결과 : "+result);
    }
}
