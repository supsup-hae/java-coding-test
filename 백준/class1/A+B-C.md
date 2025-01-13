# A + B - C

## 📌 문제 정보
- **문제**: [A + B - C](https://www.acmicpc.net/problem/31403)
- **난이도**: Bronze 4
- **풀이 날짜**: 2024-01-13

## 👓 문제 설명
세 정수 A, B, C가 주어질 때, 두 가지 계산을 수행해야 합니다:
1. A + B - C를 계산한 값
2. A와 B를 문자열로 이어붙인 후 C를 뺀 값

## 🚫 제한사항
- 0 ≤ A, B ≤ 99
- 0 ≤ C ≤ 999

## 🖥️ 입출력 예
| 입력 | 출력 |
|------|------|
| 2<br>3<br>5 | 0<br>18 |

## 📝 입출력 예 설명
첫 번째 계산: 2 + 3 - 5 = 0
두 번째 계산: "23" - 5 = 23 - 5 = 18

### 💡 접근 방법
1. 첫 번째 줄 출력:
    - 입력받은 A, B, C를 정수로 처리하여 A + B - C 계산
2. 두 번째 줄 출력:
    - A와 B를 문자열로 변환하여 이어붙임
    - 이어붙인 문자열을 정수로 변환
    - C를 뺀 결과 출력

```java
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String a = scanner.nextLine();
		String b = scanner.nextLine();
		String c = scanner.nextLine();
		System.out.println(Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c));
		System.out.println(Integer.parseInt(a + b) - Integer.parseInt(c));
	}
}
```