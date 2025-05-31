import java.io.*;
import java.io.IOException;
import java.io.FileReader;

public class NotYonetici {
    private String klasorAdi;

    public NotYonetici(String klasorAdi) {
        this.klasorAdi = klasorAdi;
        File klasor = new File(this.klasorAdi);
        if (!klasor.exists()) {
            if (klasor.mkdir()) {
                System.out.println("Not klasörü oluşturuldu: " + this.klasorAdi);
            } else {
                System.out.println("Klasör oluşturulamadı!");
            }
        }
    }

    public void notOlustur(String notAdi, String icerik){
        String dosyaYolu = klasorAdi + File.separator + notAdi + ".txt";
        File notDosyasi = new File(dosyaYolu);
        try{
            if(notDosyasi.createNewFile()) {
                System.out.println("Yeni not oluşturuldu: " + notDosyasi.getName());

                try(FileWriter writer = new FileWriter(notDosyasi)) {
                    writer.write(icerik);
                    System.out.println("Not içeriği başarıyla yazıldı.");
                }
            }else{
                System.out.println("Belirtilen not zaten mevcut");
            }
        }catch(IOException e){
            System.err.println("Not oluşturulurken veya yazılırken bir hata oluştu: " + e.getMessage());
        }

    }

    public void notlariListele(){
        File klasor = new File(klasorAdi);
        //Klasörün var olup olmadığını ve dizin olup olmadığını kontrol et
        if(!klasor.exists() || !klasor.isDirectory()){
            System.out.println("Not klasörü bulunamadı veya bir dizin değil: " + klasorAdi);
            return;
        }
        File[] notDosyalari = klasor.listFiles();//Klasördeki tüm dosya ve dizinleri al.
        if(notDosyalari == null && notDosyalari.length == 0) {
            System.out.println("Henüz hiç not bulunmamaktadır.");
            return;
        }
        System.out.println("\n --- Mevcut Notlar ---");
        boolean notBulundu = false;
        for(File dosya : notDosyalari){
            if(dosya.isFile() && dosya.getName().endsWith(".txt")){
                String notAdi = dosya.getName().replace(".txt" , "");
                System.out.println(" - " + notAdi);
                notBulundu =true;
            }
        }
        if(!notBulundu){
            System.out.println("Henüz hiç not bulunmamaktadır.");
        }
        System.out.println("----------------------\n");

    }

    public void notOku(String notAdi){
        String dosyaYolu = klasorAdi + File.separator + notAdi + ".txt";
        File notDosyasi = new File(dosyaYolu);

        if(!notDosyasi.exists()){
            System.out.println("Hata: '" + notAdi + "' adında bir not  bulunamadı. ");
            return;
        }
        if(!notDosyasi.isFile()){
            System.out.println("Hata: '" + notAdi + "' bir dosya değil.");
            return;
        }

        System.out.println("\n ---" + notAdi + " Notunun İçeriği ---");
        try(BufferedReader reader = new BufferedReader(new FileReader(notDosyasi))){
            String satir;
            while((satir = reader.readLine()) != null){
                System.out.println(satir);
            }
        }catch (IOException e){
            System.err.println("Not okunurken bir hata oluştu: " + e.getMessage());
        }
        System.out.println("-------------------------------------\n");

    }


    public void notaEkleme(String notAdi, String eklenecekIcerik){
        String dosyaYolu = klasorAdi + File.separator + notAdi + ".txt";
        File notDosyasi = new File(dosyaYolu);

        if(!notDosyasi.exists()){
            System.out.println("Hata: '" + notAdi + "' adında bir not bulunmamaktadır.");
            return;
        }

        if(!notDosyasi.isFile()){
            System.out.println("Hata: '" + notAdi + "' bir dosya değil.");
            return;
        }

        try(FileWriter writer = new FileWriter(notDosyasi, true)){  // true parametresi append modu için
            writer.write("\n" + eklenecekIcerik);
            System.out.println("'" + notAdi + "' notuna içerik başarıyla eklendi.");
        }catch (IOException e){
            System.out.println("Nota ekleme yapılırken bir hata oluştu: " + e.getMessage());
        }

    }
    public void notSil(String notAdi){
        String dosyaYolu = klasorAdi + File.separator + notAdi + ".txt";
        File notDosyasi = new File(dosyaYolu);

        if(!notDosyasi.exists()){
            System.out.println("Hata: '" + notAdi + "' adında bir not bulunamadı. Silme işlemi yapılamadı.");
            return;
        }

        if(!notDosyasi.isFile()){
            System.out.println("Hata: '" + notAdi + "' bir dosya değil. Silme işlemi yapılamadı.");
            return;
        }

        if(notDosyasi.delete()){
            System.out.println("'" + notAdi + "' notu başarıyla silindi." );
        }else{
            System.err.println("Hata: '" + notAdi + "' notu silinirken bir sorun oluştu");

        }
    }


}




