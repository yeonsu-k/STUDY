import java.io.*;

/**
 * 수학
 * 정수론
 * 소수 판정
 * 에라토스테네스의 체
 */

public class B6588골드바흐의추측 {

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int MAX = 1000001;
    boolean[] isPrime = new boolean[MAX];

    // 소수 구하기(에라토스테네스의 체)
    isPrime[0] = isPrime[1] = true;
    for (int i = 2; i < Math.sqrt(MAX); i++) {
      if (!isPrime[i]) {
        for (int j = i * i; j < MAX; j += i) {
          if (isPrime[i])
            continue;
          isPrime[j] = true;
        }
      }
    }

    // 처리
    int num = -1;
    while ((num = Integer.parseInt(br.readLine())) != 0) {
      boolean flag = false;
      for (int i = 3; i <= num / 2; i += 2) { // 홀수 소수의 값만 가능
        // 소수 판별
        if (!isPrime[i] && !isPrime[num - i]) {
          sb.append(num + " = " + i + " + " + (num - i) + "\n");
          flag = true;
          break;
        }
        if (flag)
          break;
      }

      if (!flag)
        sb.append("Goldbach's conjecture is wrong.\n");
    }

    // 출력
    System.out.print(sb);
  }
}
