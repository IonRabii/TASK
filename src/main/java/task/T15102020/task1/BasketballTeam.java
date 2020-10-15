package task.T15102020.task1;

public class BasketballTeam extends Team{

  public BasketballTeam() {
    System.out.println("Creating new class of type " + this.getClass().getSimpleName());
  }

  public BasketballTeam(String name, int numberOfPlayers, String teamTalisman, String country) {
    super(name, numberOfPlayers, teamTalisman, country);
    System.out.println("Creating new class of type " + this.getClass().getSimpleName());
  }

  @Override
  public void singHymn() {
    System.out.println("Basketball team sign hymn!!!");
  }

  public void singHymn(String country) {
    System.out.println("[" + country + "] Basketball team sign hymn!!!");
  }
}
