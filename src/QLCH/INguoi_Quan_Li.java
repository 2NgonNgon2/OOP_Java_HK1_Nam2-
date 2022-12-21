package QLCH;

import java.io.File;

public interface INguoi_Quan_Li {
    void themNv(NhanVien nv);
	void inDanhSachNv();
	boolean xoa_nv(NhanVien nv);
	int layRaSoLuongNv();
	boolean kiemTraTonTaiNv(NhanVien nv);
	void ghiDuLieuNhanVien(File f);
	void docDuLieuNhanVien(File f);
	boolean xoaAllnv();
	void timNhanVienTheoGioiTinh(String gt);
	void sapXepNhanVienTheoLuongTang();
	void sapXepNhanVienTheoLuongGiam();
	void timKiemTheoLuong();
}
