import java.io.*;
import java.util.*;

// https://www.acmicpc.net/problem/10814

class B10814나이순정렬 {

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    StringBuilder[] p = new StringBuilder[201];
    for (int i = 0; i < p.length; i++) {
      p[i] = new StringBuilder();
    }

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int age = Integer.parseInt(st.nextToken());
      // 카운팅 정렬 : 나이를 index 로 하여 해당 배열에 나이와 이름을 append() 한다
      p[age].append(age).append(' ').append(st.nextToken()).append('\n');
    }

    for (StringBuilder val : p) {
      sb.append(val);
    }

    System.out.print(sb.toString().trim());
  }
}
