package com.lifesunny.modules.dec.param.project.materials;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Description: 材料参数
 *
 * @Author Guangcai.xu
 * @Date 2018/12/4 17:37
 */
@Data
@NoArgsConstructor
public class MaterialParam {
    private List<ItemParam> brick;
    private List<ItemParam> floor;
    private List<ItemParam> door;
    private List<ItemParam> cupboard;
    private List<ItemParam> wc;
    private List<ItemParam> stone;
    private List<ItemParam> ceiling;
    private List<ItemParam> paint;
    private List<ItemParam> plaster;
    private List<ItemParam> wallpaper;
    private List<ItemParam> wardrobe;
}