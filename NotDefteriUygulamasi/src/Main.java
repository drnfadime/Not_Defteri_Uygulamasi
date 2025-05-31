//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String klasorAdi = "Notlar";
        NotYonetici notYonetici = new NotYonetici(klasorAdi);


        int secim;
        do{
            System.out.println("\n   ---- Not Defteri Uygulaması ----");
            System.out.println("1- Yeni Not Oluştur");
            System.out.println("2- Notları Listele");
            System.out.println("3- Not Oku");
            System.out.println("4- Nota Ekleme Yap");
            System.out.println("5- Not Sil");
            System.out.println("0- Çıkış");

            System.out.print("Seçiminiz: ");
            secim = scanner.nextInt();
            scanner.nextLine();

            switch(secim){
                case 1:
                    System.out.println("Oluşturulacak yeni notun adını giriniz:");
                    String yeniNotAdi = scanner.nextLine();
                    System.out.println("Yeni nota eklenecek metini giriniz:");
                    String yeniIcerik = scanner.nextLine();
                    notYonetici.notOlustur(yeniNotAdi, yeniIcerik);
                    break;
                case 2:
                    notYonetici.notlariListele();
                    break;
                case 3:
                    System.out.print("Okumak istediğiniz notun adını giriniz:");
                    String okunacakNotAdi = scanner.nextLine();
                    notYonetici.notOku(okunacakNotAdi);
                    break;
                case 4:
                    System.out.print("Ekleme yapmak istediğiniz notun adını giriniz:");
                    String eklenecekNotAdi = scanner.nextLine();
                    System.out.print("Eklenecek metni giriniz:");
                    String eklenecekMetin = scanner.nextLine();
                    notYonetici.notaEkleme(eklenecekNotAdi, eklenecekMetin);
                    break;
                case 5:
                    System.out.println("Silinecek notun adını giriniz:");
                    String silinecekNotAdi = scanner.nextLine();
                    notYonetici.notSil(silinecekNotAdi);
                    break;
                case 0:
                    System.out.println("Not defteri uygulamasından çıkılıyor. Güle güle!");
                    break;
                default:
                    System.out.println("Geçersiz seçim! Lütfen 0 ile 5 arasında bir sayı girin.");
                    break;
            }
        }while(secim != 0 );

        scanner.close();
    }
}