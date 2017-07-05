package jums;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 * ユーザー情報を持ちまわるJavaBeans
 * データベースのカラムと型に対応させている(DTO)。データの挿入、取り出しどちらにも便利
 * @version 1.00
 * @author hayashi-s
 */
public class UserDataDTO {
    private int userID;
    private String name;
    private Date birthday;
    private String tell;
    private int type;
    private String comment;
    private Timestamp newDate;
    private int delete;
    
    
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public Date getBirthday(){
        return birthday;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    
    public String getTell(){
        return tell;
    }
    public void setTell(String tell){
        this.tell = tell;
    }
    
    public int getType(){
        return type;
    }
    public void setType(int type){
        this.type = type;
    }
    
    public String getComment(){
        return comment;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    
    public Timestamp getNewDate() {
        return newDate;
    }
    public void setNewDate(Timestamp newDate) {
        this.newDate = newDate;
    }
    public int getDelete() {
        return delete;
    }
    public void setDelete(int delete) {
        this.delete = delete;
    }

    public ArrayList<String> chkproperties(){
        ArrayList<String> chkList = new ArrayList<String>();
        if(this.name.equals("")){
            chkList.add("name");
        }
        if(this.birthday.equals("")){
            chkList.add("birthday");
        }
        if(this.tell.equals("")){
            chkList.add("tell");
        }
        if(this.type == 0){
            chkList.add("type");
        }
        if(this.comment.equals("")){
            chkList.add("comment");
        }
        
        return chkList;
    }
    
        public void UD2DTOMapping(UserDataDTO udd){
        udd.setName(this.name);
        udd.setBirthday(this.birthday);
        udd.setTell(this.tell);
        udd.setType(this.type);
        udd.setComment(this.comment);
    }
}
