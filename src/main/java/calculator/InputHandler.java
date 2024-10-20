package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {
    private String userResponse;
    private List<Integer> numbers;
    private List<String> separators = new ArrayList<>();

    // getter methods
    public String getUserResponse() {
        return userResponse;
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
    public List<String> getSeparators() {
        return separators;
    }

    // user input receiving
    public String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        userResponse = Console.readLine();
        return userResponse;
    }
    public String setUserInput(String userResponse) {
        this.userResponse = userResponse;
        return this.userResponse;
    }
    // Finding the custom separators.
    public List<String> setCustomSeparators() {
        // (*?) means Reluctant quantifiers
        Pattern pattern = Pattern.compile("//(.*?)\n");
        Matcher matcher = pattern.matcher(userResponse);
        // List to store all separators found

        // Find all matches in a loop
        while (matcher.find()) {
            separators.add(matcher.group(1).trim()); // Add separator, trim if needed
        }

        // Output all found separators
        if (separators.isEmpty()) {
            // System.out.println("No separators found.");
            return null;
        }
        return separators;
    }
    public void removeCustomSeparators() {
        Pattern pattern = Pattern.compile("//(.*?)\n");
        Matcher matcher = pattern.matcher(userResponse);
        userResponse = matcher.replaceAll("");
        // System.out.println(userResponse);
    }
    // user input handling
    public void parseInput() {
        List<Integer> result = new ArrayList<>();
        for(Character c: userResponse.toCharArray()) {
            if (c == ',') {
                separators.add(String.valueOf(c));
            }else if (c == ':') {
                separators.add(String.valueOf(c));
            }
        }
        // System.out.println(separators.toString());
        String[] tokens = userResponse.split(separators.toString());
        List<String> tokensList = Arrays.stream(tokens).toList();
        try {
            for(String token: tokensList) {
                result.add(Integer.parseInt(token));
            }
        } catch (NumberFormatException e){
            System.out.println("Invalid User Input");
        }
        this.numbers = result;
    }



}
