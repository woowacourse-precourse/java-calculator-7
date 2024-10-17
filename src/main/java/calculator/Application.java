package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {
    static String input;
    private static AdderScanner adderScanner;
    private static Adder adder;

    static void Input() throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        input=br.readLine();
        //System.out.println("input:" +input);


    }
    public static void main(String[] args) throws IOException {
        // TODO: 프로그램 구현

        Input();
        try {
            adderScanner = new AdderScanner(input);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());


        }
        adder=new Adder(adderScanner);



    }
}
