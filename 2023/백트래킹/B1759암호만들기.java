import java.io.*;
import java.util.*;

public class B1759암호만들기 {
  static boolean[] visit;
  static String[] alphabet;
  static int L, C;

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    visit = new boolean[C];
    alphabet = br.readLine().split(" ");
    Arrays.sort(alphabet);
    makeWord(0, 0);
  }

  public static void makeWord(int cnt, int start) {
    if (cnt == L) {
      int vo = 0, co = 0; // vo: 모음수, co: 자음수
      String result = "";
      for (int i = 0; i < C; i++) {
        if (visit[i]) {
          result += alphabet[i];
          if ("aeiou".contains(alphabet[i]))
            vo++;
          else
            co++;
        }
      }

      if (vo >= 1 && co >= 2)
        System.out.println(result);

      return;
    }

    for (int i = start; i < C; i++) {
      visit[i] = true;
      makeWord(cnt + 1, i + 1);
      visit[i] = false;
    }
  }
}
