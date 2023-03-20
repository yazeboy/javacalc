import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String output=calc(input);
        System.out.println(output);
    }
    public static String calc(String input){
        String[] expression = input.split(" ");
        String result;
        if(expression.length>3|expression.length<3){throw new RuntimeException("//формат ввода не удовлетворяет заданию");}
        if (converter.isRoman(expression[0]) == converter.isRoman(expression[2])){
            int a,b;
            boolean isRoman=converter.isRoman(expression[0]);
            if(isRoman){
                a=converter.romanToInt(expression[0]);
                b=converter.romanToInt(expression[2]);
            }
            else{ a = Integer.parseInt(expression[0]);
                b = Integer.parseInt(expression[2]);}
            if(a>10|b>10){throw new RuntimeException("//введенное число больше 10");}
            String operation=expression[1];
            int e = switch (operation) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "/" -> a / b;
                case "*" -> a * b;
                default -> throw new RuntimeException("//недопустимая арифметическая операция");};
            if(isRoman){
                if(e<1){throw new RuntimeException("//в римской системе нет отрицательных чисел");}
                result=converter.intToRoman(e);
            }
            else result=Integer.toString(e);
        } else throw new RuntimeException("//используются одновременно разные системы счисления");
        return(result);}
}

