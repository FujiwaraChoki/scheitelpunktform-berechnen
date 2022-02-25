import java.util.Scanner;

public class Code {

    static Scanner scanner;

    public Code() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) throws InterruptedException {
        new Code().runCode();
    }

    private void runCode() throws InterruptedException {
        System.out.print("Geben Sie bitte die Formel ein, trennen sie die einzelnen Teile mit einem ',' -> ");
        System.out.println("Hinweis: Die erst eingegebene Zahl ist die 'x' Zahl");
        System.out.println("Beispiel: (Leerzeichen vor dem ersten Operator) + 14 + 38");
        String formel = scanner.nextLine();
        String[] teile = formel.split(" ");
        String operator1 = teile[1];
        int x = Integer.parseInt(teile[2]);
        String operator2 = teile[3];
        int last = Integer.parseInt(teile[4]);
        System.out.println(process(operator1, operator2, x, last));
    }

    public String process(String operator1, String operator2, int x, int last) throws InterruptedException {
        System.out.println("x²"+operator1+x+"x"+operator2+last);
        wait(1);
        System.out.println("x²"+operator1+x+"x                            "+operator2+last);
        wait(1);
        x /= 2;
        System.out.println("x²"+operator1+"2*"+x+"x + "+x+"² -"+x+"² "+operator2+last);
        int specialX = x*x;
        wait(1);
        System.out.println("(x "+operator1+x+")² - "+specialX+" "+operator2+" "+last);
        wait(1);
        if (operator2.equals("+")) {
            return "(x "+operator1+x+")² "+(negate(specialX)+last);
        } else if(operator2.equals("-")) {
            return "(x "+operator1+x+")² "+(negate(specialX)-last);
        }
        return "";
    }

    public static void wait(int seconds) throws InterruptedException {
        int millis = seconds * 1000;
        Thread.sleep(millis);
    }

    public int negate(int currentValue) {
        return (-currentValue);
    }
}
