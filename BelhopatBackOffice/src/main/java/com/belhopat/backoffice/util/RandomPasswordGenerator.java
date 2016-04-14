package com.belhopat.backoffice.util;

import java.math.BigInteger;
import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class RandomPasswordGenerator {
	  private SecureRandom random = new SecureRandom();

	  public String nextSessionId() {
	    return new BigInteger(130, random).toString(32);
	  }
}

