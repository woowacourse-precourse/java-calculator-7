package calculator;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public String getInputString(){
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public int[] sliceString(String input){
        String[] slice = input.split("[,;]");
        int[] numList = new int[slice.length];

        for (int i = 0; i < slice.length; i++) {
            numList[i] = Integer.parseInt(slice[i]);
        }
        return numList;
    }
}
