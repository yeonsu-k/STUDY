import java.io.*;
import java.util.*;

public class B10866덱 {

  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    Deque<Integer> list = new LinkedList<>();

    while (N-- > 0) {
      String[] str = br.readLine().split(" ");

      if (str[0].equals("push_front"))
        list.addFirst(Integer.parseInt(str[1]));
      else if (str[0].equals("push_back"))
        list.addLast(Integer.parseInt(str[1]));
      else if (str[0].equals("pop_front"))
        sb.append((list.isEmpty() ? -1 : list.pollFirst()) + "\n");
      else if (str[0].equals("pop_back"))
        sb.append((list.isEmpty() ? -1 : list.pollLast()) + "\n");
      else if (str[0].equals("size"))
        sb.append(list.size() + "\n");
      else if (str[0].equals("empty"))
        sb.append((list.isEmpty() ? 1 : 0) + "\n");
      else if (str[0].equals("front"))
        sb.append((list.isEmpty() ? -1 : list.getFirst()) + "\n");
      else if (str[0].equals("back"))
        sb.append((list.isEmpty() ? -1 : list.getLast()) + "\n");
    }

    System.out.print(sb.toString().trim());
  }
}
