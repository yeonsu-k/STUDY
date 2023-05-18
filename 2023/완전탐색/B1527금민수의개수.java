import java.io.*;
import java.util.*;

public class B1527금민수의개수 {
  static int A, B, cnt = 0;

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    A = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());
    fun(0);

    System.out.println(cnt);
  }

  private static void fun(long num) {
    if (num > B)
      return;
    if (num >= A && num <= B)
      cnt++;
    fun(10 * num + 4);
    fun(10 * num + 7);
  }
}
