package QLCH;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileWriter;

public class quanLiKhachHang {
    Scanner sc = new Scanner(System.in);
    private ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
    

    public quanLiKhachHang() {
        this.dsKH = new ArrayList<KhachHang>();
    }
    public quanLiKhachHang(ArrayList<KhachHang> ds) {
        this.dsKH = ds;
    }

    public ArrayList<KhachHang> getDSKH() {
        return this.dsKH;
    }

    public void xuatDSKH() {
        System.out.print("\n==================================================================================================");
        System.out.print("\n|                               DANH SACH KHACH HANG                                             |\n");
        System.out.println("==================================================================================================");
        System.out.printf("| %-15s | %-25s | %-15s | %-30s |\n", "Ma Khach hang", "Ten khach hang", "So dien thoai", "Dia Chi");
        System.out.println( "==================================================================================================");
        for (KhachHang o : dsKH) 
            System.out.printf("| %-15s | %-25s | %-15s | %-30s |\n", o.getMaKH(), o.getTenKH(),o.getSdt(), o.getDiaChi());            
        System.out.println( "==================================================================================================");
    }

    public void themThongTinKhachHang(KhachHang kh) {
        
        dsKH.add(kh);
    }

    public void xoaThongTinKhachHang(String ma) {
        int flag=0;
        for (KhachHang o : dsKH) {
            if (o.getMaKH().equals(ma)) {
                flag++;
                dsKH.remove(o);
                System.out.println("\nLuu y: Da xoa thong tin thanh cong!");
                break;
            }
        }
        if (flag == 0) {
            System.out.println( "Ma khach hang khong ton tai");
        }
    }
    
    public void readFileFromArrUser(String filePath) {
        dsKH.clear();
        BufferedReader rf = null;
        try {
            rf = new BufferedReader(new FileReader(filePath));
            String line = "";
            String[]arr;
            String maKH;
            String tenKH;
            String sdt;
            String diaChi;
            while (line != null) { 
                line = rf.readLine();
                if(line == null) 
                    break;
                if(line.isEmpty()) 
                    continue;
                arr = line.split(","); 
                maKH = arr[0];
                tenKH = arr[1];
                sdt = arr[2];
                diaChi = arr[3];  
                dsKH.add(new KhachHang(maKH, tenKH, sdt, diaChi));
            }
            rf.close();
        } catch (Exception e) {
            // e.printStackTrace();
        }
    }

    public void writeFileToArrUser( String filePath) {
        try {
            BufferedWriter wr = new BufferedWriter(new FileWriter(filePath));
            for (KhachHang o : dsKH) {
                wr.write(o.toString());
                wr.newLine();
            }
            wr.close();
        } catch (Exception e) {
            // System.out.println(e);
        }
    }

    public int soLuongKH() {
        return dsKH.size();
    }

    public void timKiemTheoTenKhachHang(String name) {
        int flag=0;
        System.out.print("\n==================================================================================================");
        System.out.print("\n|                               DANH SACH KHACH HANG                                             |\n");
        System.out.println("==================================================================================================");
        System.out.printf("| %-15s | %-25s | %-15s | %-30s |\n", "Ma Khach hang", "Ten khach hang", "So dien thoai", "Dia Chi");
        System.out.println( "==================================================================================================");
        for (KhachHang o : dsKH) {
            if(o.getTenKH().contains(name)) {
                System.out.printf("| %-15s | %-25s | %-15s | %-30s |\n", o.getMaKH(), o.getTenKH(),o.getSdt(), o.getDiaChi());
                flag ++;
            }
        }
        if (flag == 0) {
            System.out.printf("| %-90s|\n", "Luu y: Ten khach hang khong ton tai");
        }
        System.out.println( "==================================================================================================");

    }
    public void timKiemTheoMaKhachHang(String id) {
        int flag=0;
        System.out.print("\n==================================================================================================");
        System.out.print("\n|                               DANH SACH KHACH HANG                                             |\n");
        System.out.println("==================================================================================================");
        System.out.printf("| %-15s | %-25s | %-15s | %-30s |\n", "Ma Khach hang", "Ten khach hang", "So dien thoai", "Dia Chi");
        System.out.println( "==================================================================================================");

        for (KhachHang o : dsKH) {
            if(o.getMaKH().contains(id)) {
                System.out.printf("| %-15s | %-25s | %-15s | %-30s |\n", o.getMaKH(), o.getTenKH(),o.getSdt(), o.getDiaChi());
                flag ++;
            }
        }
        if (flag == 0) {
            System.out.printf("| %-90s|\n", "Luu y: Ma khach hang khong ton tai");
        }
        System.out.println( "==================================================================================================");

    }


    public void suaThongTinKhachHang(String ma) {
        int flag=0;
        checkExist exist = new checkExist();
        for(KhachHang o : dsKH) {
            if(o.getMaKH().equals(ma)) {
                String choice;
                flag++;
                do {

                System.out.println("\n----Hay chon thong tin chinh sua----\n");
                System.out.println("1. Sua tat ca");
                System.out.println("2. Sua ma khach hang");
                System.out.println("3. Sua ten khach hang");
                System.out.println("4. Sua so dien thoai");
                System.out.println("5. Sua dia chi");
                System.out.println("0. Tro ve menu quan li khach hang");
                do {
                    System.out.print("Hay nhap lua chon: ");
                    choice = sc.nextLine();
                }while(exist.checkIsNumber(choice) == false);
                    switch (Integer.parseInt(choice)) {
                        case 1:
                            o.nhapThongTinKhachHang();
                            break;
                        case 2:
                            
                            String maKHmoi;
                            do {
                                System.out.print("Nhap ma khach hang moi: ");
                                maKHmoi = sc.nextLine();
                    
                            } while(exist.checkExistIdUser(maKHmoi) == true);
                            
                            o.setMaKH(maKHmoi);
                            break;
                        case 3:
                            String tenKHmoi;
                            do {
                                System.out.print("Nhap ten khach hang moi: ");
                                tenKHmoi = sc.nextLine();
                            
                            } while(exist.checkExistIdUser(tenKHmoi) == true);
                            o.setTenKH(tenKHmoi);
                            break;
                        case 4:
                            String sdtMoi;
                            do {
                                System.out.print("Nhap so dien thoai moi: ");
                                sdtMoi = sc.nextLine();
                                
                            }while (exist.checkExistPhoneNumberUser(sdtMoi) == true);
                            o.setSdt(sdtMoi);
                            break;
                        case 5:
                            String diaChimoi;
                            do {
                                System.out.print("Nhap dia chi moi: ");
                                diaChimoi = sc.nextLine();
                            
                            } while(exist.checkExistIdUser(diaChimoi) == true);
                            o.setDiaChi(diaChimoi);
                            break;
                        case 0:
                            System.out.println("\nLuu y: Ban da tro ve menu quan li khach hang");
                            break;
                        default:
                            System.out.println("Luu y: Hay nhap lua chon co trong menu");
                            break;
                    }
                }  while(Integer.parseInt(choice) > 5);
                if(Integer.parseInt(choice) != 0)
                System.out.println("\nLuu y: Da chinh sua thong tin thanh cong!");
                break;
            }
        }
        if (flag == 0) {
            System.out.println( "\nLuu y: Ma khach hang khong ton tai");
        }
    }

    
}
