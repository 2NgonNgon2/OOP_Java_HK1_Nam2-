package QLCH;


import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;

public class Laptop extends ThietBi_DienTu implements Comparable<Laptop>,Serializable{
    private String CPU;
	
	public Laptop() {
		
	}
	public Laptop(String ma) {
		super(ma);
	}
	public Laptop(String Masp, String TenSp, int Gia, String Hangsx, String qg,String mauSac,int NamSx, String DungL,int tinhTrang,String heDh,String Pin,String cpu) {
		super(Masp, TenSp, Gia, Hangsx, qg, mauSac, NamSx, DungL, tinhTrang, Pin);
		this.CPU = cpu;
	}
	public String getCPU() {
		return this.CPU;
	}
	@Override public void nhap() {
		/* System.out.println(getArea());
		radius *= (50/100);
		System.out.println(getArea()); */

		Scanner sc = new Scanner(System.in);
		super.nhap();
		System.out.println("Nhập CPU: ");
		CPU = sc.nextLine();
	}
	@Override
	public String toString() {
		return super.toString()+", CPU: " + this.CPU+"]";
	}
	@Override
	public int compareTo(Laptop o) {
		return this.getMasp().compareTo(o.getMasp());
	}
	@Override
	public int hashCode() {
		return Objects.hash(getMasp());
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Laptop other = (Laptop) obj;
		return Objects.equals(getMasp(), other.getMasp());
	}
	
	
}
