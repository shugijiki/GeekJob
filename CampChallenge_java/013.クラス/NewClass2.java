/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

/**
 *
 * @author guest1Day
 */
public class NewClass2 {
    
}
class Character {
    // フィールドの宣言
    public String name = "";
    public int hp = 0;

    // メソッドの宣言
    public void setHuman(String x, int y) {
        // 引数をフィールドへ設定
        this.name = x;
        this.hp = y;
    }
    public void hyouji() {
        String hyouji = "名前は" + this.name + "<br>HPは" + this.hp;
        System.out.print(hyouji);
    }
}
class Character2 extends Character {
    public void reset(){
        this.name = null;
        this.hp = 0;
    }
} 
    
