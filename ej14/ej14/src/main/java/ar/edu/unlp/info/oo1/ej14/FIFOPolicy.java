package ar.edu.unlp.info.oo1.ej14;

import java.util.List;

public class FIFOPolicy extends Policy {
	
	@Override
	public JobDescription next(List<JobDescription> jobs) {
		
		return jobs.get(0);
	}
}
