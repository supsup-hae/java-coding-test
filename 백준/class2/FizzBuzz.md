&# FizzBuzz

## 📌 문제 정보
- **문제**: [FizzBuzz](https://www.acmicpc.net/problem/28702)
- **난이도**: Bronze 3
- **풀이 날짜**: 2024-01-15

## 👓 문제 설명
FizzBuzz 문제는 연속된 숫자에 대해 다음 규칙을 적용하여 문자열을 출력합니다:
- 3의 배수이면 "Fizz"
- 5의 배수이면 "Buzz"
- 3과 5의 공배수이면 "FizzBuzz"
- 그 외의 경우 숫자 그대로 출력

## 🚫 제한사항
- 시간 제한: 0.5초
- 메모리 제한: 1024MB
- 입력되는 문자열의 길이는 8 이하
- 입력은 항상 FizzBuzz 문제의 연속된 세 개의 출력에 해당함

## 🖥️ 입출력 예
| 입력 | 출력 |
|------|------|
| Fizz<br>Buzz<br>11 | Fizz |
| 980803<br>980804<br>FizzBuzz | 980806 |

## 📝 입출력 예 설명
첫 번째 예시:
- Fizz, Buzz, 11이 주어졌으므로 다음 숫자는 12
- 12는 3의 배수이므로 "Fizz" 출력

### 💡 접근 방법
1. 주어진 세 개의 문자열을 통해 현재 위치 파악
2. 다음 숫자 계산
3. 다음 숫자에 FizzBuzz 규칙 적용하여 출력

```java
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String first = scanner.next();
		String second = scanner.next();
		String third = scanner.next();
		isFizzBuzz(first, second, third);
	}

	private static void isFizzBuzz(String first, String second, String third) {
		int tmp = 0;
		if (Character.isDigit(first.charAt(0))) {
			tmp = Integer.parseInt(first) + 3;
		} else if (Character.isDigit(second.charAt(0))) {
			tmp = Integer.parseInt(second) + 2;
		} else if (Character.isDigit(third.charAt(0))) {
			tmp = Integer.parseInt(third) + 1;
		} else {
			bw.write(0);
		}
		if (tmp % 3 == 0 && tmp % 5 == 0) {
			bw.write("FizzBuzz");
		} else if (tmp % 3 == 0 && tmp % 5 != 0) {
			bw.write("Fizz");
		} else if (tmp % 3 != 0 && tmp % 5 == 0) {
			bw.write("Buzz");
		} else {
			bw.write(tmp);
		}
	}

}
```