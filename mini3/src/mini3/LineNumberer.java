package mini3;
import api.Transformation;
public class LineNumberer implements Transformation {
	private int count;
	public LineNumberer(){	
		count=1;
	}
	public String apply(String s){
		s=count+s;
		count++;
		return s;
	}
}
