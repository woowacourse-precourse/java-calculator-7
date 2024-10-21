# java-calculator-precourse
: 입력한 문자열에서 숫자를 추출하여 더하는 계산기

</br>

## 기능 목록
- **사용자 문자열 입력**  
   - `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용하여 문자열 입력

- **입력받은 문자열에서 숫자 추출**  
   1. 기본 구분자(쉼표(,) 및 콜론(:))를 사용하는 경우
   2. 커스텀 구분자를 사용하는 경우
   3. 빈 문자열인 경우, 0 반환

- **예외 처리 : `IllegalArgumentException`**  
   1. 숫자에 음수가 있는 경우
   2. 구분자가 아닌 문자가 있는 경우

- **각 숫자의 합 반환**