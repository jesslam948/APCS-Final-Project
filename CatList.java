
import java.util.ArrayList;


public class CatList{
	private ArrayList<Cat> catList;
	
	public CatList(){
		catList = new ArrayList<Cat>();
		for(int i = 0; i <10; i++){
			catList.add(i, new Cat(-1, 0, 0, 0, 0));
		}
	}
	
	public void addCat(Cat c){
		catList.set(c.getBreed(), c);
	}
	
	public Cat getCat(int i){
		return catList.get(i);
	}
}
