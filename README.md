![image](https://user-images.githubusercontent.com/487999/79708354-29074a80-82fa-11ea-80df-0db3962fb453.png)


> EventStorming

![event_storming](https://github.com/cantagit/food-delivery-sample/assets/132859904/bf20be4b-3d03-4b6c-9996-92cb0551668f)


> Saga
 
 - 고객이 메뉴를 주문함<br>
 ![front_orderPlaced](https://github.com/cantagit/food-delivery-sample/assets/132859904/53ee7a26-0d3e-4bb4-93cc-d7ff5ff9bc00)<br>
 
 - front 소스일부<br>
 ![order_code1](https://github.com/cantagit/food-delivery-sample/assets/132859904/de09f19d-e303-41eb-88bc-53b7f6a2fdef)<br>
 ![order_code2](https://github.com/cantagit/food-delivery-sample/assets/132859904/69820cc6-0b3f-4300-86af-70c67425f418)<br>
 ![order_code3](https://github.com/cantagit/food-delivery-sample/assets/132859904/bf141784-ec4e-4d10-b99d-90875b7e5712)<br>


 - 상점 주문리스트<br>
 ![store_orderPlaced](https://github.com/cantagit/food-delivery-sample/assets/132859904/aa108dfd-23cc-4c7d-bc42-e9a509c7a1a7)<br>
 
 - 상점 조리시작<br>
 ![store_cookStarted](https://github.com/cantagit/food-delivery-sample/assets/132859904/d80b63ec-695a-48ec-a20a-675375198583)<br>

 - 상점 조리완료<br>
 ![store_cookFinished](https://github.com/cantagit/food-delivery-sample/assets/132859904/bf56869f-bc5e-4409-801f-a4046d8bcbde)<br>
 
 - store 소스일부<br>
 ![store_code1](https://github.com/cantagit/food-delivery-sample/assets/132859904/ab7ced00-523e-4a91-b62a-b099c0c8664a)<br>
 ![store_code2](https://github.com/cantagit/food-delivery-sample/assets/132859904/23f591e1-152c-42e1-a7fc-7f2e81bdd83a)<br>
 ![store_code3](https://github.com/cantagit/food-delivery-sample/assets/132859904/4512f32d-411d-4d7a-9a17-fa26a4be92ba)<br>

 - 라이더 배달요청<br>
 ![rider_reqestDelivery](https://github.com/cantagit/food-delivery-sample/assets/132859904/0a307500-5b20-448e-80bf-eb933b64bdc5)<br>

 - 라이더 배달픽업<br>
 ![rider_deliveryPicked](https://github.com/cantagit/food-delivery-sample/assets/132859904/a465026b-4a48-4157-af2a-efe87dcf3467)<br>

 - 라이더 배달완료<br>
 ![rider_deliveryFinished](https://github.com/cantagit/food-delivery-sample/assets/132859904/a80cba5e-4124-41a1-9aad-1720553d551f)<br>

 - rider 소스일부<br>
 ![rider_code1](https://github.com/cantagit/food-delivery-sample/assets/132859904/080b2079-3a33-48c5-8f56-581909ee3409)<br>


 - Kafka 이벤트별 수신이력<br>
 ![kafka_Consumer](https://github.com/cantagit/food-delivery-sample/assets/132859904/abb86fd5-959c-4bb9-9a81-81136d4f5c8b)<br>


> CQRS


![cqrs1](https://github.com/cantagit/food-delivery-sample/assets/132859904/40711e1d-6484-4394-9bf1-fb79743eff0b)
![cqrs2](https://github.com/cantagit/food-delivery-sample/assets/132859904/4259f1db-14ad-413e-9a48-1e72ce6431a3)
![cqrs3](https://github.com/cantagit/food-delivery-sample/assets/132859904/37d59874-6fb9-48d9-bef7-225449b76a64)
![cqrs4](https://github.com/cantagit/food-delivery-sample/assets/132859904/c969f7cd-424c-410f-a7e1-05bc1daa1976)


> Compensation / Correlation



> 기능적 요구사항
 - 고객이 메뉴를 선택하여 주문한다.
 - 고객이 선택한 메뉴에 대해 결제한다.
 - 주문이 되면 주문 내역이 입점상점주인에게 주문정보가 전달된다.
 - 상점주는 주문을 수락하거나 거절할 수 있다.
 - 상점주는 요리시작때와 완료 시점에 시스템에 상태를 입력한다.
 - 고객은 아직 요리가 시작되지 않은 주문은 취소할 수 있다.
 - 요리가 완료되면 고객의 지역 인근의 라이더들에 의해 배송건 조회가 가능하다.
 - 라이더가 해당 요리를 Pick한 후, 앱을 통해 통보한다.
 - 고객이 주문상태를 중간중간 조회한다.
 - 주문상태가 바뀔 때 마다 카톡으로 알림을 보낸다.
 - 라이더의 배달이 끝나면 배송확인 버튼으로 모든 거래가 완료된다.
 
 
> 비기능적 요구사항
 - 장애격리
  1. 상점관리 기능이 수행되지 않더라도 주문은 365일 24시간 받을 수 있어야 한다 Async(event-driven), Eventual Consistency
  2. 결제시스템이 과중되면 사용자를 잠시동안 받지 않고 결제를 잠시후에 하도록 유도한다. Circuit breaker, fallback
 - 성능
  1. 고객이 자주 상점관리에서 확인할 수 있는 배달상태를 주문시스템(프론트엔드)에서 확인할 수 있어야 한다 CQRS
  2. 배달상태가 바뀔때마다 카톡 등으로 알림을 줄 수 있어야 한다 Event driven
