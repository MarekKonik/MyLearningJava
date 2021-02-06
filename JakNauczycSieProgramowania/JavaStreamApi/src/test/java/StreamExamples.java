import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExamples {
    List<Employee> employeeList = new ArrayList<>();

    @BeforeEach

    public void setUp() {


        Employee employee1 = new Employee("Marek", "Konik", 45, List.of("PHP", "Java", "SQL"));
        Employee employee2 = new Employee("Janek", "Basinski", 39, List.of("PHP", "Java", "Python", "Scala", "SQL"));
        Employee employee3 = new Employee("Wioletta", "Jankowsk", 34, List.of("Java", "PHP", "Java Script", "Python", "Scala", "SQL"));
        Employee employee4 = new Employee("Jank", "Wolaszewska", 28, List.of("Java", "PHP", "SQL"));
        Employee employee5 = new Employee("Magdalena", "Mikulska", 25, List.of("Java", "PHP", "Haskell", "Rust", "SQL"));
        Employee employee6 = new Employee("Wojtek", "Malinowski", 32, List.of("Java", "PHP", "Haskell", "Rust", "SQL"));
        Employee employee7 = new Employee("Tomasz", "Kozacki", 39, List.of("Java", "C", "C++", "Springa", "Haskell", "Rust", "SQL"));
        Employee employee8 = new Employee("Tomasz", "Filipinsk", 26, List.of("Java", "C", "C++", "Springa", "SQL"));


        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeList.add(employee4);
        employeeList.add(employee5);
        employeeList.add(employee6);
        employeeList.add(employee7);
        employeeList.add(employee8);
    }

    @Test
    public void showAllEmployees() {
        employeeList.stream()
                .forEach(System.out::println);
    }

    @Test
    public void methodFromClass() {
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .filter(employee -> employee.getFirstName().startsWith("T"))

                .forEach(Employee::showListSkills);


    }


    @Test
    public void mapOfOperation() {
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .map(employee -> employee.getFirstName() + " " + employee.getLastName() + " " + employee.showHelloAndFirstName())

                .forEach(System.out::println);

    }

    @Test

    public void flatMapOperation() {
        List<List<String>> allSkills = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .map(Employee::getSkills)
                .collect(Collectors.toList());


        System.out.println(allSkills);


        List<String> allSkills1 = employeeList.stream()
                .map(Employee::getSkills)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(allSkills1);

    }


    @Test
    public void filterOperation() {
        employeeList.stream()
                .filter(employee -> employee.getFirstName().startsWith("T"))
                .forEach(System.out::println);
    }


    @Test
    public void sortedOperation() {
        List<Employee> sortedList = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getLastName))
                .collect(Collectors.toList());

        for (Employee e : sortedList) {
            System.out.println(e.getFirstName() + " " + e.getLastName());
        }

    }


    @Test
    public void limitOperation() {
        List<Employee> limitListEmployee = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .limit(2)
                .collect(Collectors.toList());

        for (Employee e : limitListEmployee) {
            System.out.println(e.getFirstName() + " " + e.getLastName() + " " + e.getAge());
        }
    }

    @Test
    public void skipOperation() {
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getFirstName))
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void countOperation() {
        long employeeOld34 = employeeList.stream()
                .filter(employee -> employee.getAge() >= 34)
                .count();

        System.out.println(employeeOld34);
    }


    @Test
    public void minMaxOperation() {
        Employee youngestEmployee = employeeList.stream()
                .min(Comparator.comparing(Employee::getAge))
                .get();

        System.out.println(youngestEmployee);

        Employee oldestEmployeer = employeeList.stream()
                .max(Comparator.comparing(Employee::getAge))
                .get();

        System.out.println(oldestEmployeer);

    }


    @Test
    public void findFirstFindAnyOperation() {
        Employee firstEmployee = employeeList.stream()
                .filter(employee -> employee.getFirstName().startsWith("T"))
                .findFirst()
                .get();
        System.out.println(firstEmployee);


        Employee anyEmployee = employeeList.stream()
                .filter(employee -> employee.getFirstName().startsWith("T"))
                .findAny()
                .get();
        System.out.println(anyEmployee);

    }

    @Test
    public void allMatchOperatin() {
        boolean b = employeeList.stream()
                .allMatch(employee -> employee.getFirstName().startsWith("T"));

        System.out.println(b);


        boolean b1 = employeeList.stream()
                .anyMatch(employee -> employee.getFirstName().contains("a"));

        System.out.println(b1);


        boolean b3 = employeeList.stream()
                .noneMatch(employee -> employee.getFirstName().startsWith("T"));

        System.out.println(b3);

    }


    @Test
    //idea metody reduce jest zredukowanie calego streama do jednego elementu
    public void reduceOperatin() {
        Integer sumOfAllAges = employeeList.stream()
                .map(Employee::getAge)

                //pierwszy konstruktor
                //piszemy pierwsze dwa elementy stream, strzalka, dalej co chcemy z nimi zrobic
                //.reduce((age1, age2) -> age1 + age2)
                .reduce(Integer::sum)
                .get();

        System.out.println(sumOfAllAges);


        //drugi konstruktor
        Integer sumOfAllAges1 = employeeList.stream()
                .map(Employee::getAge)
                .reduce(0, Integer::sum);
        //.reduce(0, (age1, age2) -> age1 + age2);

        System.out.println(sumOfAllAges1);

        //trzeci konstruktor
        Integer sumAllAges3 = employeeList.stream()
                .reduce(0, (age, employeeList) -> age + employeeList.getAge(), Integer::sum);
        System.out.println(sumAllAges3);

        //wstawienie dowolnego znaku pomiedzy elementami streama

        String allName = employeeList.stream()
                .map(Employee::getFirstName)
                .reduce((name0, name1) -> name0 + ", " + name1)
                .get();

        System.out.println(allName);

    }

    @Test
    public void takeWhileOperation(){
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .takeWhile(employee -> employee.getAge()<30)
                .forEach(System.out::println);
    }

    @Test
    public void dropWhileOperation(){
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .dropWhile(employee -> employee.getAge()<30)
                .forEach(System.out::println);
    }


    @Test
    public void forEachOperation(){

        //funkcja ta gwarantuje wlasciwo kolejnosc przy wykonywaniu streama wielowotkowo

        String sentence = "Marek uczy sie programowania z nie wielkim skutkiem";

        //Wyswietlenie Stringa tekstu podzielonego na znaki
        sentence.chars().forEach(s->System.out.print((char) s));

        //Wyswietlenie tekstu wielowatkowo z podzialem na znaki
        System.out.println();
        sentence.chars().parallel().forEach(s->System.out.print((char) s));
        System.out.println();
        //Zastosowanie funkcji forEachOrder()
        sentence.chars().parallel().forEachOrdered(s->System.out.print((char) s));

    }

    @Test
    public void peekOperation(){
        List<Employee> newEmployee = employeeList.stream()
                .peek(employee -> employee.setFirstName("Marek"))
                .collect(Collectors.toList());

        for (Employee e: newEmployee){
            System.out.println(e.getFirstName()+" "+e.getLastName());
        }

        System.out.println();
        System.out.println(employeeList);
    }







}
