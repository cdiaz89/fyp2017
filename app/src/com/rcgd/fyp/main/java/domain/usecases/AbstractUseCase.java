package com.rcgd.fyp.main.java.domain.usecases;

import com.rcgd.fyp.main.java.domain.interfaceboundary.InputBoundary;
import com.rcgd.fyp.main.java.domain.interfaceboundary.OutputBoundary;

public abstract class AbstractUseCase implements InputBoundary {
	
	protected OutputBoundary outputBoundary;
	
	public AbstractUseCase(OutputBoundary outputBoundary) {
		this.outputBoundary = outputBoundary;
	}
	
	public abstract void run();
	
	
	@Override
	public void execute() {
		
	}
	
	
}
