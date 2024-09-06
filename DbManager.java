/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cbt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author Anurag Bose
 */
public class DbManager {
    Connection con=null;
    PreparedStatement ps=null;
    ResultSet rs=null;
    public DbManager()
    {
        try
        {
             Class.forName("com.mysql.jdbc.Driver");
             con=DriverManager.getConnection("jdbc:mysql://localhost:3308/cbtdb?characterEncoding=utf8","root","");
        }
          
        catch(ClassNotFoundException ex1)
        {
        ex1.printStackTrace();
        }
        catch(SQLException ex2)
        {
        ex2.printStackTrace();
        }
    }
    public boolean insertUpdateDelete(String query)
    {
        try
        {
        ps=con.prepareStatement(query);
        ps.executeUpdate();
        return true;
        }
        catch(SQLException ex1)
        {
        ex1.printStackTrace();
        return false;
        }
    }
    public ResultSet select(String query)
    {
        try
        {
         ps=con.prepareStatement(query);
         rs=ps.executeQuery();
         return rs;
        }
        catch(SQLException ex1)
                {
                ex1.printStackTrace();
                return rs;
                }
    }
}
