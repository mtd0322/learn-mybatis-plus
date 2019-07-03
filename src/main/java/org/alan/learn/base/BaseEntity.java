package org.alan.learn.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;
import org.alan.commons.annotation.audit.CreatedBy;
import org.alan.commons.annotation.audit.CreatedDate;
import org.alan.commons.annotation.audit.LastModifiedBy;
import org.alan.commons.annotation.audit.LastModifiedDate;
import java.util.Date;

/**
 * @program: learn-mybatis-plus
 * @ClassName: BaseEntity
 * @description: 基础试题
 * @author: AlanMa
 * @create: 2019-05-07 18:54
 */
@Data
public abstract class BaseEntity{

    @CreatedBy
    private String createdBy;

    @CreatedDate
    private Date createdDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private Date ModifiedDate;

    @JSONField(serialize = false)
    @Version
    private long version;
}