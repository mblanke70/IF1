package vigenere;

import java.util.Arrays;

public class Vigenere {

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
        findeWiederholungen(g1);    // vermutete Schlüsselwortlänge: 7

        // bilde Zeichengruppen
        String[] gruppen = bildeZeichengruppen(g1, 7);
        System.out.println( Arrays.toString(gruppen));

        // erstelle Häufigkeitsverteilungen der Zeichengruppen
        double[] h = häufigkeiten( gruppen[0] );
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

    public static double[] häufigkeiten(String text) {
        double[] h = new double[26];

        // ...

        return h;
    }

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
