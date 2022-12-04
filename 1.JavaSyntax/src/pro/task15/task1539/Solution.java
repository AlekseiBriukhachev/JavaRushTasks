package com.javarush.task.pro.task15.task1539;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/* 
Использование Paths 2
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(joinToPath(Arrays.asList("d:/", "study/", "javarush/", "полезные куски кода.txt")));
    }

    public static Path joinToPath(List<String> partsList) {
        //напишите тут ваш код
//        String filePath = "";
//        for (String part : partsList){
//            if (part != null){
//                filePath = filePath + part;
//            }
//        }
//        return Paths.get(filePath);
        String[] files = new String[partsList.size() - 1];
        System.arraycopy(partsList.toArray(files), 1, files, 0, files.length);
        return Paths.get(partsList.get(0), files);
    }
}
