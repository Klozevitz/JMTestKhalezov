public class Calculations {

    static char whatAction(char[] expr) {
        char a = '0';
        for (char c : expr) {
            if (c == '+') {
                a = c;
            }
            if (c == '-') {
                a = c;
            }
            if (c == '/') {
                a = c;
            }
            if (c == '*') {
                a = c;
            }
            if (c == 'q') {
                a = c;
            }
        }
        return a;
    }

    static String[] convExpr(char[] expr, char a) {
        int i = 0;
        String[] retExpr = new String[3];
        retExpr[0] = "";
        while (expr[i] != a) {
            retExpr[0] += Character.toString(expr[i]);
            i++;
        }
        retExpr[1] = Character.toString(a);
        i++;
        retExpr[2] = "";
        while (i< expr.length) {
            retExpr[2] += Character.toString(expr[i]);
            i++;
        }
        return retExpr;
    }

    static String calculator(String[] exp, char act) {
        int isRoman = 0;
        int arg1 = 0;
        int arg2 = 0;
        String[] romNum = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        for(int i = 0; i < 10; i++) {
            if (exp[0].equals(romNum[i])) {
                arg1 = i + 1;
                isRoman++;
            }
            if (exp[2].equals(romNum[i])) {
                arg2 = i + 1;
                isRoman ++;
            }
        }

        if (isRoman != 0) {
            switch (act) {
                case '+':
                    return arabicToRoman(arg1 + arg2);
                case '-':
                    if ((arg1 - arg2) > 0) {
                        return arabicToRoman(arg1 - arg2);
                    }
                    else
                        return "Результат невозможно записать римскими цифрами!";
                case '*':
                    return arabicToRoman(arg1 * arg2);
                case '/':
                    return arabicToRoman(arg1 / arg2);
                default: return "q";
            }
        }
        else {
            return switch (act) {
                case '+' -> Integer.toString(Integer.parseInt(exp[0]) + Integer.parseInt(exp[2]));
                case '-' -> Integer.toString(Integer.parseInt(exp[0]) - Integer.parseInt(exp[2]));
                case '*' -> Integer.toString(Integer.parseInt(exp[0]) * Integer.parseInt(exp[2]));
                case '/' -> Integer.toString(Integer.parseInt(exp[0]) / Integer.parseInt(exp[2]));
                default -> "q";
            };
        }
    }

    static String arabicToRoman (int a) {
        String[] romNum = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String[] romNumX = new String[] {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C"};
        String t = "";
        if (a <= 10) {
            int i = 0;
            while (a != i + 1) {
                i++;
            }
            return romNum[i];
        }
        else {
            int b = a / 10;
            if (10 * b == a) {
                int m = 0;
                while (b != m + 1) {
                    m++;
                }
                t = romNumX[m];
            }
            else {
                int j = 0;
                while (b != j + 1) {
                    j++;
                }
                t += romNumX[j];

                int k = 0;
                int c = a - 10 * b;
                while (c != k + 1) {
                    k++;
                }
                t += romNum[k];
            }
            return t;
        }
    }
}
