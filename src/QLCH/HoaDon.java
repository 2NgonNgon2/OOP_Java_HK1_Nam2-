package QLCH;
import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class HoaDon implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maDonHang;
	private String ngayLap;
	private String tenKhach;
	private String ID;
	private String nhanVienBan;
	private String tenSp;
	private int soLuong;
	private String baoHanh;
	private String thongTinGiaoHang;
	private String phuongThucTT;
	private String phuongThucNH;
	public HoaDon() {
		
	}
	public HoaDon(String maDonHang) {
		this.maDonHang = maDonHang;
	}
	public HoaDon(String maDonHang, String ngayLap, String tenKhach, String iD, String nhanVienBan, String tenSp,
			int soLuong, String baoHanh, String thongTinGiaoHang, String phuongThucTT, String phuongThucNH) {
		this.maDonHang = maDonHang;
		this.ngayLap = ngayLap;
		this.tenKhach = tenKhach;
		this.ID = iD;
		this.nhanVienBan = nhanVienBan;
		this.tenSp = tenSp;
		this.soLuong = soLuong;
		this.baoHanh = baoHanh;
		this.thongTinGiaoHang = thongTinGiaoHang;
		this.phuongThucTT = phuongThucTT;
		this.phuongThucNH = phuongThucNH;
	}
	public void nhapHd() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập mã đơn hàng: ");
		maDonHang = sc.nextLine();
		System.out.println("Nhập ngày tạo đơn: ");
		ngayLap = sc.nextLine();
		System.out.println("Họ tên khách hàng: ");
		tenKhach = sc.nextLine();
		System.out.println("Nhập ID khách hàng(Mỗi khách sẽ có 1 mã ID vĩnh viễn của cửa hàng): ");
		ID = sc.nextLine();
		System.out.println("Họ tên nhân viên bán: ");
		nhanVienBan = sc.nextLine();
		System.out.println("Tên loại sản phẩm: ");
		tenSp = sc.nextLine();
		System.out.println("Số lượng: ");
		soLuong = Integer.parseInt(sc.nextLine());
		System.out.println("Thời gian bảo hành: ");
		baoHanh = sc.nextLine();
		System.out.println("Thông tin giao hàng: ");
		thongTinGiaoHang = sc.nextLine();
		System.out.println("Phương thức thanh toán: ");
		phuongThucTT = sc.nextLine();
		System.out.println("Phương thức nhận hàng: ");
		phuongThucNH = sc.nextLine();
	}
	public String  getTenNv() {
		return nhanVienBan;
	}
	public String getMaHd() {
		return maDonHang;
	}
	public void setMaHd(String maHd) {
		this.maDonHang = maHd;
	}
	public int getSl(){
		return soLuong;
	}
	public String getID(){
		return ID;
	}
	@Override
	public String toString() {
		return "HoaDon [maDonHang=" + maDonHang + ", ngayLap=" + ngayLap + ", tenKhach=" + tenKhach + ", ID=" + ID
				+ ", nhanVienBan=" + nhanVienBan + ", tenSp=" + tenSp + ", soLuong=" + soLuong + ", baoHanh=" + baoHanh
				+ ", thongTinGiaoHang=" + thongTinGiaoHang + ", phuongThucTT=" + phuongThucTT + ", phuongThucNH="
				+ phuongThucNH + "]";
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(baoHanh, maDonHang, ngayLap, nhanVienBan, phuongThucNH, phuongThucTT, soLuong, tenKhach,
				tenSp, thongTinGiaoHang);																																																	
	}																							
	@Override
	public boolean equals(Object obj) {
        if (this == obj)
        return true;
    if (obj == null)
        return false;
    if (getClass() != obj.getClass())
        return false;
    HoaDon other = (HoaDon) obj;
    return Objects.equals(maDonHang, other.maDonHang);
    }


}