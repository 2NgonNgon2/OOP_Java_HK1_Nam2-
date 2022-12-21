package QLCH;

import java.io.Serializable;
import java.util.Scanner;

public class ThietBi_DienTu implements Serializable{
    private String MaSp;
	private String TenSp;
	private int Gia;
	private String HangSanXuat;
	private String QGSanXuat;
	private String MauSac;
	private int NamSanXuat;
	static	String heDieuHanh = "Win11";
	private String DungLuong;
	private int TinhTrang;
	private String Pin;
	private int soLuong;
	protected double radius =1.0;
	static void thayDoiHDH() {
		heDieuHanh = "Win10";
	}
	public double getArea() {
		return 3.14 * radius* radius;
	}
	public ThietBi_DienTu() {
		this.MaSp = null;
		this.TenSp = null;
		this.Gia = 0;
		this.HangSanXuat = null;
		this.QGSanXuat = null;
		this.MauSac = null;
		this.NamSanXuat = 0 ;
		this.DungLuong = null;
		this.TinhTrang = 0;
		this.Pin = null;
	}
	public ThietBi_DienTu(String maSp) {
		this.MaSp = maSp;
	}
	public ThietBi_DienTu(String ma,String ten, int gia, String hang,String qgSx, String mau,int NamSx, String dungluong,int TinhTrang,String pin) {
		this.MaSp = ma;
		this.TenSp = ten;
		this.Gia = gia;
		this.HangSanXuat = hang;
		this.QGSanXuat = qgSx;
		this.MauSac = mau;
		this.NamSanXuat = NamSx ;
		this.DungLuong = dungluong;
		this.TinhTrang = TinhTrang;
		this.Pin = pin;
	}
	public ThietBi_DienTu(ThietBi_DienTu tbdt) {
		this.MaSp = tbdt.MaSp;
		this.TenSp = tbdt.TenSp;
		this.Gia = tbdt.Gia;
		this.HangSanXuat =tbdt.HangSanXuat;
		this.QGSanXuat = tbdt.QGSanXuat;
		this.MauSac = tbdt.MauSac;
		this.NamSanXuat = tbdt.NamSanXuat;
		this.DungLuong =tbdt.DungLuong;
		this.TinhTrang = tbdt.TinhTrang;
		this.Pin = tbdt.Pin;
	}
	public void nhap() {
		checkExist ck = new checkExist();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Nhập mã sản phẩm: ");
			MaSp = sc.nextLine();
		}while(ck.checkExistIdProduct(MaSp));
		System.out.println("Nhap ten sản phẩm: ");
		TenSp = sc.nextLine();
		System.out.println("Nhập giá tiền: ");
		Gia = sc.nextInt();
		sc.nextLine();
		System.out.println("Chon hãng sản xuất: ");
		int lc;
		do {
			System.out.println("1.Acer");
			System.out.println("2.Asus");
			System.out.println("3.Dell");
			System.out.println("4.HP");
			System.out.println("5.Lenovo");
			System.out.print("Hay nhap lua chon: ");
			lc = sc.nextInt();
			sc.nextLine();

			switch (lc) {
				case 1:
				HangSanXuat = "Acer";
					break;
				case 2:
				HangSanXuat = "Asus";
					break;
				case 3:
				HangSanXuat = "Dell";
					break;
				case 4:
				HangSanXuat = "HP";
					break;
				case 5:
				HangSanXuat = "Lenovo";
					break;	
				default:
					System.out.print("Nhap lua chon co trong menu!");
					break;
			}
		} while (lc < 1 && lc > 5);
		System.out.println("Nhập quốc gia sản xuất: ");
		QGSanXuat = sc.nextLine();
		System.out.println("Nhập màu sắc: ");
		MauSac = sc.nextLine();
		System.out.println("Nhap năm sản xuất: ");
		NamSanXuat = Integer.parseInt(sc.nextLine());
		System.out.println("Nhập dung lượng: ");
		DungLuong = sc.nextLine();
		System.out.println("Nhập tình trạng: (0/1:Chưa qua sử dụng/Đã qua sử dụng)");
		TinhTrang = Integer.parseInt(sc.nextLine());
		System.out.println("Nhập pin: ");
		Pin = sc.nextLine();
	}

	public String getMasp() {
		return MaSp;
	}
	public String getTenSp() {
		return this.TenSp;
	}
	public int getGia() {
		return this.Gia;
	}
	public String getHangSanXuat() {
		return this.HangSanXuat;
	}
	public String getQGSanXuat() {
		return this.QGSanXuat;
	}
	public String getMauSac() {
		return this.MauSac;
	}
	public int getNamSanXuat() {
		return this.NamSanXuat;
	}
	public String getDungLuong() {
		return this.DungLuong;
	}
	public int getTinhTrang() {
		return this.TinhTrang;
	}
	public String getPin() {
		return this.Pin;
	}
	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int a) {
		this.soLuong = a;
	}
	@Override
	public String toString() {
		return "Laptop [MaSp=" + MaSp + ", TenSp=" + TenSp + ", Gia=" + Gia + ", HangSanXuat=" + HangSanXuat
				+ ", QGSanXuat=" + QGSanXuat + ", MauSac=" + MauSac + ", NamSanXuat=" + NamSanXuat + ", heDieuHanh="
				+ heDieuHanh + ", DungLuong=" + DungLuong + ", TinhTrang=" + TinhTrang + ", Pin=" + Pin + "";
	}
	
	

}
