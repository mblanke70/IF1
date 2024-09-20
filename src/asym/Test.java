package asym;

public class Test {

    public static void main(String[] args) {

        String s = "TREFFENUMMITTERNACHT";

        // Code:      01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
        // Buchstabe: A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z

        // Bob wählt Primzahl: z.B. N = 8623
        // und bestimmt d und e so, dass (d * e) % N = 1 gilt
        // z.B. d=498, e=3515

        int N = 97301;       // öffentliche Modulzahl
        int d = 5784;        // öffentlicher Schlüssel

        // "naiver" Ansatz zur Bestimmung des modular inversen Schlüssels
        int i=1; while(i<N && i*d%N!=1) { i++; }
        System.out.println("e = " + i);

        int e = 3515;       // privater Schlüssel, !!!GEHEIM!!!

        //System.out.println( (d * e) % N );   // Schlüsselbedingung-Check

        // Alice verschlüsselt Klartext und sendet den resultierenden Geheimtext an Bob

        // Codierung in 2er-Gruppen
        // T R  E F  F E  N U  M M  I T  T E  R N  A C  H T
        // 2018 0506 0605 1421 1313 0920 2005 1814 0103 0820

        int g = (2018 * d) % N;     // verschlüsseln der ersten beiden Buchstaben mit d
        System.out.println("Geheimtext: " + g); // Ausgabe: 4696

        // Bob entschlüsselt den Geheimtext 4696 für die ersten beiden Buchstaben
        int k = (4696 * e) % N;     // entschlüsseln mit e
        System.out.println("Entschlüsselter Geheimtext " + k);  // Ausgabe: 2018


    }
}
