package asym;

import java.math.BigInteger;

public class RSA {

    public static BigInteger[] eea(BigInteger a, BigInteger b) {

        // Abbruchbedingung prüfen
        if( b.compareTo(BigInteger.ZERO) == 0  )
            return new BigInteger[] {a, BigInteger.ONE, BigInteger.ZERO};

        BigInteger[] erg = eea( b, a.mod(b) ); // rekursiver Aufruf mit Wertrückgabe

        BigInteger x_neu = erg[2];
        BigInteger y_neu = erg[1].subtract( erg[2].multiply( a.divide(b) ) );

        return new BigInteger[] {erg[0], x_neu, y_neu};
    }

    public static String decode(String t) {
        String klar = "";
        for(int i=0; i<t.length(); i+=2) {
            int z = Integer.parseInt( t.substring(i,i+2) );
            klar += (char) (z+64);
        }
        return klar;
    }

    public static String encode(String t) {
        String klar = "";
        t = t.replaceAll(" ", "@");
        for(int i=0; i<t.length(); i++) {
            int c = t.charAt(i) - 64;
            klar += (c<10) ? "0" + c : c;
        }
        return klar;
    }

    public static void main(String[] argv) {
        BigInteger N = new BigInteger("114381625757888867669235779976146612010218296721242362562561842935706935245733897830597123563958705058989075147599290026879543541");
        BigInteger d = new BigInteger("9007");
        BigInteger s = new BigInteger("16717861150380844246015271389168398245436901032358311217835038446929062655448792237114490509578608655662496577974840004057020373");

        BigInteger c = new BigInteger("96869613754622061477140922254355882905759991124574319874695120930816298225145708356931476622883989628013391990551829945157815154");
        BigInteger p = new BigInteger("3490529510847650949147849619903898133417764638493387843990820577");
        BigInteger q = new BigInteger("32769132993266709549961988190834461413177642967992942539798288533");

        BigInteger p_BLA = new BigInteger("25127825078328010047858673225105821183683787500171");
        BigInteger q_BLA = new BigInteger("81471526334370314847858985788295421293301427867791");
        BigInteger pq_BLA = p_BLA.subtract(BigInteger.ONE).multiply(q_BLA.subtract(BigInteger.ONE));

        BigInteger N_BLA = p_BLA.multiply(q_BLA);
        //System.out.println( N_BLA );
        // 2047202262594451290024842740659253909772090317054429932617937352778956460625925678366054682577892261

        BigInteger d_BLA = new BigInteger("12334233456546767586781");
        System.out.println( pq_BLA.gcd(d_BLA) );

        BigInteger e_BLA = d_BLA.modInverse(pq_BLA);
        //System.out.println("e_BLA " + e_BLA);

        BigInteger e = d.modInverse( p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE)) );
        // e = 813001176067171165299508431326933359792114930880721498661657899958541924170440132685395937632580221

        String nachricht = "RIVEST SHAMIR ADLEMAN";
        //System.out.println( "Hashwert: " + nachricht.hashCode() );

        // #########################################

        BigInteger N_Simon = new BigInteger("385053815546974478192386611998962320146977805118279390653441");
        BigInteger d_Simon = new BigInteger("-43581806880563841328782962116910456534454611324697761304875");

        BigInteger N_Flo = new BigInteger("6710320879940273693186866373198020940980084800378281191621062189554257109834407893448414383997094254889133483515066703971686801749139880899615293104948582107433135794314719574222160343443931062116301");
        BigInteger d_Flo = new BigInteger("37465627834572364586478676189037589734959768978773402895789");

        BigInteger N_Tom = new BigInteger("162259276829213363878355840775767090174734030864381");
        BigInteger d_Tom = new BigInteger("43587643672966595090471477829564697362204937705351");

        // #########################################

        BigInteger message = new BigInteger( encode("RIVEST SHAMIR ADLEMAN") );

        System.out.println(new BigInteger( nachricht.hashCode() + "" ));
        BigInteger signatur = new BigInteger( nachricht.hashCode() + "" ).modPow(e_BLA, N_BLA);
        //BigInteger signatur = new BigInteger( "12345678").modPow(e_BLA, N_BLA);
        System.out.println("Signatur: " + signatur);

        BigInteger signatur_decrypt = signatur.modPow(d_BLA, N_BLA);
        System.out.println("Signatur decrypt: " + signatur_decrypt);

        BigInteger encryptedMessage = message.modPow(d_Simon, N_Simon);
        System.out.println("Verschlüsselte Nachricht: " + encryptedMessage );

        String s_klar = "" + s.modPow(d,N);
        String c_klar = "" + c.modPow(e,N);

        if(s_klar.length()%2==1) s_klar = "0" + s_klar;
        if(c_klar.length()%2==1) c_klar = "0" + c_klar;

        //System.out.println( decode(s_klar) );
        //System.out.println( decode(c_klar) );

        BigInteger N_Marisa = new BigInteger("4083910520453");
        BigInteger d_Marisa = new BigInteger("43171348903");
        BigInteger e_Marisa = new BigInteger("1816495230487");

        BigInteger p_Marisa = new BigInteger("49549393");
        BigInteger q_Marisa = new BigInteger("82421");
        System.out.println("N_Marisa: " + p_Marisa.multiply(q_Marisa));

        BigInteger pq_Marisa = p_Marisa.subtract(BigInteger.ONE).multiply(q_Marisa.subtract(BigInteger.ONE));

        System.out.println(d_Marisa.multiply(e_Marisa).mod(pq_Marisa));

        String n2 = "MOIN";
        System.out.println("Nachricht: " + encode(n2));

        BigInteger encoded = new BigInteger( encode(n2) );
        System.out.println("encoded: " + encoded);   // 13150914

        BigInteger crypted = encoded.modPow(e_Marisa, N_Marisa);
        System.out.println("encoded+crypted: " + crypted);  // 2424500699904

        BigInteger decrypted = crypted.modPow(d_Marisa, N_Marisa);
        System.out.println("decrypted: " + decrypted); // 2990249987904
    }
}