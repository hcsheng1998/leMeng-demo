package com.nhsoft.ledemo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author heChangSheng
 * @date 2020/12/10 : 16:54
 */
@ApiModel("分页数据")
public class PagingDTO implements Serializable {

    private static final long serialVersionUID = 9107353203645156826L;

    @ApiModelProperty(value = "分页数据起始位置",example = "0")
    public int page = 0;

    @ApiModelProperty(value = "每页分成多少个",example = "5")
    public int size = 5;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "PagingDTO{" +
                "page=" + page +
                ", size=" + size +
                '}';
    }
}
