/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;
/**
 *
 * @author guest1Day
 */
public class UserDataBeans implements Serializable {
    private String name;
    private String year;
    private String month;
    private String day;
    private String type;
    private String type2;
    private String tell;
    private String comment;
    
    public UserDataBeans(){
        name    = "";
        year    = "";
        month   = "";
        day     = "";
        type    = "";
        type2    = "";
        tell    = "";
        comment = "";
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getYear(){
        return year;
    }
    public void setYear(String year){
        this.year = year;
    }
    public String getMonth(){
        return month;
    }
    public void setMonth(String month){
        this.month = month;
    }
    public String getDay(){
        return day;
    }
    public void setDay(String day){
        this.day = day;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
        setType2(type);
    }
    public String getType2(){
        return type2;
    }
    public void setType2(String type){
        int i= Integer.valueOf(type);
        switch(i){
            case 1:
                this.type2="エンジニア";
                break;
            case 2:
                this.type2="営業";
                break;
            case 3:
                this.type2="その他";
                break;
        }
    }
    public String getTell(){
        return tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
}