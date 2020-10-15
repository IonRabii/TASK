package task.T15102020.task1;

public class HockeyTeam extends Team {

  public HockeyTeam() {
    System.out.println("Creating new class of type " + this.getClass().getSimpleName());
  }

  public HockeyTeam(String name, int numberOfPlayers, String teamTalisman, String country) {
    super(name, numberOfPlayers, teamTalisman, country);
    System.out.println("Creating new class of type " + this.getClass().getSimpleName());
  }

  @Override
  public void singHymn() {
    System.out.println("Hockey team sign hymn!!!");
  }

  public void singHymn(String country) {
    System.out.println("[" + country + "] Hockey team sign hymn!!!");
  }
}
