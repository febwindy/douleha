package com.douleha.www.utils.type.api;

import java.util.List;

/**
 * Created by ivan_ on 2015/9/1.
 */
public class ApiPagination<T> {

    private int pageSize;
    private int page;
    private List<T> result;

    public ApiPagination() {
        super();
    }

    public ApiPagination(int pageSize, int page, List<T> result) {
        this();
        this.pageSize = pageSize;
        this.page = page;
        this.result = result;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
