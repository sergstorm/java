package PULLTHEADS;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore smp = new Semaphore(2,true);
    private static final boolean[] PARKING_PLACES = new boolean[2];
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {long t1 = System.currentTimeMillis();
            try {
                smp.acquire();

                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                long t2 = System.currentTimeMillis();
                long total = t2-t1;
                c.setTime(c.getTime()+total);c.setStageN((byte) 2);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}