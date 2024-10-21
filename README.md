# java-calculator-precourse


1. 빈 문자열 입력 처리
  
- 입력: ""  
- 출력: 0  
- Commit: feat: 빈 문자열 입력 처리 기능 구현  


2. 쉼표(,) 또는 콜론(:)을 구분자로 사용하는 문자열 처리

- 입력: "1,2" 또는 "1:2"  
- 출력: 숫자의 합 (예: 3)  
- Commit: feat: 쉼표와 콜론 구분자 처리 기능 구현  


3. 커스텀 구분자 지원

- 입력 형식: "//[구분자]\n[숫자들]"  
- 예시 입력: "//;\n1;2;3"  
- 출력: 지정된 구분자로 분리된 숫자들의 합 (예: 6)  
- Commit: feat: 커스텀 구분자 지원 기능 구현  


4. 잘못된 입력 처리

- 숫자가 아닌 값이 포함된 경우 IllegalArgumentException 발생  
- 음수가 입력된 경우 IllegalArgumentException 발생  
- Commit: feat: 잘못된 입력 처리 기능 구현  


5. 애플리케이션 실행 로직 구현

- Application 클래스의 main() 메소드 구현  
- 사용자 입력 처리 및 결과 출력  
- Commit: feat: 애플리케이션 실행 로직 구현  
