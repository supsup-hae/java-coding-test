# Hashing

## 📌 문제 정보
- **문제**: [Hashing](https://www.acmicpc.net/problem/15829)
- **난이도**: Bronze 2
- **풀이 날짜**: 2024-02-01

## 👓 문제 설명
해시 함수는 임의의 길이의 입력을 특정 범위의 출력으로 변환하는 함수입니다. 이 문제에서는 영문 소문자로 구성된 문자열을 다음과 같은 해시 함수로 변환합니다[2][4]:

1. 각 알파벳에 고유한 번호를 부여 (a=1, b=2, ..., z=26)
2. 각 자리에 31의 거듭제곱을 곱하여 더함
3. 결과값을 1234567891로 나눈 나머지를 구함

## 🚫 제한사항
- 문자열의 길이 L은 1 ≤ L ≤ 50
- 입력은 알파벳 소문자로만 구성
- r = 31
- M = 1234567891

## 🖥️ 입출력 예
| 입력 | 출력 |
|------|------|
| 5<br>abcde | 4739715 |
| 3<br>zzz | 25818 |

## 💡 풀이 방법

### 처음 풀이

- 처음 풀이를 진행했을때는 출력을 Small 기준으로 코드를 작성을 했다. 아스키 코드와 Math를 이용하였다.

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		String value = br.readLine();
		br.close();
		long sum = 0L;
		for (int i = 0; i < n; i++) {
			int key = value.charAt(i) - 'a' + 1;
			sum += key * (int)Math.pow(31, i);
		}
		bw.write(sum + "");
		bw.flush();
		bw.close();
	}

}

```

- Large의 범위로 생각해보면 31^50 을 담을 수 있는 자료형은 존재하지 않기에 방법에 대해서 고민해보았지만 
모듈러 연산에 대한 지식 없이 풀이를 진행하였기때문에 풀이가 틀릴수밖에 없었다. 이후 블로그 글을 참고하여 모듈러 연산에 대한 지식을 바탕으로 문제풀이를 진행하였다.

### 최종 풀이

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		String value = br.readLine();
		br.close();
		long sum = 0L;
		long pow = 1;
		for (int i = 0; i < n; i++) {
			long key = value.charAt(i) - 'a' + 1;
			sum += (key * pow) % 1234567891;
			pow = 31 * pow % 1234567891;
		}
		bw.write((sum % 1234567891) + "");
		bw.flush();
		bw.close();
	}

}

```


## 🔑 주요 알고리즘
- **해싱**
- **모듈러 연산**
- **거듭제곱 계산**
