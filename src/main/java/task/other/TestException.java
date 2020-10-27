package task.other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestException {

  public static void main(String[] args) {
    int i = 0;
    List<String> list = new ArrayList<>();

    for (int j = 0; j < 1000000; j++) {
      list.add(String.valueOf(j));
    }

    System.out.println(list.size());

    list.parallelStream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
  }
}
