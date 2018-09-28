//package com.example.ChatApp;
//
//
//import java.sql.*;
//
//public class SqlConnect {
//
//    private Connection con;
//    private Statement st;
//    private ResultSet rs;
//
//
//    public SqlConnect(){
//
////        Connection con = null;
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat","root", "root");
//            st = con.createStatement();
//
//
//
//        }
//        catch (SQLException ex) {
//
//            System.out.println("SQL Exception : "+ ex.getMessage());
//
//            System.out.println("Vendor Error : "+ ex.getErrorCode());
//
//        }
//            catch(ClassNotFoundException ex) {
//
//            ex.printStackTrace();
//
//        }
//    }
//    public void getData(){
//        try{
//            String query = "select * from users";
//            rs= st.executeQuery(query);
//            System.out.println("Records from database");
//            while(rs.next()){
//                String user = rs.getString("user");
//                String content = rs.getString("content");
//                System.out.println("user" + user + " content    " + content);
//            }
//
//        }
//        catch (Exception ex){
//            System.out.println(ex);
//        }
//    }
//
//}
