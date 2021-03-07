package examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapExample {

    public static void main(String[] args) {
        FlatMapExample mapExample = new FlatMapExample();
        List<User> users = mapExample.getUsers();

        //iterate list using Stream for each
        users.stream().forEach((t) -> System.out.println(t));

        System.out.println();

        // get all Address  using stream flat map function

        List<String> names = users.stream().flatMap(t -> {
            Stream<String> cities = t.getAddresses().stream();
            return  cities;
        }).collect(Collectors.toList());

        names.stream().forEach(t -> System.out.println(t));

        System.out.println();
        // Line # 17 to #21 can be achieved in one line of code
        users.stream().flatMap(t ->  t.getAddresses().stream()).forEach(t -> System.out.println(t));
    }

    private  List<User> getUsers(){
        List<User> users = Arrays.asList(
                new User("Tom1","Mathews",42,"M", Arrays.asList("NY","NJ")),
                new User("Linda","Rey",35,"F",Arrays.asList("TN","VA")),
                new User("Borris","Beker",50,"M",Arrays.asList("TX","IL")),
                new User("Maria","Sarapova",35,"F",Arrays.asList("AZ","DE")),
                new User("Rafel","Nadal",40,"M",Arrays.asList("IN","FL"))

        );
        return users;
    }
    class User {
        private String firstName;
        private String lastName;
        private String sex;
        private int age;
        private List<String> addresses;

        public User(String firstName,String lastName, int age,String sex,List<String> addresses){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
            this.addresses = addresses;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public List<String> getAddresses() {
            return addresses;
        }

        public void setAddresses(List<String> addresses) {
            this.addresses = addresses;
        }

        @Override
        public String toString() {
            return "User{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", sex='" + sex + '\'' +
                    ", age=" + age +
                    ", addresses=" + addresses +
                    '}';
        }
    }
}
