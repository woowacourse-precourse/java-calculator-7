# 1. main은 사용자 및 계산기(하드웨어)

## 계산기 기본 설정을 세팅한다.

- CalculatorDependencyConfig를 통해 의존성 주입을 설정한다.
- 사용자는 CalculatorController를 갖는다.
- 사용자는 Calculator를 이용할 수 있는 View를 갖는다.

# 2. Controller

## CalculatorContoller

- 사용자가 요청할 수 있는 계산기 컨트롤러이다.
- CalculatorService에 계산(사용자 요청 값)을 요청한다.

# 3. Service

## CalculatorService

- DTO를 만들어 사용자 요청 값(inputString)을 감싼다.
- CalculationStrategySelector에 커스텀 구분자 방식, 기본 구분자 방식 중 하나 선택을 요청한다.
- 두 방식 중 하나를 통해 CaculationStrategy에 계산을 요청한다.

## CalculationStrategySelector

- 전략 선택기이다.
- DTO에서 사용자 요청 값을 가져와 요청 값 형식을 분석한다.(예외처리 가능)
- //의 유무를 통해 커스텀 구분자 방식, 기본 구분자 방식 중 하나를 선택한다.

## DefaultDelimiterCalculationStrategy

- 양수(양수 범위 제한x 즉, Long) 추출기에 양수 추출을 요청
- 추출된 모든 양수를 더함

## DefaultAndCustomDelimiterCalculationStrategy

- 커스텀 구분자 방식일 시 구분자 추출기에 구분자 추출을 요청
- 양수 추출기에 양수 추출을 요청
- 추출된 모든 양수를 더함

## CustomDelmiterExtractor

- PatternMatcherUtil을 이용해 커스텀 라인에서 String으로 구분자를 뽑아낸다.
- `(예시: "//$\n1$2$2" => "$")`
- 커스텀 구분자를 뽑아낸다.

## PositiveNumberExtractor

- 양수 라인을 PatternMatcherUtil을 이용해 뽑아낸다.
- `(예시: "//$\n1$2$2" => "1$2$2")`
- 구분자 분리 표현식 생성기에 구분자 분리 표현식을 요청
- 구분자 분리 표현식을 통해 양추 추출

## SplitPatternGenerator

- 커스텀 구분자 + 기본 구분자를 포함한 구분자 분리 표현식 생성
- 기본 구분자를 포함한 구분자 분리 표현식 생성

## PatternMatcherUtil

- PositiveNumber, CustomDelimiter에서 PatternMatcher가 반복되어 사용됨
- 리팩터링으로, 새로운 클래스를 만들어 책임 분산
- 패턴을 받아, String으로 return

# 4.Model

## CustomDelmiter

- 커스텀 구분자를 리스트 형식으로 저장(일급 컬렉션)
- 정적 팩토리 패턴으로 생성

## DefaultDelmiter

- 기본 구분자를 저장(Enum)
- 기본 구분자들을 가져옴.

## PositiveNumber

- 양수들을 리스트 형식으로 저장(일급 컬렉션)
- 정적 팩토리 패턴으로 생성
- 양수들의 합을 가져올 수 있음

## RegularExpression

- CustomLine을 추출하거나, NumberLine을 추출하는 표현식들을 저장
- 표현식을 가져올 수 있음

# 5. Config

## CalculatorDependencyConfig

- 의존성 주입기로 의존성들을 주입

# 6. Validator

- 모두 IllegalArgumentException을 Throw

## 방식을 선택할때, "//"로 시작하지 않는 경우

## 커스텀 구분자 라인이 형식에 맞지 않을 경우

- 커스텀 구분자에 같은 문자가 중복된 경우
- 커스텀 구분자가 숫자인 경우

## 숫자 추출 시 형식에 맞지 않을 경우()

- 설정하지 않은 구분자가 있을 경우
- 숫자로 시작하지 않을 경우

## `Exception 계속 추가 예정`

# 7. DTO

## CalculationRequestDTO

- 사용자 요청 입력을 저장
- 정적 팩토리 방식 생성

## CalculationResponseDTO

- 출력할(Response)를 저장
- 정적 팩토리 방식 생성