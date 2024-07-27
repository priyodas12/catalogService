package tech.eurekaClient.catalogService.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogServiceHealthController {

  @Value ("${eureka.instance.instanceId}")
  private String instanceId;

  @GetMapping("/status")
  public ResponseEntity<Object> getServiceStatus(){
    log.info ("Instance Id: {}",instanceId);
    var serverStatus=Map.of("InstanceId",instanceId,"Status", HttpStatus.OK.value ());
    return ResponseEntity.ok (serverStatus);
  }
}
