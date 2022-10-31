public class Main3 {
        public static void main(String[] args) {
            //Нахождение кол-ва решений, дискриминант - 1
            System.out.print(solutions(1, 0, -1));
            System.out.print("\t");
            System.out.print(solutions(1, 0, 0));
            System.out.print("\t");
            System.out.println(solutions(1, 0, 1));

            //Нахождение индекса 2 упоминания "zip" с учетом регистра - 2
            System.out.print(findZip("all zip files are zipped"));
            System.out.print("\t");
            System.out.println(findZip("all zip files are compresseped"));

            //Совершенное число - состоит из суммы множителей - 3
            System.out.print(checkPerfect(6));
            System.out.print("\t");
            System.out.println(checkPerfect(97));

            //Смена местами 1 и последнего символов - 4
            System.out.print(flipEndChars("Cat, dog, and mouse."));
            System.out.print("\t");
            System.out.print(flipEndChars("ada"));
            System.out.print("\t");
            System.out.println(flipEndChars("z"));

            //Шестнадцатеричный ключ - 5
            System.out.print(isValidHexCode("#CD5C5C"));
            System.out.print("\t");
            System.out.print(isValidHexCode("#pqr&kdss"));
            System.out.print("\t");
            System.out.println(isValidHexCode("#eaecee"));

            //Число уникальных элементов в массивах - 6
            System.out.print(same(new Integer[]{1,3,4,4,4},new Integer[]{2,5,7}));
            System.out.print("\t");
            System.out.print(same(new Integer[]{9,8,7,6},new Integer[]{4,4,3,1}));
            System.out.print("\t");
            System.out.println(same(new Integer[]{2},new Integer[]{3,3,3,3,3}));

            //Число Капрекара, сумма чисел в квадрате числу - 7
            System.out.print(isKaprekar(3));
            System.out.print("\t");
            System.out.print(isKaprekar(5));
            System.out.print("\t");
            System.out.println(isKaprekar(297));

            //Самая длинная последовательность 0 - 8
            System.out.print(longestZero("01100001011000"));
            System.out.print("\t");
            System.out.print(longestZero("100100100"));
            System.out.print("\t");
            System.out.println(longestZero("11111"));

            //Интервал простых чисел - 9
            System.out.print(nextPrime(12));
            System.out.print("\t");
            System.out.print(nextPrime(29));
            System.out.print("\t");
            System.out.println(nextPrime(11));

            //Ребра прямоугольного треугольника - 10
            System.out.print(rightTriangle(3, 4, 5));
            System.out.print("\t");
            System.out.print(rightTriangle(145, 105, 100));
            System.out.print("\t");
            System.out.println(rightTriangle(70, 130, 110));
        }
        //1 задание
        public static int solutions(int a, int b, int c) {
            int d = b * b - 4 * a * c;
            if (d > 0)
                return 2;
            else if (d == 0)
                return 1;
            else
                return 0;
        }
        //2 задание
        public static int findZip(String z_name) {
            int k = 0;
            for (int i = 0; i < z_name.length(); i++) {
                if (z_name.charAt(i) == 'z' && z_name.charAt(i+1) == 'i' && z_name.charAt(i+2) == 'p') {
                    k += 1;
                    if (k == 2)
                        return i;
                }
            }
            return -1;
        }
        //3 задание
        public static boolean checkPerfect(int num) {
            int sum_num = 0;
            for (int i = 1; i < (num / 2) + 1; i++) {
                if (num % i == 0) {
                    sum_num += i;
                }
            }
            return sum_num == num;
        }
        //4 задание
        public static String flipEndChars(String pare) {
            if (pare.length() < 2) return "Incompatible";
            if (pare.charAt(0) == pare.charAt(pare.length()-1)) return "Two's a pair.";
            else {
                char a = pare.charAt(pare.length()-1);
                return a + pare.substring(1, pare.length()-1) + pare.charAt(0);
            }
        }
        //5 задание
        public static boolean isValidHexCode(String num) {
            if (num.charAt(0) != '#' || num.length() != 7) return false;
            for (int i = 1; i < num.length(); i++) {
                int ascii = (int) num.charAt(i);
                if (!( (ascii >= 48 && ascii <= 57) || (ascii >= 65 && ascii <= 70) || (ascii >= 97 && ascii <= 102) ))
                    return false;
            }
            return true;
        }
        //6 задание
        public static boolean same(Integer[] arr1, Integer[] arr2) {
            return uni_sort(arr1) == uni_sort(arr2);
        }
        public static int uni_sort(Integer[] mass) {
            int[] list = new int[mass.length];
            int rez = 0, n = 0;
            for (int i = 0; i < mass.length; i++) {
                for (int j = i+1; j < mass.length; j++) {
                    if (mass[i] == mass[j] && (list[i] == 0 || list[j] == 0)){
                        if (list[i] == 0 && list[j] == 0)   n++;
                        if (list[i] == 0)   list[i]++;
                        if (list[j] == 0)   list[j]++;
                    }
                }
            }
            for (int k = 0; k < list.length; k++) {
                rez += list[k];
            }
            return list.length - rez + n;
        }
        //7 задание
        public static boolean isKaprekar(int num) {
            String num_sqad = Integer.toString(num * num), leftstr = "", rightstr = "";
            for (int i = 0; i < num_sqad.length()/2; i++) {
                leftstr += num_sqad.charAt(i);
                rightstr += num_sqad.charAt(i + num_sqad.length()/2);
            }
            if (num_sqad.length() == 1) {
                leftstr += num_sqad.charAt(0);
                rightstr += "0";
            }
            else if (num_sqad.length() % 2 != 0)
                rightstr += num_sqad.charAt(num_sqad.length()-1);
            return Integer.valueOf(leftstr) + Integer.valueOf(rightstr) == num;
        }
        //8 задание
        public static String longestZero(String str) {
            String rez = "";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '0' && str.charAt(i) != '1')
                    return "";
                if (str.charAt(i) == '0')
                    rez += str.charAt(i);
                if (str.charAt(i) == '1')
                    rez = "";
            }
            return rez;
        }
        //9 задание
        public static int nextPrime(int simple_num) {
            for (int i = simple_num; i < simple_num + 1000; i++){
                if(isPrime(i)) return i;
            }
            return simple_num;
        }
        public static boolean isPrime(int n) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                return false;
                }
            }
            return true;
        }
        //10 задание
        public static boolean rightTriangle(int x, int y, int z) {
            int gip = 0, kat1 = 0, kat2 = 0;
            if(x > y && x > z) {
                gip = x;
                kat1 = y;
                kat2 = z;
            }
            if(y > x && y > z) {
                gip = y;
                kat1 = x;
                kat2 = z;
            }
            if(z > x && z > y) {
                gip = z;
                kat1 = x;
                kat2 = y;
            }
            return (gip * gip == kat1 * kat1 + kat2 * kat2);
        }
}
