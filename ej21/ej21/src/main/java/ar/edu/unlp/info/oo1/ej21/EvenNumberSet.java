package ar.edu.unlp.info.oo1.ej21;

import java.util.HashSet;

public class EvenNumberSet extends HashSet<Integer> {
	@Override
	public boolean add(Integer num) {
		if ((int) num % 2 == 0) {
			return super.add(num);
		} else
			return false;
	
	}
}
