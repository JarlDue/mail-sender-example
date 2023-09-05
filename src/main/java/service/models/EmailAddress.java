package service.models;

import org.immutables.value.Value;
@Value.Immutable
public interface EmailAddress {

    String getAddress();

    // You can add validation here if desired, for example:
    @Value.Check
    default void validate() {
        if (!isValidEmail(getAddress())) {
            throw new IllegalArgumentException("Invalid email address provided");
        }
    }

    // Email validation logic (You can use any robust method or library you prefer)
    static boolean isValidEmail(String email) {
        // Simple regex for email validation (not exhaustive, consider using a library like Apache Commons Validator)
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(regex);
    }
}

