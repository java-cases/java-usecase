package org.owasp;

public enum ValidatorType {

    EMAIL("Email"),
    IP_ADDRESS("IPAddress"),
    SAFT_STRING("SafeString"),
    CREDIT_CARD("CreditCard"),
    SSN("SSN"),
    URL("URL");

    private final String name;

    public String getName() {
        return name;
    }

    ValidatorType(String name){
        this.name=name;
    }

    @Override
    public String toString() {
        return "ValidatorType{" +
                "name='" + name + '\'' +
                '}';
    }
}
