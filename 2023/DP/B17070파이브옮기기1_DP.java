import java.io.*;
import java.util.*;

public class B17070파이브옮기기1_DP {
  static int N, map[][], dp[][][];

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 입력
    N = Integer.parseInt(br.readLine());
    dp = new int[N + 1][N + 1][3]; // 가로(0) ,세로(1), 대각선(2)
    map = new int[N + 1][N + 1]; // 지도
    for (int i = 1; i <= N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 처리
    if (map[N][N] != 1)
      DP();

    System.out.print(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
  }

  private static void DP() {
    dp[1][2][0] = 1;
    for (int i = 1; i <= N; i++) {
      for (int j = 1; j <= N; j++) {
        if (map[i][j] == 1)
          continue;
        dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2]; // 가로 파이프 = 가로 + 대각선
        dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2]; // 세로 파이프 = 세로 + 대각선
        if (map[i][j - 1] != 1 && map[i - 1][j] != 1) {
          dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
        }
      }
    }
  }
}
