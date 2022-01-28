package bussiness.script;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Cpuer {

    public static void main(String[] args) {
        //1、找到这个项目根目录下的文件
        File file = new File("cpu.txt");
        //2、判断这个文件是否存在
        if (!file.exists()){
            System.out.println("cpu.txt not exist");
        }else {
            System.out.println("cpu.txt exist");
        }
        //3、从文件里面逐行读取文字
        BufferedReader bufferedReader = null;
        List<String> result = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
//                System.out.println("这行是"+line);
                //4、如果这行文字包含com.ximalaya.ting.kid，且不是com.ximalaya.ting.kid:player,取出这行文字第一个字符直到百分号截止
                if (line.contains("ximalaya.ting.kid") && !line.contains("player")){
//                    System.out.println("过滤后的"+line);
                    String cpu = "";
                    for (int i=0; i < line.length(); i++){
                        if (line.charAt(i) != ' '){
                            cpu += line.charAt(i);
                            if (line.charAt(i) == '%'){
                                break;
                            }
                        }
                    }
                    result.add(cpu);
                }
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
