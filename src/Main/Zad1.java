import java.util.Scanner;

public class Zad1 {

    public static void main(String[] args) {
        System.out.println();
        drawHourglass(makeARequest("Podaj liczbę znaków: "));
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
    public static void drawHourglass(int n) {
        for (int i=n; i>=1; i--)
            drawHourglassLine(n, i);
        for (int i=2; i<=n; i++)
            drawHourglassLine(n, i);
    }
    public static void drawHourglassLine(int n, int i) {
        drawMultipleSpacing(n,i);
        drawLine(n,i);
        System.out.println();
    }
    public static void drawMultipleSpacing(int n, int i) {
        for (int j=1; j<=n-i; j++)
            drawSpace();
    }
    public static void drawLine(int n, int i) {
        if (i == n)
            drawSimpleLine(n);
        else
            drawComplexLine(i);
    }
    public static void drawSimpleLine(int n) {
        for (int i=0; i<2*n-1; i++)
            drawX();
    }
    public static void drawComplexLine(int n) {
        if (n == 1)
            drawX();
        else if (n == 2) {
            drawX();
            drawSpace();
            drawX();
        }
        else {
            drawX();
            drawSpace();
            for (int i=0; i<2*n-5; i++)
                drawO();
            drawSpace();
            drawX();
        }
    }
    public static void drawX() {
        System.out.print("X");
    }
    public static void drawSpace() {
        System.out.print(" ");
    }
    public static void drawO() {
        System.out.print("O");
    }
 }
