package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;
import no.hvl.dat100.jplab11.oppgave2.Tekst;

public class Blogg {

	// TODO: objektvariable 

	private Innlegg[] innleggstabell;
	private int nesteledig;

	public Blogg() {
		this.innleggstabell = new Innlegg[20];
		this.nesteledig = 0;	
	}

	public Blogg(int lengde) {
		this.innleggstabell = new Innlegg[lengde];
		this.nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggstabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i<nesteledig;i++){
			if (innleggstabell[i].erLik(innlegg))return i;
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for (int i = 0; i<nesteledig;i++){
			if (innleggstabell[i].erLik(innlegg))return true;
		}
		return false;
	}

	public boolean ledigPlass() {
		return nesteledig < innleggstabell.length;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (nesteledig<innleggstabell.length){
			innleggstabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		String tekst = "";
		tekst += nesteledig;
		for (int i = 0; i<nesteledig;i++) {
			tekst += "\n" + innleggstabell[i].toString();
		}
		return tekst;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		
		Innlegg[] ny = new Innlegg[innleggstabell.length*2];
		for (int i = 0; i<innleggstabell.length;i++) ny[i] = innleggstabell[i];
		this.innleggstabell = ny;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		if (finnes(innlegg)) return false;
		if(leggTil(innlegg)) {
			return true;
		}else{
			utvid();
			leggTil(innlegg);
			return true;
		}

	}
	
	public boolean slett(Innlegg innlegg) {
		boolean slettet= false;
		for (int i = 0; i<nesteledig;i++){
			if (innleggstabell[i].erLik(innlegg)){
				innleggstabell[i] = null;
				for(int y = i; y < nesteledig-1; y++){
					innleggstabell[y] = innleggstabell[y+1];
				}
				slettet = true;
				nesteledig --;
			}
		}
		return slettet;

	}
	
	public int[] search(String keyword) {
		
		int[] ider = new int[nesteledig];
		int ideTeller = 0;
		for(int i = 0; i<nesteledig; i++){
			if(innleggstabell[i].getTekst().contains(keyword)) {
				ider[ideTeller] = innleggstabell[i].getId();
				ideTeller++;
			}
		}
		return ider;

	}
}