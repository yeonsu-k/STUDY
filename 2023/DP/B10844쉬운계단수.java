import java.io.*;

public class B10844쉬운계단수 {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[][] dp = new int[N + 1][10]; // 1 ~ N+1 자릿수와 각 자리별 계단 가능 수
    for (int i = 1; i < 10; i++) {
      dp[1][i] = 1;
    }

    for (int i = 2; i <= N; i++) {
      // 0이라면 이전 자릿수 1만 가능
      dp[i][0] = dp[i - 1][1];
      for (int j = 1; j <= 8; j++) {
        dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
      }
      // 9이라면 이전 자릿수 8만 가능
      dp[i][9] = dp[i - 1][8];
    }

    long result = 0;
    for (int i = 0; i < 10; i++) {
      result += dp[N][i];
    }

    System.out.println(result % 1000000000);

  }
}
