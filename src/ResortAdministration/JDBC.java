package ResortAdministration;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBC {

    private static final String uname = "root";
    private static final String pword = "root";
    private static final String url = "jdbc:mysql://localhost:3306/resort_administration";
    String s = "";
    int q;
    int i;
    int id;
    int deleteItem;
    boolean Y;

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    int rowsAffected;

    public JDBC() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, uname, pword);
            System.out.println("Connected to the database");

        } catch (Exception e) {
            System.out.println("Not Connected");
        }

    }

    public void customerReg(String firstname, String lastname, String address, String nationality, String email,
            String passport, String mobile, String phone,
            String username, String password, String creditcard, String cardpin, String gender, FileInputStream img) {
        try {
            preparedStatement = connection
                    .prepareStatement("INSERT INTO customer_registration (firstname,lastname,address,nationality,email,"
                            + "passport,mobile,phone,username, password, creditcard, cardpin,gender,picture) VALUES ('"
                            + firstname + "','" + lastname + "','"
                            + address + "','" + nationality + "','" + email + "','" + passport + "','" + mobile + "','"
                            + phone + "','" + username + "',"
                            + "'" + password + "','" + creditcard + "','" + cardpin + "','" + gender + "',?);");
            preparedStatement.setBinaryStream(1, img);
            rowsAffected = preparedStatement.executeUpdate();
            System.out.println("Inserted Successfully");
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean loginCustomer(String user, String pass) {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM customer_registration WHERE username='"
                    + user
                    + "' AND password='"
                    + pass
                    + "';");
            resultSet = preparedStatement.executeQuery();
            Y = resultSet.next();

        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Y;
    }

    public void healthSupport() {
        Timestamp sqldate = new Timestamp(System.currentTimeMillis());
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO support (username,time) VALUES (?,?);");
            preparedStatement.setString(1, Welcome.user);
            preparedStatement.setTimestamp(2, sqldate);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean checkPin(String pin, String amount) {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM customer_registration WHERE cardpin='"
                    + pin
                    + "';");
            resultSet = preparedStatement.executeQuery();
            Y = resultSet.next();
            if (Y) {
                preparedStatement = connection.prepareStatement("INSERT INTO money (username,amount) VALUES (?,?);");
                preparedStatement.setString(1, Welcome.user);
                preparedStatement.setString(2, amount);
                rowsAffected = preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Y;
    }

    public void gymPass(int year, int month, int day, int shour, int sminute, int ehour, int eminute) {
        Date date = new Date(year, month, day);
        Time start = new Time(shour, sminute, 0);
        Time end = new Time(ehour, eminute, 0);
        try {
            preparedStatement = connection
                    .prepareStatement("INSERT INTO gym (username,date,start,end) VALUES (?,?,?,?);");
            preparedStatement.setString(1, Welcome.user);
            preparedStatement.setDate(2, date);
            preparedStatement.setTime(3, start);
            preparedStatement.setTime(4, end);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void tour() {
        Timestamp sqldate = new Timestamp(System.currentTimeMillis());
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO tour (username,time,location,destination,car,suv,bus,speedBoat,yatch,price) VALUES (?,?,?,?,?,?,?,?,?,?);");
            preparedStatement.setString(1, Welcome.user);
            preparedStatement.setTimestamp(2, sqldate);
            preparedStatement.setString(3, Welcome.loc);
            preparedStatement.setString(4, Welcome.des);
            preparedStatement.setInt(5, SelectVehicle.car);
            preparedStatement.setInt(6, SelectVehicle.suv);
            preparedStatement.setInt(7, SelectVehicle.bus);
            preparedStatement.setInt(8, SelectVehicle.sb);
            preparedStatement.setInt(9, SelectVehicle.yt);
            preparedStatement.setInt(10, SelectVehicle.price);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fetchData() {
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM book_cot WHERE username=?;");
            preparedStatement.setString(1, Welcome.user);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Welcome.user = resultSet.getString("username");
                Welcome.cot = resultSet.getString("cot");
                BookCottage.time = resultSet.getTime("time");
                System.out.println(Welcome.user);
                System.out.println(Welcome.cot);
                System.out.println("" + BookCottage.time);
            } else
                System.out.println("Not found");
            preparedStatement = connection.prepareStatement("SELECT * FROM book_venue WHERE username=?;");
            preparedStatement.setString(1, Welcome.user);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Welcome.user = resultSet.getString("username");
                Welcome.res = resultSet.getString("venue");
                BookVenue.time = resultSet.getTime("time");
                System.out.println(Welcome.user);
                System.out.println(Welcome.res);
                System.out.println("" + BookVenue.time);
            } else
                System.out.println("Not found");
            preparedStatement = connection.prepareStatement("SELECT * FROM tour WHERE username=?;");
            preparedStatement.setString(1, Welcome.user);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Welcome.user = resultSet.getString("username");
                Welcome.loc = resultSet.getString("location");
                Welcome.des = resultSet.getString("destination");
                SelectVehicle.car = resultSet.getInt("car");
                SelectVehicle.suv = resultSet.getInt("suv");
                SelectVehicle.bus = resultSet.getInt("bus");
                SelectVehicle.sb = resultSet.getInt("speedBoat");
                SelectVehicle.yt = resultSet.getInt("yatch");
                SelectVehicle.price = resultSet.getInt("price");
                BookCottage.time = resultSet.getTime("time");
                System.out.println(Welcome.user);
                System.out.println(Welcome.loc);
                System.out.println(Welcome.des);
                System.out.println(SelectVehicle.car
                        + " " + SelectVehicle.suv + " " + SelectVehicle.bus + " " + SelectVehicle.sb + " "
                        + SelectVehicle.yt + " " + SelectVehicle.price + " " + BookCottage.time);

            } else
                System.out.println("Not found");
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bookCottage() {
        Timestamp sqldate = new Timestamp(System.currentTimeMillis());
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO book_cot (username,time,cot) VALUES (?,?,?);");
            preparedStatement.setString(1, Welcome.user);
            preparedStatement.setTimestamp(2, sqldate);
            preparedStatement.setString(3, Welcome.cot);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bookVenue() {
        Timestamp sqldate = new Timestamp(System.currentTimeMillis());
        try {
            preparedStatement = connection.prepareStatement(
                    "INSERT INTO book_venue (username,venue,time) VALUES (?,?,?);");
            preparedStatement.setString(1, Welcome.user);
            preparedStatement.setString(2, Welcome.res);
            preparedStatement.setTimestamp(3, sqldate);
            rowsAffected = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void checkOut_cot(){
        Timestamp sqldate = new Timestamp(System.currentTimeMillis());
        Timestamp prev=null;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT time FROM book_cot WHERE username=?;");
            preparedStatement.setString(1, Welcome.user);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                prev=resultSet.getTimestamp("time");
            }
            Date t=null;
            t=new Date(prev.getTime());
            String pattern="dd MM";
            SimpleDateFormat sdf=new SimpleDateFormat(pattern);
            String res=sdf.format(t);
            System.out.println(res);
            String ds2=res.substring(0, 2);
            String ms2=res.substring(3, 5);
            int di2=Integer.parseInt(ds2);
            int mi2=Integer.parseInt(ms2);
            Date t_1=null;
            t_1=new Date(sqldate.getTime());
            String pattern_1="dd MM";
            SimpleDateFormat sdf_1=new SimpleDateFormat(pattern_1);
            String res_1=sdf_1.format(t_1);
            String ds1=res_1.substring(0, 2);
            String ms1=res_1.substring(3, 5);
            int di1=Integer.parseInt(ds1);
            int mi1=Integer.parseInt(ms1);
            if(mi1==mi2){
                BookCottage.diff=di1-di2;
            }
            else if(mi1<mi2){
                BookCottage.diff=di1-di2+30;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void checkOut_res(){
        Timestamp sqldate = new Timestamp(System.currentTimeMillis());
        Timestamp prev=null;
        try {
            preparedStatement = connection.prepareStatement(
                    "SELECT time FROM book_venue WHERE username=?;");
            preparedStatement.setString(1, Welcome.user);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                prev=resultSet.getTimestamp("time");
            }
            Date t=null;
            t=new Date(prev.getTime());
            String pattern="dd MM";
            SimpleDateFormat sdf=new SimpleDateFormat(pattern);
            String res=sdf.format(t);
            System.out.println(res);
            String ds2=res.substring(0, 2);
            String ms2=res.substring(3, 5);
            int di2=Integer.parseInt(ds2);
            int mi2=Integer.parseInt(ms2);
            System.out.println(di2);
            System.out.println(mi2);
            Date t_1=null;
            t_1=new Date(sqldate.getTime());
            String pattern_1="dd MM";
            SimpleDateFormat sdf_1=new SimpleDateFormat(pattern_1);
            String res_1=sdf_1.format(t_1);
            System.out.println(res_1);
            String ds1=res_1.substring(0, 2);
            String ms1=res_1.substring(3, 5);
            int di1=Integer.parseInt(ds1);
            int mi1=Integer.parseInt(ms1);
            System.out.println(di1);
            System.out.println(mi1);
            if(mi1==mi2){
                BookVenue.diff=di1-di2;
            }
            else if(mi1<mi2){
                BookVenue.diff=di1-di2+30;
            }
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
