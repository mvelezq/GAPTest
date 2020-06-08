package utils.enums;

public enum Constants {

    EMAIL("gap-automation-test@mailinator.com"),
    PASSWORD("12345678");

    private String value;
    private Constants(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
