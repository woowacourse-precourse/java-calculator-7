package calculator.domain;


public class User {
    public User(String userString) {
        String[] userStringArray = substringUserStrings(userString);
    }

    private String[] substringUserStrings(String userString) {
        String[] userStringArray = new String[userString.length()];
        for (int i = 0; i < userString.length(); i++) {
            userStringArray[i] = userString.substring(i, i + 1);
        }
        return userStringArray;
    }
}