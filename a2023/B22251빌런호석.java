import java.io.*;
import java.util.*;

/*
 * 출력 : 호석이가 반전시킬 LED를 고를 수 있는 경우의 수
 */
public class B22251빌런호석 {
  static int N, K, P, X;
  static int[][] display = {
      { 1, 1, 1, 0, 1, 1, 1 }, // 0
      { 0, 0, 1, 0, 0, 0, 1 }, // 1
      { 0, 1, 1, 1, 1, 1, 0 }, // 2
      { 0, 1, 1, 1, 0, 1, 1 }, // 3
      { 1, 0, 1, 1, 0, 0, 1 }, // 4
      { 1, 1, 0, 1, 0, 1, 1 }, // 5
      { 1, 1, 0, 1, 1, 1, 1 }, // 6
      { 0, 1, 1, 0, 0, 0, 1 }, // 7
      { 1, 1, 1, 1, 1, 1, 1 }, // 8
      { 1, 1, 1, 1, 0, 1, 1 } // 9
  };
  static int count = 0;

  public static void main(String[] args) throws Exception {
    System.setIn(new FileInputStream("index.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken()); // 엘리베이터 최고층 수
    K = Integer.parseInt(st.nextToken()); // 디스플레이에 최대 표시 가능한 자리수
    P = Integer.parseInt(st.nextToken()); // LED 최대 반전 가능 수
    X = Integer.parseInt(st.nextToken()); // 현재 멈춰 있는 층

    int[] x_digit = numTodigit(X);
    for (int i = 1; i <= N; i++) {
      if (i == X)
        continue; // 현재층 제외 반복
      if (changeNum(i, x_digit)) count++;
    }
    
    System.out.println(count);
  }

  private static boolean changeNum(int num, int[] x_digit) {
    int[] target = numTodigit(num);

    int reCount = 0; // 바뀐 LED 수 count
    for (int i = 0; i < K; i++) { // 한자리씩 찾아와 비교
      for (int j = 0; j < 7; j++) { // 각 숫자의 LED 자리 비교
        if (display[x_digit[i]][j] != display[target[i]][j]) {
          reCount++;
          if (reCount > P) return false;
        }
      }
    }
    return true;
  }

  // 디지털식 자리수 바꿔주는 함수(2자리일 경우.... 2 => 02)
  public static int[] numTodigit(int num) {
    int[] result = new int[K];
    for (int i = K - 1; i >= 0; i--) {
      result[i] = num % 10;
      num /= 10;
    }
    return result;
  }
}