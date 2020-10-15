package task.initial;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static task.initial.Status.*;

public class UserService {
  private final List<User> users;
  private final LocalDateTime today;

  public UserService(List<User> users, LocalDateTime today) {
    this.users = users;
    this.today = today;
  }

  private UserService(List<User> users) {
    today = LocalDateTime.now();
    this.users = users;
  }

  public void processingUsers() {
    System.out.println("CURRENT DATATIME: " + today);
    System.out.println("PRINT INITIAL LIST STATUS");
    users.stream().filter(Objects::nonNull).forEach(System.out::println);

    List<User> updatedList = updateNewUsers(users);
    System.out.println("\nPRINT LIST AFTER STATUS WAS CHANGED [NEW --> ACTIVE]");
    updatedList.forEach(System.out::println);

    List<User> updatedList2 = blockInactiveUsers(users);
    System.out.println("\nPRINT LIST AFTER STATUS WAS CHANGED [INACTIVE --> BLOCKED]");
    updatedList2.forEach(System.out::println);
  }

  public List<User> processingUsers(int option) {
    switch (option) {
      case 1:
        return updateNewUsers(users);
      case 2:
        return blockInactiveUsers(users);
      default:
        throw new RuntimeException("Unknown option");
    }
  }

  private List<User> updateNewUsers(List<User> users) {
    return users.stream()
      .filter(Objects::nonNull)
      .map(this::changeStatus).collect(Collectors.toList());
  }

  private User changeStatus(User user) {
    if (isValidForUpdate(user)) {
      user.setStatus(ACTIVE);
    }
    return user;
  }

  private boolean isValidForUpdate(User user) {
    return user.getTimestamp() != null && user.getStatus() != null
      && user.getTimestamp().compareTo(today.minusDays(1)) < 0 && user.getStatus().equals(NEW);
  }

  private List<User> blockInactiveUsers(List<User> users) {
    return users.stream()
      .filter(Objects::nonNull)
      .map(user -> {
        if (isInactive(user)) {
          user.setStatus(BLOCKED);
        }
        return user;
      }).collect(Collectors.toList());
  }

  private boolean isInactive(User user) {
    return user.getStatus() != null && user.getTimestamp() != null
      && user.getStatus().equals(INACTIVE) && user.getTimestamp().compareTo(today.minusMonths(1)) < 0;
  }
}
