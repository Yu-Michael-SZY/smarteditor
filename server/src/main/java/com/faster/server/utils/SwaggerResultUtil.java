package com.faster.server.utils;


import java.io.Serializable;

import com.faster.server.model.common.HttpCode;
import com.faster.server.model.common.HttpCodeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SwaggerResultUtil<T> implements Serializable {

    private static final long serialVersionUID = -3323181209814493274L;

    /**
     * 错误码
     */
    @ApiModelProperty(value = "响应码", required = true)
    private Integer code = HttpCode.SUCCESS;

    @ApiModelProperty(value = "消息提示")
    private String msg;

    /**
     * 业务码
     */
    @ApiModelProperty(value = "业务码")
    private String bizCode;

    @ApiModelProperty(value = "查询数据长度", required = true)
    private Object dataSize = 0;

    @ApiModelProperty(value = "数据", required = true)
    private T data;

    public SwaggerResultUtil() {
        super();
    }

    public SwaggerResultUtil(T data) {
        this.data = data;
    }

    public SwaggerResultUtil(T data, int status) {
        this.data = data;
        this.code = status;
    }

    public SwaggerResultUtil(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public SwaggerResultUtil(Integer code, String bizCode, String msg) {
        super();
        this.code = code;
        this.bizCode = bizCode;
        this.msg = msg;
    }

    public SwaggerResultUtil(Integer code, String bizCode, String msg, T data) {
        super();
        this.code = code;
        this.bizCode = bizCode;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 构造添加data数据.
     *
     * @param data T 数据
     * @return 返回 SwaggerResultUtil
     */
    public SwaggerResultUtil<T> data(T data) {
        this.data = data;
        return this;
    }

    /**
     * 构造添加msg数据.
     *
     * @param msg msg内容
     * @return 返回 SwaggerResultUtil
     */
    public SwaggerResultUtil<T> msg(String msg) {
        this.msg = msg;
        return this;
    }

    /**
     * 构造添加bizCode业务代码
     *
     * @param bizCode 业务代码
     * @return 返回 SwaggerResultUtil
     */
    public SwaggerResultUtil<T> bizCode(String bizCode) {
        this.bizCode = bizCode;
        return this;
    }

    /**
     * 构造添加查询数据长度
     *
     * @param dataSize 查询数据长度
     * @return 返回 SwaggerResultUtil
     */
    public SwaggerResultUtil<T> dataSize(Object dataSize) {
        this.dataSize = dataSize;
        return this;
    }

    public void setDefError(Exception ex) {
        this.msg = ex.getMessage();
        this.code = HttpCode.SWAGGER_ERROR;
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

    public String getBizCode() {
        return bizCode;
    }

    public void setBizCode(String bizCode) {
        this.bizCode = bizCode;
    }

    public Object getDataSize() {
        return dataSize;
    }

    public void setDataSize(Object dataSize) {
        this.dataSize = dataSize;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 可使用静态构造对象再按需变更返回字段值. eg: {@link SwaggerResultUtil#ok()};
     */
    public SwaggerResultUtil<T> success() {
        this.code = HttpCodeEnum.SUCCESS.getCode();
        this.msg = HttpCodeEnum.SUCCESS.getMsg();
        return this;
    }

    /**
     * 可使用静态构造对象再按需变更返回字段值. eg: {@link SwaggerResultUtil#ok(Object)};
     */
    public SwaggerResultUtil<T> success(T data) {
        this.data = data;
        return success();
    }

    /**
     * 可使用静态构造对象再按需变更返回字段值. eg: {@link SwaggerResultUtil#errorCustomer(int)};
     */
    public SwaggerResultUtil<T> error(int code) {
        return this.error(code, null, null);
    }

    /**
     * 可使用静态构造对象再按需变更返回字段值. eg: {@link SwaggerResultUtil#errorCustomer(int, String)};
     */
    public SwaggerResultUtil<T> error(int code, String msg) {
        return this.error(code, msg, null);
    }

    /**
     * 可使用静态构造对象再按需变更返回字段值. eg:
     * {@link SwaggerResultUtil#errorCustomer(int, String, T)};
     */
    public SwaggerResultUtil<T> error(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        return this;
    }

    /**
     * 可使用静态构造对象再按需变更返回字段值. eg: {@link SwaggerResultUtil#errorParam()};
     */
    public static <T> SwaggerResultUtil<T> errorParams() {
        return new SwaggerResultUtil<T>().error(HttpCodeEnum.SWAGGER_ERROR.getCode(), HttpCodeEnum.SWAGGER_ERROR.getMsg());
    }

    /**
     * 可请使用静态构造对象再按需变更返回字段值. eg:
     * {@link SwaggerResultUtil#errorCustomer(int, String)};
     */
    public static <T> SwaggerResultUtil<T> resultError(int code, String msg) {
        return new SwaggerResultUtil<T>().error(code, msg);
    }

    /**
     * 可使用静态构造对象再按需变更返回字段值. eg: {@link SwaggerResultUtil#ok()};
     */
    public static <T> SwaggerResultUtil<T> resultSuccess() {
        return new SwaggerResultUtil<T>().success();
    }

    /**
     * 可使用静态构造对象再按需变更返回字段值. eg: {@link SwaggerResultUtil#ok()};
     */
    public static <T> SwaggerResultUtil<T> resultSuccess(Object data) {
        return new SwaggerResultUtil().success(data);
    }

    /**
     * Defines a builder that adds a body to the response entity.
     *
     * @since 4.1
     */
    public interface DataBuilder {

        <T> SwaggerResultUtil<T> build();

        <T> SwaggerResultUtil<T> build(int status);

        <T> SwaggerResultUtil<T> build(int status, String msg);

        <T> SwaggerResultUtil<T> build(int status, String msg, T data);

        <T> SwaggerResultUtil<T> msg(String msg);

        <T> SwaggerResultUtil<T> data(T data);
    }

    /**
     * Create a builder with the given status.
     *
     * @param httpCode the response status
     * @return the created builder
     * @since 4.1
     */
    private static DataBuilder status(HttpCodeEnum httpCode) {
        return new DefaultBuilder(httpCode.getCode(), httpCode.getMsg());
    }

    /**
     * Create a builder with the given status.
     *
     * @param status the response status
     * @return the created builder
     * @since 4.1
     */
    public static DataBuilder status(int status) {
        return new DefaultBuilder(status);
    }

    /**
     * A.SUCCESS 执行成功.
     */
    public static DataBuilder okbuild() {
        return status(HttpCode.SUCCESS);
    }

    /**
     * A.SUCCESS 执行成功.
     */
    public static <T> SwaggerResultUtil<T> ok() {
        DataBuilder builder = okbuild();
        return builder.build();
    }

    /**
     * @param data 设置响应结果中data内容.
     * A.SUCCESS 执行成功.
     */
    public static <T> SwaggerResultUtil<T> ok(T data) {
        DataBuilder builder = okbuild();
        return builder.data(data);
    }

    /**
     * 自定义正常返回
     *
     * @param msg 设置响应结果中msg内容
     */
    public static <T> SwaggerResultUtil<T> okCustomer(String msg) {
        DataBuilder builder = status(HttpCode.SUCCESS);
        return builder.msg(msg);
    }

    /**
     * 自定义正常返回
     *
     * @param msg  设置响应结果中msg内容
     * @param data 结果内容.
     */
    public static <T> SwaggerResultUtil<T> okCustomer(String msg, T data) {
        DataBuilder builder = status(HttpCode.SUCCESS);
        return builder.build(HttpCode.SUCCESS, msg, data);
    }

    /**
     * 自定义错误返回，默认设置为405 参数异常
     *
     * Global.PARAM_ERROR Global.PARAM_ERROR_TEXT
     */
    public static <T> SwaggerResultUtil<T> errorCustomer() {
        return new DefaultBuilder(HttpCodeEnum.SWAGGER_ERROR.getCode()).msg(HttpCodeEnum.SWAGGER_ERROR.getMsg());
    }

    /**
     * 自定义错误返回
     *
     * @param code 设置响应结果中code内容. 参考 Global 中定义设置
     */
    public static <T> SwaggerResultUtil<T> errorCustomer(int code) {
        return new DefaultBuilder(code).build();
    }

    /**
     * 自定义错误返回
     *
     * @see HttpCodeEnum
     */
    public static <T> SwaggerResultUtil<T> errorCustomer(HttpCodeEnum httpCodeEnum) {
        return new DefaultBuilder(httpCodeEnum.getCode()).msg(httpCodeEnum.getMsg());
    }

    /**
     * 自定义错误返回
     *
     * @param code 设置响应结果中code内容. 参考 Global 中定义设置
     * @param msg  设置响应结果中msg内容.
     * A.PARAM_ERROR 执行成功.
     */
    public static <T> SwaggerResultUtil<T> errorCustomer(int code, String msg) {
        return new DefaultBuilder(code).msg(msg);
    }

    /**
     * 自定义错误返回
     *
     * @param code 设置响应结果中code内容. 参考 Global 中定义设置
     * @param msg  设置响应结果中msg内容.
     * @param data    设置响应结果中data内容.
     * A.PARAM_ERROR 执行成功.
     */
    public static <T> SwaggerResultUtil<T> errorCustomer(int code, String msg, T data) {
        return new DefaultBuilder(code).msg(msg);
    }

    /**
     * 响应错误，默认设置为510 参数异常
     */
    public static <T> SwaggerResultUtil<T> errorParam() {
        DataBuilder builder = status(HttpCodeEnum.SWAGGER_ERROR);
        return builder.build();
    }

    /**
     * 响应错误，默认设置为510 参数异常
     *
     * @param msg 设置响应结果中msg内容.
     */
    public static <T> SwaggerResultUtil<T> errorParam(String msg) {
        DataBuilder builder = status(HttpCodeEnum.SWAGGER_ERROR);
        return builder.msg(msg);
    }

    /**
     * 响应错误，用于一般请求错误响应400
     *
     * @param msg 设置响应结果中msg内容.
     */
    public static <T> SwaggerResultUtil<T> error400(String msg) {
        DataBuilder builder = status(HttpCodeEnum.BAD_REQUIRED_ERROR);
        return builder.msg(msg);
    }

    /**
     * 响应错误，用于一般请求错误响应400
     *
     * A.BAD_REQUIRED_ERROR
     */
    public static <T> SwaggerResultUtil<T> error400() {
        DataBuilder builder = status(HttpCodeEnum.BAD_REQUIRED_ERROR);
        return builder.build();
    }

    /**
     * 响应错误，用于严重错误响应500
     *
     * @param msg 设置响应结果中msg内容.
     * A.INTERNAL_SERVER_ERROR
     */
    public static <T> SwaggerResultUtil<T> error500(String msg) {
        DataBuilder builder = status(HttpCodeEnum.INTERNAL_SERVER_ERROR);
        return builder.msg(msg);
    }

    /**
     * 响应错误，用于严重错误响应500
     *
     * A.INTERNAL_SERVER_ERROR
     */
    public static <T> SwaggerResultUtil<T> error500() {
        DataBuilder builder = status(HttpCodeEnum.INTERNAL_SERVER_ERROR);
        return builder.build();
    }

    /**
     * 响应错误，用于一般错误响应400
     *
     * A.BAD_REQUIRED_ERROR
     */
    public static <T> SwaggerResultUtil<T> errorBadRequest() {
        DataBuilder builder = status(HttpCodeEnum.BAD_REQUIRED_ERROR);
        return builder.build();
    }

    /**
     * 响应错误，用于一般错误响应400
     *
     * @param msg 设置响应结果中msg内容.
     * A.BAD_REQUIRED_ERROR
     */
    public static <T> SwaggerResultUtil<T> errorBadRequest(String msg) {
        DataBuilder builder = status(HttpCodeEnum.BAD_REQUIRED_ERROR);
        return builder.msg(msg);
    }


    private static class DefaultBuilder implements DataBuilder {

        private int code;

        private String msg;

        public DefaultBuilder(int code) {
            this.code = code;
        }

        public DefaultBuilder(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        @Override
        public <T> SwaggerResultUtil<T> build() {
            return data(null);
        }

        @Override
        public <T> SwaggerResultUtil<T> build(int status) {
            return new SwaggerResultUtil<T>(null, status);
        }

        @Override
        public <T> SwaggerResultUtil<T> data(T data) {
            return new SwaggerResultUtil<T>(this.code, null, this.msg, data);
        }

        @Override
        public <T> SwaggerResultUtil<T> msg(String msg) {
            return new SwaggerResultUtil<T>(this.code, null, msg, null);
        }

        @Override
        public <T> SwaggerResultUtil<T> build(int status, String msg) {
            return new SwaggerResultUtil<T>(status, null, msg, null);
        }

        @Override
        public <T> SwaggerResultUtil<T> build(int status, String msg, T data) {
            return new SwaggerResultUtil<T>(status, null, msg, data);
        }
    }

}

