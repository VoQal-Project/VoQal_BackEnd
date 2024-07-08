package Capstone.VoQal.global.enums;

//public enum Role {
//
//    TRAINER("ROLE_TRAINER"),
//    STUDENT("ROLE_STUDENT"),
//    GUEST("ROLE_GUEST");
//
//    private final String value;
//
//    Role(String value) {
//        this.value = value;
//    }
//
//    public static Role fromValue(String value) {
//        for (Role role : values()) {
//            if (role.value.equalsIgnoreCase(value)) {
//                return role;
//            }
//        }
//        throw new IllegalArgumentException("지원하지 않는 권한입니다: " + value);
//    }
//}

public enum Role {

    COACH("COACH"),
    STUDENT("STUDENT"),
    GUEST("GUEST");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public static Role fromValue(String value) {
        for (Role role : values()) {
            if (role.value.equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 권한입니다: " + value);
    }
}