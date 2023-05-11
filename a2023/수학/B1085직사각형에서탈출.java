import java.io.*;
import java.util.*;

public class B1085직사각형에서탈출 {
  public static void main(String[] args) throws Exception {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    List<Integer> list = new ArrayList<>();
    String[] str = br.readLine().split(" ");
    list.add(Integer.parseInt(str[0]));
    list.add(Integer.parseInt(str[1]));
    list.add(Integer.parseInt(str[3]) - list.get(1));
    list.add(Integer.parseInt(str[2]) - list.get(0));

    System.out.print(Collections.min(list));
  }
}
