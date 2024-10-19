package calculator.util;

public class TestEvironment {
    public static boolean isRunningInTest() {
      for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
        if (element.getClassName().startsWith("org.junit.")) {
          return true;
        }
      }
      return false;
    }
}
