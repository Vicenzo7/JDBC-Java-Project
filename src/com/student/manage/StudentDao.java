package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class StudentDao {

    public static boolean insertStudentToDB(Student st)
    {
        boolean flag= false;
        try {
            //jdbc code...
            Connection con = ConnectionProvider.createConnection();
            String q ="insert into students(sname,sphone,scity) values(?,?,?)";
            //PreparedStatement
            PreparedStatement pstmt =con.prepareStatement(q);
            //set the values of parameters
            pstmt.setString(1, st.getStudentName());
            pstmt.setString(2, st.getStudentPhone());
            pstmt.setString(3, st.getStudentCity());

            //executing query..
            pstmt.executeUpdate();
            flag=true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;


    }

    public static boolean deleteStudent(int sId) {
        boolean flag= false;
        try {
            //jdbc code...
            Connection con = ConnectionProvider.createConnection();
            String q ="delete from students where sid=?";
            //PreparedStatement
            PreparedStatement pstmt =con.prepareStatement(q);
            //set the values of parameters
            pstmt.setInt(1, sId);
            //executing query..
            pstmt.executeUpdate();
            flag=true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static void showAllStudents() {

        try {
            //jdbc code...
            Connection con = ConnectionProvider.createConnection();
            String q ="select * from students ";
            Statement stmt = con.createStatement();

            //gets the data from database(execute query)
            ResultSet set= stmt.executeQuery(q);

            while(set.next())
            {
                int id=set.getInt(1);
                String name=set.getString(2);
                String phone=set.getString(3);
                String city=set.getString(4);

                System.out.println("ID    : "+id);
                System.out.println("Name  : "+name);
                System.out.println("Phone : "+phone);
                System.out.println("City  : "+city);
                System.out.println("+++++++++++++++++++++++++++++++++++++++");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static boolean updateStudent(int sId, String sName, String sPhone, String sCity) {
        boolean flag= false;
        try {
            //jdbc code...
            Connection con = ConnectionProvider.createConnection();
            String q ="update students set sname=?,sphone=?, scity=? where sid=? ";
            //PreparedStatement
            PreparedStatement pstmt =con.prepareStatement(q);
            //set the values of parameters
            pstmt.setString(1, sName);
            pstmt.setString(2, sPhone);
            pstmt.setString(3, sCity);
            pstmt.setInt(4, sId);

            //executing query..
            pstmt.executeUpdate();
            flag=true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
