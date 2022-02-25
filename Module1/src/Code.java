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
        System.out.print("Geben Sie bitte die Formel ein, trennen sie die einzelnen Teile mit einem Leerzeichen -> ");
        System.out.println("Hinweis: Die erst eingegebene Zahl ist die 'x' Zahl");
        System.out.println("Beispiel: (Leerzeichen vor dem ersten Operator) + 14 + 38");
        String formel = scanner.nextLine();
        // Splits Input Formula through space
        String[] teile = formel.split(" ");
        String operator1 = teile[1];
        // Set x
        int x = Integer.parseInt(teile[2]);
        String operator2 = teile[3];
        // Set last Number
        int last = Integer.parseInt(teile[4]);
        // Gives op1, 2 and x, last as parameters for @process Method
        System.out.println(process(operator1, operator2, x, last));
    }

    /*
    * Method to process the formula through certain steps to return the "Scheitelpunktform"
    * Return: SCheitelpunktform
    * Parameters: First Operator, Second Operator, x Number, last number
    * */
    public String process(String operator1, String operator2, int x, int last) throws InterruptedException {
        System.out.println("x²"+operator1+x+"x"+operator2+last);
        wait(1);
        System.out.println("x²"+operator1+x+"x                            "+operator2+last);
        wait(1);
        x /= 2;
        // x divided by two
        System.out.println("x²"+operator1+"2*"+x+"x + "+x+"² -"+x+"² "+operator2+last);
        int specialX = x*x;
        wait(1);
        // Prints complete formula, withou having calculated with specialX and last
        System.out.println("(x "+operator1+x+")² - "+specialX+" "+operator2+" "+last);
        wait(1);
        // Turns specialX Negative
        specialX = negate(specialX);
        if (operator2.equals("+")) {
            // If the second operator is +, adds specialX and list
            return "(x "+operator1+x+")² "+(specialX+last);
        } else if(operator2.equals("-")) {
            // If the second operator is -, subtracts last from specialX
            return "(x "+operator1+x+")² "+(specialX-last);
        }
        return "";
    }

    // Pauses application for certain amount of time
    public static void wait(int seconds) throws InterruptedException {
        int millis = seconds * 1000;
        Thread.sleep(millis);
    }

    // Returns negative Value
    public int negate(int currentValue) {
        return (-currentValue);
    }
}
