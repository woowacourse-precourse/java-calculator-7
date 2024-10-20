package calculator;

import java.sql.SQLOutput;

public class Application {
    int add(String text) {
        if (text.isEmpty()) {
            return 0;
        }

        if(text.contains(",") || text.contains("\n")) {
            String[] numbers = text.split(",|\n");
           // return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
            int sum =0;
            for(int i=0; i < numbers.length; i++) {
                sum += Integer.parseInt(numbers[i]);
            }
            return sum;
        }
        return Integer.parseInt(text);
    }

    public static void main(String[] args) {
       Application app = new Application();
        System.out.println("value is empty : " + app.add(""));
        System.out.println("value is number one : " + app.add("1"));
        System.out.println("value is number two : " + app.add("1,2"));
        System.out.println("value is number three : " + app.add("1,2,3"));
        System.out.println("value is number four : " + app.add("1,2,3,4"));
        System.out.println("value is number three : " + app.add("1,2\n3"));
        System.out.println("value is number three : " + app.add("1\n2\n3"));


    }
}
