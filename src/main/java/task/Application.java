package task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static task.Status.*;

public class Application {

  public static void main(String[] args) {
    UserService service = new UserService(createUserList(), LocalDateTime.parse("2020-10-01T18:00:00"));
    service.processingUsers();
  }


  private static List<User> createUserList() {
    return new ArrayList<>(asList(
      new User("Miles", "Davis", 20, "noemail@company.com", NEW, LocalDateTime.parse("2020-10-01T09:00:00")),
      new User("James", "Dean", 27, "james.dean@company.com", NEW, LocalDateTime.parse("2020-09-30T12:00:54")),
      new User("George", "Fox", 27, "george.fox@company.com", NEW, LocalDateTime.parse("2020-09-01T08:48:53")),
      new User("John", "Edwards", 34, "john.edwards@company.com", ACTIVE, LocalDateTime.parse("2019-06-01T12:30:15")),
      new User("Thomas", "Edison", 65, "thomas.edison@company.com", ACTIVE, LocalDateTime.parse("1989-09-01T12:30:15")),
      new User("Richard", "Feynman", 18, "richard.feynman@company.com", INACTIVE, LocalDateTime.parse("2020-09-15T12:30:15")),
      new User("Henry", "Ford", 31, "henry.ford@company.com", INACTIVE, LocalDateTime.parse("2020-05-01T10:24:14")),
      new User("Charles", "Fort", 45, "charles.fort@company.com", BLOCKED, LocalDateTime.parse("2020-10-01T12:30:15")),
      new User(null, null, 0, null, null, null),
      null
    ));
  }
}
