import java.util.Scanner;
import java.lang.*;

public class CalcTest {

    static char[] getArgsChar() {
        Scanner argsInput = new Scanner(System.in);
        String charExpr = argsInput.nextLine().replaceAll("\\s", "");
        return charExpr.toCharArray();
    }

    public static void main(String[] args) {
        char[] a;
        String[] aStr;
        char contAct = '_';
        while (contAct != 'q') {
            System.out.print("\nВведите выражение (для выхода введите 'q'): ");
            a = getArgsChar();

            if (Exceptions.isActionValid(a)) {
                contAct = Calculations.whatAction(a);
                aStr = Calculations.convExpr(a, contAct);
                if (Exceptions.isExprValid(aStr))
                    System.out.println(Calculations.calculator(aStr, contAct));
                else
                    if (contAct == 'q')
                        System.out.println("Программа завершила работу!");
                    else
                        System.out.println("Введен недопустимый набор аргументов!");

            } else
                System.out.println("Введена неверная операция!");
        }
    }
}
