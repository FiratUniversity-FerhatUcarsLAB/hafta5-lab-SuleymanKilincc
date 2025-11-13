/*
 * Ad Soyad: Suleyman Kilinc
 * Ogrenci No: 250541031
 * Tarih: 13/11/25
 * Aciklama: Gorev 3 - E-Ticaret Sepet Hesaplayici
 *
 * Bu program 3 adet urunun sepet tutarini
 * KDV, indirim ve kargo dahil hesaplar.
 */

/*
 * Ad Soyad: [ADINIZ SOYADINIZ]
 * Ogrenci No: [NUMARA]
 * Tarih: [TARIH]
 * Aciklama: E-Ticaret Sepet Hesaplayıcı Görevi
 */

import java.util.Scanner;

/**
 * Bu program, 3 adet ürünün fiyat ve adet bilgisine göre
 * indirim, KDV ve kargo ücreti dahil edilerek
 * toplam sepet tutarını hesaplar.
 */
public class SepetHesap {

    // --- SABİTLER ---
    // KDV Oranı (%18)
    public static final double VAT_RATE = 0.18;
    // Sabit kargo ücreti (TL)
    public static final double SHIPPING_FEE = 29.99;

    // --- ZORUNLU METOTLAR ---

    /**
     * 1. Bir ürünün toplam fiyatını hesaplar (fiyat * adet).
     */
    public static double calculateLineTotal(double price, int quantity) {
        return price * quantity;
    }

    /**
     * 2. Sepetteki 3 ürünün ara toplamını hesaplar.
     */
    public static double calculateSubtotal(double line1, double line2, double line3) {
        return line1 + line2 + line3;
    }

    /**
     * 3. İndirim tutarını hesaplar (araToplam * (indirimYuzdesi / 100)).
     */
    public static double calculateDiscountAmount(double subtotal, double discountPercentage) {
        return subtotal * (discountPercentage / 100.0);
    }

    /**
     * 4. İndirimli fiyatı hesaplar (araToplam - indirimTutari).
     */
    public static double applyDiscount(double subtotal, double discountAmount) {
        return subtotal - discountAmount;
    }

    /**
     * 5. KDV tutarını hesaplar (indirimliTutar * kdvOrani).
     */
    public static double calculateVAT(double discountedTotal, double vatRate) {
        return discountedTotal * vatRate;
    }

    /**
     * 6. Genel toplamı hesaplar (indirimliTutar + kdv + kargo).
     */
    public static double calculateGrandTotal(double discountedTotal, double vatAmount, double shippingFee) {
        return discountedTotal + vatAmount + shippingFee;
    }

    // --- ANA PROGRAM (main metodu) ---
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== E-TICARET SEPET HESAPLAYICI ===");
        System.out.println();
        System.out.println("Lutfen 3 urunun bilgilerini girin:");
        System.out.println();

        // --- GİRDİ ALMA ---

        // ÜRÜN 1
        System.out.println("URUN 1:");
        System.out.print("  Birim Fiyat (TL): ");
        double fiyat1 = scanner.nextDouble();
        System.out.print("  Adet: ");
        int adet1 = scanner.nextInt();
        System.out.println();

        // ÜRÜN 2
        System.out.println("URUN 2:");
        System.out.print("  Birim Fiyat (TL): ");
        double fiyat2 = scanner.nextDouble();
        System.out.print("  Adet: ");
        int adet2 = scanner.nextInt();
        System.out.println();

        // ÜRÜN 3
        System.out.println("URUN 3:");
        System.out.print("  Birim Fiyat (TL): ");
        double fiyat3 = scanner.nextDouble();
        System.out.print("  Adet: ");
        int adet3 = scanner.nextInt();
        System.out.println();

        // İNDİRİM
        System.out.print("Indirim Kuponu Yuzdesi (%): ");
        double indirimYuzdesi = scanner.nextDouble();
        System.out.println();

        // --- HESAPLAMA (Metotları çağırma) ---

        // 1. Satır toplamları
        double satirToplam1 = calculateLineTotal(fiyat1, adet1);
        double satirToplam2 = calculateLineTotal(fiyat2, adet2);
        double satirToplam3 = calculateLineTotal(fiyat3, adet3);

        // 2. Ara toplam
        double araToplam = calculateSubtotal(satirToplam1, satirToplam2, satirToplam3);

        // 3. İndirim
        double indirimTutari = calculateDiscountAmount(araToplam, indirimYuzdesi);
        double indirimliToplam = applyDiscount(araToplam, indirimTutari);

        // 4. KDV (Sabit VAT_RATE kullanılır)
        double kdvTutari = calculateVAT(indirimliToplam, VAT_RATE);

        // 5. Genel Toplam (Sabit SHIPPING_FEE kullanılır)
        double genelToplam = calculateGrandTotal(indirimliToplam, kdvTutari, SHIPPING_FEE);


        // --- SONUÇLARI YAZDIRMA (printf ile) ---
        
        System.out.println("========================================");
        System.out.println("           SIPARIS OZETI");
        System.out.println("========================================");
        System.out.println();

        // Ürün Detayları
        System.out.printf("Urun 1 Toplam (%.2f TL x %d): %.2f TL\n", fiyat1, adet1, satirToplam1);
        System.out.printf("Urun 2 Toplam (%.2f TL x %d) : %.2f TL\n", fiyat2, adet2, satirToplam2);
        System.out.printf("Urun 3 Toplam (%.2f TL x %d): %.2f TL\n", fiyat3, adet3, satirToplam3);
        System.out.println("----------------------------------------");
        
        // Ara Toplam
        System.out.printf("%-28s : %.2f TL\n", "Ara Toplam", araToplam);
        System.out.println();

        // İndirim
        System.out.printf("%-28s : -%.2f TL\n", 
            String.format("Indirim Tutari (%%%.0f)", indirimYuzdesi), indirimTutari);
            
        System.out.printf("%-28s : %.2f TL\n", "Indirimli Toplam", indirimliToplam);
        System.out.println();

        // Vergiler ve Ücretler
        System.out.printf("%-28s : +%.2f TL\n", 
            String.format("KDV Tutari (%%%.0f)", VAT_RATE * 100), kdvTutari);
            
        System.out.printf("%-28s : +%.2f TL\n", "Kargo Ucreti", SHIPPING_FEE);
        System.out.println("----------------------------------------");

        // Genel Toplam
        System.out.printf("%-28s : %.2f TL\n", "GENEL TOPLAM", genelToplam);
        System.out.println("========================================");

        scanner.close();
    }
}
