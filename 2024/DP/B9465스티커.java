import java.io.*;
import java.util.*;

public class B9465스티커 {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      int[][] sticker = new int[2][N];
      int[][] dp = new int[2][N];

      StringTokenizer st0 = new StringTokenizer(br.readLine());
      StringTokenizer st1 = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        sticker[0][i] = Integer.parseInt(st0.nextToken());
        sticker[1][i] = Integer.parseInt(st1.nextToken());
      }

      dp[0][0] = sticker[0][0];
      dp[1][0] = sticker[1][0];
      int max = Math.max(dp[0][0], dp[1][0]);
      for (int i = 1; i < N; i++) {
        if (i == 1) {
          dp[0][i] = dp[1][0] + sticker[0][1];
          dp[1][i] = dp[0][0] + sticker[1][1];
          max = Math.max(dp[0][i], dp[1][i]);
          continue;
        }
        dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
        dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
        max = Math.max(max, Math.max(dp[0][i], dp[1][i]));
      }
      sb.append(max + "\n");
    }
    System.out.print(sb);
  }
}
