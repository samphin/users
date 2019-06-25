package cn.sq.users.core.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页参数对象
 */
@ApiModel(value = "分页查询对象")
public class PageParam {

    @ApiModelProperty(value = "页码", notes = "页码", required = true, dataType = "Integer")
    private int pageNum;

    @ApiModelProperty(value = "页大小", notes = "页大小", required = true, dataType = "Integer")
    private int pageSize;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
