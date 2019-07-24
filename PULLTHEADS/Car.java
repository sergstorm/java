package PULLTHEADS;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static final CyclicBarrier BARRIER = new CyclicBarrier(8);
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private Long time;
    private byte stageN;

    public byte getStageN() {
        return stageN;
    }

    public void setStageN(byte stageN) {
        this.stageN = stageN;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed,long time,byte stageN) {
        this.time=time;
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.stageN=stageN;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов"+" TIME "+this.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            try {
               if(i==0) BARRIER.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            race.getStages().get(i).go(this);
        }
    }
}
