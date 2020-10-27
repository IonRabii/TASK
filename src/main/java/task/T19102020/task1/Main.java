package task.T19102020.task1;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Stream.of;

public class Main {

  public static void main(String[] args) {
    List<Animal> animals = createList();
    processingList(animals);
//    Map<String, List<Animal>> map = generateMapFrom(animals);
//    System.out.println("\nPRINT ALL MAP ELEMENTS THAT CONTAINS IN KEY THE WORD 'Cat'");
//    filterMapByKey(map, "Cat").forEach((k, v) -> System.out.println(k + " - " + v));
  }

  private static void processingList(List<Animal> animals) {
    System.out.println("PRINT INITIAL LIST");
    animals.stream().filter(Objects::nonNull).forEach(System.out::println);

    System.out.println("\nPPINT ALL DOGS WHOSE NAME BEGINS WITH [A]");
    filterDogsByName(animals, "A").forEach(System.out::println);

    System.out.println("\nPRINT ALL DOGS AND CATS WHOSE NAME BEGINS WITH [B]");
    filterDogsAndCatsByName(animals, "B").forEach(System.out::println);

    if (containsDuplicates(animals)) {
      System.out.println("List contains duplicates values!!!");
    }
  }

  private static void processingMap(List<Animal> animals) {
    Map<String, List<Animal>> map = generateMapFrom(animals);
    System.out.println("\nPRINT INITIAL MAP");
    map.forEach((key, value) -> System.out.printf("Key: (%s) Value: (%s)", key, value));

    System.out.println("\nPRINT ALL MAP ELEMENTS WHERE THE KEY CONTAINS THE WORD [DOG]");
    filterMapByKey(map, "Dog").forEach((key, value) -> System.out.printf("Key: (%s) Value: (%s)", key, value));

    System.out.println("\nPRINT ALL MAP ELEMENTS WHERE THE ANIMAL NAME START WITH [B]");
    filterMapByAnimalName(map, "B").forEach((key, value) -> System.out.printf("Key: (%s) Value: (%s)", key, value));

    System.out.println("\nPRINT ALL MAP ELEMENTS WHERE THE ANIMAL SPECIES IS EQUAL WITH [Tabby]");
    filterMapByAnimalSpecies(map, "Tabby").forEach((key, value) -> System.out.printf("Key: (%s) Value: (%s)", key, value));
  }

  private static Map<String, List<Animal>> filterMapByKey(Map<String, List<Animal>> map, String word) {
    Map<String, List<Animal>> filteredMap = new HashMap<>();
    map.forEach((k, v) -> {
      if (k.contains(word)) {
        filteredMap.put(k, v);
      }
    });
    return filteredMap;
  }

  private static Map<String, List<Animal>> filterMapByAnimalName(Map<String, List<Animal>> map, String prefix) {
    Map<String, List<Animal>> filteredMap = new HashMap<>();
    map.forEach((k, v) -> {
      if (v.stream().anyMatch(e -> e.name().startsWith(prefix))) {
        filteredMap.put(k, v);
      }
    });
    return filteredMap;
  }

  private static Map<String, List<Animal>> filterMapByAnimalSpecies(Map<String, List<Animal>> map, String species) {
    Map<String, List<Animal>> filteredMap = new HashMap<>();
    map.forEach((k, v) -> {
      if (v.stream().anyMatch(e -> e.species().equals(species))) {
        filteredMap.put(k, v);
      }
    });
    return filteredMap;
  }

  private static Map<String, List<Animal>> generateMapFrom(List<Animal> animals) {
    Set<List<Animal>> set = new HashSet<>();
    Map<String, List<Animal>> map = new HashMap<>();

    animals.forEach(e -> animals.forEach(e2 -> {
      if (combinationNotExist(set, e, e2)) {
        System.out.println(asList(e, e2));
        map.put(e.getClass().getSimpleName() + "+" + e2.getClass().getSimpleName(), asList(e, e2));
      }
    }));
//    Set<List<Animal>> combinations = animals.stream()
//      .flatMap(e -> animals.stream().filter(e2 -> !e2.equals(e))
//        .map(e3 -> of(e, e3).sorted(comparator).collect(Collectors.toList())))
//      .collect(Collectors.toSet());

//    combinations.forEach(e -> {
//      String key = e.get(0).getClass().getSimpleName() + "+" + e.get(1).getClass().getSimpleName();
////      if (isValid(map, key, e)) {
//      map.put(key, e);
////      }
//    });
    return map;
  }

  private static boolean combinationNotExist(Set<List<Animal>> set, Animal e, Animal e2) {
    Comparator<Animal> comparator = Comparator.comparing(Animal::name)
      .thenComparing(Animal::species).thenComparing(Animal::age).thenComparing(Animal::averageLifeSpan);

    return !e.equals(e2) && set.add(of(e, e2).sorted(comparator).collect(Collectors.toList()));
  }

  private static boolean containsDuplicates(List<Animal> animals) {
    List<Animal> newList = new ArrayList<>(new HashSet<>(animals));
    return newList.size() != animals.size();
  }

  private static List<Animal> filterDogsByName(List<Animal> animals, String prefix) {
    return animals.stream()
      .filter(e -> e != null && e.name().startsWith(prefix) && e instanceof Dog).collect(toList());
  }

  private static List<Animal> filterDogsAndCatsByName(List<Animal> animals, String prefix) {
    Predicate<Animal> filter = e -> e != null && e.name().startsWith(prefix)
      && (e instanceof Dog || e instanceof Cat);
    return animals.stream().filter(filter).collect(toList());
  }

  private static List<Animal> createList() {
    return new ArrayList<>(asList(
      new Dog("Apollo", "Norwich", 2, 8),
      new Dog("Baxter", "Husky", 1, 15),
      new Cat("Simba", "Lynx", 2, 10),
      new Cat("Binx", "Tabby", 2, 10),
      new Bird("Rio", "Paridae", 2, 10),
      new Bird("Pilot", "Fringillidae", 2, 10)
    ));
  }
}
