import java.io.*;
import java.util.*;

/**
 * 브루트포스 알고리즘
 * 두 포인터
 * 슬라이딩 윈도우
 */
public class B2531회전초밥 {
  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // 벨트 위 접시 수
    int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
    int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시의 수
    int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

    int[] sushi = new int[N]; // 벨트 위 초밥
    for (int i = 0; i < N; i++) {
      sushi[i] = Integer.parseInt(br.readLine());
    }
    int[] eat = new int[d + 1]; // 종류별 먹은양
    eat[c]++;

    // 1. 초밥을 0번째부터 연속으로 k만큼 먹었을 때
    int count = 1;
    for (int i = 0; i < k; i++) {
      if (eat[sushi[i]]++ == 0)
        count++;
    }
    int max = count;

    // 2. 모든 초밥 투 포인터로 탐색하기
    for (int i = 0; i < N; i++) {
      if (--eat[sushi[i]] == 0)
        count--;

      if (eat[sushi[(i + k) % N]]++ == 0)
        count++;

      if (count > max)
        max = count;
    }

    System.out.print(max);
  }
}
