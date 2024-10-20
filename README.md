# java-calculator-precourse

# 문자열 덧셈 계산기

사용자가 입력한 문자열에서 숫자를 추출하여 덧셈을 수행하는 계산기입니다.  
쉼표(,)와 콜론(:)을 기본 구분자로 하며, 커스텀 구분자를 지정할 수 있습니다.  
잘못된 입력 값이 주어진 경우 IllegalArgumentException을 발생시켜 애플리케이션을 종료합니다.

## 기능 구현 사항

1. 입력받은 문자열에서 기본 구분자 혹은 커스텀 구분자를 통해 숫자를 추출하는 기능
    1. 커스텀 구분자는 하나 또는 그 이상으로 설정 가능
2. 사용자가 잘못된 값을 입력하는 경우 IllegalArgumentException 에러를 발생시키는 기능
    1. 음수를 입력하는 경우
    2. 입력값에 공백이 포함되는 경우 (단, 공백이 커스텀 구분자르 지정되는 경우를 제외)
    3. 문자를 입력하는 경우
