package QLCH;

import java.util.ArrayList;
import java.lang.String;
import java.io.File;

public class checkExist {
    public checkExist() {
    }

    public boolean checkExistIdProduct(String id) {
        DS_DienTu dsdt = new DS_DienTu();
        File file = new File("project_oop\\SanPham.txt");
        if(id == "" || id.matches("\\s+")) {
            System.out.println("Luu y: Thong tin khong duoc de trong");
            return true;
        }
        dsdt.docDuLieu(file);
        for (Laptop o : dsdt.getDS_Dientu()) {
            if(o.getMasp().equals(id)) {
                System.out.println("Luu y: Ma san pham da ton tai");
                return true;
            }
        }
        return false;
    }

    public boolean checkExistIdEmployee(String id) {
        quanLi_NhanVien dsnv = new quanLi_NhanVien();
        File file = new File("project_oop\\NhanVien.txt");
        if(id == "" || id.matches("\\s+")) {
            System.out.println("Luu y: Thong tin khong duoc de trong");
            return true;
        }
        dsnv.docDuLieuNhanVien(file);
        for (NhanVien o : dsnv.getArrEmployee()) {
            if(o.getMaNv().equals(id)) {
                System.out.println("Luu y: Ma nhan vien da ton tai");
                return true;
            }
        }
        return false;
    }

    public boolean checkExistIdUser(String id) {
        quanLiKhachHang dskh = new quanLiKhachHang();
        if(id == "" || id.matches("\\s+")) {
            System.out.println("Luu y: Thong tin khong duoc de trong");
            return true;
        }
        dskh.readFileFromArrUser("project_oop\\dsKhachHang.txt");
        for (KhachHang o : dskh.getDSKH()) {
            if(o.getMaKH().equals(id)) {
                System.out.println("Luu y: Ma khach hang da ton tai");
                return true;
            }
        }
        return false;
    }

    public boolean checkExistPhoneNumberUser(String sdt) {
        quanLiKhachHang dskh = new quanLiKhachHang();
        dskh.readFileFromArrUser("project_oop\\dsKhachHang.txt");
        
        for (int i = 0; i < sdt.length(); i++) 
            if(Character.isDigit(sdt.charAt(i)) == false) {
                System.out.println("Luu y: So dien thoai phai la so\n");
                return true;
            }
        if (sdt == "" || sdt.matches("\\s+")) {
            System.out.println("Luu y: Thong tin khong duoc de trong\n");
            return true;
        }
        if(sdt.length() != 10)  {
            System.out.println("Luu y: So dien thoai phai co 10 so\n");
            return true;
        }
        
        
        for (KhachHang o : dskh.getDSKH() ) {
            if(o.getSdt().equals(sdt)) {
                System.out.println("Luu y: So dien thoai nay da ton tai\n");
                return true;
            }
        }
        return false;
    }


    public boolean checkIsNumber(String a) {
        if(a == "" || a.matches("\\s+")) {
            System.out.println("Luu y: Lua chon khong duoc de trong\n");
            return false;
        }
        for (int i = 0; i < a.length(); i++) 
            if(Character.isDigit(a.charAt(i)) == false) {
                System.out.println("Luu y: Lua chon phai la so\n");
                return false;
            }
        return true;
    }
}
