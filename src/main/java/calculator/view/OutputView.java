package calculator.view;

public class OutputView {

    public void printResult(double value){
        Object result = determine_type(value);
        System.out.println("결과 : " + result);
    }

    private Object determine_type(double result){
        if(result%1 == 0){
            return (long) result;
        }
        return result;
    }

}
