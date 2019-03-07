package com.cc.proj1.infra;

public interface EC2setup {

	public void creatInstance(int numOfInstances);
	
	public void deleteInstance(int instanceID);
}
