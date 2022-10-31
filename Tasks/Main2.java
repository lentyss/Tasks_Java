import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        //Повтор букв слова - 1
        System.out.print(repeat("mice", 5));
        System.out.print(repeat("hello", 3));
        System.out.println(repeat("stop", 1));

        //Разница между самыми большими и маленькими числами - 2
        System.out.print(differenceMaxMin(new int[]{10, 4, 1, 4, -10, -50, 32, 21}));
        System.out.print("\t");
        System.out.println(differenceMaxMin(new int[]{44, 32, 86, 19}));

        //Среднее значения массива - целое число - 3
        System.out.print(isAvgWhole(new int[]{1, 2, 3, 4}));
        System.out.print("\t");
        System.out.println(isAvgWhole(new int[]{1, 5, 6}));

        //Массив, где каждое число - сумма самого себя и предыд - 4
        System.out.print(cumulativeSum(new int[]{1, 2, 3}));
        System.out.println(cumulativeSum(new int[]{3, 3, -2, 408, 3, 3}));

        //Количество десятичных знаков - 5
        System.out.print(getDecimalPlaces("43.200"));
        System.out.print("\t");
        System.out.println(getDecimalPlaces("3.1"));

        //Число Фибоначчи - 6
        System.out.print(fibonacci(3));
        System.out.print("\t");
        System.out.println(fibonacci(12));

        //Почтовые адреса - 7
        System.out.print(isValid("59001"));
        System.out.print("\t");
        System.out.print(isValid("9393939"));
        System.out.print("\t");
        System.out.println(isValid("590a01"));

        //1 и последние буквы равны. Странные пары - 8
        System.out.print(isStrangePair("ratio","orator"));
        System.out.print("\t");
        System.out.print(isStrangePair("bush","hubris"));
        System.out.print("\t");
        System.out.println(isStrangePair("",""));

        //Префикс и суффикс - 9
        System.out.print(isPrefix("automation","auto-"));
        System.out.print("\t");
        System.out.print(isSuffix("arachnophobia","-phobia"));
        System.out.print("\t");
        System.out.print(isPrefix("retrospect","sub-"));
        System.out.print("\t");
        System.out.println(isSuffix("vocation","-logy"));

        //Количество полей на шаге последовательности - 10
        System.out.print(boxSeq(0));
        System.out.print("\t");
        System.out.print(boxSeq(1));
        System.out.print("\t");
        System.out.println(boxSeq(2));
    }
    //1 задание
    public static String repeat(String word, int kolvo) {
        String rez = " ";
        for (int i = 0; i < word.length(); i++)
        {
            for (int j = 0; j < kolvo; j++) {
                rez += word.charAt(i);
            }
        }
        return rez;
    }
    //2 задание
    public static int differenceMaxMin(int[] max_min) {
        int max = -100, min = 100;
        for (int i = 0; i < max_min.length; i++){
            if (max_min[i] > max)
                max = max_min[i];
            if (max_min[i] < min)
                min = max_min[i];
        }
        return max - min;
    }
    //3 задание
    public static boolean isAvgWhole(int[] m) {
        int rez = 0;
        for (int i = 0; i < m.length; i++)
            rez += m[i];
        return rez % m.length == 0;
    }
    //4 задание
    public static String cumulativeSum(int[] m_summ) {
        int summ = m_summ[0];
        for (int i = 1; i < m_summ.length; i++){
            summ += m_summ[i];
            m_summ[i] = summ;
        }
        return Arrays.toString(m_summ);
    }
    //5 задание
    public static int getDecimalPlaces(String string) {
        double value = Double.parseDouble(string);
        //вычитаем целую часть и символ запятой
        return string.length() - String.valueOf((int)value).length() - 1;
    }
    //6 задание
    public static int fibonacci(int num) {
        int num1 = 0;
        int num2 = 1;
        int sum_num = 0;
        for (int i = 0; i < num; i++) {
            sum_num = num1 + num2;
            num1 = num2;
            num2 = sum_num;
        }
        return sum_num;
    }
    //7 задание
    public static boolean isValid(String address) {
        if (address.length() > 5) return false;
        for (int i = 0; i < address.length(); i++) {
            if (!Character.isDigit(address.charAt(i))) return false;
        }
        return true;
    }
    //8 задание
    public static boolean isStrangePair(String fst_str, String snd_str) {
        if(fst_str == "" && snd_str == "") return true;
        if((fst_str.charAt(fst_str.length()-1) == snd_str.charAt(0)) && (fst_str.charAt(0) == snd_str.charAt(snd_str.length()-1)))
            return true;
        return false;
    }
    //9 задание
    public static boolean isPrefix (String word, String prefix) {
        for(int i = 0; i < prefix.length() - 1; i++){
            if(word.charAt(i) != prefix.charAt(i)) return false;
        }
        return true;
    }
    public static boolean isSuffix (String word, String suffix) {
        for(int i = 1; i < suffix.length(); i++){
            int dif = i + (word.length()-suffix.length());
            if(word.charAt(dif) != suffix.charAt(i)) return false;
        }
        return true;
    }
    //10 задание
    public static int boxSeq(int step) {
        if (step == 0)
            return 0;
        else if(step % 2 == 0)
            return step;
        else
            return step + 2;
    }
}