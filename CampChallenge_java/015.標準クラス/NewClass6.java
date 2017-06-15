/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;



/**
 *
 * @author guest1Day
 */
class NewClass6 {
    public static void main(String[] argg) throws IOException {
        File fp = new File("log.txt");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
        try (
            FileWriter fw = new FileWriter(fp)) {
            fw.write("開始\r\n");
            Calendar d = Calendar.getInstance();
            fw.write(sdf.format(d.getTime()));
            fw.close();
        }
        
        double a = Math.ceil(Math.random()*10); 
        System.out.print("選ばれた数字は"+a+"です");
        try (
            FileWriter fw = new FileWriter(fp,true)) {
            fw.write("\r\n終了\r\n");
            Calendar f = Calendar.getInstance();
            fw.write(sdf.format(f.getTime()));
            fw.close();
        }
    }
}

    
