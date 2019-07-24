package PULLTHEADS;

import java.util.concurrent.CyclicBarrier;

public class CiclikBarrierferry {
    private static final CyclicBarrier BARRIER = new CyclicBarrier(3, new FerryBoat());
    //Инициализируем барьер на три потока и таском, который будет выполняться, когда
    //у барьера соберется три потока. После этого, они будут освобождены.
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60));
        PULLTHEADS.Car[] cars = new PULLTHEADS.Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new PULLTHEADS.Car(race, 20 + (int) (Math.random() * 10),0,(byte)0);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
//        for (int i = 0; i < 9; i++) {
//            new Thread(new Car(i)).start();
//            Thread.sleep(400);
//        }

    }

    //Таск, который будет выполняться при достижении сторонами барьера
    public static class FerryBoat implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
                System.out.println("Паром переправил автомобили!");
            } catch (InterruptedException e) {
            }
        }
    }

    //Стороны, которые будут достигать барьера
    public static class Car implements Runnable {
        private int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            try {
                System.out.printf("Автомобиль №%d подъехал к паромной переправе.\n", carNumber);
                //Для указания потоку о том что он достиг барьера, нужно вызвать метод await()
                //После этого данный поток блокируется, и ждет пока остальные стороны достигнут барьера
                BARRIER.await();
                System.out.printf("Автомобиль №%d продолжил движение.\n", carNumber);
            } catch (Exception e) {
            }
        }
    }
}
