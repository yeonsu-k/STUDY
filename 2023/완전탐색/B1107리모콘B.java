import java.io.*;
import java.util.*;

/**
 * B1107리모콘
 * 브루트포스 알고리즘(완전탐색)
 */
public class B1107리모콘B {
  static int N, M, res, length;
  static List<Integer> list;

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine()); // 이동할 채널 번호
    length = String.valueOf(N).length(); // 이동할 채널 번호 길이
    M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수
    list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)); // 사용가능한 번호 리스트

    // 고장난 버튼 입력 받기
    if (M != 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; i++) {
        list.remove(list.indexOf(Integer.parseInt(st.nextToken())));
      }
    }

    // 채널 위아래 버튼 이동만 가능할 때
    res = Math.abs(100 - N);
    if (res <= 3 || N == 100 || M == 10 || M == 0) {
      if (M == 0) {
        // 모든 숫자 입력 가능 할 때(위 아래 버튼 이동과 길이 중 최소)
        System.out.print(Math.min(res, length));
      } else
        System.out.print(res);
      return;
    }

    for (int num : list) {
      dfs(1, num);
    }

    System.out.print(res);
  }

  public static void dfs(int cnt, int resultNum) {
    int temp = cnt + Math.abs(N - resultNum); // 현재 누른 번호의 개수 + 목표 채널과의 차이
    res = Math.min(res, temp);
    if (cnt <= length) {
      for (int num : list)
        dfs(cnt + 1, resultNum * 10 + num);
    }
  }
}