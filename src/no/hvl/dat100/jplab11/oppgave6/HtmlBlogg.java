package no.hvl.dat100.jplab11.oppgave6;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.Innlegg;
import no.hvl.dat100.jplab11.oppgave3.Blogg;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}
	
	private static String HTMLPREFIX = 
			"<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";
	
	private static String HTMLPOSTFIX = 
			"\t</body>\n</html>";
	
	@Override
	public String toString() {
		String tekst = "";
		tekst += "<html>\n";
		tekst += "<head>\n<title>DAT100blogg</title\n</head>";
		tekst += "<body>\n";
		for (int i = 0; i<this.getAntall();i++){
			tekst += this.getSamling()[i].toHTML()+"\n";
		}
		tekst += "</body>\n";
		tekst += "</html>";


		return tekst;


		/*for (int i = 0; i<this.getAntall();i++){
			tekst += "<h2>"+this.getSamling()[i].getBruker()+" @"+this.getSamling()[i].getDato()+"["+this.getSamling()[i].getLikes()+"]<h2>";
			tekst += "<p>"+this.getSamling()[i].getTekst()+"<p>";
		} */
	}
}
