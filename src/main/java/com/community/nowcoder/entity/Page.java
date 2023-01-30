package com.community.nowcoder.entity;

public class Page {
    private int current = 1; //当前页码
    private int limit = 10; // 当前页面大小
    private String path; // 复用路径
    private int rows;   // 数据总条数

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit >= 1 && limit <= 100){
            this.limit = limit;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getOffset(){
        return (this.current - 1) * this.limit;
    }

    public int getTotal(){
        if(this.rows % this.limit == 0){
            return this.rows / this.limit;
        }
        else{
            return this.rows / this.limit + 1;
        }
    }

    public int getFrom(){
        return Math.max(this.current - 2, 1);
    }

    public int getTo(){
        return Math.min(this.current + 2, this.getTotal());
    }

}
