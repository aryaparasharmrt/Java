import java.util.*;
import java.util.stream.Collectors;

public class Sorting {
	
	public static void main(String[] args) {
		
		List<String> st = new ArrayList<>();
		st.add("Ak");st.add("A");st.add("AAAAA");st.add("AAA");st.add("AA");st.add("AAAA");
		
		System.out.println("Before Sorting: "+st);
//		List<String> sortedList = st.stream().sorted((e1, e2) -> (e1.length() > e2.length())? -1 : (e1.length() < e2.length())? +1:e1.compareTo(e2)).collect(Collectors.toList());
        List<String> sortedList = st.stream().sorted((e1, e2) -> (e1.length() > e2.length())? -1 : (e1.length() < e2.length())? +1:0).collect(Collectors.toList());
		System.out.println("After Sorting: "+sortedList);
	}
	
}