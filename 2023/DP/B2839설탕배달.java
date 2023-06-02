import java.io.*;

public class B2839설탕배달 {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 방법 1. DP 활용하기
    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[5001];
    dp[3] = 1;
    dp[5] = 1;

    for (int i = 6; i <= N; i++) {
      if (i % 5 == 0) {
        dp[i] = dp[i - 5] + 1;
      } else if (i % 3 == 0) {
        dp[i] = dp[i - 3] + 1;
      } else {
        if (dp[i - 3] != 0 && dp[i - 5] != 0) {
          dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
        }
      }
    }

    // System.out.print(dp[N] == 0 ? "-1" : dp[N]);

    // 방법 2. 규칙 찾아서 한번에 출력하기
    /*
     * if (N == 4 || N == 7) {
     * System.out.print(-1);
     * } else if (N % 5 == 0) {
     * System.out.print(N / 5);
     * } else if (N % 5 == 1 || N % 5 == 3) {
     * System.out.print((N / 5) + 1);
     * } else if (N % 5 == 2 || N % 5 == 4) {
     * System.out.print((N / 5) + 2);
     * }
     */

    // 방법 3. 단순 반복문으로 풀이
    /*
     * for (int i = 0; i <= N / 3; i++) {
     * for (int j = 0; j <= N / 5; j++) {
     * if (i * 3 + j * 5 == N) {
     * System.out.print(i + j);
     * return;
     * }
     * }
     * }
     * System.out.print("-1");
     */

  }

}
