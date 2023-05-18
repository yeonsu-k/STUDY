import java.io.*;
import java.util.*;

public class B6068시간관리하기 {

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    TreeMap<Integer, Integer> list = new TreeMap<>();
    for (int i = 0; i < N; i++) {
      String[] str = br.readLine().split(" ");
      list.put(Integer.parseInt(str[1]), Integer.parseInt(str[0]));
    }

    // list.keySet().forEach(key -> {
    // System.out.println(key + " " + list.get(key));
    // });

    int sum = 0;
    int result = Integer.MAX_VALUE;
    for (Integer key : list.keySet()) {
      sum += list.get(key);
      result = Math.min(result, key - sum);
      if (sum > key) {
        result = -1;
        break;
      }
    }

    System.out.print(result);
  }
}