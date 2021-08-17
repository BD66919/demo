package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class lambda {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("123");
        stringList.add("234");
        stringList.add("789");
        stringList.add("1234");
        List<String> filterList = stringList.stream().filter(t->t.contains("123")).collect(Collectors.toList());
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(12,"张三"));
        personList.add(new Person(14,"王五"));
        personList.add(new Person(13,"李四"));
        personList = personList.stream().sorted((p1,p2)->p1.getAge()-p2.getAge()).collect(Collectors.toList());
        personList.forEach(p-> System.out.println(p.getName()));
    }

    private static class Person{
        int age;
        String name;
        Person(int age,String name) {
            this.age = age;
            this.name = name;
        }
        public int getAge(){
            return this.age;
        }
        public String getName(){
            return this.name;
        }
    }


}
