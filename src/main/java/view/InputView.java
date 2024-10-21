package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String getInput(){
        System.out.print("Write Input Value\n");
        String input = readLine();
        if(input == null){
            throw new NoSuchElementException("No Input Value");
        }
        if(input.isEmpty()){
            Console.close();
            return "";
        }
        Console.close();
        return input;
    }
}
