package com.example.samuraitravel.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.samuraitravel.form.ReservationRegisterForm;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class StripeService {
	@Value("${stripe.api-key}")
	private String stripeApiKey;

	public String createStripeSession(String houseName, ReservationRegisterForm reservationRegisterForm,
			HttpServletRequest httpServletRequest) {

		String requestUrl = httpServletRequest.getRequestURL().toString();

		SessionCreateParams params = SessionCreateParams.builder()
				.addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
				.addLineItem(SessionCreateParams.LineItem.builder()
						.setPriceData(SessionCreateParams.LineItem.PriceData.builder().setCurrency("jpy")
								.setUnitAmount(reservationRegisterForm.getAmount().longValue())
								.setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
										.setName(houseName).build())
								.build())
						.setQuantity(1L).build())
				.setMode(SessionCreateParams.Mode.PAYMENT)
				.setSuccessUrl(
						requestUrl.replaceAll("/houses/[0-9]+/reservations/confirm", "") + "/reservations?reserved")
				.setCancelUrl(requestUrl.replace("/reservations/confirm", ""))
				.putAllMetadata(java.util.Map.of("houseId", reservationRegisterForm.getHouseId().toString(), "userId",
						reservationRegisterForm.getUserId().toString(), "checkinDate",
						reservationRegisterForm.getCheckinDate(), "checkoutDate",
						reservationRegisterForm.getCheckoutDate(), "numberOfPeople",
						reservationRegisterForm.getNumberOfPeople().toString(), "amount",
						reservationRegisterForm.getAmount().toString()))
				.build();

		try {
			Session session = Session.create(params);
			return session.getId();
		} catch (StripeException e) {
			e.printStackTrace();
			return "";
		}
	}
}