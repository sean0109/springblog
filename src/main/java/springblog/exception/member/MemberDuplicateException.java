package springblog.exception.member;

public class MemberDuplicateException extends MemberException {

    String duplicateData;

    public MemberDuplicateException(String message, String duplicateLoginId) {
        super(message);
        this.duplicateData = duplicateLoginId;
    }

    public String getDuplicateData() {
        return duplicateData;
    }
}
