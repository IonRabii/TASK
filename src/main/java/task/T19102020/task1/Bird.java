package task.T19102020.task1;

public class Bird extends AbstractAnimal {

  public Bird(String name, String species, int age, int averageLifeSpan) {
    super(name, species, age, averageLifeSpan);
  }

  @Override
  public String move() {
    return "The bird flies";
  }
}
