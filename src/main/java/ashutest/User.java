package ashutest;



import java.time.LocalDate;
import java.util.*;
import java.util.Arrays;
import java.util.stream.Collectors;

class User implements Comparable<User> {

    String name;
    String lastname;
    int age;
    double score;
    LocalDate doj;

    private class InnerClass
    {
        void hello () {
            System.out.println("hello");
        }
    }

    public User(String name, int age, String lastname,double score ){
        this.name = name;
        this.age = age;
        this.score = score;
        this.lastname = lastname;
        //InnerClass ic = new InnerClass();
        //ic.hello();
    }
    public User(String name, int age, String lastname,double score,LocalDate doj ){
        this.name = name;
        this.age = age;
        this.score = score;
        this.lastname = lastname;
        this.doj = doj;
        //InnerClass ic = new InnerClass();
        //ic.hello();
    }

    public double getScore () {
        return score;

    }

    public LocalDate getDoj() {
        return doj;
    }

    public String getName () {
        return name;
    }

        public void setName (String name){
        this.name = name;
    }

        @Override
        public int compareTo (User otherUser){
        return Integer.compare(getAge(), otherUser.getAge());
    }

        @Override
        public boolean equals (Object o){
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getAge() == user.getAge() &&
                Double.compare(user.getScore(), getScore()) == 0 &&
                getName().equals(user.getName()) &&
                lastname.equals(user.lastname);
    }

        @Override
        public int hashCode () {
        return Objects.hash(getName(), lastname, getAge(), getScore());
    }

        public int getAge () {
        return age;
    }

        public void setAge ( int age){
        this.age = age;
    }

        @Override
        public String toString () {
        return "User{" +
                "name='" + name + '\'' +
                "score='" + score + '\'' +
                "lastname='" + lastname + '\'' +
                ", age=" + age +
                '}';
    }

        public static void main (String[]args){

        /*List<User> sortedList = users.stream()
			.sorted((o1, o2) -> o1.getAge() - o2.getAge())
			.collect(Collectors.toList());*/
        User users [] = {
                new User("C", 30, "agrawal", 50),
                new User("A", 20, "bdsa", 10),
                new User("B", 90, "opmp", 100),
                new User("F", 40, "kdhg", 100),
                new User("G", 810, "gkgu", 40),
                new User("J", 10, "gkgu", 0.0)};

        Comparator<User> comp =  Comparator.comparingDouble(User::getScore).reversed()
                    .thenComparing(User::getAge)
                    .thenComparing(User::getName);

        List<User> sortedList = Arrays.stream(users).filter(x -> x.getScore() != 0.0)
                        .sorted(comp)
                .collect(Collectors.toList());
        boolean a = sortedList.add(new User("C",30,"yippe",20));



        //sortedList.forEach(System.out::println);
        Comparator<User> ageComp = (x, y) -> (Integer.valueOf(x.getAge()).compareTo(y.getAge()));
        Arrays.sort(users, ageComp);
        for (User user : users) {
            System.out.println(user.toString());
        }


    }

    }
