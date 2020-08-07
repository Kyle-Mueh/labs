package mini3;
import api.Combiner;

public class LetterCollector implements Combiner {
	private String alph;
	public LetterCollector(){
		alph="";
	}
	public String combine(String first, String second){
		String s=second.toLowerCase();
		String f=first.toLowerCase();
		for(int i=0; i<first.length(); i++){
			alph+=f.charAt(i);
			f.replace(first.charAt(i), ' ');
			f=f.trim();
		}
		for(int i=0; i<alph.length(); i++){
			s.replace(alph.charAt(i), ' ');
			s=s.trim();
		}
		for(int i=0; i<second.length(); i++){
			alph+=s.charAt(i);
			s.replace(s.charAt(i), ' ');
			s=s.trim();
		}
		return alph;
	}
}
