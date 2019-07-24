package PULLTHEADS;

public class Road extends Stage {
   private int count=0;
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            long t1=System.currentTimeMillis();
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            long t2=System.currentTimeMillis();
            long total = (t2-t1);
            System.out.println(c.getName() + " закончил этап: " + description+" TIME "+total);
            c.setTime(c.getTime()+total);
            if(c.getStageN()==2)
            {   count++;
                System.out.println(count+" WINNER !!!!!!!!!!!!!!!!!!!!!!!!!!!!" + c.getName() + " TIME: " + c.getTime());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
