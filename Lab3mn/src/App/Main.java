package App;
import Matnum.Prostokatow;
import Matnum.Simpsona;
import Matnum.Trapezow;

import java.util.Scanner;

public class Main {
    private static int OPTION = -1;
    private static Scanner SCAN = new Scanner(System.in);

    public static void main(String[] args){
        while(OPTION != 0){
            System.out.println(" Metody numeryczne -> Lab3");
            System.out.println(" [ 1 ] Metoda prostokątów");
            System.out.println(" [ 2 ] Metoda trapezów");
            System.out.println(" [ 3 ] Metoda Simpsona");
            System.out.println(" [ 0 ] Zakończ");
            System.out.print("> ");
            OPTION = getOPTION();

            switch (OPTION){
                case 1:
                    Prostokatow.start();
                    break;
                case 2:
                    Trapezow.start();
                    break;
                case 3:
                    Simpsona.start();
                    break;
                case 0:
                    break;
                default:
                    System.out.println(" [ ! ] Nieprawidlowa opcja");
            }
        }
    }

    private static int getOPTION(){
        return SCAN.nextInt();
    }
}
