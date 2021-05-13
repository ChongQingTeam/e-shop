package top.knpf.domain.b.output;

import lombok.Data;

@Data
public class BaseResult<T> {
    private String status;
    private boolean success;
    private String msg;
    private T result;

    public BaseResult renderSuccess() {
        setMsg("成功");
        setSuccess(true);
        setStatus("200");
        return this;
    }

    public BaseResult renderSuccess(T data) {
        setMsg("成功");
        setSuccess(true);
        setStatus("200");
        setResult(data);
        return this;
    }

    public BaseResult renderSuccess(String msg) {
        setMsg(msg);
        setSuccess(true);
        setStatus("200");
        return this;
    }

    public BaseResult renderSuccess(String msg, String status) {
        renderSuccess(msg);
        setStatus(status);
        return this;
    }

    public BaseResult renderSuccess(String msg, String status, T obj) {
        renderSuccess(msg, status);
        setResult(obj);
        return this;
    }

    public BaseResult renderError() {
        setMsg("失败");
        setSuccess(false);
        setStatus("500");
        return this;
    }

    public BaseResult renderError(String msg) {
        renderError();
        setMsg(msg);
        return this;
    }

    public BaseResult renderError(String msg, String status) {
        renderError(msg);
        setStatus(status);
        return this;
    }

    public BaseResult renderError(String msg, String status, T obj) {
        renderError(msg, status);
        setResult(obj);
        return this;
    }
}
