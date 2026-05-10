package pu.fmi.webprogramming.service;

import org.springframework.stereotype.Component;
import pu.fmi.webprogramming.model.Delivery;

import java.time.LocalDateTime;

@Component
public class DeliveryEstimator {

  public LocalDateTime estimateArrivalTime(Delivery delivery) {


    if(delivery.getWarehouse().getCity().equals(delivery.getCustomer().getCity())){
      delivery.setEstimatedArrivalAt(delivery.getCreatedAt().plusDays(1L));
    }else {
      delivery.setEstimatedArrivalAt(delivery.getCreatedAt().plusDays(3L));
    }

    if(delivery.getCourier()== null){
      delivery.setEstimatedArrivalAt(delivery.getEstimatedArrivalAt().plusDays(2L));
    }


    return null;
  }
}
