package QLCH;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class quanLi_HoaDon {
	private ArrayList<HoaDon> list_hd;
	Scanner sc = new Scanner(System.in);
	public quanLi_HoaDon() {
		this.list_hd = new ArrayList<HoaDon>();
	}
	public quanLi_HoaDon(ArrayList<HoaDon>list_hd) {
		this.list_hd = list_hd;
	}
	public void themHd(HoaDon hd) {
		this.list_hd.add(hd);
	}
	public void inDanhSachHd() {
		int i=1;
		for (HoaDon hoaDon : list_hd) {
			System.out.println("STT: "+i);
			System.out.println(hoaDon);
			i++;
		} 
	}
	public boolean xoa_hd(HoaDon hd) {
		return this.list_hd.remove(hd);
	}
	public boolean xoaAllhd() {
		return this.list_hd.removeAll(list_hd);
	}
	public int layRaSoLuonghd() {
		return this.list_hd.size();
	}
	public void ghiDuLieuHoaDon(File file) {
		try {
			OutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			for (HoaDon hoaDon : list_hd) {
				oos.writeObject(hoaDon);
			}
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void docDuLieuHoaDon(File file) {
		try {
			InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
			HoaDon hd  = null;
			while(true) {
				Object oj = ois.readObject();
				if(oj==null) {
					break;
				}
				if(oj!=null) {
					hd = (HoaDon) oj;
					this.list_hd.add(hd);
				}
			}
			ois.close();
		} catch (Exception e) {
//			e.printStackTrace();
		}	
	}
	public void timHoaDonTheoMa(String ma) {
		for (HoaDon hoaDon : list_hd) {
			if(hoaDon.getMaHd().indexOf(ma)>=0) {
				System.out.println(hoaDon);
			}
		}
	}
	public void timHoaDonTheoTenNhanVien(String ma) {
		for (HoaDon hoaDon : list_hd) {
			if(hoaDon.getTenNv().equals(ma)) {
				System.out.println(hoaDon);
			}
		}
	}
	public void suaThongTinHoaDonTheoMa(String ma) {
		System.out.println("Sửa thành: "); String ma1 = sc.nextLine();
		for (HoaDon hoaDon : list_hd) {
			if(hoaDon.getMaHd().equals(ma)) {
				hoaDon.setMaHd(ma1);
			}
		}
	}
	public void timHoaDonMuaTren3Sp() {
		for (HoaDon hoaDon : list_hd) {
			if(hoaDon.getSl()>3) {
				System.out.println(hoaDon);
			}
		}
	}
	public void timSoLanMua(String id) {
		int count=0;
		for (HoaDon hoaDon : list_hd) {
			if(hoaDon.getID().equals(id)) {
				count++;
			}
		}
		System.out.println(""+count);
	}
}
