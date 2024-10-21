package calculator;

public class Calculator {

    private String readLine;
    private String separator = "[:,]";

    public Calculator(String readLine) {
        this.readLine = readLine;
        checkCustom();
    }

    public void run() {

        System.out.println("결과 : "+ sum());

    }

    private void checkCustom() {

        if (readLine.startsWith("//")) {
            separator = readLine.substring(2, 3);
            readLine = readLine.substring(readLine.indexOf("n") + 1);
        }
    }

    private int sum(){

        String[] strNum = readLine.split(separator);

        int sum = 0;
        for (String s : strNum) {
            int num = Integer.parseInt(s);
            if(num < 0) throw new IllegalArgumentException("잘못된 값을 입력했습니다.");
            sum += num;
        }

        return sum;
    }

}
