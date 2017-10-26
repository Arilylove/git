package com.laison.common.sql;

import java.util.LinkedHashMap;

public class Query {
	private static final long serialVersionUID = 1L;
	//当前页码
    private int page=1;
    //每页条数
    private int limit=10;

    public int getPage() {
        return page>1?page:1;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}