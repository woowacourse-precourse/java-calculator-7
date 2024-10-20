# java-calculator-precourse
### Application.java
* 사용자에게 문자열 입력
* 입력받은 문자열을 구분자를 이용하여 나눈 뒤 합계를 출력

### Spliter.java
* Application.java 에서 입력받은 문자열을 객체의 생성자로 전달
* 문자열을 구분자 바탕으로 분리 후 숫자의 합 계산


      [Method 정의]
      1. Method 'calculate'
         * Return Type - Void
         * 기능
            - 문자열에서 구분자를 통해 나누고 나눈 숫자들의 합을 계산

      2. Method 'generateCustomSeparator'
         * Return Type - Void
         * 기능
            - 커스텀 구분자가 있으면 추가

      3. Method 'sum'
         * Return Type - Void
         * 기능
            - String[] result 값을 넘겨 받아 배열에 있는 값들의 합을 계산
      
      4. Method 'inNum'
         * Return Type - Boolean
         * 기능
            - 특정 인덱스에 해당하는 값의 자료형이 int형 인지 판단

      5. Method 'inspectionValue'
         * Return Type - Boolean
         * 기능
            - split 된 배열에 잘못된 값이 입력되어 있으면 IllegalArgumentException 발생

      6. Method 'getResultValue'
         * Return Type - Integer
         * 기능
            - 결과 값 출력을 위한 resultValue 호출 메서드