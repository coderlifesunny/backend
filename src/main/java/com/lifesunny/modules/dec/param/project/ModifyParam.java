package com.lifesunny.modules.dec.param.project;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 修改操作的param
 *
 * @Author Guangcai.xu
 * @Date 2018/12/6 14:45
 */
@Data
@NoArgsConstructor
public class ModifyParam extends ProjectOperateParam {
    private Integer id;

    private Integer status;
}