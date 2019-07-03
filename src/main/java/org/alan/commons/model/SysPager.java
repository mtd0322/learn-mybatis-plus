package org.alan.commons.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SysPager<T> implements Serializable {


    /**
     * @Description 当前页数
     */
    private int pageNum;
    /**
     * @Description 当前页需要显示的数量
     */
    private int pageSize;
    /**
     * @Description 当前页数目
     */
    private int size;

    /**
     * @Description 总条数
     */
    private long total;
    /**
     * @Description 总页数
     */
    private int pages;
    /**
     * @Description 数据
     */
    private List<T> list;

    /**
     * @Description 处理返回结果
     */
    private Integer code=0;
    private String msg="成功";

}
