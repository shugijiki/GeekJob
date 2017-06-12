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
abstract class Human {
    abstract public int open();
    abstract public void  setCard(ArrayList<Integer> setup);
    abstract public boolean checkSum();
    ArrayList<Integer> myCards = new ArrayList<>();
}