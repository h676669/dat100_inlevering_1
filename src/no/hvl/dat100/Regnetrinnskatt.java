package no.hvl.dat100;
import static javax.swing.JOptionPane.*;
import java.text.DecimalFormat;

public class Regnetrinnskatt {

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        String skirveinntekt = showInputDialog("Hva er inntekten din?: ");
        double finneinntekt = Double.parseDouble(skirveinntekt);

        /*
            Definerer kr grensen for alle trinnene og trinnene sin individuel skatteprosent.
            Trinn med nummer på slutten er grensen i kr for skatte trinnet, tall med 'pr' på slutten er prosenten det trinner har.
            De med 'etter' i begynnelsen er den delen mellom trinnene som blir skattet:
                eks.trinn1 198350 - 279 149. her er totale kr i trinnet som blir skattet 80 799kr. 
                Dette blir brukt til å beregne hvor mye skatt som kommer fra tidligere trinn hvis beløppet er høyere enn f.eks trinn 1
        */  
        double trinn0 = 198350;
        double trinn0pr = 0.017;
        double trinn1 = 279149;
        double trinn1pr = 0.04;
        double trinn2 = 642949;
        double trinn2pr = 0.135;
        double trinn3 = 926799;
        double trinn3pr = 0.165;
        double trinn4 = 1499999;
        double trinn4pr = 0.175;
        
        double ettertrinn1 = trinn1-trinn0;
        double ettertrinn2 = trinn2-trinn1;
        double ettertrinn3 = trinn3-trinn2;
        double ettertrinn4 = trinn4-trinn3;

        //tomme variabler for utrekning 
        double regneutskatt = 0;
        double etterskatt = 0;

        //sjekker om inntekten er høy nok for trinn skatt
        if(finneinntekt <= trinn0 && finneinntekt >= 0){
            showMessageDialog(null,"Du har ingen trinn skatt :)");
        }

        //sjekker for beløp opptil trinn 1
        if(finneinntekt <= trinn1 && finneinntekt >= trinn0){
            regneutskatt = finneinntekt - trinn0;
            etterskatt = regneutskatt *trinn0pr;
            showMessageDialog(null,"Du har trinn 1 skatt med trinnskatt på 1,7% og skatter: " + df.format(etterskatt)  +"kr ekstra");
        }

        //sjekker for beløp opptil trinn 2
        if(finneinntekt <= trinn2 && finneinntekt >= trinn1+1){
            regneutskatt = ettertrinn1 *trinn0pr;
            etterskatt = finneinntekt - trinn1;
            regneutskatt = regneutskatt + etterskatt*trinn1pr;
            showMessageDialog(null,"Du har trinn 2 skatt med trinnskatt på 4,0% og skatter: " + df.format(regneutskatt) +"kr ekstra");
        }   
 
        //sjekker for beløp opptil trinn 3
        if(finneinntekt <= trinn3 && finneinntekt >= trinn2+1){
            regneutskatt = ettertrinn1 *trinn0pr;
            regneutskatt += ettertrinn2*trinn1pr;
            etterskatt = finneinntekt - trinn2;
            etterskatt = etterskatt * trinn2pr;
            regneutskatt = regneutskatt + etterskatt;
            showMessageDialog(null,"Du har trinn 3 skatt med trinnskatt på 13,4% og skatter: " + df.format(regneutskatt) +"kr ekstra");

        }

        //sjekker for beløp opptil trinn 4
        if(finneinntekt <= trinn4 && finneinntekt >= trinn3+1){
            regneutskatt = ettertrinn1 *trinn0pr;
            regneutskatt += ettertrinn2*trinn1pr;
            regneutskatt += ettertrinn3*trinn2pr;
            etterskatt = finneinntekt - trinn3;
            etterskatt = etterskatt*trinn3pr;
            regneutskatt = regneutskatt + etterskatt;
            showMessageDialog(null,"Du har trinn 4 skatt med trinnskatt på 16,4% og skatter: " + df.format(regneutskatt) +"kr ekstra");

        }

        //sjekker for beløp opptil trinn 5
        if(finneinntekt >= trinn4+1){
            regneutskatt = ettertrinn1 *trinn0pr;
            regneutskatt += ettertrinn2*trinn1pr;
            regneutskatt += ettertrinn3*trinn2pr;
            regneutskatt += ettertrinn4*trinn3pr;
            etterskatt = finneinntekt - trinn4;
            etterskatt = etterskatt*trinn4pr;
            regneutskatt = regneutskatt + etterskatt;
            showMessageDialog(null,"Du har trinn 5 skatt med trinnskatt på 17,4% og skatter: " + df.format(regneutskatt) +"kr ekstra");
        }
    }
}
