import java.io.*;
import java.util.*;

/**
 * B1107리모콘
 * 브루트포스 알고리즘(완전탐색)
 */
public class B1107리모콘A {
  static int N, res;
  static List<Integer> list;

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 이동할 채널 번호
    int M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수
    list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)); // 사용가능한 번호 리스트

    // 고장난 버튼 입력 받기
    if (M != 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; i++) {
        list.remove(list.indexOf(Integer.parseInt(st.nextToken())));
      }
    } else if (M == 10) {
      System.out.print(Math.abs(100 - N));
      return;
    }

    // 채널 상하 버튼으로만 눌러 이동했을 때
    res = Math.abs(100 - N);
    if (res <= 3 || N == 100) {
      System.out.print(res);
      return;
    }

    dfs(0, "");
    System.out.print(res);
  }

  public static void dfs(int idx, String str) {
    for (int i = 0; i < list.size(); i++) {
      String temp = str + list.get(i);
      int cnt = Math.abs(N - Integer.parseInt(temp)) + temp.length();
      res = res > cnt ? cnt : res;
      if (idx < 6)
        dfs(idx + 1, temp);
    }
  }
}