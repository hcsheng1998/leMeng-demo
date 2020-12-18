package com.nhsoft.ledemo.util;

import com.nhsoft.ledemo.dto.ResponseMessageDTO;

/**
 * @author heChangSheng
 * @date 2020/12/11 : 9:20
 */
public class ResponseUtil {

    /**
     * 数据错误返回信息
     * @return
     */
    public static ResponseMessageDTO dataFalse() {

        return new ResponseMessageDTO(StatusCodeEnum.DATAEXCEPTION.getCode(),StatusCodeEnum.DATAEXCEPTION.getMessage());
    }

    /**
     * 查询成功返回数据
     * @return
     */
    public static ResponseMessageDTO opeSuc(Object o) {

        return new ResponseMessageDTO(StatusCodeEnum.SUCCESS.getCode(), StatusCodeEnum.SUCCESS.getMessage(), o);
    }

    /**
     * 操作成功返回数据
     * @return
     */
    public static ResponseMessageDTO opeSuc() {

        return new ResponseMessageDTO(StatusCodeEnum.SUCCESS.getCode(), StatusCodeEnum.SUCCESS.getMessage());
    }

    /**
     * 操作失败返回数据
     * @return
     */
    public static ResponseMessageDTO opeFail() {

        return new ResponseMessageDTO(StatusCodeEnum.FAIL.getCode(), StatusCodeEnum.FAIL.getMessage());
    }
}
