import java.util.TreeMap;

class converter { public static boolean isRoman(String expression) {
    String[] list = {"I", "V", "X", "L", "C", "D", "M"};
    boolean roman=false;
    for (String s : list) {
        if (expression.contains(s)) {
            roman = true;
            break;
        }
    }
    return(roman);}

    public static int romanToInt(String expression){        //dawd
        int[] number = {0,1,5,10,50,100,500,1000};
        String[] list = {"0","I","V","X","L","C","D","M"};
        String[] rom = expression.split("");
        int[] b = new int[rom.length];
        for(int i = 0;i<rom.length; i++){
            for(int k=1;k<list.length;k++){
                if (rom[i].contains(list[k]))
                {b[i]=number[k];}}}
        int end=b.length-1;
        int a=b[end];
        int max=b[end];
        for(int i=end-1; i>=0; i--)
        {if(b[i]>=b[i+1])
        {if(b[i]>=max){a=a+b[i];}
        else{throw new RuntimeException("//некорректная запись римского числа");}}
        else {{a=a-b[i];max=b[i+1];}}}
        return(a);}

    public static String intToRoman(int e){
        TreeMap<Integer, String> arabianKeyMap=new TreeMap<>();
        arabianKeyMap.put(100, "C");
        arabianKeyMap.put(90, "XC");
        arabianKeyMap.put(50, "L");
        arabianKeyMap.put(40, "XL");
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");
        int arabianKey;
        StringBuilder result = new StringBuilder();
        do {
            arabianKey = arabianKeyMap.floorKey(e);
            e = e-arabianKey;
            result.append(arabianKeyMap.get(arabianKey));
        } while(e>0);
        return(result.toString());}
}
