package com.daniu.nz.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 列表分页
 */
public class Pagination<E> implements Serializable {

    private static final long serialVersionUID = 7212683632408653278L;

    /** 总条数 */
    private int totalRows;

    /** 每页显示的条数 */
    private int pageSize;

    /** 当前页码 */
    private int currentPage;

    /** 总页数 */
    private int totalPages;

    /** 起始条数 */
    private int index;

    /** 存放数据列表 */
    private List<E> datas;

    /**
     * @param sum 记录总条数
     * @param pageNo 当前页码
     * @param size 每页条数
     */
    public Pagination(int sum, int pageNo, int size) {
        totalRows = sum;
        if (sum > 0) {
            totalPages = (int) Math.ceil((double) sum / (double) size);
            if (pageNo <= 0) {
                pageNo = 1;
            }
            if (pageNo > totalPages) {
                currentPage = totalPages;
            } else {
                currentPage = pageNo;
            }
        } else {
            totalPages = 1;
            currentPage = 1;
        }
        index = (currentPage - 1) * size;
    }

    /**
     * 空页面
     */
    public Pagination() {
        this(0, 1, 1);
        datas = new ArrayList<E>();
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int size) {
        pageSize = size;
        if (totalRows > 0) {
            totalPages = (int) Math.ceil((double) totalRows / (double) size);
            index = (currentPage - 1) * pageSize;
        }
        System.out.println(totalPages);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<E> getDatas() {
        return datas;
    }

    public void setDatas(List<E> datas) {
        this.datas = datas;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
