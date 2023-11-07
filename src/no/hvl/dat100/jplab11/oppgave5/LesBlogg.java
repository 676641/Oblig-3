package no.hvl.dat100.jplab11.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.*;
import no.hvl.dat100.jplab11.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {
		Blogg blogg = new Blogg();
		try {
			File fil = new File(mappe, filnavn);
			Scanner sc = new Scanner(fil);
			int antall = Integer.parseInt(sc.nextLine());
			System.err.println(antall);
			for (int i = 0; i < antall; i++) {
				String type = sc.nextLine();
				if(type.equals(TEKST)){
					int id = Integer.parseInt(sc.nextLine());
					System.err.println(id);
					String bruker = sc.nextLine();
					System.err.println(bruker);
					String dato = sc.nextLine();
					System.err.println(dato);
					int likes = Integer.parseInt(sc.nextLine());
					System.err.println(likes);
					String tekst = sc.nextLine();
					System.err.println(tekst);
					blogg.leggTilUtvid(new Tekst(id, bruker, dato, likes, tekst));
				}
				if(type.equals(BILDE)){
					int id = Integer.parseInt(sc.nextLine());
					System.err.println(id);
					String bruker = sc.nextLine();
					System.err.println(bruker);
					String dato = sc.nextLine();
					System.err.println(dato);
					int likes = Integer.parseInt(sc.nextLine());
					String tekst = sc.nextLine();
					System.err.println(tekst);
					String url = sc.nextLine();
					System.err.println(url);
					blogg.leggTilUtvid(new Bilde(id, bruker, dato, likes, tekst, url));
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			System.err.println("funket ikke");
		}
		return blogg;

	}
}
