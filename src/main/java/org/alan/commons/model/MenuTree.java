package org.alan.commons.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @program: learn-more
 * @ClassName: MenuTree
 * @description: 菜单树
 * @author: AlanMa
 * @create: 2019-04-24 12:47
 */
@NoArgsConstructor
@Data
public class MenuTree<T> {

    private String path;
    private String icon;
    private String title;
    private String name;
    private Long menuId;
    private List<T> children;
}