package calculator.parser;

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
    public void getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        userResponse = Console.readLine();
        System.out.println(userResponse);
    }
    public String setUserInput(String userResponse) {
        this.userResponse = userResponse;
        return this.userResponse;
    }
    // Finding the custom separators.
    public List<String> setCustomSeparators() {
        // (*?) means Reluctant quantifiers
        Pattern pattern = Pattern.compile("//(.*?)\\\\n");
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
        Pattern pattern = Pattern.compile("//(.*?)\\\\n");
        Matcher matcher = pattern.matcher(userResponse);
        userResponse = matcher.replaceAll("");
        // debugging output
        // System.out.println("after removing: " + userResponse);
    }
    // user input handling
    public void parseInput() {
        List<Integer> result = new ArrayList<>();
        // Add default separators
        separators.add(",");
        separators.add(":");

        // Build a regex pattern to match any of the separators
        String regex = String.join("|", separators.stream()
                .map(Pattern::quote)  // Escape special characters
                .toList());

        // Split the user input using the regex
        String[] tokens = userResponse.split(regex);

        try {
            for (String token : tokens) {
                int number = Integer.parseInt(token.trim());

                // If a negative number is found, throw an exception
                if (number < 0) {
                    throw new IllegalArgumentException("Negative numbers are not allowed: " + number);
                }

                result.add(number);
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid User Input");
        }

        // Store the parsed numbers
        this.numbers = result;
    }
}