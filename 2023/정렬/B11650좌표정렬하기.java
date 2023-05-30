import java.io.*;
import java.util.*;

class Person implements Comparable<Person> {
  int x;
  int y;

  Person(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Person o) {
    if (x == o.x)
      return y - o.y;
    else
      return x - o.x;
  }
}

class B11650좌표정렬하기 {

  public static void main(String[] args) throws IOException {
    // System.setIn(new FileInputStream("input.txt"));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    TreeSet<Person> set = new TreeSet<>();

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      set.add(new Person(x, y));
    }

    for (Person val : set) {
      sb.append(val.x + " " + val.y + "\n");
    }

    System.out.print(sb.toString().trim());
  }
}
