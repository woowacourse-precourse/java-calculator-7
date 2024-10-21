package calculator;

public class CharacterBuffer {
    private final char [] arr;
    private int cursor;

    public CharacterBuffer(String str) {
        arr = str.toCharArray();
        cursor = -1;
    }
    boolean hasNext() {
        return cursor + 1 < arr.length;
    }
    char next() {
        cursor += 1;
        return arr[cursor];
    }
    char prev() {
        cursor -= 1;
        return arr[cursor];
    }
}
