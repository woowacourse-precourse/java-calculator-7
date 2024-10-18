# java-calculator-precourse

readInput() // 입력을 위한 기능. string 형식으로 input을 받고 return한다.

parseInput() // string으로 받은 입력을 구분하고 배열에 저장한다. 배열을 return한다.
    isCustomDivider() // 구분자가 default인지 custom인지 구분한다.
    parseDivider() // 만약 커스텀 구분자라면, 어떤 문자인지 파싱한다.
    normalizeInput() // 만약 커스텀 구분자라면, 입력에서 커스텀 구분자 부분을 제외한다. 정수로 형변환하기 용이하도록 하기 위해서이다.
    divideInput() // 구분자로 입력을 구분하고, 구분된 string들을 string 배열에 저장한다.

convertStringToInt() // 파싱된 string 배열을 int 배열로 변환한다. 여기서 int로 파싱할 수 없으면 예외를 발생시킨다. 예외를 발생시키는 부분을 다른 함수로 구분할 수 있는 방법을 찾아 봐야겠다.

calculateNumber() // int로 변환된 배열을 합한다.

showOutput() // 결과를 보여준다.