package Control;

/**
 * Created by Michael on 12/05/2016.
 */
public class chrono {
    public chrono() {
        long t1;
        int tpsSec = 1;
        t1 = java.lang.System.currentTimeMillis();
        if ((java.lang.System.currentTimeMillis() - t1) > 1000*tpsSec )
        {
            tpsSec++;
            System.out.println(tpsSec);
        }
    }
}
