package task.T19102020.task1;

import java.util.Objects;

public abstract class AbstractAnimal implements Animal {
  private final String name;
  private final String species;
  private final int age;
  private final int averageLifeSpan;

  public AbstractAnimal(String name, String species, int age, int averageLifeSpan) {
    this.name = name;
    this.species = species;
    this.age = age;
    this.averageLifeSpan = averageLifeSpan;
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public String species() {
    return species;
  }

  @Override
  public int age() {
    return age;
  }

  @Override
  public int averageLifeSpan() {
    return averageLifeSpan;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AbstractAnimal that = (AbstractAnimal) o;
    return age == that.age &&
      averageLifeSpan == that.averageLifeSpan &&
      name.equals(that.name) &&
      species.equals(that.species);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, species, age, averageLifeSpan);
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + " {" +
      "name='" + name + '\'' +
      ", species='" + species + '\'' +
      ", age=" + age +
      ", averageLifeSpan=" + averageLifeSpan +
      '}';
  }
}
