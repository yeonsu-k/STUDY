package 정렬;

import java.io.*;
import java.util.*;

public class B1181단어정렬 {

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuffer sb = new StringBuffer();

    int N = Integer.parseInt(br.readLine());
    TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        if (s1.length() == s2.length()) {
          return s1.compareTo(s2); // 사전 순 정렬
        } else {
          return s1.length() - s2.length();
        }
      }

    });

    for (int i = 0; i < N; i++) {
      set.add(br.readLine());
    }

    for (String str : set) {
      sb.append(str).append("\n");
    }

    System.out.print(sb);
  }
}
