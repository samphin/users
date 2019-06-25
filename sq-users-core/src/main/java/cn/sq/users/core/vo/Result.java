package cn.sq.users.core.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.util.StringUtils;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 2633283546876721434L;

    private boolean success = true;
    private Integer code = 200;
    private String msg = "操作成功";
    private T data;

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public static Result ok(String msg) {
        Result result = new Result();
        result.setMsg(msg);
        return result;
    }

    public static Result ok() {
        Result result = new Result();
        return result;
    }

    public static Result failure(int code, String msg) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(code);
        if (StringUtils.isEmpty(msg)) {
            msg = "操作失败";
        }
        result.setMsg(msg);
        return result;
    }

    public static Result failure() {
        return failure(null);
    }

    public static Result failure(String msg) {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(-400);
        if (StringUtils.isEmpty(msg)) {
            msg = "操作失败";
        }
        result.setMsg(msg);
        return result;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }
}
