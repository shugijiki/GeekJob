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
public class User extends Human {

    @Override
    public int open() {
        int total = 0;
        int count = 0;
        for(int i=0;i<myCards.size();i++){
            if(myCards.get(i)  > 11){
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