const stripe = Stripe('pk_test_51TVkObRqqmWdS2AvJyagf1bZ9R8W1dOZvBr1YwA90V1dUEMAu6XimLUreEaVpkHe1ECeUNhGCrft0zjYIPmZuMMC00LszkrRnM');


const paymentButton = document.querySelector('#paymentButton');

console.log("sessionId:", sessionId);

paymentButton.addEventListener('click', async () => {

    const result = await stripe.redirectToCheckout({
        sessionId: sessionId
    });

    if (result.error) {
        console.error(result.error.message);
    }
});