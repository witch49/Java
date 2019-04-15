package sec04.exam01;

import java.util.Comparator;
import sec04.exam01.CompareExample.Student;

public class StudentComparator implements Comparator<Student> {
	@Override
	public int compare(Student a, Student b) {
		if (a.sno > b.sno)
			return -1;
		else if (a.sno == b.sno)
			return 0;
		else
			return 1;
		// same as
		//return Integer.compare(a.sno, b.sno);
	}

}
