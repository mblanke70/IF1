package vigenere;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Vigenere {

    double[] relHEnglisch = {8.167, 1.492, 2.782, 4.253, 12.702, 2.228, 2.015, 6.094, 6.966, 0.153, 0.772, 4.025, 2.406, 6.749, 7.507, 1.929, 0.095, 5.987, 6.327, 9.056, 2.758, 0.978, 2.360, 0.150, 1.974, 0.074};

    public static String encode(String klar, String schlüsselwort) {
        String geheim = "";

        int j = 0;

        for (int i = 0; i < klar.length(); i++) {
            char c = klar.charAt(i);

            int schlüssel = schlüsselwort.charAt(j) - 65;
            geheim += (char)((c - 65 + schlüssel) % 26 + 65);

            j = (j + 1) % schlüsselwort.length();
        }

        return geheim;
    }

    public static String decode(String geheim, String key) {
        return "";
    }

    public static void main(String[] argv) {
        System.out.println( encode("DERKLARTEXTWIRDZUMGEHEIMTEXT","PLUTO") ); // SPLDZPCNXLIHCKROFGZSWPCFHTIN
        System.out.println( encode("DERKLARTEXTWERDEGEHEIMTEXT","PLUTO") ); // SPLDZPCNXLIHYKRTRYASXXNXLI

        String g1 = "PWTMYTBADKDGPWPFYWFGUESOTLUPNVYWAPKCSOOJWWASTLSUZUSJMJBBRSTIMGPYSXOJWWASMMZQLCHJQWGYDHKOJWWASTMFPADWIPVKLHONZWPDPWRAAGQPRKNJCNPKGPJJLTHYOWOHPGYJWCUEKUZLGAOWKHOGPESMZMRWPBKVFVZTQNLAGSFSMVWTDPWRAAGQPRKNJCNPTGTKEOMSGVLYVCHKBVKLOFOBLGNCIVXWPLYBZAAEOOWKEWEODZKZOGPWGOMSWMPWTIFFLCTUTYGUOSLZSILYOHEWEODSRVVYHSFAVVHHWGIPTGHYHCWJVLERGJWKPDHGJWTUTQNBXGZEUKTWIAZPPMOGPWGJQWGYDHKNJCNPSOVWTZPFOMNQUQFGOWPYTQNBAIVOSXNSNZNVHMSPAHCXBWVDTFJRWFLASXAGPHYHCWJVLEOANWKUPTXIYGUFFSQLLHZRKZFGPYTXIYGUOWKVAEOEAOBBCVOSXVWKUMSGVLYVCHKBOGYOSTSGGUYSTAAPKYWIPLBBRSRIKULYJUVWKUPFHMDKLMWMMFRLCGUVKQSWAGVVWYNVLZSILYROMKKJSBAZSWMOWKHMILSCKZAIRPWZHMGPYSXLWTNCIVXWPIPNOMZGUSSXIMUIPYUUEGUKICMDEOPFMZMRWPGOMYGOZSXBOKLGWKTWHYLUKVEWZDAGVEKUOSYBWPZDHKTDGUFBJEWNJSSLZSILYYUMFPAPAGVKVLWZKV";
        String g2 = "KQOWEFVJPUJUUNUKGLMEKJINMWUXFQMKJBGWRLFNFGHUDWUUMBSVLPSNCMUEKQCTESWREEKOYSSIWCTUAXYOTAPXPLWPNTCGOJBGFQHTDWXIZAYGFFNSXCSEYNCTSSPNTUJNYTGGWZGRWUUNEJUUQEAPYMEKQHUIDUXFPGUYTSMTFFSHNUOCZGMRUWEYTRGKMEEDCTVRECFBDJQCUSWVBPNLGOYLSKMTEFVJJTWWMFMWPNMEMTMHRSPXFSSKFFSTNUOCZGMDOEOYEEKCPJRGPMURSKHFRSEIUEVGOYCWXIZAYGOSAANYDOEOYJLWUNHAMEBFELXYVLWNOJNSIOFRWUCCESWKVIDGMUCGOCRUWGNMAAFFVNSIUDEKQHCEUCPFCMPVSUDGAVEMNYMAMVLFMAOYFNTQCUAFVFJNXKLNEIWCWODCCULWRIFTWGMUSWOVMATNYBUHTCOCWFYTNMGYTQMKBBNLGFBTWOJFTWGNTEJKNEEDCLDHWTVBUVGFBIJGYYIDGMVRDGMPLSWGJLAGOEEKJOFEKNYNOLRIVRWVUHEIWUURWGMUTJCDBNKGMBIDGMEEYGUOTDGGQEUJYOTVGGBRUJYS";

        // Finde Wiederholungen und berechne Abstände
        findeWiederholungen(g2);    // vermutete Schlüsselwortlänge: 7

        int schlüsselwortlänge = 5;

        // bilde Zeichengruppen
        String[] gruppen = bildeZeichengruppen(g2, schlüsselwortlänge);
        System.out.println( Arrays.toString(gruppen) );

        // erstelle Häufigkeitsverteilungen der Zeichengruppen
        for(int l=0; l<schlüsselwortlänge; l++) {
            double[] h = häufigkeiten(gruppen[l]);

            Map<Double, Character> map = new TreeMap<Double, Character>();
            double summe = 0;
            for (int verschiebung = 0; verschiebung < 26; verschiebung++) {
                summe = 0;
                for (int j = 0; j < 26; j++) {
                    summe += Math.abs(h[(j + verschiebung) % 26] - relHFranz[j]);
                }
                map.put(summe, (char) (65+verschiebung));
                //System.out.println(verschiebung + " " + (char) (65 + verschiebung) + " " + summe);
            }
            System.out.println(map);
        }
    }

    private static double[] relHFranz = {7.63, 0.90, 3.26, 3.66, 14.72, 1.07, 0.87, 0.74, 7.53, 0.55, 0.05, 5.45, 2.97, 7.09, 5.38, 3.02, 1.36, 6.55, 7.95, 7.23, 6.31, 1.63, 0.11, 0.39, 0.31, 0.14};

    public static double[] häufigkeiten(String text) {
        double[] h = new double[26];

        // ASCII-Code: A=65, B=66, ...
        for(int i=0; i<text.length(); i++) {
            char c = text.charAt(i);
            h[c-'A']++;
        }

        for(int i=0; i<26; i++) {
            h[i] = h[i] / text.length() * 100;
        }

        return h;
    }

    public static String[] bildeZeichengruppen (String geheim, int anz) {
        String[] gruppen = new String[anz];
        for(int i=0; i<anz; i++) {
            gruppen[i] = "";
        }

        for(int i=0; i<geheim.length(); i++) {
            gruppen[i % anz] += geheim.charAt(i);
        }

        return gruppen;
    }



    private static double[] relHDeutsch = {6.51, 1.89, 3.06, 5.08, 17.4, 1.66, 3.01, 4.76, 7.55, 0.27, 1.21, 3.44, 2.53, 9.78, 2.51, 0.79, 0.02, 7.00, 7.27, 6.15, 4.35, 0.67, 1.89, 0.03, 0.04, 1.13};

    // Math.abs() Maßzahl ist die Summe S = (6.51 - 4.67) + (1.89 - 0) + (3.06 - 7.47) + ...



    public static void findeWiederholungen(String text) {
       //String text = "HOOLAHOOLAGIRLSLIKEHOOLIGANS";

       for(int l=15; l>=3; l--) {
           for (int j = 0; j < text.length()-l+1; j++) {
               String muster = text.substring(j, j+l);
               for (int i = j + l; i < text.length(); i++) {
                   if (text.startsWith(muster, i)) {
                       System.out.println(muster + ":" + j + ":" + i + ":" + (i - j));
                   }
               }
           }
       }
    }

}
