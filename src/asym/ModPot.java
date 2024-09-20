package asym;

public class ModPot {
    public static void main(String[] args) {

        String s = "TREFFENUMMITTERNACHT";

        // Code:      01 02 03 04 05 06 07 08 09 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26
        // Buchstabe: A  B  C  D  E  F  G  H  I  J  K  L  M  N  O  P  Q  R  S  T  U  V  W  X  Y  Z

        // Codierung in 2er-Gruppen
        // T R  E F  F E  N U  M M  I T  T E  R N  A C  H T
        // 2018 0506 0605 1421 1313 0920 2005 1814 0103 0820

        // Wähle Primzahl: N = 8623
        // Bestimme d und e so, dass (d * e) MOD N = 1 gilt
        // z.B. d=498, e=3515, N=8623

        // Bob legt fest:
        int N = 8623;       // öffentliche Modulzahl
        int d = 498;        // öffentlicher Schlüssel
        int e = 3515;       // privater Schlüssel

        System.out.println( (d*e) % N );   // Check

        // Alice nutzt d und N und übermittelt an Bob 4696 als Geheimtext für die ersten beiden Buchstaben
        System.out.println( (2018*498) % 8623 );

        // Bob entschlüsselt den Geheimtext von Alice mit seinem privaten Schlüssel e und erhält den Klartext 2018 (=TR)
        System.out.println( (4696*3515) % 8623 );

        // VERSCHLÜSSELN MIT ÖFFENTLICHEM SCHLÜSSEL
        String geheim = "";
        for(int i=0; i<s.length(); i+=2) {
            int x1 = s.charAt(i  ) - 64; String X1 = (x1<10) ? "0" + x1 : "" + x1;
            int x2 = s.charAt(i+1) - 64; String X2 = (x2<10) ? "0" + x2 : "" + x2;

            int x = Integer.parseInt(X1+X2);

            int g = (x*d) % N;  // Modulare Multiplikation als Verschlüsselungsverfahren

            geheim += (g<1000 ? "0" : "") + g;
        }

        System.out.println(geheim + " : " + geheim.length());     // Geheimtext: 4696 1921 8108 0572 7149 1141 6845 6580 8179 3079

        // ENTSCHLÜSSELN MIT PRIVATEM SCHLÜSSEL
        String klar = "";
        for(int i=0; i<geheim.length(); i+=4) {
            int y = Integer.parseInt(geheim.substring(i,i+4));
            int x = (y*e) % N;
            String X = ((x<1000) ? "0" : "") + x ;
            klar += (char) (Integer.parseInt(X.substring(0,2))+64) + " " + (char) (Integer.parseInt(X.substring(2,4))+64) + " ";
        }
        System.out.println(klar);
    }
}