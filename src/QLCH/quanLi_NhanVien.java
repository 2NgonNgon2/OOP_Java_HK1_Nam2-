package QLCH;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class quanLi_NhanVien implements INguoi_Quan_Li{
    private ArrayList<NhanVien> list_nv;
    Scanner sc = new Scanner(System.in);
    public quanLi_NhanVien() {
        this.list_nv = new ArrayList<NhanVien>();
    }
    public quanLi_NhanVien(ArrayList<NhanVien>list_nv) {
        this.list_nv = list_nv;
    }


    public ArrayList<NhanVien> getArrEmployee() {
        return this.list_nv;
    }
    @Override
    public void themNv(NhanVien nv) {
        this.list_nv.add(nv);
    }
    @Override
    public void inDanhSachNv() {
        System.out.print("=========================================================================================================================================================================");
        System.out.print("\n|                        			   				    DANH SACH SAN PHAM                                        		   		|\n");
        System.out.println("=========================================================================================================================================================================");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n", "Ma nhan vien", "Ten nhan vien", "Gioi tinh", "Luong","So dien thoai","Dia chi");
        System.out.println( "=========================================================================================================================================================================");        
        for (NhanVien nhanVien : list_nv) {
        	System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n", nhanVien.getMaNv(), nhanVien.getTennv(),nhanVien.getGt(), nhanVien.getLuong(),nhanVien.getSDT(),nhanVien.getDiaChi());  
        }
        System.out.println( "=========================================================================================================================================================================");
    }
    @Override
    public boolean xoa_nv(NhanVien nv) {
        return this.list_nv.remove(nv);
    }
    @Override
    public boolean xoaAllnv() {
        return this.list_nv.removeAll(list_nv);
    }
    @Override 
    public boolean kiemTraTonTaiNv(NhanVien nv) {
        return this.list_nv.contains(nv);
    }
    @Override
    public int layRaSoLuongNv() {
        return this.list_nv.size();
    }
    @Override
    public void ghiDuLieuNhanVien(File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            for (NhanVien nhanVien : list_nv) {
                oos.writeObject(nhanVien);
            }
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
    @Override
    public void docDuLieuNhanVien(File file) {
        try {
            InputStream is = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(is);
            NhanVien nv  = null;
            while(true) {
                Object oj = ois.readObject();
                if(oj==null) {
                    break;
                }
                if(oj!=null) {
                    nv = (NhanVien) oj;
                    this.list_nv.add(nv);
                }
            }
            ois.close();
        } catch (Exception e) {
//			e.printStackTrace();
        }
        
    }
    @Override
    public void timNhanVienTheoGioiTinh(String gt) {
        for (NhanVien nhanVien : list_nv) {
            if(nhanVien.getGt().equals(gt)) {
                System.out.println(nhanVien);
            }
        }
        
    }
    @Override
    public void sapXepNhanVienTheoLuongTang() {
        Collections.sort(this.list_nv, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien nv1, NhanVien nv2) {
                if(nv1.getLuong()>nv2.getLuong()) {
                    return 1;
                }else if(nv1.getLuong()<nv2.getLuong()) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        
    }
    @Override
    public void sapXepNhanVienTheoLuongGiam() {
        Collections.sort(this.list_nv, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien nv1, NhanVien nv2) {
                if(nv1.getLuong()<nv2.getLuong()) {
                    return 1;
                }else if(nv1.getLuong()>nv2.getLuong()) {
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        
    }
    @Override
    public void timKiemTheoLuong() {
        for (NhanVien nhanVien : list_nv) {
            if(nhanVien.getLuong()<=1500 & nhanVien.getLuong()>=1000) {
                System.out.println(nhanVien);
            }
        }
        
    }
}

