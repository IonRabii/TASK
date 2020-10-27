package task.other;

import java.util.ArrayList;
import java.util.List;

public class TestList {

  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("abc");
    list.add("NAME1");
    list.add("NAME2");
    list.add("tAXG");
    list.add("QWERTY");

    for (String item : list) {
      if (item.startsWith("N")) {
        System.out.println(item);
      }
    }

  }
}
