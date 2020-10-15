package task.T15102020.task1;

public class WaterPoloTeam extends Team {

  public WaterPoloTeam() {
    System.out.println("Creating new class of type " + this.getClass().getSimpleName());
  }

  public WaterPoloTeam(String name, int numberOfPlayers, String teamTalisman, String country) {
    super(name, numberOfPlayers, teamTalisman, country);
    System.out.println("Creating new class of type " + this.getClass().getSimpleName());
  }

  @Override
  public void singHymn() {
    System.out.println("Water polo team sign hymn!!!");
  }

  public void singHymn(String country) {
    System.out.println("[" + country + "] Water polo team sign hymn!!!");
  }
}
