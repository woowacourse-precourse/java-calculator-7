package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Vector;

import static java.lang.Character.isDigit;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String word = Console.readLine();

        int sum=0;

        boolean check =false;

        if(word.charAt(0)=='/'){
            if(word.charAt(1)=='/'&&word.charAt(3)=='\\'&&word.charAt(4)=='n'){
                check = true;
            }
        }


        if(check){
            Cal cal = new Cal(5,word.charAt(2),word,word.length());
            sum = cal.getSum();
        }


        else{
            if(!isDigit(word.charAt(0))){
                throw new IllegalArgumentException();
            }
            else{
                Cal cal = new Cal(0,'`',word,word.length());
                sum = cal.getSum();
            }

        }

        System.out.println("결과 : "+ sum);


    }
}
