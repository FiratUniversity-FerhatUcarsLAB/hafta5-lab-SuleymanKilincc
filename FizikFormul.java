/*
 * Ad Soyad: Suleyman Kilinc
 * Ogrenci No: 250541031
 * Tarih: 13/11/25
 * Aciklama: Gorev 2 - Fizik Formulu Asistani
 *
 * Bu program temel fizik formullerini kullanarak
 * hesaplamalar yapar.
 */

import java.util.Scanner;

/**
 * Bu program, temel fizik formüllerini kullanarak
 * kullanıcıdan alınan bilgilere göre hesaplamalar yapar.
 * Metotlar, değişkenler, Math sınıfı ve printf kullanımı üzerine
 * bir alıştırmadır.
 */
public class FizikFormul {

    // Sabit: Yerçekimi ivmesi (m/s²)
    public static final double GRAVITY = 9.8;

    // --- ZORUNLU METOTLAR ---

    // 1. Hız hesapla (v = s / t)
    public static double calculateVelocity(double distance, double time) {
        return distance / time;
    }

    // 2. İvme hesapla (a = Δv / t)
    public static double calculateAcceleration(double velocityChange, double time) {
        return velocityChange / time;
    }

    // 3. Kuvvet hesapla (F = m * a)
    public static double calculateForce(double mass, double acceleration) {
        return mass * acceleration;
    }

    // 4. İş hesapla (W = F * d)
    public static double calculateWork(double force, double distance) {
        return force * distance;
    }

    // 5. Güç hesapla (P = W / t)
    public static double calculatePower(double work, double time) {
        return work / time;
    }

    // 6. Kinetik enerji (KE = 0.5 * m * v²)
    public static double calculateKineticEnergy(double mass, double velocity) {
        // v² için Math.pow kullanıyoruz
        return 0.5 * mass * Math.pow(velocity, 2);
    }

    // 7. Potansiyel enerji (PE = m * g * h)
    public static double calculatePotentialEnergy(double mass, double gravity, double height) {
        return mass * gravity * height;
    }

    // 8. Momentum (p = m * v)
    public static double calculateMomentum(double mass, double velocity) {
        return mass * velocity;
    }

    // --- ANA PROGRAM (main metodu) ---

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== FIZIK FORMUL ASISTANI ===");
        System.out.println();

        // --- GİRDİ ALMA ---
        System.out.println("TEMEL OLCUMLER:");
        System.out.print("Kutle (kg): ");
        double kutle = scanner.nextDouble();

        System.out.print("Mesafe (m): ");
        double mesafe = scanner.nextDouble();

        System.out.print("Zaman (s): ");
        double zaman = scanner.nextDouble();

        System.out.print("Hiz degisimi (m/s): ");
        double hizDegisimi = scanner.nextDouble();

        System.out.print("Yukseklik (m): ");
        double yukseklik = scanner.nextDouble();
        System.out.println();

        // --- HESAPLAMA (Metotları çağırma) ---
        // Bazı hesaplamalar, diğer hesaplamaların sonucunu kullanır.

        // 1. Hız ve İvme (Temel girdilerle hesaplanabilir)
        double hiz = calculateVelocity(mesafe, zaman);
        double ivme = calculateAcceleration(hizDegisimi, zaman);

        // 2. Kuvvet (İvme'ye ihtiyaç duyar)
        double kuvvet = calculateForce(kutle, ivme);

        // 3. İş (Kuvvet'e ihtiyaç duyar)
        double is = calculateWork(kuvvet, mesafe);

        // 4. Güç (İş'e ihtiyaç duyar)
        double guc = calculatePower(is, zaman);

        // 5. Enerjiler (Hız'a ihtiyaç duyar)
        double kinetikEnerji = calculateKineticEnergy(kutle, hiz);
        double potansiyelEnerji = calculatePotentialEnergy(kutle, GRAVITY, yukseklik);
        double toplamEnerji = kinetikEnerji + potansiyelEnerji; 

        // 6. Momentum (Hız'a ihtiyaç duyar)
        double momentum = calculateMomentum(kutle, hiz);


        // --- SONUÇLARI YAZDIRMA (printf ile) ---
        
        System.out.println("========================================");
        System.out.println("        HESAPLAMA SONUCLARI");
        System.out.println("========================================");
        System.out.println();

        // %-25s -> 25 karakterlik alana sola yaslı String
        // %.2f   -> 2 ondalık basamaklı double
        // \n     -> Yeni satır

        // HIZ ve HAREKET
        System.out.println("HIZ ve HAREKET:");
        System.out.printf("  %-25s : %.2f m/s\n", "Hiz (v = s/t)", hiz);
        System.out.printf("  %-25s : %.2f m/s²\n", "Ivme (a = Δv/t)", ivme);
        System.out.println();

        // KUVVET ve IS
        System.out.println("KUVVET ve IS:");
        System.out.printf("  %-25s : %.2f N\n", "Kuvvet (F = m*a)", kuvvet);
        System.out.printf("  %-25s : %.2f J\n", "Is (W = F*d)", is);
        System.out.printf("  %-25s : %.2f W\n", "Guc (P = W/t)", guc);
        System.out.println();

        // ENERJI
        System.out.println("ENERJI:");
        System.out.printf("  %-25s : %.2f J\n", "Kinetik Enerji (KE)", kinetikEnerji);
        System.out.printf("  %-25s : %.2f J\n", "Potansiyel Enerji (PE)", potansiyelEnerji);
        System.out.printf("  %-25s : %.2f J\n", "Toplam Enerji", toplamEnerji);
        System.out.println();

        // MOMENTUM
        System.out.println("MOMENTUM:");
        System.out.printf("  %-25s : %.2f kg·m/s\n", "Momentum (p = m*v)", momentum);
        System.out.println();

        System.out.println("========================================");

        scanner.close();
    }
}