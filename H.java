import java.util.ArrayList;

public class H {
    //Sozdat masiiv
   private static SimpleBox[] mass = new SimpleBox[10];
   private static ArrayList arrayList = new ArrayList();

    public static void fillMassiv()
    {
        for (int i = 0; i <10 ; i++)
        {
            String s = i+" Object";
           mass[i] = new SimpleBox(s);
            System.out.print(mass[i]+" ");
        }
    }
    public static void change(int el1 ,int ell2)
    {
        if (el1>=0 && el1<mass.length && ell2>=0 && ell2<mass.length)
        {
            SimpleBox box=null;
            box=mass[el1];
            mass[el1]=mass[ell2];
            mass[ell2]=box;
        }
    }
    public static void showMass()
    {
        for (SimpleBox m:mass)
        {
            System.out.print(m+" ");
        }
    }
    public static ArrayList toArrayList(SimpleBox[] mass)
    {
        for (SimpleBox m :mass)
        {
           arrayList.add(m);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        fillMassiv();
        System.out.println(mass+" Length"+mass.length);
        change(2,4);
        showMass();
        toArrayList(mass);
        System.out.println(arrayList);

        ArrayList<Apple> apples = new ArrayList<>();//apples.add(new Apple(11));apples.add(new Apple(12));
        Box<Apple> appleBox = new Box<Apple>(apples);
        appleBox.basket.add(new Apple(11.99f));appleBox.basket.add(new Apple(21.99f));
        ArrayList<Orange> oranges = new ArrayList<>();//oranges.add(new Orange(12));oranges.add(new Orange(43));
        Box<Orange> orangeBox = new Box<>(oranges);
        orangeBox.basket.add(new Orange(12.78f));orangeBox.basket.add(new Orange(12.9f));
        //System.out.println(orangeBox.basket.get(1).getWeight());

        System.out.println("Ves Opelsinov "+orangeBox.getWeight());
        System.out.println("Ves Yaplok "+appleBox.getWeight());
        System.out.println("Perviy  tiagelee? "+orangeBox.compare(appleBox));

    }
}
 class Fruit
{
   public float weightFF;

    public Fruit(float weightFF) {
        this.weightFF = weightFF;
    }
}
class Apple extends Fruit
{
  float weight;

    public Apple(float weight) {
        super(weight);
        this.weight = weight;
    }
}
class Orange extends Fruit
{
    private float weight;

    public Orange(float weight) {
        super(weight);
        this.weight = weight;
    }
}
class Box<T extends Fruit>
{
     private float weight;
     ArrayList<T> basket;
      public Box(ArrayList<T> basket)
    {
        this.basket = basket;
    }

    public  float getWeight()
    {
        for(int i = 0; i < basket.size(); i++)
        {
            weight = weight+basket.get(i).weightFF;
        }

        return weight;
    }
    public Boolean compare(Box<? extends Fruit> b)
    {
        return b.getWeight()<this.getWeight();
    }

}
