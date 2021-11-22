package com.devweek.camundademo.common.util;

public class ValidationPatterns {
    public static final String WEBSITE = "^((https?:\\/\\/)?(www\\.)?([a-zA-Z0-9]+(-?[a-zA-Z0-9])*\\.)+[\\w]{2,}(\\/\\S*)?)?$";
    public static final String NUMERIC = "^[0-9]*$";
    public static final String NUMERIC_POSITIVE_INTEGER = "^[1-9]\\d*$";
    public static final String ALPHA_NUMERIC_WITHOUT_SPACES = "^[a-zA-Z0-9]*$";
    public static final String PERCENTAGE = "^[1-9]$|^[1-9][0-9]$|^100$";
    public static final String PHONE = "^(\\+|00)[0-9]{4,15}$";
    public static final String UUID = "^[a-fA-F\\d]{8}(\\-[a-fA-F\\d]{4}){3}\\-[a-fA-F\\d]{12}$";
    public static final String SWIFT_CODE = "^[A-Z0-9]{4,4}[A-Z]{2,2}[A-Z0-9]{2,2}([A-Z0-9]{3,3}){0,1}$";
    public static final String ALPHA_NUMERIC_PLUS_SPACE = "^[a-zA-Z0-9 ]*$";
    public static final String ALPHA_NUMERIC_PLUS_SPACE_AND_HYPHEN = "^[a-zA-Z0-9 \\-]*$";
    public static final String ALPHA_NUMERIC_PLUS_SPACE_HYPHEN_SLASH = "^[a-zA-Z0-9 \\-/]*$";

    private ValidationPatterns() {
    }
}
