import java.io.*;

public class A1003피보나치수열 {
  static Integer[][] dp;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    dp = new Integer[41][2];
    dp[0][0] = 1; // N=0 일 때의 0 호출 횟수
    dp[0][1] = 0; // N=0 일 때의 1 호출 횟수
    dp[1][0] = 0; // N=1 일 때의 0 호출 횟수
    dp[1][1] = 1; // N=1 일 때의 1 호출 횟수

    int T = Integer.parseInt(br.readLine());
    while(T-- >0){
      int N = Integer.parseInt(br.readLine());
      function(N);
      sb.append(dp[N][0]+" "+ dp[N][1]+'\n');
    }
    System.out.print(sb.toString());
    br.close();
  }

  private static Integer[] function(int N) {
    if(dp[N][0]==null || dp[N][1]==null){
      dp[N][0]=function(N-1)[0]+function(N-2)[0];
      dp[N][1] = function(N - 1)[1] + function(N - 2)[1];
    }
    return dp[N];
  }
}