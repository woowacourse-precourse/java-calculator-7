# java-calculator-precourse

# 구현할 기능 목록
- View
    - [x] Input
    - [x] Output
- Model
    - [x] CustomDelimiterValidator
    - [x] Delimiter
    - [x] Status
    - [x] StringValidator
    - [x] NumberExtractor
    - [x] SumCalculator
- Controller
    - [x] StringCalculator
- Test
    - [x] CustomDelimiterValidatorTest
    - [x] StringValidatorTest
    - [x] NumberExtractorTest

# 기능 동작 순서
1. 입력 메세지를 출력한다. (View/Output) 
- 덧셈할 문자열을 입력해 주세요.
2. 문자열을 입력받는다. (View/Input)
3. 문자열에 커스텀 구분자가 있는지 판별한다. (Model/CustomDelimiterValidator)
- 구분자는 문자여야 한다.
- 커스텀 구분자는 문자열 앞부분의 "//"와 "\n" 사이에 위치해야 한다.
- 위 조건을 만족하지 않으면 IllegalArgumentException을 발생시킨다.
5. 구분자를 바탕으로 문자열의 유효성을 판별한다. (Model/StringValidator)
6. 문자열에 있는 정수를 분리하고 이를 리스트로 반환한다. (Model/NumberExtractor)
7. 정수의 합을 반환한다. (Model/SumCalculator)
8. 정답을 출력한다. (View/Output)
- 결과 : (정답)