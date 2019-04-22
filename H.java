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
    }
}
class Fruit
{
   float weight;
}
class Apple extends Fruit
{
  float weight;

    public Apple(float weight) {
        this.weight = weight;
    }
}
class Orange extends Fruit
{
    float weight;

    public Orange(float weight) {
        this.weight = weight;
    }
}
class Box<T extends Fruit>
{
    private ArrayList<Fruit> bascet;
    public void addFruit()
    {
        bascet.add(new Apple(2.4f));
        bascet.add(new Orange(3.5f));
    }

    public <T extends Fruit> void compare(ArrayList<T> b)
    {



    }
}
