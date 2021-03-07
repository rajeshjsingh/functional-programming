package examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {

    public static void main(String[] args) {
        FlatMapExample mapExample = new FlatMapExample();
        List<User> users = mapExample.getUsers();

        //iterate list using Stream for each
        users.stream().forEach((t) -> System.out.println(t));

        System.out.println();

        // concatenate first name and last name using stream map function

        List<String> names = users.stream().map(t -> {
            String name = t.getFirstName() + " " + t.getLastName();
            return  name;
        }).collect(Collectors.toList());

        names.stream().forEach(t -> System.out.println(t));

        System.out.println();
        // Line # 17 to #21 can be achieved in one line of code
        users.stream().map(t ->  t.getFirstName() + " " + t.getLastName()).forEach(System.out::println);

    }

    private  List<User> getUsers(){
        List<User> users = Arrays.asList(
                new User("Tom","Mathews",42,"M"),
                new User("Linda","Rey",35,"F"),
                new User("Borris","Beker",50,"M"),
                new User("Maria","Sarapova",35,"F"),
                new User("Rafel","Nadal",40,"M")

        );
        return users;
    }
    class User {
        private String firstName;
        private String lastName;
        private String sex;
        private int age;

        public User(String firstName,String lastName, int age,String sex){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.sex = sex;
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

        @Override
        public String toString() {
            return "User{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", sex='" + sex + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
