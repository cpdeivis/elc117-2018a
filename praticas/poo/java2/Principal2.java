import java.util.ArrayList;
import java.util.Scanner;

public class Principal2{
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int size = ler.nextInt();
        ArrayList<Point> arrList = new ArrayList<Point>(size);
        for (int i = 0; i < size; i++) {
            arrList.add(new Point(ler.nextInt(),ler.nextInt()));
        }
        for (int i = 0; i < (size - 1); i++) {
            for (int j = i+1; j < size; j++) {
              System.out.println("Distância P"+ i + " to P"+ j +": " + arrList.get(i).Pitagoras(arrList.get(j)));
            }
        }
    }
}
