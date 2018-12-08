package com.lifesunny.modules.dec.vo;

import com.lifesunny.modules.dec.entity.ProjectEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 仪表盘上展示的项目信息
 *
 * @Author Guangcai.xu
 * @Date 2018/12/6 17:27
 */
@Data
@NoArgsConstructor
public class DashboardVO {
    /**
     * 按工地阶段进行统计
     */
    private List<StageStatistics> byStages = new ArrayList<>();

    /**
     * 按设计师进行统计（只统计前三）
     */
    private List<DesignerStatistics> byDesigners = new ArrayList<>();

    /**
     * 按阶段进行工地统计
     */
    @Data
    @NoArgsConstructor
    class StageStatistics {
        //0：未开工 1：施工中 2：已竣工
        private Integer status;

        private String statusName;

        private Integer count;
    }

    /**
     * 按设计师进行统计
     */
    @Data
    @NoArgsConstructor
    class DesignerStatistics {
        private String designerName;
        private String count;
    }

    public DashboardVO build(List<ProjectEntity> list) {
        if (CollectionUtils.isEmpty(list)) {
            return this;
        }
        return this;
    }
}