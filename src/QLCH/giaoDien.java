package QLCH;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class giaoDien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;
        menuChucNang menu = new menuChucNang();
        String choice;
        checkExist ck = new checkExist();
        do {
            String textInHeaderMenuSignIn = "CHAO MUNG DEN CUA HANG";
            int m = 100;// m là số cột 
            System.out.println("\n");
            for (int i = 1; i <= 2; i++) {
                for (int j = 1; j <= m; j++) {
                    if(i == 1 || j == 1 || j == 2 || j == m-1 || j == m )
                    System.out.print("*");
                    else 
                    System.out.print(" ");
                }
                System.out.println();
            }

            for (int j = 1; j <= m; j++) {
                if(j == 1 || j == 2 || j == m-1 || j == m )
                System.out.print("*");
                else if (j == 35)  {
                    System.out.print(textInHeaderMenuSignIn);
                    j += textInHeaderMenuSignIn.length()-1;
                }
                else 
                    System.out.print(" ");
            }
            System.out.println();

            for (int i = 1; i <= 2; i++) {
                for (int j = 1; j <= m; j++) {
                    if(i == 2 || j == 1 || j == 2 || j == m-1 || j == m )
                    System.out.print("*");
                    else 
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println("\n----------------------------------");
            System.out.println("|          MENU DANG NHAP        |");
            System.out.println("|--------------------------------|");
            System.out.println("|1. Nhan vien                    |");
            System.out.println("|2. Khach hang                   |");
            System.out.println("|3. Quan Li                      |");
            System.out.println("|0. Thoat                        |");
            System.out.println("----------------------------------");
            do {
                System.out.print("Hay nhap lua chon: ");
                choice = sc.nextLine();
            }while(ck.checkIsNumber(choice) == false);
            switch (Integer.parseInt(choice)) {
                case 1:
                    menu.menuEmployee();
                    break;
                case 2:
                    menu.menuUser();
                    break;
                case 3: 
                    menu.menuManager();
                    break;    
                case 0:
                    System.out.println("\nBan da roi khoi cua hang!\n");
                    break;
                default:
                    System.out.println("\nLuu y: Nhap lua chon co trong menu!");
                    break;
            }
        }while(Integer.parseInt(choice) != 0);

        sc.close();
    }


 

    
}
