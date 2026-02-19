import java.util.Scanner;

public class App01_DataTypes {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Input number: ");
        String angkaString = input.next();

        String[] tipeVariabel = new String[4];
        byte n = 4;

        try{
            long angka = Long.parseLong(angkaString);

            if(angka >= Long.MIN_VALUE && angka <= Long.MAX_VALUE){
                tipeVariabel[3] = "Long"; n--;
                if(angka >= Integer.MIN_VALUE && angka <= Integer.MAX_VALUE){
                    tipeVariabel[2] = "Integer"; n--;
                    if(angka >= Short.MIN_VALUE && angka <= Short.MAX_VALUE){
                        tipeVariabel[1] = "Short"; n--;
                        if(angka >= Byte.MIN_VALUE && angka <= Byte.MAX_VALUE){
                            tipeVariabel[0] = "Byte"; n--;
                        }
                    }
                }

                System.out.println("\n" + angka + " Can be fitten in:");
                for(byte i = (byte) (0 + n); i < 4; i++){
                    System.out.println("- " + tipeVariabel[i]);
                }
            }
        } catch (NumberFormatException e){
            System.out.println(angkaString + " can't be fitted anywhere!");
        }

        input.close();
    }
}