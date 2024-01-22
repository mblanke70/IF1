package vigenere;

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

        findDuplicates3(g2);
    }

    public static String[] schlüsselzeichengruppen (String g, int anz) {
        String[] gruppen = new String[anz];
        // ...
        return gruppen;
    }

    /*
     * public String substring(int beginIndex, int endIndex)
     * Diese Methode liefert den Teilstring des aufrufenden String-Objektes, der bei Index
     * beginIndex beginnt und dessen letztes Zeichen an Index-Position endIndex-1 steht. Der Aufruf
     * substring(10,15) liefert im Beispiel oben die Teilzeichenkette „girls“.
     *
     * public boolean startsWith(String prefix, int toffset)
     * Diese Methode prüft, ob das aufrufende String-Objekt von der Index-Position toffset an mit
     * dem Muster-String prefix übereinstimmt. Falls dies der Fall ist, wird true zurückgegeben. Das
     * Ergebnis ist auch falsch, wenn toffset negativ oder größer als die Länge des aufrufenden String-Objektes ist.
     * Der Aufruf startsWith("girls", 10) an obigem String-Objekt liefert demnach true.
     */

    // A1: Formulieren Sie eine Schleife, die das gegebene String-Objekt nach der 3-elementigen Zeichenfolge
    //„hoo“ durchsucht und ggf. Abstände zu Duplikaten auf der Konsole ausgibt.
    public static void findDuplicates1() {
        String text = "HOOLAHOOLAGIRLSLIKEHOOLIGANS";
        for(int i=0; i<text.length(); i++) {
            if( text.startsWith("HOO", i) ) {
                System.out.println("HOO" + " " + i);
            }
        }
    }

    // A2: Schachteln Sie eine weitere Schleife um die erste Schleife. Diese Schleife soll nach allen
    // vorkommenden 3-elementigen Zeichenfolge suchen. Also im zweiten Durchlauf nach „ool“, im
    // dritten nach „ola“, usw. Hier gilt es, den Wertebereich für die Laufvariable der Schleife sinnvoll
    // festzulegen und den Initialisierungsausdruck der inneren Schleife anzupassen.
    public static void findDuplicates2() {
        String text = "HOOLAHOOLAGIRLSLIKEHOOLIGANS";
        for(int j=0; j<text.length()-2; j++) {
            String muster = text.substring(j, j+3);
            for (int i=j+3; i < text.length(); i++) {
                if (text.startsWith(muster, i)) {
                    System.out.println(muster + ":" + j + ":" + i + ":" + (i-j) );
                }
            }
        }
    }

    // A3: Und noch eine äußere Schleife! Diesmal um die Länge der Zeichenfolge, nach der gesucht wird, zu
    // variieren. Angefangen von 3 soll die Länge bis zu einer geeigneten Grenze hochgezählt werden. Die
    // Laufvariable dieser äußersten Schleife beeinflusst beide innere Schleifen..
    public static void findDuplicates3(String text) {
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
