package task.T19102020.task1;

public class Dog extends AbstractAnimal {

  public Dog(String name, String species, int age, int averageLifeSpan) {
    super(name, species, age, averageLifeSpan);
  }

  @Override
  public String move() {
    return "The dog is walking!";
  }
}
