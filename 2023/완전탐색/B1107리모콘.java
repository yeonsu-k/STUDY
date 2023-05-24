import java.io.*;
import java.util.*;

/**
 * B1107리모콘
 * 브루트포스 알고리즘(완전탐색)
 */
public class B1107리모콘 {

  public static void main(String[] args) throws IOException {
    System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    char[] N = br.readLine().toCharArray(); // 이동할 채널 번호
    int M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수
    List<Integer> list = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)); // 사용가능한 번호 리스트

    if (M != 0) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < M; i++) {
        list.remove(list.indexOf(Integer.parseInt(st.nextToken())));
      }
    }

    // System.out.println(list.toString());

    int num = Integer.parseInt(String.valueOf(N)); // 이동할 채널 번호
    int res = Math.abs(100 - num); // 채널 상하 버튼으로만 눌러 이동했을 때
    if (res <= 3) {
      System.out.print(res);
      return;
    } else
      res = N.length;

    String temp = "";
    int n = -1;
    for (int i = 0; i < N.length; i++) {
      int a = (N[i] - '0') == 0 ? 10 : (N[i] - '0');
      int dist = 11; // 숫자간 차이가 제일 작은 것
      for (int j = 0; j < list.size(); j++) {
        int b = list.get(j);
        if (dist > Math.abs(a - b)) {
          dist = Math.min(dist, Math.abs(a - b));
          n = b;
        }
      }
      temp += n;
    }

    System.out.print(N.length + Math.abs(num - Integer.parseInt(temp)));
  }
}