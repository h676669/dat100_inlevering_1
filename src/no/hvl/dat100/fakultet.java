package no.hvl.dat100;
import static javax.swing.JOptionPane.*;

public class fakultet {
    public static void main(String[] args) {
        //Lag et program som leser inn et heltall n > 0, beregner verdien n! (n fakultet) og skriver verdien til n! ut på skjermen, der n! = 1*2*3* … *(n-1)*n
        String henteN = showInputDialog("hvilket tall vil du vite fakultetet av?: ");
        int N = Integer.parseInt(henteN);
        int fakultettall = N; 

        if(N>0){
            for(int i = N-1;i > 1; i--){
                fakultettall = fakultettall*i;
            }
            showMessageDialog(null,"Fakultetet av "+N+" er "+fakultettall);
        }
        else{
            showMessageDialog(null,"du må skrive et heltall over null");
        }
    }
}
