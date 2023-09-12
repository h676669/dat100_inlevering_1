package no.hvl.dat100;
import static javax.swing.JOptionPane.*;

public class Regnekarakter  {
	public static void main(String[] args) {

		String karakter = null;

		for(int i = 0;i<=1;i++){
			String poengsum = showInputDialog("Skriv inn poengsum");
			int finnepoeng = Integer.parseInt(poengsum);

			if(finnepoeng >=90 && finnepoeng <= 100){
			karakter = "A";
			showMessageDialog(null,"Elven har fått karakteren: "+karakter);
			}
			else if(finnepoeng >=80 && finnepoeng <= 89){
				karakter = "b";
				showMessageDialog(null,"Elven har fått karakteren: "+karakter);
			}
			else if(finnepoeng >=60 && finnepoeng <= 79){
				karakter = "c";
				showMessageDialog(null,"Elven har fått karakteren: "+karakter);
			}
			else if(finnepoeng >=50 && finnepoeng <= 59){
				karakter = "d";
				showMessageDialog(null,"Elven har fått karakteren: "+karakter);
			}
			else if(finnepoeng >=40 && finnepoeng <= 49){
				karakter = "e";
				showMessageDialog(null,"Elven har fått karakteren: "+karakter);
			}
			else if(finnepoeng >=0 && finnepoeng <= 39){
				karakter = "f";
				showMessageDialog(null,"Elven har fått karakteren: "+karakter);
			}
			else if(finnepoeng < 0 || finnepoeng >100){
				showMessageDialog(null,"Skrevet inn en ulovlig verdi");
				i = i -1;
				showMessageDialog(null,"Skriv inn poengsum på nytt");

			}
		}

		
	}
}
