package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Application {
    static String input;
    private static Scanner scanner;

    static void Input() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        input=br.readLine();


    }
    public static void main(String[] args) throws IOException {
        // TODO: 프로그램 구현

        Input();
        try {
            scanner = new Scanner(input);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());


        }
        ArrayList<Integer> a=scanner.getOutput();

        for(int i=0;i<a.size();i++) {
            System.out.print(a.get(i) +" ");
        }
    }
}
