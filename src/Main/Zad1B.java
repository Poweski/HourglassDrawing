import java.util.Scanner;

public class Zad1B {

    public static void main(String[] args) {
        System.out.println();
        drawBridge(makeARequest("Podaj liczbę znaków: "));
    }
    public static int makeARequest(String order) {
        boolean flag = true;
        int result = 0;
        while (flag) {
            System.out.print(order);
            result = tryCollectData();
            if (result > 0)
                flag = false;
        }
        return result;
    }
    public static int tryCollectData() {
        try {
            int result = Integer.parseInt(collectData());
            if (!(result > 0))
                throw new IllegalArgumentException();
            return result;
        }
        catch (NumberFormatException e) {
            System.out.println("Podano błędne dane!");
            return 0;
        }
        catch (IllegalArgumentException e) {
            System.out.println("Podano wartość niedodatnią!");
            return 0;
        }
    }
    public static String collectData() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static void drawBridge(int n) {
        if (n == 1)
            drawDeck(2*n-1);
        else if (n == 2) {
            drawDeck(2*n -1);
            drawBase(n);
        }
        else {
            drawPeak(n);
            drawDeck(2*n-1);
            drawBase(n);
        }
    }
    public static void drawDeck(int n) {
        for (int i=0; i<n; i++)
            drawX();
        System.out.println();
    }
    public static void drawBase(int n) {
        drawI();
        for (int i=0; i<2*n-3; i++)
            drawSpace();
        drawI();
        System.out.println();
    }
    public static void drawPeak(int n) {
        drawBase(n);
        for (int i=0; i<n-3; i++)
            drawLine(n,i);
    }
    public static void drawLine(int n, int j) {
        drawI();
        for (int i=0; i<j; i++)
            drawSpace();
        drawLine1();
        for (int i=0; i<2*(n-j)-5; i++)
            drawSpace();
        drawLine2();
        for (int i=0; i<j; i++)
            drawSpace();
        drawI();
        System.out.println();
    }
    public static void drawX() {
        System.out.print("X");
    }
    public static void drawI() {
        System.out.print("I");
    }
    public static void drawLine1() {
        System.out.print("\\");
    }
    public static void drawLine2() {
        System.out.print("/");
    }
    public static void drawSpace() {
        System.out.print(" ");
    }
}
