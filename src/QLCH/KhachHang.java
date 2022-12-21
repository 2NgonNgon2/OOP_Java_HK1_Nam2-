package QLCH;

import java.util.Scanner;


public class KhachHang {
    Scanner sc = new Scanner(System.in);
    private String maKH;
    private String tenKH;
    private String sdt;
    private String diaChi;
    
    public KhachHang() {
        this.maKH = null;
        this.tenKH = null;
        this.sdt = null;
        this.diaChi = null;
    }
    public KhachHang(String a, String b, String c, String d) {
        this.maKH = a;
        this.tenKH = b;
        this.sdt = c;
        this.diaChi = d;
    }

    

    public void setMaKH(String ma) {
        this.maKH = ma;
    }
    public void setTenKH(String ten) {
        this.tenKH = ten;
    }
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public void setDiaChi(String diachi) {
        this.diaChi = diachi;   
    }
    public String getMaKH(){
        return this.maKH;
    }
    public String getTenKH(){
        return this.tenKH;
    }
    public String getSdt(){
        return this.sdt;
    }
    public String getDiaChi(){
        return this.diaChi;
    }

    public void nhapThongTinKhachHang() {
        checkExist exist = new checkExist();
        System.out.print("\n-------------NHAP THONG TIN KHACH HANG-------------\n");
        do {
            System.out.print("\nNhap ma khach hang: ");
            this.maKH = sc.nextLine();

            this.maKH = this.maKH.trim().replaceAll("\\s+", "");
        } while(exist.checkExistIdUser(this.maKH) == true);
        
        System.out.print("Nhap ho va ten khach hang: ");
        this.tenKH = sc.nextLine();
        this.tenKH = this.tenKH.trim().replaceAll("\\s+", " ");
        
        do {
            System.out.print("Nhap so dien thoai: ");
            this.sdt = sc.nextLine();
            this.sdt = this.sdt.trim();
        } while(exist.checkExistPhoneNumberUser(this.sdt) == true);
        
        System.out.print("Nhap dia chi: ");
        this.diaChi = sc.nextLine();
        this.diaChi = this.diaChi.trim().replaceAll("\\s+", " ");
    }

    public void xuatThongTinKhachHang() {
        System.out.println("Ma khach hang: " + maKH);
        System.out.println("Ho va ten khach hang: " + tenKH);
        System.out.println("So dien thoai: " + sdt);
        System.out.println("Dia chi: " + diaChi);

    }

    @Override
    public String toString() {
        return  maKH + "," + tenKH + "," + sdt + "," + diaChi;
    }
}
