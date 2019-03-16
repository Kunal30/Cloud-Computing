vs_vpc_cidr_block="10.0.0.0/16"
vs_subnet_cidr_block="10.0.0.0/24"

vs_security_group_name="vs_security_group"
vs_key_pair_name="vs_key_pair"

web_image_id="ami-06397100adf427136"
web_instance_type="t2.micro"
web_instance_count=1

app_image_id="ami-06397100adf427136"
app_instance_type="t2.micro"
app_instance_count=1

echo 'creating VPC...'
vs_vpc_id=`aws ec2 create-vpc --cidr-block $vs_vpc_cidr_block --query 'Vpc.VpcId' --output text`

echo 'enabling DNS for VPC...'
aws ec2 modify-vpc-attribute --vpc-id $vs_vpc_id --enable-dns-support "{\"Value\":true}"
aws ec2 modify-vpc-attribute --vpc-id $vs_vpc_id --enable-dns-hostnames "{\"Value\":true}"

echo 'creating internet gateway...'
vs_internet_gateway_id=`aws ec2 create-internet-gateway --query 'InternetGateway.InternetGatewayId' --output text`

echo 'attaching internet gateway to VPC...'
aws ec2 attach-internet-gateway --internet-gateway-id $vs_internet_gateway_id --vpc-id $vs_vpc_id

echo 'creating subnet...'
vs_subnet_id=`aws ec2 create-subnet --vpc-id $vs_vpc_id --cidr-block $vs_subnet_cidr_block --query 'Subnet.SubnetId' --output text`

echo 'creating routes...'
vs_route_table_id=`aws ec2 create-route-table --vpc-id $vs_vpc_id --query 'RouteTable.RouteTableId' --output text`
aws ec2 associate-route-table --route-table-id $vs_route_table_id --subnet-id $vs_subnet_id --output text > /dev/null
aws ec2 create-route --route-table-id $vs_route_table_id --destination-cidr-block 0.0.0.0/0 --gateway-id $vs_internet_gateway_id > /dev/null

echo 'creating security group...'
vs_security_group_id=`aws ec2 create-security-group --group-name $vs_security_group_name --description $vs_security_group_name --vpc-id $vs_vpc_id --query 'GroupId' --output text`

echo 'allowing incoming traffic...'
aws ec2 authorize-security-group-ingress --group-id $vs_security_group_id --protocol tcp --port 22 --cidr 0.0.0.0/0
aws ec2 authorize-security-group-ingress --group-id $vs_security_group_id --protocol tcp --port 80 --cidr 0.0.0.0/0

echo 'creating key pair...'
aws ec2 create-key-pair --key-name $vs_key_pair_name > /dev/null
#aws ec2 create-key-pair --key-name $vs_key_pair_name --query 'KeyMaterial' --output text > ~/.ssh/$vs_key_pair_name.pem
#chmod 400 ~/.ssh/$vs_key_pair_name.pem


echo 'creating web instance...'
web_instance_id=`aws ec2 run-instances --image-id $web_image_id --count $web_instance_count --instance-type $web_instance_type --key-name $vs_key_pair_name --security-group-ids $vs_security_group_id --subnet-id $vs_subnet_id --associate-public-ip-address --query 'Instances[0].InstanceId' --output text`

echo 'creating first app instance...'
app_instance_id=`aws ec2 run-instances --image-id $app_image_id --count $app_instance_count --instance-type $app_instance_type --key-name $vs_key_pair_name --security-group-ids $vs_security_group_id --subnet-id $vs_subnet_id --associate-public-ip-address --query 'Instances[0].InstanceId' --output text`

echo $web_instance_id
echo $app_instance_id