package com.udacity.pricing;

//import org.junit.Test;
import com.udacity.pricing.api.PricingController;
import com.udacity.pricing.domain.price.Price;
import com.udacity.pricing.domain.price.PriceRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PricingServiceApplicationTests {

	PricingController pricingController = new PricingController();


	@MockBean
	private PriceRepository priceRepository;


	@Test
	public void contextLoads() {
	}

	@Test
	public void testPricing(){
		Price price = new Price();
		price.setPrice(BigDecimal.valueOf(4.99));
		price.setCurrency("USD");
		when(priceRepository.findById(1L)).thenReturn(Optional.of(price));
		Assert.assertEquals(BigDecimal.valueOf(4.99), price.getPrice());

	}



}
