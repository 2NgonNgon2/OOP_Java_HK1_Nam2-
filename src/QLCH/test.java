package QLCH;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Formatter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.File;
import java.util.*;
//get date and time 
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class test {
    public static void main(String[] args) throws Exception{
        // quanLiKhachHang dskh = new quanLiKhachHang();
        // Scanner sc = new Scanner(System.in);
        // File pathFile = new File("dsKhachHang.txt");
        
        // dskh.readFileFromArrUser("project_oop\\src\\QLCH\\ds.txt");
        // dskh.xuatDSKH();
        // Scanner input = new Scanner(pathFile);
        // String in = "";
        // in = input.nextLine();
        Laptop lt = new Laptop();
        lt.nhap();
    }
}
