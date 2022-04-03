import java.util.Scanner;

public class A2748피보나치수2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int N = scan.nextInt();
    long[] dp = new long[N+1];

    dp[0]=0;
    dp[1]=1;
    for(int i=2;i<N+1;i++){
      dp[i] = dp[i-1]+dp[i-2];
    }
    System.out.print(dp[N]);
  }
}