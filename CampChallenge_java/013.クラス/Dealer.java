/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.util.*;

/**
 *
 * @author guest1Day
 */
public class Dealer extends Human{
    ArrayList<Integer> cards = new ArrayList<>();
    public Dealer(){
        for (int num=1;num < 14;num++) {
            for (int i=0;i < 4;i++) {
               cards.add(num);
            }
        }
    }
    public ArrayList<Integer> deal() {
        ArrayList<Integer> deal2 = new ArrayList<>();
        Random rand = new Random();
        
        int num1 = rand.nextInt(cards.size());
        deal2.add(cards.get(num1));
        cards.remove(num1);
        int num2 = rand.nextInt(cards.size());
        deal2.add(cards.get(num2));
        cards.remove(num2);
        
        return deal2;
        }
    public ArrayList<Integer> hit(){
        ArrayList<Integer> hit2 = new ArrayList<>();
        Random rand = new Random();
        
        int num3 = rand.nextInt(cards.size());
        hit2.add(cards.get(num3));
        cards.remove(num3);
        
        return hit2;
    }

    
    
    @Override
    public int open() {
        int total = 0;
        int count = 0;
        for(int i=0;i<myCards.size();i++){
            if(myCards.get(i)  >= 11){
                total = total + 10;
            } else if(myCards.get(i)  == 1) {
                total++;
                count++;
            }else{
                total = total + myCards.get(i);
            }
            
         }
        for(int i=0;i<count;i++){
        if(total <12){
            total = total + 10;
            }
        }
        return total;
    }


    @Override
    public void setCard(ArrayList<Integer> setup) {
        for(int num=0 ;num < setup.size() ;num++){
            myCards.add(setup.get(num));
        }
    }

    @Override
    public boolean checkSum() {
        if(open() >17){
            return false;
        }else{
            return true;
        }
    }
    
    
   
}