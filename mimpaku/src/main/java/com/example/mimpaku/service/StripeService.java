package com.example.mimpaku.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.mimpaku.form.ReservationRegisterForm;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Event;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionRetrieveParams;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class StripeService {
	private final ReservationService reservationService;

	public StripeService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@Value("${stripe.api-key}")
	private String stripeApiKey;

	public String createStripeSession(String houseName, ReservationRegisterForm reservationRegisterForm,
			HttpServletRequest http) {
		Stripe.apiKey = stripeApiKey;
		String requestUrl = new String(http.getRequestURL());
		SessionCreateParams params = SessionCreateParams.builder()
				.addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)

				.addLineItem(SessionCreateParams.LineItem.builder()

						.setPriceData(SessionCreateParams.LineItem.PriceData.builder()

								.setCurrency("jpy")

								.setUnitAmount(reservationRegisterForm.getAmount().longValue())

								.setProductData(SessionCreateParams.LineItem.PriceData.ProductData.builder()
										.setName(houseName).build())

								.build())

						.setQuantity(1L).build())

				.setMode(SessionCreateParams.Mode.PAYMENT)

				.setSuccessUrl(
						requestUrl.replaceAll("/houses/[0-9]+/reservations/confirm", "") + "/reservations?reserved")

				.setCancelUrl(requestUrl.replace("/reservations/confirm", ""))

				.setPaymentIntentData(SessionCreateParams.PaymentIntentData.builder()

						.putMetadata("houseId", reservationRegisterForm.getHouseId().toString())

						.putMetadata("userId", reservationRegisterForm.getUserId().toString())

						.putMetadata("checkinDate", reservationRegisterForm.getCheckinDate())

						.putMetadata("checkoutDate", reservationRegisterForm.getCheckoutDate())

						.putMetadata("numberOfPeople", reservationRegisterForm.getNumberOfPeople().toString())

						.putMetadata("amount", reservationRegisterForm.getAmount().toString())

						.build())

				.build();

		try {
			Session session = Session.create(params);
			return session.getId();
		} catch (StripeException e) {
			e.printStackTrace();
			return "";
		}

	}

//	// セッションから予約情報を取得し、ReservationServiceクラスを介してデータベースに登録する
//	public void processSessionCompleted(Event event) {
//
//		Optional<StripeObject> optionalStripeObject = event.getDataObjectDeserializer().getObject();
//
//		optionalStripeObject.ifPresent(stripeObject -> {
//
//			Session session = (Session) stripeObject;
//
//			SessionRetrieveParams params = SessionRetrieveParams.builder().addExpand("payment_intent").build();
//
//			try {
//
//				session = Session.retrieve(session.getId(), params, null);
//
//				Map<String, String> paymentIntentObject = session.getPaymentIntentObject().getMetadata();
//
//				reservationService.create(paymentIntentObject);
//
//			} catch (StripeException e) {
//
//				e.printStackTrace();
//				
//
//			}
//			
//
//		});
//
//	}
//	public void processSessionCompleted(Event event) {
//
//		System.out.println("process start");
//
//		Optional<StripeObject> optionalStripeObject = event.getDataObjectDeserializer().getObject();
//
//		System.out.println("optional: " + optionalStripeObject.isPresent());
//
//		optionalStripeObject.ifPresent(stripeObject -> {
//
//			Session session = (Session) stripeObject;
//
//			try {
//
//				SessionRetrieveParams params = SessionRetrieveParams.builder().addExpand("payment_intent").build();
//
//				session = Session.retrieve(session.getId(), params, null);
//
//				System.out.println("session id: " + session.getId());
//
//				System.out.println("paymentIntentObject: " + session.getPaymentIntentObject());
//
//				Map<String, String> metadata = session.getPaymentIntentObject().getMetadata();
//
//				System.out.println("metadata: " + metadata);
//
//				reservationService.create(metadata);
//
//				System.out.println("reservation created");
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		});
//	}

	public void processSessionCompleted(Event event) {

		try {

			Session session = (Session) event.getDataObjectDeserializer().deserializeUnsafe();

			System.out.println("session: " + session);

			SessionRetrieveParams params = SessionRetrieveParams.builder().addExpand("payment_intent").build();

			session = Session.retrieve(session.getId(), params, null);

			System.out.println(session.getPaymentIntentObject());

			Map<String, String> metadata = session.getPaymentIntentObject().getMetadata();

			System.out.println(metadata);

			reservationService.create(metadata);

			System.out.println("reservation created");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
