package Matnum;
import java.util.Scanner;

public class Prostokatow {
    // METODA STARTOWA
    public static void start(){
        setSIZE(); // USTAWIA STOPIEN WIELOMIANU
        buildFUNC(); // BUDUJE WIELOMIAN DO OBLICZANIA
        paintFUNC(); // WYPISUJE FUNKCJE
        setRANGE(); // USTAWIA PRZEDZIAL CALKOWANIA
        setSLICES(); // USTAWIA ILOSC KAWALKOW
        aproximate(); // PRZYBLIZANIE
        showResult(); // WYPISUJE WYNIK
    }
    //////////////////////////////
    private static double[] FUNC; // TABLICA Z WSPOLCZYNNIKAMI FUNKCJI
    private static int SIZE; // ROZMIAR TABLICY PRZECHOWUJACEJ WSPOLCZYNNIKI FUNKCJI
    private static Scanner SCAN = new Scanner(System.in); // OBIEKT POBIERANIA DANYCH
    private static double LEFT; // POCZATEK PRZEDZIALU
    private static double RIGHT; // KONIEC PRZEDZIALU
    private static double SLICES; // LICZBA CZESCI
    private static double DX; // ZMIENNA DLA DZIELENIA PRZEDZIAŁÓW
    private static double RESULT; // WYNIK

    private static void setSIZE(){
        int n;
        do {
            System.out.print("Podaj stopień n -> ");
            n = SCAN.nextInt();
        }while (n<0);

        SIZE = n;
    }
    private static void buildFUNC(){
        FUNC = new double[SIZE+1];
        for(int index=SIZE; index>=0; index--){
            System.out.print("Wprowadź wartość współczynnika dla x^" + index + " > ");
            FUNC[index] = SCAN.nextDouble();
        }
    }
    private static void paintFUNC(){
        System.out.println();
        System.out.print("Badana funkcja -> " + FUNC[SIZE-1] + "x^" + SIZE);

        for(int index=SIZE-1; index>=0; index--){
            if(index==0) System.out.print(" + " + FUNC[0]);
            else System.out.print(" + " + FUNC[index] + "x^" + index);
        }
        System.out.println();
    }
    private static void setRANGE(){
        System.out.print("Podaj lewy kraniec przedziału > ");
        LEFT = SCAN.nextDouble();
        System.out.print("Podaj prawy kraniec przedzialu > ");
        RIGHT = SCAN.nextDouble();
    }
    private static void setSLICES(){
        System.out.print("Podaj dokładność > ");
        SLICES = SCAN.nextDouble();
    }
    private static double calc(double x){
        double value = 0;
        for(int index=SIZE; index>=0; index--){
            value  = value + (FUNC[index] * Math.pow(x,index));
        }

        return value;
    }
    private static void aproximate(){
        DX = (RIGHT - LEFT) / SLICES; // WYZNACANIE SZEROKOSCI PROSTOKATA
        RESULT = 0;

        for(int index=1; index<=SLICES; index++){ // SUMOWANIE POL
            RESULT += calc(LEFT + index * DX); // PODANIE JAKO ARGUMENT -> POCZATEK + KOLEJNE SZEROKOSCI PROSTOKATOW
        }

        RESULT = RESULT * DX; // PO ZSUMOWANIU (ZBUDOWANIU JEDNEJ WYSOKOSCI) MNOZE RAZY SZEROKOSC
    }
    private static void showResult(){
        System.out.println("Wynik całkowania > " + RESULT);
    }
}
