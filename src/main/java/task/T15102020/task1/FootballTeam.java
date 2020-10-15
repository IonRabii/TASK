package task.T15102020.task1;

public class FootballTeam extends Team {

  public FootballTeam() {
    System.out.println("Creating new class of type " + this.getClass().getSimpleName());
  }

  public FootballTeam(String name, int numberOfPlayers, String teamTalisman, String country) {
    super(name, numberOfPlayers, teamTalisman, country);
    System.out.println("Creating new class of type " + this.getClass().getSimpleName());
  }

  @Override
  public void singHymn() {
    System.out.println("Football team sign hymn!!!");
  }

  public void singHymn(String country) {
    System.out.println("[" + country + "] Football team sign hymn!!!");
  }

  @Override
  public String toString() {
    return "FootBallTeam {" +
      "name='" + super.getName() + '\'' +
      ", numberOfPlayers=" + super.getNumberOfPlayers() +
      ", teamTalisman='" + super.getTeamTalisman() + '\'' +
      ", country='" + super.getCountry() + '\'' +
      '}';
  }
}
