package com.glg.shiroadmin.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jesse
 * @since 2020-10-22
 */
@Data
  @EqualsAndHashCode(callSuper = false)
    public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    private String test;


}
