package task;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static task.Status.*;

public class UserServiceTest {
  private static final LocalDateTime TODAY = LocalDateTime.parse("2020-10-01T18:00:00");

  @Test
  public void processingUsersUpdateNewUsers() {
    List<User> users = createUsersList(1);
    User expectedResult = new User("James", "Dean", 27, "james.dean@company.com", ACTIVE, LocalDateTime.parse("2020-09-29T08:00:15"));
    UserService service = new UserService(users, TODAY);
    List<User> result = service.processingUsers(1);

    assertThat(result.size()).isEqualTo(4);
    assertThat(result.get(0)).isEqualToComparingFieldByField(users.get(0));
    assertThat(result.get(1)).isEqualToComparingFieldByField(expectedResult);
    assertThat(result.get(2)).isEqualToComparingFieldByField(users.get(2));
    assertThat(result.get(3)).isEqualToComparingFieldByField(users.get(3));
  }

  @Test
  public void processingUsersEmptyList() {
    UserService app = new UserService(Collections.emptyList(), TODAY);
    assertThat(app.processingUsers(1).size()).isZero();
  }

  @Test
  public void processingUsersThrowException() {
    UserService app = new UserService(createUsersList(1), TODAY);
    assertThatThrownBy(() -> app.processingUsers(99))
      .isInstanceOf(RuntimeException.class)
      .hasMessage("Unknown option");
  }

  @Test
  public void processingUsersBlockInactiveUsers() {
    List<User> users = createUsersList(2);
    User expectedResult = new User("George", "Fox", 27, "george.fox@company.com", BLOCKED, LocalDateTime.parse("2020-07-01T12:30:15"));
    UserService app = new UserService(users, TODAY);
    List<User> result = app.processingUsers(2);

    assertThat(result.size()).isEqualTo(4);
    assertThat(result.get(0)).isEqualToComparingFieldByField(users.get(0));
    assertThat(result.get(1)).isEqualToComparingFieldByField(users.get(1));
    assertThat(result.get(2)).isEqualToComparingFieldByField(users.get(2));
    assertThat(result.get(3)).isEqualToComparingFieldByField(expectedResult);
  }

  private List<User> createUsersList(int option) {
    switch (option) {
      case 1:
        return new ArrayList<>(asList(
          new User("Davis", "Miles", 20, "noemail@company.com", NEW, LocalDateTime.parse("2020-10-01T19:00:00")),
          new User("James", "Dean", 27, "james.dean@company.com", NEW, LocalDateTime.parse("2020-09-29T08:00:15")),
          new User("John", "Edwards", 34, "john.edwards@company.com", ACTIVE, LocalDateTime.parse("2019-06-01T12:30:15")),
          new User("George", "Fox", 27, "george.fox@company.com", INACTIVE, LocalDateTime.parse("2020-07-01T12:30:15"))
        ));
      case 2:
        return new ArrayList<>(asList(
          new User("Davis", "Miles", 20, "noemail@company.com", INACTIVE, LocalDateTime.parse("2020-09-25T19:00:00")),
          new User("James", "Dean", 27, "james.dean@company.com", NEW, LocalDateTime.parse("2020-09-29T08:00:15")),
          new User("John", "Edwards", 34, "john.edwards@company.com", ACTIVE, LocalDateTime.parse("2019-06-01T12:30:15")),
          new User("George", "Fox", 27, "george.fox@company.com", INACTIVE, LocalDateTime.parse("2020-07-01T12:30:15"))
        ));
      default:
        return Collections.emptyList();
    }
  }
}
