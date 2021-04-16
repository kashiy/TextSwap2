public class Swap {
    final static  int taf = 44;
    final static  int zadi_sofit = 46 ;
    final static  int pe_sofit = 59;
    final static  int dot = 47;

    final static int a = 97;
    final static  int b = 98;
    final static  int c = 99;
    final static  int d = 100;
    final static  int e = 101;
    final static  int f = 102;
    final static  int g = 103;
    final static  int h = 104;
    final static  int i = 105;
    final static  int j = 106;
    final static  int k = 107;
    final static  int l = 108;
    final static  int m = 109;
    final static  int n = 110;
    final static  int o = 111;
    final static  int p = 112;
    final static  int q = 113;
    final static  int r = 114;
    final static  int s = 115;
    final static  int t = 116;
    final static  int u = 117;
    final static  int v = 118;
    final static  int w = 119;
    final static  int x = 120;
    final static  int y = 121;
    final static  int z = 122;


    static String toHeb(String engText){

        StringBuilder newtext = new StringBuilder();
        for(char cha: engText.toCharArray()){
            newtext.append(switcher(cha));
        }
        return newtext.toString();

    }

    private static char switcher(char cha){
        switch ((int) cha) {
            case ((int) ' '):
                cha = ' ';
                break;
            case taf:
                cha = 'ת';
                break;
            case zadi_sofit:
                cha = 'ץ';
                break;
            case pe_sofit:
                cha = 'ף';
                break;
            case dot:
                cha = '.';
                break;


            case a:
                    cha = 'ש';
                break;
            case b:
                    cha = 'נ';
                break;
            case c:
                cha = 'ב';
                break;
            case d:
                cha = 'ג';
                break;
            case e:
                cha = 'ק';
                break;
            case f:
                cha = 'כ';
                break;
            case g:
                cha = 'ע';
                break;
            case h:
                cha = 'י';
                break;
            case i:
                cha = 'ן';
                break;
            case j:
                cha = 'ח';
                break;
            case k:
                cha = 'ל';
                break;
            case l:
                cha = 'ך';
                break;
            case m:
                cha = 'צ';
                break;
            case n:
                cha = 'מ';
                break;
            case o:
                cha = 'ם';
                break;
            case p:
                cha = 'פ';
                break;
            case q:
                cha = '/';
                break;
            case r:
                cha = 'ר';
                break;
            case s:
                cha = 'ד';
                break;
            case t:
                cha = 'א';
                break;
            case u:
                cha = 'ו';
                break;
            case v:
                cha = 'ה';
                break;
            case w:
                cha = '\'';
                break;
            case x:
                cha = 'ס';
                break;
            case y:
                cha = 'ט';
                break;
            case z:
                cha = 'ז';
                break;
        }
        return cha;
    }

}

/*
aleph       128     41    96     224
        bet         129     42    97     225
        gimel       130     43    98     226
        dalet       131     44    99     227
        hey         132     45   100     228
        vav         133     46   101     229
        zayin       134     47   102     230
        het         135     48   103     231
        tet         136     49   104     232
        yud         137     51   105     233
        chaf sofit  138     52   106     234
        chaf        139     53   107     235
        lamed       140     54   108     236
        mem sofit   141     55   109     237
        mem         142     56   110     238
        nun sofit   143     57   111     239
        nun         144     58   112     240
        samech      145     59   113     241
        ayin        146     62   114     242
        pey sofit   147     63   115     243
        pey         148     64   116     244
        zadik sofit 149     65   117     245
        zadik       150     66   118     246
        kuf         151     67   119     247
        reish       152     68   120     248
        shin        153     69   121     249
        tuv         154     71   122     250

 */