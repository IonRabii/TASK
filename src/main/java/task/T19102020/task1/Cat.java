package task.T19102020.task1;

public class Cat extends AbstractAnimal {

  public Cat(String name, String species, int age, int averageLifeSpan) {
    super(name, species, age, averageLifeSpan);
  }

  @Override
  public String move() {
    return "The cat is walking";
  }
}
