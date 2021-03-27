package com.haikou.reagent.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haikou.reagent.pojo.ReagentTable;
import com.haikou.reagent.mapper.ReagentTableMapper;
import com.haikou.reagent.service.ReagentTableService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 试剂订单 服务实现类
 * </p>
 *
 * @author 章卜
 * @since 2021-03-24
 */
@Service
public class ReagentTableServiceImpl extends ServiceImpl<ReagentTableMapper, ReagentTable> implements ReagentTableService {

    @Autowired
    ReagentTableMapper mapper;


    @Override
    public IPage<ReagentTable> selectAll(Page<ReagentTable> page) {
        return mapper.selectPage(page,null);
    }
}
