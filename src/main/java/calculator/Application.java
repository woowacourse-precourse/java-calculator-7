package calculator;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        System.out.println("1,2,3 = " + calculator.addNumber("1,2,3"));
        System.out.println("1:2:3 = " + calculator.addNumber("1:2:3"));
        System.out.println("1,2:3 = " + calculator.addNumber("1,2:3"));


        System.out.println("//;\n1;2;3 = " + calculator.addNumber("//;\n1;2;3"));
        System.out.println("//@\n2@3@4 = " + calculator.addNumber("//@\n2@3@4"));


//        System.out.println("'' = " + calculator.addNumber(""));
//        System.out.println("' ' = " + calculator.addNumber(" "));


        System.out.println("//.\n1.2.3 = " + calculator.addNumber("//.\n1.2.3"));
        System.out.println("//*\n1*2*3 = " + calculator.addNumber("//*\n1*2*3"));

    }
}
