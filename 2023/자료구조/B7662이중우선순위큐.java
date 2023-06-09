import java.io.*;
import java.util.*;

/* 
 * 자료구조 - TreeMap
 * map.merge(key, value, 중복키일 경우 함수)
 * 키 값이 중복일 경우 기존 value값에 1을 더한다.
 * map.put(num,map.get(num)+1);
 * map.merge(num, 1, Integer::sum); 
 * map.merge(num, 1, (v1, v2) -> v1 + v2)); 
 */

public class B7662이중우선순위큐 {
  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    while (T-- > 0) {
      int k = Integer.parseInt(br.readLine());
      TreeMap<Integer, Integer> map = new TreeMap<>();

      while (k-- > 0) {
        st = new StringTokenizer(br.readLine());
        char ch = st.nextToken().charAt(0);
        int num = Integer.parseInt(st.nextToken());

        if (ch == 'I') {
          map.merge(num, 1, Integer::sum);
        } else if (!map.isEmpty()) {
          int key = num == 1 ? map.lastKey() : map.firstKey();
          if (map.get(key) == 1) {
            map.remove(key);
          } else {
            map.merge(key, -1, Integer::sum);
          }
        }
      }

      if (map.isEmpty()) {
        sb.append("EMPTY\n");
      } else {
        sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
      }
    }
    System.out.print(sb);
  }
}
