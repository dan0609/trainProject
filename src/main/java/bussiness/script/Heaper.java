package bussiness.script;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Heaper {
    public static void main(String[] args) {
        //1、找到这个项目根目录下的文件
        File file = new File("heap.txt");
        //2、判断这个文件是否存在
        if (!file.exists()){
            System.out.println("heap.txt not exist");
        }else {
            System.out.println("heap.txt exist");
        }
        //3、从文件里面逐行读取文字
        BufferedReader bufferedReader = null;
        List<String> result = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
//                System.out.println("这行是"+line);
                //4、如果这行文字包含total，且空格数为"        ",先找到这一行
                String kongge = "";
                for (int i = 0; i < line.length(); i++){
                    if (line.charAt(i) == ' '){
                        kongge += line.charAt(i);
                    }else{
                        break;
                    }
                }
                if (line.contains("TOTAL") && kongge.equals("        ")){
//                    System.out.println("过滤后的"+line);
                    String heap = "";
                    String head = "        TOTAL   ";
                    for (int i =head.length(); i < line.length(); i++){
                        heap += line.charAt(i);
                        if (line.charAt(i) == ' '){
                            break;
                        }
                    }
                    System.out.println("heap="+ heap);
                    result.add(heap);
                }


            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
