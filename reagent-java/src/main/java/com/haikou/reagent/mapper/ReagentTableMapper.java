package com.haikou.reagent.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haikou.reagent.pojo.ReagentTable;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 试剂订单 Mapper 接口
 * </p>
 *
 * @author 章卜
 * @since 2021-03-24
 */
@Mapper
@Repository
public interface ReagentTableMapper extends BaseMapper<ReagentTable> {

}
