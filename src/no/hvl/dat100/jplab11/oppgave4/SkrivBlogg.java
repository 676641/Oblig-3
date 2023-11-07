package no.hvl.dat100.jplab11.oppgave4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {
		/* 
		try {
			PrintWriter skriver = new PrintWriter(filnavn);
			for (int i = 0;i<samling.getAntall();i++) {
				skriver.write(samling.getSamling()[i].toString());
			}
			skriver.close();
			return true;
		} catch (FileNotFoundException e){
			return false;
		}
		*/
		boolean funker = false;
		try {
			File fil = new File(filnavn);
			PrintWriter skriver = new PrintWriter(fil);
			funker = true;
			for (int i = 0;i<samling.getAntall();i++) {
				skriver.write(samling.getSamling()[i].toString());
			}
			skriver.write("funker!");
			skriver.close();
		} catch (FileNotFoundException e) {
		}
		return funker;
	}
}
