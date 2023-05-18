import java.io.*;
import java.util.*;

public class B4358생태학 {
  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    HashMap<String, Integer> trees = new HashMap<>();

    String word;
    int count = 0;
    while ((word = br.readLine()) != null) {
      if (trees.containsKey(word)) {
        trees.put(word, trees.get(word) + 1);
      } else {
        trees.put(word, 1);
      }
      count++;
    }
    List<String> list = new ArrayList<>(trees.keySet());
    list.sort(String::compareTo);

    for (String key : list) {
      double value = (double) trees.get(key);
      sb.append(key + " ").append(String.format("%.4f", value / count * 100)).append("\n");
    }

    System.out.print(sb.toString());
    br.close();
  }
}
