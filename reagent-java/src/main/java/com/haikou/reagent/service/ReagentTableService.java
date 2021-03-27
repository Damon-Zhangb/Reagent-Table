package com.haikou.reagent.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haikou.reagent.mapper.ReagentTableMapper;
import com.haikou.reagent.pojo.ReagentTable;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 试剂订单 服务类
 * </p>
 *
 * @author 章卜
 * @since 2021-03-24
 */
public interface ReagentTableService extends IService<ReagentTable> {



    /**
     * 分页
     * @param page
     * @return
     */
    IPage<ReagentTable> selectAll(Page<ReagentTable> page);
}
