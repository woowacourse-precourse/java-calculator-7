package calculator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Parser {

    public static ArrayList<String> separators = new ArrayList<String>();

    public static void parseSeperator(String input) {

        initialSeprator();
        if(input.substring(0,2).equals("//") && input.substring(3,5).equals("\\n")){
               separators.add(input.substring(2,3));
        }
//        System.out.println("input : " + input);
//        System.out.println("separator : "  + separators.toString());

    }


    private static void initialSeprator(){
        separators.clear();
        separators.add(",");
        separators.add(":");
    }



}