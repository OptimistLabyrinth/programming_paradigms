가 나 다 라 마 바 사 아 자 차 카 타 파 하 가 나 다 라 마 바 사 아 자 차 (velog 한 줄)
가 나 다 라 마 바 사 아 자 차 카 타 파 하 가 나 다 라 마 바 사 아 자 차 (linkedin 한 줄)
가 나 다 라 마 바 사 아 자 차 카 타 파 하 가 나 다 라 마 바 사 아 자 (facebook 한 줄)

---------- ---------- ---------- ---------- ----------

# [6] 함수형 원리로 리팩터링하는 예제 1 - 액션, 계산, 데이터
URL ( 함수형-프로그래밍-시작해보기-6-액션-계산-데이터 )

[actions-calculations-data]()

이제는 실제 코드 예시를 리팩터링하는 과정을 직접 보면서
어떤식으로 함수형 프로그래밍의 원리를 코드에 적용하는지 살펴보자.

함수형 프로그래밍에서는 모든 구성요소를 크게 세 가지로 분류한다.

첫번째 액션(actions) 는 부수효과를 일으키는 함수이다.
다른 말로는 비순수 함수(impure function),
순수하지 않은 함수 라고 한다.

두번째 계산(calculations) 는 앞에서 언급한
순수 함수(pure function)를 말한다.
순수 함수가 되는 특성은
참조 무결성(referential transparency) 이라고도 한다.

세번째 데이터(data) 는 벌어진 사건들에 대한 객관적 사실을 의미한다.
함수형 프로그래밍에서 모든 로직을 작성하는데
기반이 되는 정보를 담고 있다.

[장보기 과정]()

그런데 actions, calculations, data 로 분류하는 것은
프로그래밍에서 뿐만 아니라 세상 모든 것을 바라볼때
적용할 수 있는 관점이다.

위의 그림처럼 장보기 프로세스를 정리한다고 해보자.
처음에 냉장고를 확인해서 어떤 재고가 남았나 확인하고
운전해서 상점으로 간 후에
필요한 항목들을 구매해서 챙긴 후
다시 운전해서 집으로 돌아오고
사 온 음식을 전부 다 냉장고에 집어넣으면
장보기 활동이 끝난다.

[필요한 것 구입하기]()

이 중에서 장보기 목록을 작성하는 과정을 자세히 살펴보자.
장보기 목록은
내가 필요로 하지만
내가 지금 가지고 있지 못한 것 목록을 말한다.
그러므로 (필요한 재고) - (현재 재고) = (장보기 목록) 과 같은
공식을 도출할 수 있다.
이걸 액션, 계산, 데이터라는 관점에서 분류해보면

현재 재고는 데이터이고
필요한 재고도 데이터이고
필요한 재고에서 현재 재고를 빼는 것은 계산이 된다.
장보기 목록도 데이터가 되고
목록에 있는 걸 구입하는건 액션이라고 할 수 있다.

[장보기 과정을 분류한 다이어그램]()

장보기 과정에 포함된 여러가지 요소를 액션, 계산, 데이터로 분류해서
다이어그램을 다시 그려보면 위에 그림과 같이 된다.
냉장고 확인, 운전해서 상점으로 가기는 액션이다.
현재 재고, 필요한 재고는 데이터이고 재고를 빼는 동작은 계산이다.
장보기 목록도 데이터이고
목록에 있는 것을 구입하기, 운전해서 집으로 오기는 액션에 해당한다.

이런식으로 액션, 계산, 데이터가 뭔지 감을 잡았으니까
이제는 간단한 요구조건을 바탕으로
실제 코드에 적용하는 예시를 살펴보자.

[기능1 - 장바구니에 담은 물품 가격 총합을 실시간으로 보여줌]()

MegaMart 라는 e-commerce 서비스가 있다고 해보자.
여기서는 이해를 돕기 위해 장바구니 기능으로 범위를 좁혀서 생각한다.
장바구니 관련해서 첫번째 요구조건은
사용자가 장바구니에 물건을 담거나 빼거나 할때
UI 상에 실시간으로 장바구니 물품 가격의 합을 보여준다는 것이다.

[기능2 - 상품 목록에서 어떤걸 장바구니에 추가할때 20 달러 이상이 되면 무료배송 아이콘]()

두번째 요구조건은
MegaMart 에서는 한번에 20 달러 이상을 구매하면
모든 물품을 무료배송하기로 결정했다.
사용자가 화면에서 상품 목록을 보고 있을때
어떤 물품을 장바구니에 추가했을때 가격 총합이 20 달러 이상이 된다면
해당 물품 옆에 "무료 배송 가능!" 이라는 걸 알려주는
아이콘을 달아서 표시한다.

[기능3 - 장바구니 금액 합계가 바뀔때마다 세금을 다시 계산한다]()

세번째 요구조건은
장바구니에 담은 물품 목록에 변화가 생길때마다
세금을 다시 계산해서 별도의 위치에 저장해두어야 한다.

이렇게 세 가지 요구조건을 기억하면서
하나씩 코드로 구현해보자.

[첫번째 요구조건 구현 코드]()

첫번째 요구조건을 구현하면 이렇게 된다.

[두번째, 세번재 요구조건 구현 코드]()

두번째, 세번째 요구조건을 구현하면 이렇게 된다.

[액션에서 게산 빼내기 코드]()

액션은 코드 전체로 퍼져나간다.
어떤 함수에 순수하지 않은 부분,
즉 부수효과(side effect)를 일으키는 부분이 하나라도 있다면
그 함수는 전체가 액션(action)이 된다.

그러므로 액션 함수 또는 비순수 함수에서
계산 영역을 분리해내서 순수 함수로 만드는 것이 좋다.

[암묵적 입출력을 명시적 입출력으로 바꾸기 코드]()

모든 함수는 입력과 출력이 있다.
입력과 출력은 크게 분류해서 명시적 입출력과 암시적 입출력으로 나눌 수 있다.
함수에 암묵적 입출력 요소가 하나라도 있으면
그 함수는 액션, 즉 비순수 함수가 된다.

명시적 입력은 함수 내부구현에 사용하는 정보를
오직 함수 파라미터를 통해서 얻는 것을 의미하고
명시적 출력은 함수 실행 결과를
오직 함수 반환값을 통해서 얻는 것을 의미한다.

어떤 함수가 명시적 입출력만 이용해서 내부구현을 완료할 수 있어야만
그 함수는 순수 함수가 된다.

[최대한 명시적 입출력으로 만들기 코드]()

암시적 입출력이 있는 부분을 찾아서 명시적 입출력으로 만드는
리팩터링 작업을 조금 더 한다.

[입력값을 변경하는 경우, 커피 온 라이트(Copy-On-Write) 적용하기 코드]()

순수 함수 내에서 입력 파라미터로 받는 어떤 항목을
수정, 변경해야 하는 경우가 있더라도
모든 변수들에 대해서 불변성(immutability)을 유지해야만 한다.
그래야 순수 함수는 그대로 순수 함수로 남을 수 있다.
그걸 가능하게 만드는 방법 중에 하나가 Copy-On-Write 방식이다.

여기서는 입력으로 받은 배열에 항목 하나를 추가해야 하므로
다음과 같은 플로우를 따른다.
(시작) 수정하려는 배열 전체를 복사
-> 새로운 배열을 얻음
-> 새로운 배열에 항목을 하나 추가
-> 새로운 배열을 반환
배열이 아니라 어떤 형태의 변수를 다루더라도
비슷한 원리로 Copy-On-Write 를 구현하면 된다.

함수형 프로그래밍은 전혀 어렵지 않다.
누구라도 당장에
자신의 코드베이스에서 함수형 프로그래밍을 시작할 수 있다.

딱 두 가지 원칙만 지키면 된다.

<참조>
책, [쏙쏙 들어오는 함수형 코딩](https://jpub.tistory.com/1265) 3장, 에릭 노먼드, 김은민, 2022
책, [쏙쏙 들어오는 함수형 코딩](https://jpub.tistory.com/1265) 4장, 에릭 노먼드, 김은민, 2022
책, [쏙쏙 들어오는 함수형 코딩](https://jpub.tistory.com/1265) 5장, 에릭 노먼드, 김은민, 2022
책, [쏙쏙 들어오는 함수형 코딩](https://jpub.tistory.com/1265) 6장, 에릭 노먼드, 김은민, 2022

---------- ---------- ---------- ---------- ----------

# [7] 함수형 원리로 리팩터링하는 예제 2 - 고차함수, 일급객체
URL ( 함수형-프로그래밍-시작해보기-7-고차함수-일급객체 )

함수형 프로그래밍의 독특한 특징은
평범한 변수 뿐만 아니라 함수조차도 변수처럼 사용할 수 있다는 점이다.
그래서 함수형 프로그래밍에서는 모든 함수가 언제든
고차함수가 될 수 있다.
고차함수는 파라미터로 어떤 함수를 입력받거나
출력값으로 함수를 반환하는 함수를 의미한다.
둘 중에 하나만 하더라도 고차함수라고 부른다.
그리고 이렇게 파라미터로 전달하거나 반환값으로 받는 함수를
일급객체라고 부른다.

이런 고차함수, 일급객체 라는 특성을 활용하면
함수형 프로그래밍의 원리를 따르는 코드는
프로그래머에게 레고 블럭 놀이를 하는 것 같은 인상을 준다.
전체 프로그램을 완성하기 위해서
작은 단위의 함수를 모아서 사용해서
이렇게 조합한 결과로 나온 중간 단위 함수를 적절하게 조합해서
큰 단위 함수를 만들고
이 큰 단위 함수를 또 모아서 재배치한 후에 호출하면
마침내 전체 프로그램을 완성하게 된다.

이게 어떤 느낌인지는 예제 코드를 통해서 확인해보자.

[user info list 구현 코드]()

사용자 목록을 가지고
필요한 정보를 추출하는 기능을 개발한다고 가정해보자.

사용자 정보는 아이디(id), 이름(name), 나이(age) 를 담고 있다.

상세한 요구조건을 정리하면 다음과 같이 두 가지가 있다.

* (1) 나이가 30살 이상인 사용자들의 이름 목록 확인하기
* (1) 나이가 30살 미만인 사용자들의 나이 목록 확인하기

우선 여기서는 생각나는대로 구현해본다.

[_filter, _map 함수]()

앞에서 구현한 내용을
함수형 프로그래밍의 원리 중 하나인
고차함수 원리를 적용해서 수정해보자.

새롭게 두 개의 함수를 만들었다.

_filter 함수는
어떤 항목들의 집합에서 명시한 조건에 맞지 않는 항목을 버리고
조건에 맞는 항목만 추출하는 기능이다.

_map 함수는
어떤 항목들의 집합의 모든 요소를 하나씩
파라미터로 사용해서 명시한 함수를 호출한 뒤
그 결과값을 처음과 똑같은 순서, 똑같은 구조로 반환하는 기능이다.

[_each]()

어떤 항목들의 집합 요소를 하나씩 순회하며
파라미터로 전달해서 명시한 함수를 호출하는 기능이다.

여기서부터는 고차함수로 구현하는게
레고 블럭 놀이같은 프로그래밍이 가능하다는 것을 조금씩 느낄 수 있는데
앞에서 구현한 _filter, _map 함수 내부에서
_each 함수를 사용할 수 있다.

예제코드로 가져온 코드는
실제로 실행해보면 빈 리스트([])를 출력하는데
그 이유는 람다 함수(lambda function)에서
람다 함수 스코프 내에 있지 않은 변수를
캡쳐(capture, capturing)하지 못해서 벌어진 이슈다.
이 이슈를 해결할 수 있다면
반복문을 사용하는 곳마다 _each 로 대체해서
레고 블럭 놀이가 가능해진다.

[_curry, _curry_right]()

_curry 함수는
func(a, b, c, d) 라는 함수가 있을때
func(a)(b)(c)(d) 형태로 호출할 수 있도록 만드는 기능이다.
이 기능이 유용한 경우는 함수 func 를 호출하는 시점에
해당 함수에 전달할 아규먼트로 필요한 a, b, c, d 를
모두 알고 있지 못할때
중간 단계에 해당하는 함수를 미리 만들어두고
나중에 필요한 파라미터를 채워서
최종결과값을 알아낼 때 사용할 수 있다.

_curry_right 함수는
func(a, b, c, d) 라는 함수가 있을때
func(d)(c)(b)(a) 형태로 호출할 수 있도록 만드는 기능이다.
위의 _curry 함수와 차이는 파라미터를 사용하는 순서가
서로 반대라는 점이다.
_curry 함수는 a, b, c, d 순서로 파라미터를 사용하지만
_curry_right 함수는 d, c, b, a 처럼
역순으로 파라미터를 사용한다.

여기서 설명한 것처럼 파라미터를 lazy 하게 사용하는 방식을
함수형 프로그래밍에서는 '커링(currying)' 이라고 한다.

함수형 프로그래밍에서는 어떤 함수를 구현할때
가장 왼쪽 파라미터부터 명시한 함수를 실행하는 left 버전 고차함수와
가장 오른쪽 파라미터부터 명시한 함수를 실행하는 right 버전 고차함수
두 가지로 구현하는 경우가 일반적이다.

[_reduce]()

_reduce 함수는
어떤 항목들의 집합에 속한 요소들에 대해서
일괄적으로 어떤 연산을 한 뒤 하나의 최종결과값을 반환하는 기능이다.
reduce 함수는 흔히 fold 라고도 부른다.

함수 오버로딩을 적용해서 두 가지 버전으로 구현했는데
accumulator 를 입력받는 버전과
집합의 첫번째 요소를 accumulator 로 사용하는 버전
두 가지로 구현했다.

이 _reduce 는
위의 _curry 와 마찬가지로
left 버전, right 버전 두 가지로 구현할 수도 있다.

여기서도 보면 _reduce 함수를 구현하기 위해서
_curry 함수를 사용하면서 레고 블럭 놀이를 하고 있다.

[_pipe]()

_pipe 는 여러개의 함수 리스트를 받아서
순서대로 하나씩 적용하는 기능이다.
이렇게 파이프라인을 먼저 셋업해두고 나중에 파라미터를 넘기면서 실행하면
파이프라인에 지정한 모든 함수를 호출한 결과값을 얻을 수 있다.
이를 구현할때
파이프라인만 먼저 만들어두는 버전과
파이프라인을 만들면서 아규먼트까지 함께 전달해서 결과값을 즉시 얻는 버전
두 가지로 구현했다.

[처음 사용자 정보 목록 구하는 기능 고차함수로 다시 구현]()

처음에 사용자 정보를 추출하는 두 개의 기능을
지금까지 알아본 다양한 고차함수의 특성을 바탕으로
다시 구현해보면 이렇게 된다.

기본적인 아이디어는 바로 앞에서 구현한 _pipe 함수를 사용하는 것이지만
생각보다 잘 되지 않아서
우선은 프로그래밍 언어에서 기본적으로 제공하는 기능을 사용해서
_pipe 를 사용했을때와 동일한 구조를 만들어봤다.

함수형 프로그래밍의 원리를 적용해서 구현하게 되면
코드가 선언적으로 변하고
유지보수하는 입장에서 한층 더 직관적으로 이해기 쉬워지는 장점이 있다.

<참조>
온라인 강의, [자바스크립트로 알아보는 함수형 프로그래밍 (ES5)](https://inf.run/Z1n7), 유인동

---------- ---------- ---------- ---------- ----------

# [14] 부수효과 다루는 방법을 적용해서 리팩터링하는 예제
URL ( 함수형-프로그래밍-시작해보기-14-부수효과를-다루는-방법-적용하기 )

앞에서 본 bind, flatMap, >=> 원리를 적용하는
아주 간단한 예제코드를 살펴보자.

[사칙연산 + 로그적재 예제코드 1]()

간단한 함수부터 시작해보자.
square 함수는 입력받는 정수값을 제곱한 결과를 반환한다.
add_one 함수는 입력받는 정수값에 +1 한 결과를 반환한다.

[기존에 만들어둔 함수를 호출할 때마다 로그를 남겨야 한다]()

추가적인 요구조건이 도착했다.
기존에 만들어둔 함수를 호출할 때마다
어떤 입력값을 받았고 연산 결과가 무엇이었는지
사람이 읽기 편한 형태로 로그를 남긴다.

계산결과값과 로그를 함께 다루는
number_with_logs 라는 데이터 클래스를 만들었다.
그리고 이걸 파라미터로 전달하거나 반환값으로 받아서
일관성있게 코드를 작성할 수 있도록 수정한다.

[다른 함수들도 추가해보자. 똑같이 로그를 남긴다]()

다른 함수들도 추가로 구현해야 한다.
기존과 마찬가지로 함수가 호출될때마다 로그를 남겨야 한다.
minus_five 함수는 입력받은 정수값에 -5 한 결과를 반환한다.
multiply_three 함수는 입력받은 정수값에 x3 한 결과를 반환한다.
add_twelve 함수는 입력받은 정수값에 +12 한 결과를 반환한다.

[Normal World 와 Wrapper World 왕복하는 코드 제거]()

위의 코드를 계속해서 읽다보니 반복되는 부분을 발견했다.
우선은 정수값 연산하는 부분을 보면
number_with_logs 에서 result 필드에 접근해서
값을 얻어낸 후 실제로 필요한 연산을 한다.
로그메시지를 남기는 부분에서도
number_with_logs 에서 logs 필드에 접근해서
기존에 로그가 쌓여있는 배열을 얻어내고 거기에
로그메시지를 한 줄 추가한다.

[Normal World, Wrapper World 왕복 횡단]()

여기서 number_with_logs 라는
wrapper 타입의 항목에서 실제 필요한 값을 꺼내는 코드가
바로 Normal World 와 Wrapper World 를 왕복하는 부분이다.

[Normal World 에서는 시작과 끝에만 접근하고 중간 과정에서 Wrapper World 에만 있음]()

이런 모양으로 가기 위해서는 앞선 포스팅에서 알아본
bind, >=>(kleisli arrow), flatMap 에 해당하는 함수를
구현해야 한다.
여기서는 run_with_logs 함수가 그 역할을 한다.

이를 통해서 코드는
처음 시작할때만 Normal World 에서 Wrapper World 로 진입한 후
중간 과정에서는 내내 Wrapper World 에 머무르는 코드가 되었다.
이 코드가 함수형 프로그래밍 Monad 의 개념을 적용한 예시이다.

<참조>
유뷰트 영상, [The Absolute Best Intro to Monads For Software Engineers](https://youtu.be/C2w45qRc3aU?si=I9BGOrdOR0_b3bEd)

---------- ---------- ---------- ---------- ----------

