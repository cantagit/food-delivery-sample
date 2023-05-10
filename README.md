# 

## Model
www.msaez.io/#/storming/fooddelivery-kyoo

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd kafka
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- front
- store
- rider


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- front
```
 http :8088/orders id="id" menu="menu" qty="qty" status="status" storeId="storeId" deliveryAddress="deliveryAddress" userName="userName" userPhoneNumber="userPhoneNumber" 
```
- store
```
 http :8088/orderAndCooks id="id" orderId="orderId" menu="menu" qty="qty" deliveryAddress="deliveryAddress" status="status" storeId="storeId" storeAddress="storeAddress" userName="userName" userPhoneNumber="userPhoneNumber" 
```
- rider
```
 http :8088/deliveries id="id" orderId="orderId" menu="menu" qty="qty" storeAddress="storeAddress" status="status" storeId="storeId" userName="userName" userPhoneNumber="userPhoneNumber" deliveryAddress="deliveryAddress" 
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

