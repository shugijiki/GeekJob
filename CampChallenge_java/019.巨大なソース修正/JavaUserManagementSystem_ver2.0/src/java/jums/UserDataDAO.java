package jums;

import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
            st.setString(1, ud.getName());
            st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public ArrayList<UserDataDTO> search(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        ArrayList<UserDataDTO> uddArray = new ArrayList<UserDataDTO>();
        try{
            con = DBManager.getConnection();
            
            //
            String sql = "SELECT * FROM user_t";
            boolean Nflag = false;
            boolean Bflag = false;
            boolean Tflag = false;
            int numB = 0;
            int numT = 0;
            
            if (!ud.getName().equals("")) {
                sql += " WHERE name like ?";
                Nflag = true;
            }
            if (ud.getBirthday()!=null) {
                Bflag = true;
                if(!Nflag){
                    sql += " WHERE birthday like ?";
                    numB = 1;
                }else{
                    sql += " AND birthday like ?";
                    numB = 2;
                }
            }
            if (ud.getType()!=0) {
                Tflag = true;
                if(!Nflag && !Bflag){
                    sql += " WHERE type like ?";
                    numT =1;
                }else{
                    sql += " AND type like ?";
                    if(numB == 2){
                        numT = 3;
                    }else{numT = 2;}
                }
            }
            //ここを修正
            st =  con.prepareStatement(sql);
            if(Nflag){st.setString(1, "%"+ud.getName()+"%");}
            if(Bflag){st.setString(numB, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");}
            if(Tflag){st.setInt(numT, ud.getType());}
            
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                UserDataDTO resultUd = new UserDataDTO();
                resultUd.setUserID(rs.getInt(1));
                resultUd.setName(rs.getString(2));
                resultUd.setBirthday(rs.getDate(3));
                resultUd.setType(rs.getInt(4));
                resultUd.setTell(rs.getString(5));
                resultUd.setComment(rs.getString(6));
                resultUd.setNewDate(rs.getTimestamp(7));
                uddArray.add(resultUd);
            }
            
            System.out.println("search completed");

            return uddArray;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
    
    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
            resultUd.setUserID(rs.getInt(1));
            resultUd.setName(rs.getString(2));
            resultUd.setBirthday(rs.getDate(3));
            resultUd.setType(rs.getInt(4));
            resultUd.setTell(rs.getString(5));
            resultUd.setComment(rs.getString(6));
            resultUd.setNewDate(rs.getTimestamp(7));
            
            System.out.println("searchByID completed");

            return resultUd;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }

    void update(UserDataDTO userdata) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("UPDATE user_t SET name=?,birthday=?,tell=?,type=?,comment=?,newDate=? WHERE userID = ?");
            st.setString(1, userdata.getName());
            st.setDate(2, new java.sql.Date(userdata.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, userdata.getTell());
            st.setInt(4, userdata.getType());
            st.setString(5, userdata.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            st.setInt(7, userdata.getUserID());
            st.executeUpdate();
            System.out.println("update completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
        int delete(UserDataDTO userdata) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            st =  con.prepareStatement("DELETE FROM user_t WHERE userID =?");
            st.setInt(1, userdata.getUserID());
            int rs = st.executeUpdate();
            System.out.println("delete completed");
            return rs;
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }
    }
    
}
