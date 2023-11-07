package no.hvl.dat100.jplab11.oppgave2;

import no.hvl.dat100.jplab11.common.TODO;

public class Bilde extends Tekst {

	String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id, bruker, dato, tekst);
		this.url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		String streng = "BILDE\n"+this.getId()+"\n"+this.getBruker()+"\n"+this.getDato()+"\n"+this.getLikes()+"\n"+ this.getTekst()+"\n"+url+"\n";
		return streng;
	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
		
		String streng = "";
		streng += "<h2>"+this.getBruker()+" @"+this.getDato()+"["+this.getLikes()+"]<h2>\n";
		streng += "<p>"+tekst+"<p>\n";
		streng += "<iframe src="+url+" height=600 width=800></iframe>";
		streng += "<hr>";
		return streng;
	}
}
