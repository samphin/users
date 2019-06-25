package cn.sq.users.core.exception;

public enum MyErrorEnum {
    errorParm(-1, "参数错误。"),
    PLEASE_LOGIN(-2, "请登录。"),
    PLEASE_RETRY_AGAIN(-3, "操作失败，请重试"),
    USER_NOT_EXIST(-4, "用户不存在"),

    NOT_YOURS_TOPICT(-1000, "找不到要删除的主贴"),
    TOPICT_NOT_EXIST(-1000, "主贴不存在"),


    DUPLICATE_THUMP_UP(-1100, "不能重复点赞"),
    COMMENT_NOT_EXIST(-1300, "评论不存在"),


    ;

    private final int errorCode;
    private final String errorMsg;

    private MyErrorEnum(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public MyException getMyException() {
        return getMyException(errorMsg);
    }

    public MyException getMyException(String msg) {
        return new MyException(errorCode, "", msg);//  返回输入的错误信息
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public static MyErrorEnum findByCode(int code) {
        for (MyErrorEnum value : MyErrorEnum.values()) {
            if (value.errorCode == (code)) {
                return value;
            }
        }
        return null;
    }
}
