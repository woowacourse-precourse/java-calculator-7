package calculator.io.writer;

public class SystemOut implements Output{
    @Override
    public void outputString(Integer totalSum) {
        System.out.println("결과 : " + totalSum);
    }
}
