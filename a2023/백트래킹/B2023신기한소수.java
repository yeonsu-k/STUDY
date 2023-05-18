import java.io.*;

public class B2023신기한소수 {
  static int N;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력
    N = Integer.parseInt(br.readLine());
    // 처리
    makeNumber("", 0);
    // 출력
    System.out.println(sb.toString());
  }

  private static void makeNumber(String number, int cnt) {
    if (cnt == N) {
      sb.append(number + "\n");
      return;
    }
    for (int i = 1; i <= 9; i++) {
      if (primes(number + i))
        makeNumber(number + i, cnt + 1);
    }
  }

  public static boolean primes(String strnum) {
    int num = Integer.parseInt(strnum);
    if (num < 2)
      return false;
    // Math.sqrt : 제곱근 함수
    for (int i = 2; i <= Math.sqrt(num); i++) {
      if (num % i == 0)
        return false;
    }
    return true;
  }
}