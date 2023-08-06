import java.io.*;
import java.util.*;

public class B12865평범한배낭1 {

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("input.txt"));
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

    int[] dp = new int[K + 1];
    for (int i = 1; i < N + 1; i++) { // 배낭에 담을 물품
      for (int j = K; j >= item[i][0]; j--) { // 배낭에 담을 수 있는 무게
        // 현재 무게를 뺀 배낭에 물품 가치 + 현재 물품 가치
        dp[j] = Math.max(dp[j - item[i][0]] + item[i][1], dp[j]);
      }
    }

    System.out.print(dp[K]);
  }
}