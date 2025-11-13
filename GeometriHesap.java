/*
 * Ad Soyad: Suleyman Kilinc
 * Ogrenci No: 250541031
 * Tarih: 13/11/25
 * Aciklama: Gorev 1 - Geometrik Sekil Hesaplayici
 * 
 * Bu program temel geometrik sekillerin alan ve
 * cevre hesaplamalarini yapar.
 */

import java.util.Scanner;

/**
 * Bu program, temel geometrik şekillerin alan ve çevrelerini
 * kullanıcıdan alınan bilgilere göre hesaplar.
 * Metotlar, değişkenler, Math sınıfı ve printf kullanımı üzerine
 * bir alıştırmadır.
 */
public class GeometriHesap {

    // --- ZORUNLU METOTLAR ---

    // 1. Kare alanı
    public static double calculateSquareArea(double side) {
        // Alan = kenar * kenar
        return side * side;
        // Alternatif: return Math.pow(side, 2);
    }

    // 2. Kare çevresi
    public static double calculateSquarePerimeter(double side) {
        // Çevre = 4 * kenar
        return 4 * side;
    }

    // 3. Dikdörtgen alanı
    public static double calculateRectangleArea(double width, double height) {
        // Alan = genişlik * yükseklik
        return width * height;
    }

    // 4. Dikdörtgen çevresi
    public static double calculateRectanglePerimeter(double width, double height) {
        // Çevre = 2 * (genişlik + yükseklik)
        return 2 * (width + height);
    }

    // 5. Daire alanı
    public static double calculateCircleArea(double radius) {
        // Alan = π * r²
        return Math.PI * Math.pow(radius, 2);
    }

    // 6. Daire çevresi
    public static double calculateCircleCircumference(double radius) {
        // Çevre = 2 * π * r
        return 2 * Math.PI * radius;
    }

    // 7. Üçgen alanı (taban ve yükseklik ile)
    public static double calculateTriangleArea(double base, double height) {
        // Alan = (taban * yükseklik) / 2
        return (base * height) / 2.0;
    }

    // 8. Üçgen çevresi
    public static double calculateTrianglePerimeter(double a, double b, double c) {
        // Çevre = a + b + c
        return a + b + c;
    }

    // --- ANA PROGRAM (main metodu) ---
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== GEOMETRIK SEKIL HESAPLAYICI ===");
        System.out.println();

        // --- GİRDİ ALMA ---

        // KARE
        System.out.println("KARE:");
        System.out.print("Kenar uzunlugu (cm): ");
        double kareKenar = scanner.nextDouble();
        System.out.println();

        // DİKDÖRTGEN
        System.out.println("DIKDORTGEN:");
        System.out.print("Kisa kenar (cm): ");
        double dikKisa = scanner.nextDouble();
        System.out.print("Uzun kenar (cm): ");
        double dikUzun = scanner.nextDouble();
        System.out.println();

        // DAİRE
        System.out.println("DAIRE:");
        System.out.print("Yaricap (cm): ");
        double daireYaricap = scanner.nextDouble();
        System.out.println();

        // ÜÇGEN
        System.out.println("UCGEN:");
        System.out.print("Taban (cm): ");
        double ucgenTaban = scanner.nextDouble();
        System.out.print("Yukseklik (cm): ");
        double ucgenYukseklik = scanner.nextDouble();
        System.out.print("1. kenar (cm): ");
        double ucgenKenarA = scanner.nextDouble();
        System.out.print("2. kenar (cm): ");
        double ucgenKenarB = scanner.nextDouble();
        System.out.print("3. kenar (cm): ");
        double ucgenKenarC = scanner.nextDouble();
        System.out.println();

        // --- HESAPLAMA (Metotları çağırma) ---

        double kareAlan = calculateSquareArea(kareKenar);
        double kareCevre = calculateSquarePerimeter(kareKenar);

        double dikAlan = calculateRectangleArea(dikKisa, dikUzun);
        double dikCevre = calculateRectanglePerimeter(dikKisa, dikUzun);

        double daireAlan = calculateCircleArea(daireYaricap);
        double daireCevre = calculateCircleCircumference(daireYaricap);

        double ucgenAlan = calculateTriangleArea(ucgenTaban, ucgenYukseklik);
        double ucgenCevre = calculateTrianglePerimeter(ucgenKenarA, ucgenKenarB, ucgenKenarC);

        // --- SONUÇLARI YAZDIRMA (printf ile) ---
        
        System.out.println("========================================");
        System.out.println("        HESAPLAMA SONUCLARI");
        System.out.println("========================================");
        System.out.println();

        // %-10s -> 10 karakterlik alana sola yaslı String
        // %.1f   -> 1 ondalık basamaklı double
        // %.2f   -> 2 ondalık basamaklı double
        // \n     -> Yeni satır

        // Kare Sonuçları
        System.out.printf("KARE (kenar: %.1f cm):\n", kareKenar);
        System.out.printf("  %-10s: %.2f cm²\n", "Alan", kareAlan);
        System.out.printf("  %-10s: %.2f cm\n", "Cevre", kareCevre);
        System.out.println();

        // Dikdörtgen Sonuçları
        System.out.printf("DIKDORTGEN (%.1f x %.1f cm):\n", dikKisa, dikUzun);
        System.out.printf("  %-10s: %.2f cm²\n", "Alan", dikAlan);
        System.out.printf("  %-10s: %.2f cm\n", "Cevre", dikCevre);
        System.out.println();

        // Daire Sonuçları
        System.out.printf("DAIRE (yaricap: %.1f cm):\n", daireYaricap);
        System.out.printf("  %-10s: %.2f cm²\n", "Alan", daireAlan);
        System.out.printf("  %-10s: %.2f cm\n", "Cevre", daireCevre);
        System.out.println();

        // Üçgen Sonuçları
        System.out.printf("UCGEN (taban: %.1f, yukseklik: %.1f cm):\n", ucgenTaban, ucgenYukseklik);
        System.out.printf("  %-10s: %.2f cm²\n", "Alan", ucgenAlan);
        System.out.printf("  %-10s: %.2f cm\n", "Cevre", ucgenCevre);
        System.out.println();
        
        System.out.println("========================================");

        scanner.close();
    }
}