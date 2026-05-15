package com.example.mimpaku.form;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReservationInputForm {
	@NotBlank(message = "Select checkin date and checkout date.")
	private String fromCheckinDateToCheckoutDate;

	@NotNull(message = "How many people stay?")
	@Min(value = 1, message = "At least 1 person stays at the mimpaku.")
	private Integer numberOfPeople;

	// get checkin date
	public LocalDate getCheckinDate() {
		String[] checkinDateAndCheckoutDate = getFromCheckinDateToCheckoutDate().split("から");
		return LocalDate.parse(checkinDateAndCheckoutDate[0].trim());

	}

	// get checkout date
	public LocalDate getCheckoutDate() {
		String[] checkinDateAndCheckoutDate = getFromCheckinDateToCheckoutDate().split("から");
		return LocalDate.parse(checkinDateAndCheckoutDate[1].trim());
	}

}