import java.io.*;

public class B128521로만들기2 {
  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] dp = new int[N + 1]; // 횟수 저장
    int[] print = new int[N + 1]; // 결과 까지 오게 된 경로

    dp[1] = 0;
    for (int i = 2; i <= N; i++) {
      dp[i] = dp[i - 1] + 1;
      print[i] = i - 1;

      if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
        dp[i] = dp[i / 3] + 1;
        print[i] = i / 3;
      }
      if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
        dp[i] = dp[i / 2] + 1;
        print[i] = i / 2;
      }
    }
    
    StringBuilder sb = new StringBuilder();
    sb.append(dp[N]+"\n");
    while (N > 0) {
      sb.append(N + " ");
      N = print[N];
    }

    System.out.print(sb);
    br.close();
  }
}
