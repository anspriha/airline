package com.airline.reservation.service;

import com.airline.reservation.entity.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public boolean processPayment(PaymentDetails paymentDetails) {
        // Simulate payment processing with dummy card details
        if (isValidCard(paymentDetails.getCardNumber()) && paymentDetails.getCvv().length()==3) {
            return true; // Simulate successful payment
        }
        return false; // Simulate payment failure
    }

    //Luhn Algorithm to validate credit card number
    public static boolean isValidCard(String cardNumber) {
        int sum = 0;
        boolean doubleDigit = false;

        // Iterate from right to left
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = Character.getNumericValue(cardNumber.charAt(i));

            if (doubleDigit) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9; // Same as adding the digits (e.g., 12 → 1+2 = 3)
                }
            }

            sum += digit;
            doubleDigit = !doubleDigit; // Toggle doubleDigit for the next iteration
        }

        return sum % 10 == 0; // Valid if sum is a multiple of 10
    }

}
