package br.ueg.reviewer.enums;

import br.ueg.genericarchitecture.enums.MessageCode;
import br.ueg.genericarchitecture.enums.MessageType;
import lombok.Getter;

@Getter
public enum ErrorEnum implements MessageCode {
    GENERAL("M1", MessageType.ERROR),
    CONFIRM_PASSWORD_NOT_ENTIRED("M2", MessageType.ERROR),
    PASSWORD_NOT_ENTIRED("M3", MessageType.ERROR),
    PASSWORD_DIFERENT("M4", MessageType.ERROR),
    PASSWORD_INVALID("M5", MessageType.ERROR),
    PDF_ERROR("M6", MessageType.ERROR),
    MANDATORY_FIELD("M7", MessageType.ERROR),
    IMAGE_CONTENT_TYPE_INVALID("M8", MessageType.ERROR),
    EMAIL_EXISTS("M9", MessageType.ERROR),
    LOGIN_EXISTS("M10", MessageType.ERROR),;

    private final String code;
    private final MessageType type;

    ErrorEnum(String code, MessageType type){
        this.type = type;
        this.code = code;
    }
}
