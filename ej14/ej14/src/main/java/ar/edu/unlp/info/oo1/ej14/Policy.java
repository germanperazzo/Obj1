package ar.edu.unlp.info.oo1.ej14;

import java.util.List;

public abstract class Policy {
	public abstract JobDescription next(List<JobDescription> jobs);
}
