package examples.predicate;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicates {

    public static Predicate<Employee> isAdultMale(){
        return p -> p.getAge() > 18 && p.getGender()=="M";
    }

    public static Predicate<Employee> isAdultFemale(){
        return p -> p.getAge() > 18 && p.getGender() =="F";
    }

    public static List<Employee> filterEmployees(List<Employee> employees, Predicate<Employee> predicate){
        return employees.stream().filter(predicate).collect(Collectors.toList());
    }
}
