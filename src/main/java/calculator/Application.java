package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        List<Integer> changedNumber = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please input the number.");
        String input = sc.nextLine();

        String[] number = input.split("[, :]");

        for (String pureNumber : number) {
            changedNumber.add(Integer.parseInt(pureNumber.trim()));
        }

        int sum = 0;
        for (int i = 0; i < changedNumber.size(); i++) {
            sum += changedNumber.get(i);
        }

        System.out.println(sum);

        sc.close();
    }
}

