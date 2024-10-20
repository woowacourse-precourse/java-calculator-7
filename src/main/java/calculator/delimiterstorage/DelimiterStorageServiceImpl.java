package calculator.delimiterstorage;

import java.util.HashSet;

public class DelimiterStorageServiceImpl implements DelimiterStorageService {
    private HashSet<Character> delimiters= new HashSet<Character>();



    public DelimiterStorageServiceImpl() {
        delimiters.add(':');
        delimiters.add(',');
    }
    @Override
    public HashSet<Character> getDelimiters() {
        return delimiters;
    }

    @Override
    public void delimeterStore(String s) {
        if (s.length()<=5){
            return;
        }
        if (s.charAt(0)=='/' && s.charAt(1)=='/' && s.charAt(3)==92 && s.charAt(4)=='n'){
            delimiters.add(s.charAt(2));
        }

    }
}
