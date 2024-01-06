import java.io.*;
import java.util.*;

/*
 * 그래프 
 * 유니온 파인드
 * union 연산
 */

public class B1976여행가자_2 {
  static int N, M;
  static int[] parent;

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    parent = new int[N];
    for (int i = 0; i < N; i++) {
      parent[i] = i;
    }

    // 방문 가능한 도시 입력 받기
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < N; j++) {
        if ((str.charAt(2 * j) - '0') == 1) {
          union(i, j);
        }
      }
    }

    // 여행 가능 여부 확인
    boolean check = true;
    StringTokenizer st = new StringTokenizer(br.readLine());
    int now = Integer.parseInt(st.nextToken()) - 1;
    for (int i = 1; i < M; i++) {
      int next = Integer.parseInt(st.nextToken()) - 1;
      if (find(now) != find(next)) {
        check = false;
        break;
      }
      now = next;
    }

    System.out.print(check ? "YES" : "NO");
  }

  private static int find(int x) {
    if (x == parent[x]) // 배열 인덱스와 값이 같다면 해당 값 리턴
      return x;
    return parent[x] = find(parent[x]); // 배열의 값을 인덱스로 갖는 값 리턴
  }

  private static void union(int x, int y) {
    x = find(x); // 최상위 노드 찾기
    y = find(y);
    if (x == y)
      return; // 같은 집합(이미 연결 되어 있음)
    parent[y] = x;
  }
}
