package com.redisexample.redisexample.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author Naveen Bavu
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@JsonInclude(value = Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable {

  private Long id;
  private  String name;
  private Long qty;
  private Long price;


}
