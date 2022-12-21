package QLCH;

import java.util.Scanner;

import java.io.Serializable;
import java.util.Objects;


public class NhanVien implements Comparable<NhanVien>,Serializable{ 
	private static final long serialVersionUID = 1L;
	private String MANV;
    private String TENNV;
    private String GioiTinh;
    private float Luong;
    private String ngayVaoLam;
    private String SDT;
    private String DiaChi;
    
    public NhanVien() {
    }
    public NhanVien(String ma) {
    	this.MANV = ma;
    }

    public NhanVien(String ma, String ten,String gt,float luong,String ngayVl, String sdt, String diachi) {
        this.MANV = ma;
        this.TENNV = ten;
        this.GioiTinh = gt;
        this.Luong = luong;
        this.ngayVaoLam = ngayVl;
        this.SDT = sdt;
        this.DiaChi = diachi;
    }

	public String getMaNv() {
		return MANV;
	}
	public String getTennv() {
		return TENNV;
	}
    public String getGt() {
		return GioiTinh;
	}
    public float getLuong() {
		return Luong;
	}
	public String getSDT() {
		return SDT;
	}
	public String getDiaChi() {
		return DiaChi;
	}

	@Override
	public int compareTo(NhanVien o) {
		return this.MANV.compareTo(o.MANV);
	}
	
	@Override
	public String toString() {
		return "NhanVien [MANV=" + MANV + ", TENNV=" + TENNV + ", GioiTinh=" + GioiTinh + ", Luong=" + Luong
				+ ", ngayVaoLam=" + ngayVaoLam + ", SDT=" + SDT + ", DiaChi=" + DiaChi + "]";
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(DiaChi, GioiTinh, Luong, MANV, SDT, TENNV, ngayVaoLam);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return  Objects.equals(MANV, other.MANV);
				
	}
	
	

}
