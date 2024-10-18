# 문자열 덧셈 계산기

## [개요]
입력한 문자열에서 숫자를 추출하여 더하는 계산기입니다.
<br/>
<br/>
## [기능 목록]
1. **문자열 입력 기능**
    - 구분자를 포함한 문자열을 입력받습니다.
      ```
          ex) 덧셈할 문자열을 입력해 주세요.
              //;\n1;2;3
      ```

2. **문자열 분리 기능**
    - 입력받은 문자열에서 커스텀 구분자와 덧셈할 문자열을 나누어 저장합니다.
      ```
          ex) 입력받은 문자열이 //;\n1;2;3 일 경우,
              - 커스텀 구분자: ;
              - 덧셈할 문자열: 1;2;3
      ```
    
3. **문자열 유효성 검사 기능**
    - 덧셈할 문자열에 기본 구분자(쉼표(,), 콜론(:))와 커스텀 구분자, 숫자 이외의 문자가 포함되어 있는지 확인합니다.
   <br/>


    
3. **숫자 합계 계산 기능**
    - 덧셈할 문자열에서 숫자를 추출하고, 합계를 계산하여 반환합니다.
       ```
          ex) "1;2;3"의 경우 6을 반환합니다.
       ```

