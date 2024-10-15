package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    static BufferedReader br;

    public Input(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String nextLine(){
        String str = "";
        try{
            str = br.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return str;
    }

}
