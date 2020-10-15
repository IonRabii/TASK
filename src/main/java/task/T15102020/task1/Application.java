package task.T15102020.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

import static java.util.Arrays.asList;

public class Application {

  public static void main(String[] args) {
    print(createList());
    run();
  }

  private static void run() {
    System.out.println("\nTEST_#1");
    Team footballTeam = new FootballTeam("Barcelona", 11, "TF1", "Spania");
    footballTeam.singHymn(); // will be called method from FootballTeam
    // footballTeam.singHymn("Spania"); // will throw compilation error because method wiht siganture signHymn(String s)
    // is not defined in Team class

    System.out.println("\nTEST_#2");
    HockeyTeam hockeyTeam = new HockeyTeam("Washington Capitals", 20, "TH1", "SUA");
    hockeyTeam.singHymn(); // will be called method from FootballTeam
    hockeyTeam.singHymn("SUA");  // will work because HockeyTeam class contains method with singnature signHymn(String s)

    // HockeyTeam team = (HockeyTeam) new Team(); // will not work. Will produce ClassCastException at runtime

    System.out.println("\nTEST_#3");
    Team team = new Team("OTHER_TEAM", 2, "TO1", "UNKNOWN");
    team.singHymn(); // will be called method from Team
  }

  private static void print(List<Team> teams) {
    System.out.println("\nPRINT ALL FOOTBALL TEAMS");
    teams.stream().filter(Objects::nonNull).filter(e -> e instanceof FootballTeam).forEach(System.out::println);

    System.out.println("\nPRINT ALL BASKETBALL TEAMS");
    teams.stream().filter(Objects::nonNull).filter(e -> e instanceof BasketballTeam).forEach(System.out::println);

    System.out.println("\nPRINT ALL NON FOOTBALL AND NON BASKETBALL TEAMS");
    Predicate<Team> otherTeams = e -> !(e instanceof FootballTeam) && !(e instanceof BasketballTeam);
    teams.stream().filter(Objects::nonNull).filter(otherTeams).forEach(System.out::println);
  }

  private static List<Team> createList() {
    return new ArrayList<>(asList(
      new FootballTeam("Barcelona", 11, "TF1", "Spania"),
      new FootballTeam("Juventus", 11, "TF2", "Italia"),
      new FootballTeam("Real Madrid", 11, "TF3", "Spania"),
      new BasketballTeam("Houston Rockets", 10, "TB1", "SUA"),
      new BasketballTeam("Dallas Mavericks", 10, "TB2", "SUA"),
      new WaterPoloTeam("Pro Recco", 7, "TW1", "Italia"),
      new WaterPoloTeam("United States men's national water polo team", 7, "TW2", "SUA"),
      new WaterPoloTeam("VK Jug", 7, "TW3", "Croatia"),
      new HockeyTeam("Washington Capitals", 20, "TH1", "SUA")
    ));
  }

}
