public class Main {
    public static void main(String[] args) {
        System.out.println(rgb(0, 0, 0)); //"000000"
        System.out.println(rgb(1, 2, 3)); //"000000"
        System.out.println(rgb(-20, 275, 125)); //00FF7D
    }


//    The rgb function is incomplete. Complete it so that passing in RGB decimal values
//    will result in a hexadecimal representation being returned.
//    Valid decimal values for RGB are 0 - 255.
//    Any values that fall out of that range must be rounded to the closest valid value.
//    Note: Your answer should always be 6 characters long, the shorthand with 3 will not work here.
    public static String rgb(int r, int g, int b) {
        return String.format("%02X%02X%02X", verify(r), verify(g), verify(b));
    }

    private static int verify(int i) {
        return i > 0 ? Math.min(255, i) : 0;
    }
    public static String rgbMy(int r, int g, int b) {
        StringBuilder sb = new StringBuilder();
        if (r<=0) sb.append("00");
        else if (r>=255) sb.append("FF");
        else if (r<16) sb.append("0").append((Integer.toHexString(r)));
        else sb.append((Integer.toHexString(r)));
        if (g<=0) sb.append("00");
        else if (g>=255) sb.append("FF");
        else if (g<16) sb.append("0").append((Integer.toHexString(g)));
        else sb.append((Integer.toHexString(g)));
        if (b<=0) sb.append("00");
        else if (b>=255) sb.append("FF");
        else {if (b<16) sb.append("0").append((Integer.toHexString(b)));
        else sb.append((Integer.toHexString(b)));}
        return sb.toString().toUpperCase();
    }
}