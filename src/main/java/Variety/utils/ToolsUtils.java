package Variety.utils;

import java.lang.annotation.Target;

public class ToolsUtils {
    public static int StringToint(String s){
        int target=-1;
        try {
             target=Integer.parseInt(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return target;
    }
}
