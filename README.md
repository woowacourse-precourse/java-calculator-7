# java-calculator-precourse

### 구현할 기능 목록

1. 입력값 처리
   1. null 문자열 처리
      - 입력 : null
      - 출력 : Error
   2. 입력값의 개수 처리
      - 입력 : "1,2,3" "1:2:3"
      - 출력 : Error

1. 공백 처리
    - 입력: "  1, 2, 3,  "
    - 결과: "1,2,3"

    - 입력: "     "
    - 결과: ""

1. 빈 문자열 처리
    - 입력: “”
    - 출력: 0

1. 쉼표(,) 구분자 처리
    - 입력: “1,2”
    - 출력: 3

1. 콜론(:) 구분자 처리
    - 입력: “1:2:3”
    - 출력: 6

1. 쉼표와 콜론 함께 처리
    - 입력: “1,2:3”
    - 출력: 6

1. 커스텀 구분자 처리
    - 입력: “//;\n1;2;3”
    - 출력: 6

1. 잘못된 커스텀 구분자 처리
    1. 구분자 형식이 잘못된 경우 (구분자 형식: `//[구분자]\n`)
        - 입력: “//\n”
        - 출력: Error
        - 입력: “//;1;2;3”
        - 출력: Error

1. 음수 입력 시 예외 처리
    - 입력: “-1:1,2”
    - 출력: Error

1. 문자 처리
    - 입력: “a:1,2”
    - 출력: Error

1. 기본 구분자와 커스텀 구분자 처리
    - 입력: “1,2:3//;\n4;5;6”
    - 출력: 21