package com.douleha.www.utils.type.command;

/**
 * Created by ivan_ on 2015/9/1.
 */
public class PaginationCommand extends AbstractCommand {

    private final static int DEFAULT_PAGE_SIZE = 10;
    private final static int DEFAULT_PAGE = 1;

    private int pageSize;
    private int page;

    public PaginationCommand() {
        this.page = DEFAULT_PAGE;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    public PaginationCommand(int pageSize, int page) {
        this.pageSize = pageSize;
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        if (null == pageSize) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        }
        try {
            this.pageSize = Integer.parseInt(pageSize);
            if (this.pageSize < 0) {
                this.pageSize = DEFAULT_PAGE_SIZE;
            }
        } catch (NumberFormatException e) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(String page) {
        if (null == page) {
            this.page = DEFAULT_PAGE;
        }
        try {
            this.page = Integer.parseInt(page);
            if (this.page < 0) {
                this.page = DEFAULT_PAGE;
            }
        } catch (NumberFormatException e) {
            this.page = DEFAULT_PAGE;
        }
    }

}
