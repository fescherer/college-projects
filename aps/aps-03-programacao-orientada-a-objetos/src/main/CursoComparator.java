package main;

import java.util.Comparator;

public class CursoComparator implements Comparator<Curso>{

	@Override
	public int compare(Curso arg0, Curso arg1) {
		int var = 3;
		if(arg0.equals(arg1))
			var = 0;
		return var;
	}

}
