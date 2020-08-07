package mini3;
import api.Transformation;

public class CommentRemover implements Transformation{
	public CommentRemover(){
	}
	public String apply(String s){
		if(s.contains("//")){
			s=s.substring(0, s.indexOf("//"));
		}
		return s;
	}
}
