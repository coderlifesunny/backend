package com.lifesunny.modules.dec.param.project.materials;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description:
 *
 * @Author Guangcai.xu
 * @Date 2018/12/4 17:41
 */
@Data
@NoArgsConstructor
public class ItemParam {
    /**
     * position: '餐客厅', brand: '', standard: '', modal: '', remark: ''
     */
    private String position;
    private String brand;
    private String standard;
    private String modal;
    private String remark;
}