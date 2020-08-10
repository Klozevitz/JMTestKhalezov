public class Exceptions {

    static boolean isActionValid (char[] expr) {
        int count = 0;
        char[] a = new char[] {'+', '-' ,'*' ,'/' ,'q'};

        for (char c : expr) {
            for (char value : a) {
                if (c == value)
                    count++;
            }
        }

        return count == 1;
    }

    static boolean isExprValid(String[] expr) {
        int romCount = 0;
        int arCount = 0;
        String[] romNum = new String[] {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};

        for (int i = 0; i < 10; i++) {
            if (romNum[i].equals(expr[0]))
                romCount++;
            if (romNum[i].equals(expr[2]))
                romCount++;
            if (expr[0].equals(String.valueOf(i + 1)))
                arCount++;
            if (expr[2].equals(String.valueOf(i + 1)))
                arCount++;
        }

        return Math.abs(romCount - arCount) == 2;
    }

}
