import java.io.*;
import java.util.*;

public class B12865평범한배낭2 {

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[][] item = new int[N + 1][2];
    for (int i = 1; i < N + 1; i++) {
      st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      item[i] = new int[] { w, v };
    }

    int[][] dp = new int[N + 1][K + 1];
    for (int i = 1; i < N + 1; i++) { // 배낭에 담을 수 있는 물품 수
      for (int j = 1; j < K + 1; j++) { // 배낭에 담을 수 있는 무게
        if (item[i][0] <= j) {
          // 현재 물품 가치 + 현재 무게를 뺀 이전 최대 물품 가치
          dp[i][j] = Math.max(item[i][1] + dp[i - 1][j - item[i][0]], dp[i - 1][j]);
        } else
          dp[i][j] = dp[i - 1][j];
      }
    }

    // for (int[] ddp : dp) {
    // System.out.println(Arrays.toString(ddp));
    // }

    System.out.print(dp[N][K]);
  }
}