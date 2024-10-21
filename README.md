# 문자열 덧셈 계산기

## 📌 프로젝트 소개
이 프로젝트는 **주어진 문자열에서 숫자를 추출하고 합산하는 기능**을 구현합니다.  
기본 구분자는 쉼표(`,`)와 콜론(`:`)을 사용하며, 사용자가 **커스텀 구분자**를 지정할 수도 있습니다.

---

## ✨ 주요 기능

1. **기본 덧셈 기능**
    - 쉼표(`,`) 또는 콜론(`:`)을 구분자로 사용하는 문자열의 숫자를 더한 결과를 반환합니다.  
      **예:** `"1,2:3"` → `6`

2. **커스텀 구분자 지원**
    - 문자열의 첫 부분에 `"//"`와 개행(`\n`) 사이에 **커스텀 구분자**를 지정할 수 있습니다.  
      **예:** `"//;\n1;2;3"` → 커스텀 구분자는 세미콜론(`;`), 결과는 `6`.

3. **유효성 검사 및 예외 처리**
    - 잘못된 형식의 입력이 들어올 경우 `IllegalArgumentException`을 발생시킵니다.
    - 음수 값이 입력되면 예외가 발생하며 프로그램이 종료됩니다.

---

## 🛠️ 코드 구조 설명

### 1. `StringCalculator` 클래스

- **기능:** 문자열을 파싱하고 숫자를 더하는 역할을 담당합니다.

#### 🔍 주요 기능 설명
- **기본 구분자 설정:** 쉼표(`,`)와 콜론(`:`)을 기본 구분자로 사용합니다.
- **커스텀 구분자 처리:**  
  `"//"`로 시작하는 문자열에서 커스텀 구분자를 추출하고, 이를 기준으로 문자열을 분리합니다.
- **숫자 합산:** 문자열을 숫자로 변환해 합산하며, **음수 값**이 포함되면 예외를 발생시킵니다.

#### 💡 코드 흐름
1. **입력 검증:** 문자열이 비어있거나 `null`인 경우 `0`을 반환합니다.
2. **커스텀 구분자 처리:** `"//"`로 시작하는 경우 구분자를 추출하고 이를 정규 표현식으로 변환합니다.
3. **문자열 분리:** 구분자를 사용해 문자열을 분리합니다.
4. **음수 값 검사 및 합산:** 음수 값을 발견하면 예외를 던지고, 모든 숫자를 더해 결과를 반환합니다.

---

### 2. `Application` 클래스

- **기능:** 프로그램의 진입점으로 사용자 입력을 받아 계산 결과를 출력합니다.

#### 💻 주요 기능
1. **사용자 입력:**  
   `Console.readLine()`을 통해 문자열을 입력받습니다.
2. **계산기 호출:**  
   `StringCalculator`를 사용해 입력된 문자열의 합을 계산합니다.
3. **결과 출력:**  
   계산 결과를 사용자에게 출력합니다.

---

## 🚨 예외 처리 방식

1. **입력 형식 오류:**
    - 커스텀 구분자를 지정했지만 개행(`\n`)이 없거나 형식이 올바르지 않을 경우 예외를 발생시킵니다.

2. **음수 입력:**
    - 입력된 숫자 중 음수가 포함된 경우 `IllegalArgumentException`을 발생시키고 프로그램을 종료합니다.

---

## 📋 코드 예시

### `StringCalculator.java`

```java
package calculator.util;

import java.util.regex.Pattern;

public class StringCalculator {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//";

    public static int calculateSum(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return 0;
        }

        String delimiter = DEFAULT_DELIMITER;

        if (inputString.startsWith(CUSTOM_DELIMITER)) {
            int delimiterIndex = inputString.indexOf("\\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다. 구분자가 없습니다.");
            }
            String customDelimiter = inputString.substring(2, delimiterIndex);
            delimiter = Pattern.quote(customDelimiter);
            inputString = inputString.substring(delimiterIndex + 2);
        }

        String[] splitNumbers = inputString.split(delimiter);
        int totalNumber = 0;

        for (String num : splitNumbers) {
            int number = Integer.parseInt(num);
            if (number < 0) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다. 값이 음수입니다.");
            }
            totalNumber += number;
        }

        return totalNumber;
    }
}


