package ashutest;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

final public class Employee {
    final private String name;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", doj=" + doj.toLocaleString() +
                '}';
    }

    final private long id ;
    final private Date doj;

    public Employee(String name, long id, Date doj) {
        this.name = name;
        this.id = id;
        this.doj = doj;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public Date getDoj() {
        return doj;
    }
    public static void main (String args [])
    {
        Date date = new Date(2012,Calendar.OCTOBER,01);
        date.setDate(20121005);
        Employee emp = new Employee("Ashu",12345,date);
        //date.plusDays(10);
        System.out.println(emp.toString());
        System.out.println(Calendar.getInstance().getTime());
    }
}

