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
class NewClass4 {
    public static void main(String[] argg) throws IOException{
        File fp = new File("C:\\Users\\guest1Day.DESKTOP-HHEP438\\Documents\\NetBeansProjects\\AAA\\AAA\\src\\java\\org\\mypackage\\sample\\test.txt");

        // 書き込み
        try ( // FileWriter作成
                FileWriter fw = new FileWriter(fp)) {
            // 書き込み
            fw.write("私の名前は嘉門達夫です\r\n");
            fw.write("1959年3月25日生まれです\r\n");
            fw.write("趣味は店の弁当に付いている小さな醤油の入れ物の収集です");
            // クローズ
            fw.close();
        }
    }
    
}
