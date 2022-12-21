package QLCH;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class cart {
    Scanner sc = new Scanner(System.in);
    private static long total;
    private int id;
    private ArrayList<productInCart> arrProduct = new ArrayList<productInCart>();//quan he has-a

    public cart() {
        this.arrProduct = new ArrayList<productInCart>();
    }

    public cart(ArrayList<productInCart> ds) {
        this.arrProduct = ds;
    }

    public void addToCart(String productId, int quantity) {
        boolean flag=false;
        DS_DienTu dsdt = new DS_DienTu();
		String ten1 = ("project_oop\\SanPham.txt");
		File file = new File(ten1);
		dsdt.docDuLieu(file);
        for(Laptop o : dsdt.getDS_Dientu()) {
            if(o.getMasp().equals(productId)) {

                for (productInCart p : arrProduct) {
                    if (p.getProductId().equals(productId)) {
                        flag =true;
                        quantity += p.getProductQuantity();
                        p.setProductQuantity(quantity);
                        System.out.println( "\nLuu y: Da them san pham thanh cong!");
                        break;
                    }
                }
                if(flag == true)break;
                flag =true;
                productInCart pic = new productInCart(o.getMasp(), o.getTenSp(),quantity, o.getGia());
                arrProduct.add(pic);
                System.out.println( "\nLuu y: Da them san pham thanh cong!");
                break;
            }
        }
        if(flag == false) {
            System.out.println( "\nLuu y : Ma san pham khong ton tai");
        }
    }

    public void showCart() {
        boolean check =false;
        System.out.print("\n==============================================================================");
        System.out.print("\n|                                 GIO HANG                                   |\n");
        System.out.println("==============================================================================");
        System.out.printf("| %-15s | %-20s | %-10s | %-20s |\n", "Ma san pham", "Ten san pham", "So luong", "Gia");
        System.out.println( "==============================================================================");
        for (productInCart o : arrProduct)  {
            check = true;
            total += (o.getProductQuantity() * o.getProductPrice());
            System.out.printf("| %-15s | %-20s | %-10s | %-20s |\n", o.getProductId(), o.getProductName(),o.getProductQuantity(), o.getProductPrice());            
        }
        if(check == false) {
            System.out.printf("| %-74s |\n","Chua co san pham trong gio hang");
        }
        System.out.println( "==============================================================================");
        System.out.println( "\nTONG TIEN : " + total + "$");
        
    }

    public void delProduct(String id) {
        boolean flag =false;
        if (arrProduct.isEmpty()) {
            System.out.println( "\nLuu y : Khong co san pham trong gio hang");
        } else {
            for (productInCart o : arrProduct) {
                if(o.getProductId().equals(id)) {
                    flag = true;
                    total -= (o.getProductQuantity()*o.getProductPrice());
                    arrProduct.remove(o);
                    writeFileToArrCart();
                    System.out.println( "\nLuu y : Da xoa san pham trong gio hang");
                    break;
                }
            }
            if(flag == false) {
                System.out.println( "\nLuu y : Ma san pham khong ton tai");
            }
        }
    }

    public void delAllProduct() {
        if (arrProduct.isEmpty()) {
            System.out.println( "\nLuu y : Khong co san pham trong gio hang");
            
        } else {
            total = 0;
            arrProduct.removeAll(arrProduct);
            System.out.println( "\nLuu y : Da xoa toan bo san pham trong gio hang");
        }
        
    }

    public void paymentAllProduct() {
            boolean check =false;
            int datHang;
            System.out.print("\n==============================================================================");
            System.out.print("\n|                               HOA DON                                      |\n");
            System.out.println("==============================================================================");
    
            // In hoa don ra
            System.out.printf("| %-15s | %-20s | %-10s | %-20s |\n", "Ma san pham", "Ten san pham", "So luong", "Gia");
            System.out.println( "==============================================================================");
            for (productInCart o : arrProduct)  {
                System.out.printf("| %-15s | %-20s | %-10s | %-20s |\n", o.getProductId(), o.getProductName(),o.getProductQuantity(), o.getProductPrice());            
            }
    
            // Cho khach tu nhap hoa don
            System.out.println( "==============================================================================\n");
            
    
            // In thanh tien
            System.out.printf("\nThanh tien:" + total + "$\n");
            System.out.printf("--------------------------------------------------------------------------\n");
            System.out.printf("1. Tiep tuc dat hang\n");
            System.out.printf("2. Huy don hang\n");
            while(true){
                datHang = sc.nextInt();
                sc.nextLine();
                if(datHang == 1){
                    System.out.println( "Luu y: Da thanh toan thanh cong");
                    delAllProduct();
                    writeFileToArrCart();
                    break;
                }
                else if(datHang == 2){
                    System.out.println( "Luu y: Don hang cua ban da bi huy");
                    break;
                }
                else System.out.println( "Luu y: Vui long nhap lai");
            } 
        

        }
     
    public void writeBillToFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("project_oop\\HoaDon.txt"));
            for (productInCart o : arrProduct)  {
                bw.write(id);    
            }
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }    
    // public void showHoaDon() {
    //     FileReader fr = new FileReader("donHang.txt");
    //     int i;
    //     while ((i = fr.read()) != -1) {
    //         System.out.print((char) i);
    //     }
    //     fr.close();
    // }

    public void readFileFromArrCart() {
        arrProduct.clear();
        try {
            BufferedReader rf = new BufferedReader(new FileReader("project_oop\\cart.txt"));
            String line = "";
            String[]arr;
            String masp;
            String tensp;
            int soLuong;
            int gia;
            
            while(line != null) {
                line = rf.readLine();
                if(line== null) 
                    break;
                
                if(line.isEmpty()) 
                    continue;
                
                arr = line.split(",");
                masp = arr[0];
                tensp = arr[1];
                soLuong = Integer.parseInt(arr[2]);
                gia = Integer.parseInt(arr[3]);
                arrProduct.add(new productInCart(masp, tensp, soLuong, gia));
            }
           
            rf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void writeFileToArrCart() {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("project_oop\\cart.txt"));
            for(productInCart o : arrProduct) {
                bw.write(o.toString());
                bw.newLine();
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
