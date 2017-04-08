package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Константин on 08.04.2017.
 */
public class PrimeTests {

  @Test
  public void testPrime() {
    int n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrimeFast(n));
  }

  @Test
  public void testPrimeLong() {
    long n = (long) Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));
  }

  @Test
  public  void testNonPrime(){
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }
}
