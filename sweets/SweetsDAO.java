package sweets;

import java.sql.*;
import java.util.ArrayList;

public class SweetsDAO{

 private Connection conn;

 public SweetsDAO() throws ClassNotFoundException, SQLException{
  Class.forName("com.mysql.jdbc.Driver");
  String strConn = 
  /* 私のDBにつなげます。 */
  conn = DriverManager.getConnection(strConn);
 }

 public void close() {
  try{conn.close();}catch(SQLException e){e.printStackTrace();}
 }

 public String getFirstName() throws SQLException{
  String    name = null;
  Statement  stmt = null;
  ResultSet  rs  = null;
  try{
   stmt = conn.createStatement();
   String strSql = "SELECT name FROM product_tbl";
   rs=stmt.executeQuery(strSql);
   if(rs.next()){
    name = rs.getString("name");
   }
  }finally{
   try{rs.close();}catch(SQLException e){e.printStackTrace();}
   try{stmt.close();}catch(SQLException e){e.printStackTrace();}
  }
  return name;
 }

 public SweetsDTO getDataById(int id) throws SQLException{
  SweetsDTO   dto = null;
  Statement   stmt = null;
  ResultSet   rs  = null;
  String totalSta = "";
  try{
   stmt = conn.createStatement();
   String strSql = "SELECT * FROM product_tbl"
          + " join shop_tbl on product_tbl.shop_id = shop_tbl.id join shop_station_tbl"
          + " on shop_tbl.id = shop_station_tbl.shop_id join station_tbl"
          + " on shop_station_tbl.station_id = station_tbl.id where product_tbl.id=" + id;
   rs=stmt.executeQuery(strSql);
   while(rs.next()){
    totalSta += rs.getString("station_tbl.name") + " A";
   }
   totalSta = totalSta.substring(0,totalSta.length()-1);
   rs.beforeFirst();
   if(rs.next()){
    dto = new SweetsDTO(rs.getString("product_tbl.name")
              ,rs.getInt("price")
              ,rs.getString("shop_tbl.name")
              ,rs.getInt("product_tbl.lot")
              ,rs.getString("product_tbl.pic_name"),totalSta); 
   }
  }finally{
   try{rs.close();}catch(SQLException e){e.printStackTrace();}
   try{stmt.close();}catch(SQLException e){e.printStackTrace();}
  }
  return dto;
 }

 public ArrayList<SweetsDTO> getListByName(String word) throws SQLException{
  Statement       stmt = null;
  ResultSet       rs  = null;
  ArrayList<SweetsDTO> dtoAr = new ArrayList<>();
  try{
   stmt = conn.createStatement();
   String strSql = "SELECT * FROM shop_tbl"
          + " join product_tbl on shop_tbl.id=product_tbl.shop_id"
          + " where product_tbl.name like '%" + word + "%'";
   rs=stmt.executeQuery(strSql);
   SweetsDTO dto;
   while(rs.next()){
    dto = new SweetsDTO(rs.getString("product_tbl.name")
              ,rs.getInt("price")
              ,rs.getString("shop_tbl.name")
              ,rs.getInt("product_tbl.id"));
    dtoAr.add(dto); 
   }
  }finally{
   try{rs.close();}catch(SQLException e){e.printStackTrace();}
   try{stmt.close();}catch(SQLException e){e.printStackTrace();}
  }
  return dtoAr;
 }

}
