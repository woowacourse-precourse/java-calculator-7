package calculator.parser.delimiter;

public enum CustomDelimiterPrefix {

   START("//", 0),
   END("\n", 3);

   private final String prefix;
   private final int startIndex;

   CustomDelimiterPrefix(String prefix, int startIndex) {
      this.prefix = prefix;
      this.startIndex = startIndex;
   }

   public String getPrefix() {
      return prefix;
   }

   public int getStartIndex() {
      return startIndex;
   }

   public int getEndIndex() {
      return startIndex + prefix.length();
   }
}
