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

    public static int StringToint(String s,int defaultValue){
        int target;
        try {
           target=Integer.parseInt(s);
           return target;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;
    }

    public  static  String intToStatus(int status){
        if(status==0){
            return "未发货";
        }else if(status==1){
            return "已发货";
        }else{
            return "以签收";
        }


    }
}
