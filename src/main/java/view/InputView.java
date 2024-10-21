package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String getInput(){
        System.out.print("Write Input Value\n");
        String firstLine = readLine();
        if(firstLine == null){
            throw new NoSuchElementException("No Input Value");
        }
        if(firstLine.isEmpty()){
            Console.close();
            return "";
        }
        if(firstLine.startsWith("//")){
            String nextLine = readLine();
            Console.close();
            if(nextLine != null && !nextLine.isEmpty()){
                return firstLine + "\n" + nextLine;
            }
        }
        Console.close();
        return firstLine;
    }
}
