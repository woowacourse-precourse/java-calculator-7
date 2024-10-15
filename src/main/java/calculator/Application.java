package calculator;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input  = scanner.nextLine();
        String[] spiltedNumber = input.split("[:,]");
        int sum=0;
        for(String number:spiltedNumber){
            int num = Integer.parseInt(number);
            sum +=num;
        }
        System.out.println(sum);
    }
}
