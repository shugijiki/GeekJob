/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.*;



/**
 *
 * @author guest1Day
 */
class NewClass5 {
    public static void main(String[] argg) throws IOException{
        File fo2 = new File("C:\\Users\\guest1Day.DESKTOP-HHEP438\\Documents\\NetBeansProjects\\AAA\\AAA\\src\\java\\org\\mypackage\\sample\\test.txt");

        // 書き込み

        FileReader fr = new FileReader(fo2);
        // BufferedReader作成
        BufferedReader br = new BufferedReader(fr);
        // 1行読み出し
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());

        br.close();
  }
}
    
