import java.io.*;
import java.util.*;

public class B11659구간합구하기4 {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int[] sum = new int[N + 1];
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      sum[i] += sum[i - 1] + Integer.parseInt(st.nextToken());
    }
    while (M-- > 0) {
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int f = Integer.parseInt(st.nextToken());
      sb.append(sum[f] - sum[s - 1]).append("\n");
    }

    System.out.print(sb);
  }
}
