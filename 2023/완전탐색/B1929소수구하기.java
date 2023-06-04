import java.io.*;
import java.util.*;

public class B1929소수구하기 {
  static boolean prime[];

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    prime = new boolean[y + 1];
    getPrime();
    for (int i = x; i <= y; i++) {
      if (!prime[i])
        sb.append(i).append("\n");
    }

    System.out.print(sb);
  }

  private static void getPrime() {
    prime[0] = prime[1] = true;
    for (int i = 2; i <= Math.sqrt(prime.length); i++) {
      if (prime[i])
        continue;
      for (int j = i * i; j < prime.length; j += i) {
        prime[j] = true;
      }
    }
  }

}