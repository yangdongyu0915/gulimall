package com.ydy.gulimall.product.entity.vo;

import com.ydy.gulimall.product.entity.AttrEntity;
import lombok.Data;

/**
 * @author hl
 * @Data 2020/7/25
 */
@Data
public class AttrVo extends AttrEntity {
    /**
     * 属性分组id
     */
    private Long attrGroupId;
}
