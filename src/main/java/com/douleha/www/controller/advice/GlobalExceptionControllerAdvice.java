package com.douleha.www.controller.advice;

import com.douleha.www.controller.exception.*;
import com.douleha.www.controller.shared.BaseApiController;
import com.douleha.www.utils.type.api.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by ivan_ on 2015/8/26.
 * 控制器增强
 * 用于处理异常，并根据异常返回不同的httpStatus
 */
@ControllerAdvice
public class GlobalExceptionControllerAdvice extends BaseApiController {

    /**
     * 用户发出的请求有错误，服务器没有进行新建或修改数据的操作，抛出该异常，并把httpStatus置为400
     * @param ex
     * @return
     */
    @ExceptionHandler(InvalidRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ApiResponse invalidRequestException(InvalidRequestException ex) {
        convertToReadableForApiResponse(ex.getApiResponse());
        return ex.getApiResponse();
    }

    /**
     * 表示用户没有权限（令牌、用户名、密码错误），抛出该异常，并把httpStatus置为401
     * @param ex
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ApiResponse unAuthorizationException(UnauthorizedException ex) {
        convertToReadableForApiResponse(ex.getApiResponse());
        return ex.getApiResponse();
    }

    /**
     * 表示用户得到授权（与401错误相对），但是访问是被禁止的，抛出该异常，并把httpStatus置为403
     * @param ex
     * @return
     */
    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ApiResponse forbiddenException(ForbiddenException ex) {
        convertToReadableForApiResponse(ex.getApiResponse());
        return ex.getApiResponse();
    }

    /**
     * 用户发出的请求针对的是不存在的记录，服务器没有进行操作，抛出该异常，并把httpStatus置为404
     * @param ex
     * @return
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ApiResponse notFoundException(NotFoundException ex) {
        convertToReadableForApiResponse(ex.getApiResponse());
        return ex.getApiResponse();
    }

    /**
     * 用户发出的请求是一个不存在的方法时，服务器没有进行操作，抛出该异常，并把httpStatus置为405
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodNotAllowedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ResponseBody
    public ApiResponse notFoundException(MethodNotAllowedException ex, HttpServletRequest request) {
        Object[] params = new Object[]{request.getMethod()};
        convertToReadableForApiResponse(ex.getApiResponse(), params);
        return ex.getApiResponse();
    }

    /**
     * 用户请求的格式不可得（比如用户请求JSON格式，但是只有XML格式），抛出该异常，并把httpStatus置为406
     * @param ex
     * @return
     */
    @ExceptionHandler(NotAcceptableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public ApiResponse notAcceptableException(NotAcceptableException ex) {
        convertToReadableForApiResponse(ex.getApiResponse());
        return ex.getApiResponse();
    }

    /**
     * 用户请求的资源被永久删除，且不会再得到的，抛出该异常，并把httpStatus置为410
     * @param ex
     * @return
     */
    @ExceptionHandler(GoneException.class)
    @ResponseStatus(HttpStatus.GONE)
    @ResponseBody
    public ApiResponse goneException(GoneException ex) {
        convertToReadableForApiResponse(ex.getApiResponse());
        return ex.getApiResponse();
    }

    /**
     * 当创建一个对象时，发生一个验证错误，抛出该异常，并把httpStatus置为422
     * @param ex
     * @return
     */
    @ExceptionHandler(UnprocessedEntityException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ResponseBody
    public ApiResponse unprocessedEntityException(UnprocessedEntityException ex) {
        convertToReadableForApiResponse(ex.getApiResponse());
        return ex.getApiResponse();
    }

    /**
     * 服务器发生错误，用户将无法判断发出的请求是否成功，抛出该异常，并把httpStatus置为500
     * @param ex
     * @return
     */
    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ApiResponse internalServerException(InternalServerException ex) {
        convertToReadableForApiResponse(ex.getApiResponse());
        return ex.getApiResponse();
    }

}
