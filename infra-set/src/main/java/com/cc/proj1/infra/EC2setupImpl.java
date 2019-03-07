package com.cc.proj1.infra;

import com.amazonaws.services.ec2.model.InstanceType;
import com.amazonaws.services.ec2.model.RunInstancesRequest;

public class EC2setupImpl implements EC2setup{

	public void creatInstance(int numOfInstances) {
		
		RunInstancesRequest runInstancesRequest = new RunInstancesRequest();
		runInstancesRequest.withImageId(null)
							.withInstanceType(InstanceType.T2Micro)
							.withMinCount(1)
							.withMaxCount(numOfInstances)
							.withKeyName(null);
	}

	public void deleteInstance(int instanceID) {
		
	}

}
