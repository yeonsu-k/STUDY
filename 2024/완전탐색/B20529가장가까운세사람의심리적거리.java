import java.io.*;
import java.util.*;

/* 
 * 브루트포스 알고리즘(완전탐색)
 * 비둘기집 원리
 */

public class B20529가장가까운세사람의심리적거리 {

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    while (T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());

      if (N > 32) {
        sb.append(0 + "\n");
        continue;
      } else {
        String[] mbti = new String[N];
        for (int i = 0; i < N; i++) {
          mbti[i] = st.nextToken();
        }

        int minSum = 12; // 세 사람 다 차이가 날 때 가질 수 있는 최대 값
        int mbtiLength = mbti.length;
        outRepeat: for (int i = 0; i < mbtiLength - 2; i++) {
          for (int j = i + 1; j < mbtiLength - 1; j++) {
            for (int k = j + 1; k < mbtiLength; k++) {
              minSum = Math.min(minSum, caclDiff(mbti[i], mbti[j], mbti[k]));
              if (minSum == 0)
                break outRepeat;
            }
          }
        }

        sb.append(minSum).append('\n');
      }
    }

    System.out.print(sb);
  }

  private static int caclDiff(String str1, String str2, String str3) {
    int diff = 0;
    for (int i = 0; i < 4; i++) {
      diff += str1.charAt(i) != str2.charAt(i) ? 1 : 0;
      diff += str2.charAt(i) != str3.charAt(i) ? 1 : 0;
      diff += str3.charAt(i) != str1.charAt(i) ? 1 : 0;
    }
    return diff;
  }
}
