import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main4 {
    public static void main(String[] args) {
        //Сочинение разделенное по символам - 1
        System.out.println(text_recover(10, 7, "hello my name is Bessie and this is my essay"));

        //Строка в кластер скобок - 2
        System.out.print(split("()()()"));
        System.out.print("\t");
        System.out.print(split("((()))(())()()(()())"));
        System.out.print("\t");
        System.out.println(split("((())())(()(()()))"));

        //Функции стиля написания составных слов - 3
        System.out.print(toCamelCase("hello_edabit"));
        System.out.print("\t");
        System.out.print(toSnakeCase("helloEdabit"));
        System.out.print("\t");
        System.out.print(toCamelCase("is_modal_open"));
        System.out.print("\t");
        System.out.println(toSnakeCase("getColor"));

        //Вычисление прибыли за рабочий день - 4
        System.out.print(overTime(new double[]{9,17,30, 1.5}));
        System.out.print("\t");
        System.out.print(overTime(new double[]{16, 18, 30, 1.8}));
        System.out.print("\t");
        System.out.println(overTime(new double[]{13.25, 15, 30, 1.5}));

        //Индекс массы тела - 5
        System.out.print(BMI("205 pounds", "73 inches"));
        System.out.print("\t");
        System.out.print(BMI("55 kilos", "1.65 meters"));
        System.out.print("\t");
        System.out.println(BMI("154 pounds", "2 meters"));

        //Перемножение цифр в числе до достижения одной - 6
        System.out.print(bugger(39));
        System.out.print("\t");
        System.out.print(bugger(999));
        System.out.print("\t");
        System.out.println(bugger(4));

        //Звездная стенография и количество повторений символов - 7
        System.out.print(toStarShorthand("abbccc"));
        System.out.print("\t");
        System.out.print(toStarShorthand("77777geff"));
        System.out.print("\t");
        System.out.print(toStarShorthand("abc"));
        System.out.print("\t");
        System.out.println(toStarShorthand(""));

        //Рифмы в строках, одни и те же гласные - 8
        System.out.print(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.print("\t");
        System.out.print(doesRhyme("Sam I am!", "Green eggs and HAM."));
        System.out.print("\t");
        System.out.print(doesRhyme("You are off to the races", "a splendid day."));
        System.out.print("\t");
        System.out.println(doesRhyme("and frequently do?", "you gotta move."));

        //1 число, цифры повт. 3 раза подряд, 2, 2 раза - 9
        System.out.print(trouble(451999277, 41177722899L));
        System.out.print("\t");
        System.out.print(trouble(1222345, 12345));
        System.out.print("\t");
        System.out.print(trouble(666789, 12345667));
        System.out.print("\t");
        System.out.println(trouble(33789, 12345337));

        //Уникальные книги между парами концов - 10
        System.out.print(countUniqueBooks("AZYWABBCATTTA", 'A'));
        System.out.print("\t");
        System.out.print(countUniqueBooks("$AA$BBCATT$C$$B$", '$'));
        System.out.print("\t");
        System.out.println(countUniqueBooks("ZZABCDEF", 'Z'));
    }

    //1 задание
    public static String text_recover(int n, int k, String string){
        String[] mas_str = string.split(" ");
        int string_lengt = 0;
        String exit_string = "";
        for (int i = 0; i < mas_str.length; i++){
            String now_string = mas_str[i];
            if(now_string.length() + string_lengt <= k ){
                exit_string += now_string + " ";
                string_lengt += now_string.length();
            } else if (now_string.length() + string_lengt > k) {
                exit_string += "\n" + now_string + " ";
                string_lengt = now_string.length();
            }
        }
        return exit_string;
    }

    //2 задание
    public static List split(String string){
        int num_bkt = 0;
        ArrayList<String> return_bkt = new ArrayList<String>();
        String return_str = "";
        String edit_str = "";
        for (int i = 0; i < string.length(); i++){
            if(string.charAt(i) == '('){
                num_bkt+=1;
            }else if (string.charAt(i) == ')'){
                num_bkt-=1;
            }
            edit_str += string.charAt(i);
            if (num_bkt == 0) {
                return_bkt.add(edit_str);
                return_str += edit_str + " ";
                edit_str = "";
            }
        }
        List strList = Arrays.asList(return_str);
        return strList;
    }

    //3 задание
    public static String toCamelCase(String string){
        String ret_string = "";
        for(int i = 0; i < string.length(); i++){
            if (string.charAt(i) == '_'){
                int ascii = (int) string.charAt(i+1) - 32;
                ret_string += (char) ascii;
                i+=1;
            }else
                ret_string += string.charAt(i);
        }
        return ret_string;
    }
    public static String toSnakeCase(String string){
        String ret_string = "";
        for(int i = 0; i < string.length(); i++){
            if ((int) string.charAt(i) <= 90 && ((int) string.charAt(i) >= 65)){
                ret_string += '_';
                int ascii = (int) string.charAt(i) + 32;
                ret_string += (char) ascii;
            } else
                ret_string += string.charAt(i);
        }
        return ret_string;
    }

    //4 задание
    public static String overTime(double[] enter_ms){
        double start_wk = enter_ms[0]; // - начало раб дня
        double stop_wk = enter_ms[1]; // - конец раб дня
        double salary = enter_ms[2]; // - ставка
        double factor = enter_ms[3]; // - коэф переработки

        double normal_hr = 0;
        double overprice_hr = 0;
        if(stop_wk > 17){
            overprice_hr = stop_wk - 17;
            stop_wk -= overprice_hr;
        }
        normal_hr = stop_wk - start_wk;
        return ("$" + Math.round((normal_hr * salary + overprice_hr * salary * factor)*100d)/100d);
    }

    //5 задание
    // m / h*h
    public static String BMI(String weight_str, String height_str){
        String[] arr_weight = weight_str.split(" ");
        double weight_db = Double.parseDouble(arr_weight[0]);
        String type_of_weight = arr_weight[1];

        String[] arr_height = height_str.split(" ");
        double height_db = Double.parseDouble(arr_height[0]);
        String type_of_height = arr_height[1];

        if(type_of_weight.charAt(0) == 'p') weight_db /= 2.205;
        if (type_of_height.charAt(0) == 'i') height_db/= 39.37;

        double bmi = weight_db/ (height_db*height_db);

        if(bmi >= 25) return (Math.round(bmi*10d)/10d + " Overweight");
        else if (bmi < 18.5) return (Math.round(bmi*10d)/10d + " Underweight");
        else return (Math.round(bmi*10d)/10d + " Normal weight");
    }

    //6 задание
    public static int bugger(int start_num){

        if (start_num <= 9) return  0;

        int next_num = 1;
        int digit = (int) Math.ceil(Math.log10(start_num + 0.5));
        while (digit != 0){
            next_num *= start_num % 10;
            start_num = start_num / 10 ;
            digit -= 1;
        }
        return 1 + bugger(next_num);
    }

    //7 задание
    public static String toStarShorthand(String string){
        String return_string = "";
        string += "&";
        int n = 1;
        for (int i = 0; i < string.length()-1; i++){
            if(string.charAt(i) == string.charAt(i + 1)){
                n++;
            }
            else {
                return_string += string.charAt(i);
                if (n != 1) return_string +=  "*" + String.valueOf(n);
                n = 1;
            }
        }
        return return_string;
    }

    //8 задание
    public static boolean doesRhyme(String str1, String str2){
        String[] arr_str1 = str1.split(" ");
        String[] arr_str2 = str2.split(" ");
        String last_word1 = arr_str1[arr_str1.length-1];
        String last_word2 = arr_str2[arr_str2.length-1];
        String vowels_1 = "";
        String vowels_2 = "";

        for(int i = 0; i < last_word1.length(); i++){
            if("AEIOUaeiou".indexOf(last_word1.charAt(i)) != -1)
                vowels_1+=last_word1.charAt(i);
        }
        for(int i = 0; i < last_word2.length(); i++){
            if("AEIOUaeiou".indexOf(last_word2.charAt(i)) != -1)
                vowels_2+=last_word2.charAt(i);
        }
        return vowels_1.equalsIgnoreCase(vowels_2);
    }

    //9 задание
    public static boolean trouble(long num1, long num2){
        String num1_str = String.valueOf(num1);
        String num2_str = String.valueOf(num2);
        List<Character> list_rep_int = new ArrayList<>();
        int q = 1;
        for (int i = 0; i < num1_str.length()-1; i++){
            if (num1_str.charAt(i) == num1_str.charAt(i+1)){
                q+=1;
            }else if(q==3){
                list_rep_int.add(num1_str.charAt(i));
                q = 1;
            }else q = 1;
        }
        for(Character num : list_rep_int){
            String str = "" + num + num;
            return num2_str.contains(str);
        }
        return false;
    }

    //10 задание
    public static int countUniqueBooks(String stringSequnce, char bookEnd){
        boolean lever = false;
        List<Character> list_char = new ArrayList<Character>();
        for (int i = 0; i < stringSequnce.length()-1; i++){
            if (stringSequnce.charAt(i) == bookEnd) lever = !lever;
            if (lever){
                if(!list_char.contains(stringSequnce.charAt(i)) && stringSequnce.charAt(i) != bookEnd){
                    list_char.add(stringSequnce.charAt(i));
                }
            }
        }
        return list_char.size();
    }
}
