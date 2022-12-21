package QLCH;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


public class menuChucNang extends mainMenu{
    @Override
    public void menuUser() {
        checkExist ck = new checkExist();
        Scanner sc = new Scanner(System.in) ;
        String choiceMenuUser;
        String idProduct;
        int quantity;
        cart crt = new cart();
        DS_DienTu dsdt1 = new DS_DienTu();
		String ten1 = ("project_oop\\SanPham.txt");
		File file = new File(ten1);
		dsdt1.docDuLieu(file);
        do {
            String textInHeaderMenuUser = "BEN TRONG CUA HANG";
            int m = 100;// m là số cột 
            System.out.println("\n");
            for (int i = 1; i <= 2; i++) {
                for (int j = 1; j <= m; j++) {
                    if(i == 1 || j == 1 || j == 2 || j == m-1 || j == m )
                    System.out.print("*");
                    else 
                    System.out.print(" ");
                }
                System.out.println();
            }

            for (int j = 1; j <= m; j++) {
                if(j == 1 || j == 2 || j == m-1 || j == m )
                System.out.print("*");
                else if (j == 35)  {
                    System.out.print(textInHeaderMenuUser);
                    j += textInHeaderMenuUser.length()-1;
                }
                else 
                    System.out.print(" ");
            }
            System.out.println();

            for (int i = 1; i <= 2; i++) {
                for (int j = 1; j <= m; j++) {
                    if(i == 2 || j == 1 || j == 2 || j == m-1 || j == m )
                    System.out.print("*");
                    else 
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println("\n---------------------------------------------------------------------------");
            System.out.println("|                            MENU KHACH HANG                                |");
            System.out.println("|---------------------------------------------------------------------------|");
            System.out.println("|1.  Xem danh sach san pham                                                 |");
            System.out.println("|2.  Tim kiem san pham                                                      |");
            System.out.println("|3.  Loc san pham da qua su dung                                            |");
            System.out.println("|4.  Loc san pham theo hang                                                 |");
            System.out.println("|5.  Loc san pham theo loai ( Gaming,Hoc tap - Van phong, Do hoa - Ki thuat)|");
            System.out.println("|6.  In danh sach tu cao den thap theo muc gia                              |");
            System.out.println("|7.  In danh sach tu thap den cao theo muc gia                              |");
            System.out.println("|8.  Loc nhung san pham co gia tu 200$ den 500$                             |");
            System.out.println("|9.  Loc nhung san pham co gia tu 500$ den 1000$                            |");
            System.out.println("|10. Them san pham vao gio                                                  |");
            System.out.println("|11. Xem gio hang                                                           |");
            System.out.println("|12. Xoa san pham trong gio hang                                            |");
            System.out.println("|13. Xoa tat ca san pham trong gio hang                                     |");
            System.out.println("|14. Thanh toán                                                             |");
            System.out.println("|15. Xem đơn hàng                                                           |");
            System.out.println("|0.  Dang xuat                                                              |");
            System.out.println("-----------------------------------------------------------------------------");
            do {
                System.out.print("Hay nhap lua chon: ");
                choiceMenuUser = sc.nextLine();
            }while(ck.checkIsNumber(choiceMenuUser) == false);
            switch (Integer.parseInt(choiceMenuUser)) {
                case 1:
                    dsdt1.inDanhSach();
                    break;
                case 2:
                	System.out.println("Nhap ma san pham can tim kiem:");
                	String MaSp = sc.nextLine();
                	dsdt1.timKiemSpTheoMa(MaSp);
                    break;
                case 3: 
                	System.out.println("Nhung san pham da qua su dung:");
                	dsdt1.nhungSpDaQuaSd();
                	break;
                case 4:
                	System.out.println("Nhap hang san pham can tim kiem:");
                	String HangSx = sc.nextLine();
                	dsdt1.timKiemSpTheoHang(HangSx);
                	break;
                case 5:
                	System.out.println("Nhap loai san pham can tim kiem:");
                	String Loai = sc.nextLine();
                	dsdt1.timKiemSpTheoLoai(Loai);
                	break;
                case 6:
                	System.out.println("Danh sach tu cao den thap");
                	dsdt1.inDsCaoDenThap();
                	dsdt1.inDanhSach();
                	break;
                case 7:
                	System.out.println("Danh sach tu thap den cao");
                	dsdt1.inDsThapDenCao();
                	dsdt1.inDanhSach();
                	break;
                case 8:
                	System.out.println("Nhung san pham co gia tu 200$ den 500$:");
                	dsdt1.spTu200Den500();
                	break;
                case 9:
                	System.out.println("Nhung san pham co gia tu 500$ den 1000$");
                	dsdt1.spTu500Den1000();
                	break;
                case 10:
                    dsdt1.inDanhSach();
                    System.out.print("Hay nhap ma san pham: ");
                    idProduct = sc.nextLine();
                    System.out.print("Hay nhap so luong: ");
                    quantity = sc.nextInt();
                    sc.nextLine();
                    crt.addToCart(idProduct, quantity);
                    crt.writeFileToArrCart();
                    break;
                case 11:
                    crt.readFileFromArrCart();
                    crt.showCart();
                    break;
                case 12:
                    crt.readFileFromArrCart();
                    crt.showCart();
                    System.out.print("Hay nhap ma san pham(co trong gio hang): ");
                    idProduct = sc.nextLine();  
                    crt.delProduct(idProduct);
                    break;
                case 13:
                    crt.delAllProduct();
                    crt.writeFileToArrCart();
                    break;
                case 14: 
                    crt.paymentAllProduct();
                    
                    
                    break;
                case 15:
                    crt.showCart();
                    break;
                case 0:
                    System.out.print("\nLuu y: Ban da dang xuat!");                    
                    break;
                default:
                    System.out.print("\nLuu y: Nhap lua chon co trong menu!");
                    break;
            }

        }while(Integer.parseInt(choiceMenuUser) != 0 );
    }
    @Override
    public void menuEmployee() {
        checkExist ck = new checkExist();
        Scanner sc = new Scanner(System.in) ;
        String choiceMenuEmployee;
        do {
            String textInHeaderMenuEmployee = "GIAO DIEN QUAN LI CUA HANG";
            int m = 100;// m là số cột 
            System.out.println("\n");
            for (int i = 1; i <= 2; i++) {
                for (int j = 1; j <= m; j++) {
                    if(i == 1 || j == 1 || j == 2 || j == m-1 || j == m )
                    System.out.print("*");
                    else 
                    System.out.print(" ");
                }
                System.out.println();
            }

            for (int j = 1; j <= m; j++) {
                if(j == 1 || j == 2 || j == m-1 || j == m )
                System.out.print("*");
                else if (j == 35)  {
                    System.out.print(textInHeaderMenuEmployee);
                    j += textInHeaderMenuEmployee.length()-1;
                }
                else 
                    System.out.print(" ");
            }
            System.out.println();

            for (int i = 1; i <= 2; i++) {
                for (int j = 1; j <= m; j++) {
                    if(i == 2 || j == 1 || j == 2 || j == m-1 || j == m )
                    System.out.print("*");
                    else 
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println("\n------------------------------");
            System.out.println("|       MENU NHAN VIEN       |");
            System.out.println("|----------------------------|");
            System.out.println("|1. Quan li san pham         |");
            System.out.println("|2. Quan li khach hang       |");
            System.out.println("|3. Quan li don hang         |");
            System.out.println("|0. Dang xuat                |");
            System.out.println("------------------------------");
            do {
                System.out.print("Hay nhap lua chon: ");
                choiceMenuEmployee = sc.nextLine();
            }while(ck.checkIsNumber(choiceMenuEmployee) == false);
            switch (Integer.parseInt(choiceMenuEmployee)) {   
                case 1: 
                    DS_DienTu dsdt = new DS_DienTu();
		            String ten = ("project_oop\\SanPham.txt");
		            File file = new File(ten);
		            dsdt.docDuLieu(file);
                    String luaChon1;
                    do {
                        System.out.println("\n-------------------------------------------------");
                        System.out.println("|                Quan li san pham               |");
                        System.out.println("|-----------------------------------------------|");
                        System.out.println("|1-Them laptop vao danh sach                    |");
                        System.out.println("|2-In danh sach laptop ra man hinh              |");
                        System.out.println("|3-Kiem tra danh sach co rong hay khong?        |");
                        System.out.println("|4-Lam rong danh sach                           |");
                        System.out.println("|5-Kiem tra san pham co ton tai hay khong?      |");
                        System.out.println("|6-Lay ra so luong san pham trong danh sach     |");
                        System.out.println("|7-Xoa 1 san pham trong danh sach               |");
                        System.out.println("|8-Ghi du lieu xuong file                       |");
                        System.out.println("|9-Tim kiem san pham theo ten                   |");
                        System.out.println("|10-Tim kiem san pham theo ma                   |");
                        System.out.println("|0-Tro ve menu nhan vien                        |");
                        System.out.println("-------------------------------------------------");
                        do {
                            System.out.print("Hay nhap lua chon: ");
                            luaChon1 = sc.nextLine();
                        }while(ck.checkIsNumber(luaChon1) == false);
                        switch (Integer.parseInt(luaChon1)) {
                            case 1:
                                Laptop lt = new Laptop();
                                lt.nhap();
                                dsdt.themLapTop(lt);
                                break;
                            case 2:
                                dsdt.inDanhSach();
                                break;
                            case 3:
                                System.out.println("Danh sach cua ban(Rong: true, Khong rong: false): "+dsdt.kiemTraDsRong());
                                break; 
                            case 4:
                                dsdt.lamRongDs();	
                                System.out.println("Da lam rong danh sach...");
                                break; 
                            case 5:
                                System.out.println("Nhap ma san pham: "); 
                                String maSp = sc.nextLine();
                                dsdt.kiemTraTonTai(maSp);
                                break; 
                            case 6:
                                System.out.println("So luong san pham trong danh sach la: "+dsdt.layRaSoLuongLapTop());
                                break; 
                            case 7:
                                System.out.println("Nhap ma san pham can xoa: "); 
                                String masp = sc.nextLine();
                                Laptop lt1 = new Laptop(masp);
                                System.out.println("Da xoa / Chua xoa (true/false): "+dsdt.xoa_1Sp(lt1));
                                break;
                            case 8:
                                String tenFile = ("project_oop\\SanPham.txt");
                                File f = new File(tenFile);
                                dsdt.ghiDuLieu(f);	
                                break;
                            case 9:
                                System.out.println("Nhập loại sản phẩm cần tìm kiếm: ");
                                String ten1 = sc.nextLine();
                                System.out.println("Sản phẩm tìm kiếm: ");
                                dsdt.timKiemSanPhamTheoTen(ten1);
                                break;
                            case 10:
                                System.out.println("Nhập mã sản phẩm cần tìm kiếm: ");
								String ma = sc.nextLine();
								System.out.println("Sản phẩm tìm kiếm: ");
								dsdt.timKiemSanPhamTheoMa(ma);
                                break;    
                            case 0:
                                System.out.println("\nLuu y: Ban da tro ve menu nhan vien");   
                                break;                     
                            default:
                                System.out.print("\nLuu y: Nhap lua chon co trong menu!");
                                break;
                        }
                    } while(Integer.parseInt(luaChon1) !=0);
                        break;
                case 2:
                    // ql khách hàng
                   String luaChon2; 
                   String idUser, nameUser;
                   String filePathArrUser = "project_oop\\dsKhachHang.txt"; 
                   quanLiKhachHang DSKH = new quanLiKhachHang();
                   DSKH.readFileFromArrUser(filePathArrUser);
                    do {
                        System.out.println("\n-------------------------------------------------");
                        System.out.println("|                Quan li khach hang             |");
                        System.out.println("|-----------------------------------------------|");
                        System.out.println("|1-In danh sach khach hang                      |");
                        System.out.println("|2-Them khach hang vao danh sach                |");
                        System.out.println("|3-Xem so luong khach hang trong danh sach      |");
                        System.out.println("|4-Tim kiem khach hang theo ten                 |");
                        System.out.println("|5-Tim kiem khach hang theo ma                  |");
                        System.out.println("|6-Sua thong tin khach hang                     |");
                        System.out.println("|7-Xoa thong tin khach hang                     |");
                        System.out.println("|0-Tro ve menu nhan vien                        |");
                        System.out.println("-------------------------------------------------");
                        do {
                            System.out.print("Hay nhap lua chon: ");
                            luaChon2 = sc.nextLine();
                        }while(ck.checkIsNumber(luaChon2) == false);
                        switch (Integer.parseInt(luaChon2)) {
                            case 1: 
                                DSKH.xuatDSKH();
                                break;
                            case 2:
                                KhachHang kh = new KhachHang();
                                String check;
                                kh.nhapThongTinKhachHang();
                                System.out.println("\nBan co muon luu khach hang vao danh sach?");
                                do {
                                    System.out.println("\ny:Yes");
                                    System.out.println("\nn:No");
                                    System.out.print("\nHay nhap lua chon:");
                                    check = sc.nextLine();
                                    check = check.trim();
                                    if (check.equals("y")  || check.equals("n")) {
                                        break;
                                    }
                                } while (check != "y" || check != "n"); 
                                if(check.equals("y")) {
                                    DSKH.themThongTinKhachHang(kh);
                                    DSKH.writeFileToArrUser(filePathArrUser);
                                    System.out.println("\nLưu ý: Da them khach hang thanh !");
                                } else  {
                                    System.out.println("\nLuu y: Da bo luu khach hang!");
                                }
                                break;                               
                            case 3:
                                System.out.println("\nSo luong khach hang co trong danh sach: " + DSKH.soLuongKH());
                                break;
                            case 4:
                                System.out.print("\nNhap ten khach hang muon tim: ");
                                nameUser = sc.nextLine();
                                nameUser = nameUser.trim();
                                DSKH.timKiemTheoTenKhachHang(nameUser);
                                break;
                            case 5:
                                System.out.print("\nNhap ma khach hang muon tim: ");
                                idUser = sc.nextLine();
                                idUser = idUser.trim();
                                DSKH.timKiemTheoMaKhachHang(idUser);
                                break;    
                            case 6:
                                DSKH.xuatDSKH();
                                System.out.print("\nNhap ma khach hang muon sua: ");
                                idUser = sc.nextLine();
                                idUser = idUser.trim();
                                DSKH.suaThongTinKhachHang(idUser);
                                DSKH.writeFileToArrUser(filePathArrUser);
                                break;
                            case 7:
                                DSKH.xuatDSKH();
                                System.out.print("\nNhap ma khach hang muon xoa: ");
                                idUser = sc.nextLine();
                                idUser = idUser.trim();
                                DSKH.xoaThongTinKhachHang(idUser);
                                DSKH.writeFileToArrUser(filePathArrUser);
                                break;
                            case 0:
                            System.out.println("\nLuu y: Ban da tro ve menu nhan vien!");
                                break;
                            default:
                                System.out.println("\nLưu ý: Nhap lua chon co trong menu!");
                                break;
                        }
                    } while(Integer.parseInt(luaChon2) != 0);
                        break;
                case 3:
                    // ql đơn hàng 
                    String luaChon3; 
                    String filePathArrBill = "project_oop\\HoaDon.txt";
                    File file2 = new File(filePathArrBill); 
                    quanLi_HoaDon dshd = new quanLi_HoaDon();
                    dshd.docDuLieuHoaDon(file2);
                    do {
                        System.out.println("\n------------------------------------------------------");
                        System.out.println("|                Quan li hoa don                     |");
                        System.out.println("|----------------------------------------------------|");
                        System.out.println("|1-Them hoa don vao danh sach                        |");
                        System.out.println("|2-In danh sach hoa don                              |");
                        System.out.println("|3-Luu hoa don vao file                              |");
                        System.out.println("|4-Tim kiem hoa don theo ma                          |");
                        System.out.println("|5-Sua thong tin hoa don                             |");
                        System.out.println("|6-Thong ke so luong hoa don                         |");
                        System.out.println("|7-Loc hoa don mua tren 3 san pham                   |");
                        System.out.println("|8-Thong ke so lan khi hoa don mua tren 3 san pham   |");
                        System.out.println("|0-Tro ve                                            |");
                        System.out.println("------------------------------------------------------");
                        do {
                            System.out.print("Hay nhap lua chon: ");
                            luaChon3 = sc.nextLine();
                        }while(ck.checkIsNumber(luaChon3) == false);
                        switch (Integer.parseInt(luaChon3)) {
                        case 1: 
                            System.out.println("Nhập mã đơn hàng: ");
                            String ma = sc.nextLine();
                            System.out.println("Nhập ngày tạo đơn: ");
                            String ngay = sc.nextLine();
                            System.out.println("Họ tên khách hàng: ");
                            String tenkhach = sc.nextLine();
                            System.out.println("Nhập ID khách hàng(Mỗi khách sẽ có 1 mã ID vĩnh viễn của cửa hàng): ");
                            String ID = sc.nextLine();
                            System.out.println("Họ tên nhân viên bán: ");
                            String tenNv = sc.nextLine();
                            System.out.println("Tên loại sản phẩm: ");
                            String tenLoai = sc.nextLine();
                            System.out.println("Số lượng: ");
                            int sl = Integer.parseInt(sc.nextLine());
                            System.out.println("Thời gian bảo hành: ");
                            String tgbh = sc.nextLine();
                            System.out.println("Thông tin giao hàng: ");
                            String ttgh = sc.nextLine();
                            System.out.println("Phương thức thanh toán: ");
                            String pttt = sc.nextLine();
                            System.out.println("Phương thức nhận hàng: ");
                            String ptnh = sc.nextLine();
                            HoaDon hd = new HoaDon(ma, ngay, tenkhach, ID, tenNv, tenLoai, sl, tgbh, ttgh, pttt, ptnh);
                            dshd.themHd(hd);
                            break;
                        case 2:
                            dshd.inDanhSachHd();
                            break;                               
                        case 3:
                            String tenFile = ("project_oop\\HoaDon.txt");
                            File f = new File(tenFile);
                            dshd.ghiDuLieuHoaDon(f);
                            break;
                        case 4:
                            System.out.println("Nhập mã hóa đơn cần tìm kiếm"); String ma1 = sc.nextLine();
                            HoaDon hoaDon = new HoaDon(ma1);
                            System.out.println("Kết quả tìm kiếm: ");
                            dshd.timHoaDonTheoMa(ma1);
                            break;
                        case 5:
                            System.out.println("Nhập mã hóa đơn cần tìm kiếm"); String ma2 = sc.nextLine();
                            HoaDon hoaDon1 = new HoaDon(ma2);
                            System.out.println("Kết quả tìm kiếm: ");
                            dshd.timHoaDonTheoMa(ma2);
                            break;   
                        case 6:
                            System.out.println("Số lượng hóa đơn trong danh sách là: "+dshd.layRaSoLuonghd());
                            break;
                        case 7:
                            System.out.println("Nhập tên nhân viên: "); String ten2 = sc.nextLine();
                            System.out.println("Kết quả tìm kiếm: ");
                            dshd.timHoaDonTheoTenNhanVien(ten2);
                            break;
                        case 8:
                            dshd.timHoaDonMuaTren3Sp();
                            break;   
                        case 9:
                            System.out.println("Nhập ID của khách hàng: ");
							String id = sc.nextLine();
							System.out.print("Số lần mua: "); dshd.timSoLanMua(id);
							break;   
                        case 0:
                            System.out.println("\nLuu y: Ban da tro ve menu nhan vien!");
                            break;
                        default:
                            System.out.println("\nLưu ý: Nhap lua chon co trong menu!");
                            break;
                        }
                    } while(Integer.parseInt(luaChon3) != 0);
                    break;
                case 0:
                    System.out.println("\nLuu y: Ban da dang xuat!");
                    break;    
                default:
                    System.out.println("\nLuu y: Nhap lua chon co trong menu!");
                    break;
            }
            
        }while(Integer.parseInt(choiceMenuEmployee) != 0 );

    }
    @Override
    public void menuManager() {
        checkExist ck = new checkExist();
        Scanner sc = new Scanner(System.in) ;
        String choiceMenuManager;
        do {
            String textInHeaderChoiceMenuManager = "GIAO DIEN QUAN LI NHAN VIEN";
            int m = 100;// m là số cột 
            System.out.println("\n");
            for (int i = 1; i <= 2; i++) {
                for (int j = 1; j <= m; j++) {
                    if(i == 1 || j == 1 || j == 2 || j == m-1 || j == m )
                    System.out.print("*");
                    else 
                    System.out.print(" ");
                }
                System.out.println();
            }

            for (int j = 1; j <= m; j++) {
                if(j == 1 || j == 2 || j == m-1 || j == m )
                System.out.print("*");
                else if (j == 35)  {
                    System.out.print(textInHeaderChoiceMenuManager);
                    j += textInHeaderChoiceMenuManager.length()-1;
                }
                else 
                    System.out.print(" ");
            }
            System.out.println();

            for (int i = 1; i <= 2; i++) {
                for (int j = 1; j <= m; j++) {
                    if(i == 2 || j == 1 || j == 2 || j == m-1 || j == m )
                    System.out.print("*");
                    else 
                    System.out.print(" ");
                }
                System.out.println();
            }
            System.out.println("\n------------------------------");
            System.out.println("|      MENU NGUOI QUAN LI    |");
            System.out.println("|----------------------------|");
            System.out.println("|1. Quan li nhan vien        |");
            System.out.println("|0. Dang xuat                |");
            System.out.println("------------------------------");
            do {
                System.out.print("Hay nhap lua chon: ");
                choiceMenuManager = sc.nextLine();
            }while(ck.checkIsNumber(choiceMenuManager) == false);
            switch (Integer.parseInt(choiceMenuManager)) {   
                case 1: 
                    quanLi_NhanVien dsnv = new quanLi_NhanVien();
		            String ten = ("project_oop\\NhanVien.txt");
		            File file = new File(ten);
		            dsnv.docDuLieuNhanVien(file);
                    String luaChon1;
                    do {
                        System.out.println("\n-----------------------------------------------------");
                        System.out.println("|                Quan li nhan vien                  |");
                        System.out.println("|---------------------------------------------------|");
                        System.out.println("|1-Them nhan vien vao danh sach                     |");
                        System.out.println("|2-In danh sach nhan vien                           |");
                        System.out.println("|3-Xoa tat ca nhan vien trong danh sach             |");
                        System.out.println("|4-Kiem tra nhan vien co ton tai hay khong (theo ma)|");
                        System.out.println("|5-Loc nhan vien theo gioi tinh                     |");
                        System.out.println("|6-Loc nhan vien co muc luong (1000$ - 1500$)       |");
                        System.out.println("|7-Sap xep danh sach nhan vien tang theo muc luong  |");
                        System.out.println("|8-Sap xep danh sach nhan vien giam theo muc luong  |");
                        System.out.println("|9-Luu thong tin nhan vien vao file                 |");
                        System.out.println("|10-Xoa nhan vien theo ma nhan vien                 |");
                        System.out.println("|11-Sua nhan vien theo ma nhan vien                 |");
                        System.out.println("|0-Tro ve                                           |");
                        System.out.println("-----------------------------------------------------");
                        do {
                            System.out.print("Hay nhap lua chon: ");
                            luaChon1 = sc.nextLine();
                        }while(ck.checkIsNumber(luaChon1) == false);
                        switch (Integer.parseInt(luaChon1)) {
                            case 1:
                                String MANV;
                                do {
                                    System.out.print("Nhập mã nhân viên: ");
                                    MANV = sc.nextLine();

                                }while(ck.checkExistIdEmployee(MANV));
                                System.out.print("Nhập tên nhân viên: ");
                                String TENNV = sc.nextLine();
                                System.out.println("Nhập giới tính: ");
                                String GioiTinh = sc.nextLine();
                                System.out.println("Nhập mức lương: ");
                                float Luong = Float.parseFloat( sc.nextLine());
                                System.out.println("Nhập ngày vào làm: ");
                                String ngayVaoLam = sc.nextLine();
                                System.out.print("Nhập số điện thoại: ");
                                String SDT= sc.nextLine();
                                System.out.print("Nhập địa chỉ: ");
                                String DiaChi = sc.nextLine();
                                NhanVien nv = new NhanVien(MANV, TENNV,GioiTinh,Luong,ngayVaoLam,SDT,DiaChi);
                                dsnv.themNv(nv);
                                break;
                            case 2:
                                dsnv.inDanhSachNv();
                                break;
                            case 3:
                                System.out.println("Đã xóa / Chưa xóa (true/false): "+dsnv.xoaAllnv());
                                break;
                            case 4:
                                System.out.println("Nhập mã nhân viên cần kiểm tra: "); String ma = sc.nextLine();
                                NhanVien nv1  = new NhanVien(ma);
                                System.out.println("Nhân viên có trong danh sách (Có/Không:true/false): "+dsnv.kiemTraTonTaiNv(nv1));
                                break;
                            case 5:
                                System.out.println("Nhập giới tính cần tìm kiếm: "); String gt = sc.nextLine();
                                System.out.println("Danh sách nhân viên theo giới tính: ");
                                dsnv.timNhanVienTheoGioiTinh(gt);
                                break;
                            case 6:
                                System.out.println("Danh sách những nhân viên có mức lương từ 1000$-1500$ là: ");
                                dsnv.timKiemTheoLuong();
                                break;
                            case 7:
                                System.out.println("Danh sách nhân viên sắp xếp tăng theo mức lương là: ");
                                dsnv.sapXepNhanVienTheoLuongTang();
                                dsnv.inDanhSachNv();
                                break;
                            case 8:
                                System.out.println("Danh sách nhân viên sắp xếp giảm theo mức lương là: ");
                                dsnv.sapXepNhanVienTheoLuongGiam();
                                dsnv.inDanhSachNv();
                                break;
                            case 9:
                                String tenFile = ("project_oop\\NhanVien.txt");
                                File f = new File(tenFile);
                                dsnv.ghiDuLieuNhanVien(f);
                                break;
                            case 10:
                                System.out.println("Nhập mã nhân viên cần xóa: "); String ma1 = sc.nextLine();
								NhanVien nv2 = new NhanVien(ma1);
								System.out.println("Đã xóa / chưa xóa: (true/false): "+dsnv.xoa_nv(nv2));
                            case 0:
                                System.out.println("\nLuu y: Ban da tro ve menu nhan vien");   
                                break;                     
                            default:
                                System.out.print("\nLuu y: Nhap lua chon co trong menu!");
                                break;
                        }
                    } while(Integer.parseInt(luaChon1) !=0);
                        break;
                case 0:
                    System.out.println("\nLuu y: Ban da dang xuat!");
                    break;    
                default:
                    System.out.println("\nLuu y: Nhap lua chon co trong menu!");
                    break;
            }
            
        }while(Integer.parseInt(choiceMenuManager) != 0 );

    }
}
