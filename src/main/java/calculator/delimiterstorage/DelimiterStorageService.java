package calculator.delimiterstorage;

import java.util.HashSet;

public interface DelimiterStorageService {
    public void delimeterStore(String s);
    public HashSet<Character> getDelimiters();
}
