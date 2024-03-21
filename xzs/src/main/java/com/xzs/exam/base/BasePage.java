package com.xzs.exam.base;

/**
 * 页数相关函数
 */
public class BasePage {

    private Integer pageIndex;

    private Integer pageSize;

    /**
     * 获取页码
     * @return pageIndex
     */
    public Integer getPageIndex() { return pageIndex; }

    /**
     * 设置页码
     */
    public void setPageIndex(Integer pageIndex) { this.pageIndex = pageIndex; }

    /**
     * 获取页数
     */
    public Integer getPageSize() { return pageSize; }

    /**
    设置页数
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
