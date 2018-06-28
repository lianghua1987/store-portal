package com.hua.store.portal.pojo;

import java.util.List;

public class SearchResult {

    private List<Item> items;

    private long totalCount;

    private long totalPages;

    private long currentPage;

    public SearchResult() {
    }

    public SearchResult(List<Item> items, long totalCount, long totalPages, long currentPage) {
        this.items = items;
        this.totalCount = totalCount;
        this.totalPages = totalPages;
        this.currentPage = currentPage;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }

    public long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(long currentPage) {
        this.currentPage = currentPage;
    }
}
