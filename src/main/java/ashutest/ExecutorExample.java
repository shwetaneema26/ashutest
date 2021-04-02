package ashutest;

import java.time.LocalDate;
import java.util.concurrent.*;

public class ExecutorExample {
    public static void main (String [] args)
    {
        Callable task = ()->
        {
            try
            {
                System.out.println(LocalDate.now());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 1;
        };
        ExecutorService ex = Executors.newFixedThreadPool(2);

         Future  fut = ex.submit(task);
        try {
            fut.get(10,TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        ex.shutdown();

    }
    }
