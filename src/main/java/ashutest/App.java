package ashutest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class App extends Base
{

    public int empid = 24;
    public String name = "ashu";

    @Override
    protected String getName() {
        return super.getName();
    }

    public static void main(String[] args )
    {
        App a1 = new App();
        App a2 = a1;
        System.out.println(a2.name);
        Timer timer = new Timer();
        Date date = new Date();
        date.setHours(22);
        date.setMinutes(50);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        },date);
        //timer.cancel();


    }
}
