package QLCH;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class DS_DienTu implements Serializable{
	private static final long serialVersionUID = 1L;
    private ArrayList <Laptop> list;
	Scanner sc = new Scanner(System.in);
	public DS_DienTu() {
		this.list = new ArrayList<Laptop>();
	}
	public DS_DienTu(ArrayList<Laptop> list) {
		this.list = list;
	}
	public void themLapTop(Laptop lt) {
		this.list.add(lt);
	}

	public ArrayList<Laptop> getDS_Dientu() {
		return this.list;
	}
	public void inDanhSach() {
		System.out.print("=========================================================================================================================================================================");
        System.out.print("\n|                        			   				    DANH SACH SAN PHAM                                        		   		|\n");
        System.out.println("=========================================================================================================================================================================");
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", "Ma san pham", "Ten san pham", "Gia", "Hang san xuat","Quoc gia","Mau","Nam SX","He dieu hanh","Dung luong","Tinh trang","Pin","CPU");
        System.out.println( "=========================================================================================================================================================================");
        for (Laptop laptop : list)  
        System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", laptop.getMasp(), laptop.getTenSp(),laptop.getGia(), laptop.getHangSanXuat(),laptop.getQGSanXuat(),laptop.getMauSac(),laptop.getNamSanXuat(),laptop.heDieuHanh,laptop.getDungLuong(),laptop.getTinhTrang(),laptop.getPin(),laptop.getCPU());  

        System.out.println( "=========================================================================================================================================================================");
    
	}
	public boolean kiemTraDsRong() {
		return this.list.isEmpty();
	}
	public void lamRongDs() {
		this.list.removeAll(list);
	}
	public int layRaSoLuongLapTop() {
		return this.list.size();
	}
	public void kiemTraTonTai(String ma) {
		for (Laptop laptop : list) {
			if(laptop.getMasp().equals(ma)) {
				System.out.println("Mã: "+ma+" có tồn tại trong danh sách");
				break;
			}else {
				System.out.println("Không tồn tại!!! ");
				break;
			}
		}
	}
	public boolean xoa_1Sp(Laptop lt ) {
		return this.list.remove(lt);
		
	}
	public void timKiemSpTheoMa(String lt) {
		System.out.print("=========================================================================================================================================================================");
		System.out.print("\n|                        			   				    DANH SACH SAN PHAM                                        		   		|\n");
		System.out.println("=========================================================================================================================================================================");
		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", "Ma san pham", "Ten san pham", "Gia", "Hang san xuat","Quoc gia","Mau","Nam SX","He dieu hanh","Dung luong","Tinh trang","Pin","CPU");
		System.out.println( "=========================================================================================================================================================================");        
		for (Laptop laptop : list) {
			if(laptop.getMasp().equals(lt))
			{
        		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", laptop.getMasp(), laptop.getTenSp(),laptop.getGia(), laptop.getHangSanXuat(),laptop.getQGSanXuat(),laptop.getMauSac(),laptop.getNamSanXuat(),laptop.heDieuHanh,laptop.getDungLuong(),laptop.getTinhTrang(),laptop.getPin(),laptop.getCPU());  
			}
		}
		System.out.println( "=========================================================================================================================================================================");
		
	}
	public void timKiemSpTheoHang(String lt) {
		System.out.print("=========================================================================================================================================================================");
		System.out.print("\n|                        			   				    DANH SACH SAN PHAM                                        		   		|\n");
		System.out.println("=========================================================================================================================================================================");
		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", "Ma san pham", "Ten san pham", "Gia", "Hang san xuat","Quoc gia","Mau","Nam SX","He dieu hanh","Dung luong","Tinh trang","Pin","CPU");
		System.out.println( "=========================================================================================================================================================================");        
		for (Laptop laptop : list) {
			if(laptop.getHangSanXuat().equalsIgnoreCase(lt))
			{
        		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", laptop.getMasp(), laptop.getTenSp(),laptop.getGia(), laptop.getHangSanXuat(),laptop.getQGSanXuat(),laptop.getMauSac(),laptop.getNamSanXuat(),laptop.heDieuHanh,laptop.getDungLuong(),laptop.getTinhTrang(),laptop.getPin(),laptop.getCPU());  
			}
		}
		System.out.println( "=========================================================================================================================================================================");
		
	}
	public void timKiemSpTheoLoai(String lt) {
		System.out.print("=========================================================================================================================================================================");
		System.out.print("\n|                        			   				    DANH SACH SAN PHAM                                        		   		|\n");
		System.out.println("=========================================================================================================================================================================");
		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", "Ma san pham", "Ten san pham", "Gia", "Hang san xuat","Quoc gia","Mau","Nam SX","He dieu hanh","Dung luong","Tinh trang","Pin","CPU");
		System.out.println( "=========================================================================================================================================================================");        
		for (Laptop laptop : list) {
			if(laptop.getTenSp().contains(lt))
			{
        		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", laptop.getMasp(), laptop.getTenSp(),laptop.getGia(), laptop.getHangSanXuat(),laptop.getQGSanXuat(),laptop.getMauSac(),laptop.getNamSanXuat(),laptop.heDieuHanh,laptop.getDungLuong(),laptop.getTinhTrang(),laptop.getPin(),laptop.getCPU());  
			}
		}
		System.out.println( "=========================================================================================================================================================================");
		
	}
	public void nhungSpDaQuaSd() {
		System.out.print("=========================================================================================================================================================================");
		System.out.print("\n|                        			   				    DANH SACH SAN PHAM                                        		   		|\n");
		System.out.println("=========================================================================================================================================================================");
		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", "Ma san pham", "Ten san pham", "Gia", "Hang san xuat","Quoc gia","Mau","Nam SX","He dieu hanh","Dung luong","Tinh trang","Pin","CPU");
		System.out.println( "=========================================================================================================================================================================");        
		for (Laptop laptop : list) {
			if(laptop.getTinhTrang()==1) {
        		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", laptop.getMasp(), laptop.getTenSp(),laptop.getGia(), laptop.getHangSanXuat(),laptop.getQGSanXuat(),laptop.getMauSac(),laptop.getNamSanXuat(),laptop.heDieuHanh,laptop.getDungLuong(),laptop.getTinhTrang(),laptop.getPin(),laptop.getCPU());  
			}
		}
		System.out.println( "=========================================================================================================================================================================");
	}
	public void spTu200Den500() {
		System.out.print("=========================================================================================================================================================================");
		System.out.print("\n|                        			   				    DANH SACH SAN PHAM                                        		   		|\n");
		System.out.println("=========================================================================================================================================================================");
		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", "Ma san pham", "Ten san pham", "Gia", "Hang san xuat","Quoc gia","Mau","Nam SX","He dieu hanh","Dung luong","Tinh trang","Pin","CPU");
		System.out.println( "=========================================================================================================================================================================");        
		for (Laptop laptop : list) {
			if(laptop.getGia()<=500 && laptop.getGia()>=200) {
				System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", laptop.getMasp(), laptop.getTenSp(),laptop.getGia(), laptop.getHangSanXuat(),laptop.getQGSanXuat(),laptop.getMauSac(),laptop.getNamSanXuat(),laptop.heDieuHanh,laptop.getDungLuong(),laptop.getTinhTrang(),laptop.getPin(),laptop.getCPU());  
			}
		}
		System.out.println( "=========================================================================================================================================================================");
	}
	public void spTu500Den1000() {
		System.out.print("=========================================================================================================================================================================");
		System.out.print("\n|                        			   				    DANH SACH SAN PHAM                                        		   		|\n");
		System.out.println("=========================================================================================================================================================================");
		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", "Ma san pham", "Ten san pham", "Gia", "Hang san xuat","Quoc gia","Mau","Nam SX","He dieu hanh","Dung luong","Tinh trang","Pin","CPU");
		System.out.println( "=========================================================================================================================================================================");        
		for (Laptop laptop : list) {
			if(laptop.getGia()<=1000 && laptop.getGia()>=500) {
        		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", laptop.getMasp(), laptop.getTenSp(),laptop.getGia(), laptop.getHangSanXuat(),laptop.getQGSanXuat(),laptop.getMauSac(),laptop.getNamSanXuat(),laptop.heDieuHanh,laptop.getDungLuong(),laptop.getTinhTrang(),laptop.getPin(),laptop.getCPU());  
			}
		}
		System.out.println( "=========================================================================================================================================================================");
	}
   
	public void inDsCaoDenThap() {
		Collections.sort(this.list, new Comparator<Laptop>() {

			@Override
			public int compare(Laptop lt1, Laptop lt2) {
				if(lt1.getGia()<lt2.getGia()) {
					return 1;
				}
				else	if(lt1.getGia()>lt2.getGia()) {
					return -1;
				}
				else {
					return 0;
				}
			}
		});
	
	}
	public void inDsThapDenCao() {
		Collections.sort(this.list, new Comparator<Laptop>() {

			@Override
			public int compare(Laptop lt1, Laptop lt2) {
				if(lt1.getGia()>lt2.getGia()) {
					return 1;
				}
				else	if(lt1.getGia()<lt2.getGia()) {
					return -1;
				}
				else {
					return 0;
				}
			}
		});
	
	}

	public void timKiemSanPhamTheoTen(String ten) {
		System.out.print("=========================================================================================================================================================================");
		System.out.print("\n|                        			   				    DANH SACH SAN PHAM                                        		   		|\n");
		System.out.println("=========================================================================================================================================================================");
		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", "Ma san pham", "Ten san pham", "Gia", "Hang san xuat","Quoc gia","Mau","Nam SX","He dieu hanh","Dung luong","Tinh trang","Pin","CPU");
		System.out.println( "=========================================================================================================================================================================");        
		
		for (Laptop laptop : list) {
			if(laptop.getTenSp().indexOf(ten)>=0) {
				System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", laptop.getMasp(), laptop.getTenSp(),laptop.getGia(), laptop.getHangSanXuat(),laptop.getQGSanXuat(),laptop.getMauSac(),laptop.getNamSanXuat(),laptop.heDieuHanh,laptop.getDungLuong(),laptop.getTinhTrang(),laptop.getPin(),laptop.getCPU());  

			}
		}
		System.out.println( "=========================================================================================================================================================================");

	}
	public void timKiemSanPhamTheoMa(String ma) {
		System.out.print("=========================================================================================================================================================================");
		System.out.print("\n|                        			   				    DANH SACH SAN PHAM                                        		   		|\n");
		System.out.println("=========================================================================================================================================================================");
		System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", "Ma san pham", "Ten san pham", "Gia", "Hang san xuat","Quoc gia","Mau","Nam SX","He dieu hanh","Dung luong","Tinh trang","Pin","CPU");
		System.out.println( "=========================================================================================================================================================================");        
		
		for (Laptop laptop : list) {
			if(laptop.getMasp().indexOf(ma)>=0) {
				System.out.printf("| %-15s | %-15s | %-15s | %-15s | %-10s | %-10s | %-10s | %-15s | %-10s | %-10s | %-10s |\n", laptop.getMasp(), laptop.getTenSp(),laptop.getGia(), laptop.getHangSanXuat(),laptop.getQGSanXuat(),laptop.getMauSac(),laptop.getNamSanXuat(),laptop.heDieuHanh,laptop.getDungLuong(),laptop.getTinhTrang(),laptop.getPin(),laptop.getCPU());  
			}
		}
		System.out.println( "=========================================================================================================================================================================");

	}
	public void ghiDuLieu(File file) {
		try {
			OutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(os);
			for (Laptop laptop : list) {
				oos.writeObject(laptop);
			}
			oos.flush();
			oos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void docDuLieu(File file) {
		try {
			InputStream is = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(is);
			Laptop lt  = null;
			while(true) {
				Object oj = ois.readObject();
				if(oj==null) {
					break;
				}
				if(oj!=null) {
					lt = (Laptop) oj;
					this.list.add(lt);
				}
			}
			ois.close();
		} catch (Exception e) {
			// e.printStackTrace();
		}
		
	}
}
