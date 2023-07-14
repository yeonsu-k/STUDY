import java.io.*;
import java.util.*;

public class B6064카잉달력 {
  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      st = new StringTokenizer(br.readLine());
      int M = Integer.parseInt(st.nextToken()); // 년
      int N = Integer.parseInt(st.nextToken()); // 월
      int x = Integer.parseInt(st.nextToken()) - 1;
      int y = Integer.parseInt(st.nextToken()) - 1;

      int result = -1;
      for (int i = x; i < (N * M); i += M) {
        if (i % N == y) {
          result = i + 1;
          break;
        }
      }

      sb.append(result).append('\n');
    }

    System.out.print(sb);
    br.close();
  }
}