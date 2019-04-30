import com.sun.deploy.util.SyncAccess;

public class SortMass {
    public static void main(String[] args) {
        int[] a = new int[10000];
        int[] b = new int[10000];
        long curt1=0;long curt2=0;

       // createmass(a);copy(a,b);
       // printconsole(a);
        for (int i = 0; i <5 ; i++) {
            createmass(a);copy(a,b);
            curt1 = System.currentTimeMillis();
            selectionSort(a);
            curt2 = System.currentTimeMillis();
            System.out.println("TIME vibor" + (curt2 - curt1));

            curt1 = System.currentTimeMillis();
            bubbleSort(b);
            curt2 = System.currentTimeMillis();
            System.out.println("TIME bubble" + (curt2 - curt1));

            //printconsole(a);printconsole(b);
        }
    }
    public boolean exist(int[] a,int b)
    {
        for (int i = 0; i <a.length ; i++) {
            if (a[i]==b)return true;
        }
        return false;
    }
    public void delete(int[] a,int value){
        int i = 0;
        for(i = 0; i < a.length; i++) {
            if (a[i] == value) {
                break;
            }
        }

        for (int j = i; j < a.length - 1; j++){
            a[j] = a[j + 1];
        }

    }
    public int[] insert(int[] a, int value){
        int b[] = new int [a.length+1];
        b[a.length] = value;
        return b;
    }



    private static void createmass(int[] a) {
        for (int i = 0; i <a.length ; i++) {
            a[i]=(int)(Math.random()*a.length);
        }
    }

    private static void copy(int[] c,int []d)
    {
        for (int i = 0; i <c.length ; i++) {
             d[i]=c[i];
        }
    }

    private static void printconsole(int[] a) {
        for (int i = 0; i <a.length ; i++) {
            System.out.printf("%10d",a[i]);
            if (i%10==0) System.out.println();
        }
    }

    public static void selectionSort(int[] arr){
    /*По очереди будем просматривать все подмножества
      элементов массива (0 - последний, 1-последний,
      2-последний,...)*/
        for (int i = 0; i < arr.length; i++) {
        /*Предполагаем, что первый элемент (в каждом
           подмножестве элементов) является минимальным */
            int min = arr[i];
            int min_i = i;
        /*В оставшейся части подмножества ищем элемент,
           который меньше предположенного минимума*/
            for (int j = i+1; j < arr.length; j++) {
                //Если находим, запоминаем его индекс
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
        /*Если нашелся элемент, меньший, чем на текущей позиции,
          меняем их местами*/
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }
    public static void bubbleSort(int[] arr){
    /*Внешний цикл каждый раз сокращает фрагмент массива,
      так как внутренний цикл каждый раз ставит в конец
      фрагмента максимальный элемент*/
        for(int i = arr.length-1 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
            /*Сравниваем элементы попарно,
              если они имеют неправильный порядок,
              то меняем местами*/
            if( arr[j] > arr[j+1] ){
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
        }
    }
}

}
