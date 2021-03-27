package com.haikou.reagent.controller;



import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.haikou.reagent.pojo.ReagentTable;
import com.haikou.reagent.pojo.ResultVO;
import com.haikou.reagent.service.ReagentTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * <p>
 * 试剂订单 前端控制器
 * </p>
 *
 * @author 章卜
 * @since 2021-03-24
 */
@RestController
@RequestMapping("/reagentTable")
public class ReagentTableController {

    @Autowired
    ReagentTableService service;

    @GetMapping("/selectAll")
    public ResultVO<IPage<ReagentTable>> selectAll(@RequestParam("page") int currentPage){
        IPage<ReagentTable> page = service.selectAll(new Page<ReagentTable>(currentPage,15));

         return new ResultVO<IPage<ReagentTable>>(page);
    }

    @PostMapping("/add")
    public ResultVO<Boolean> add(@RequestBody ReagentTable reagent){
        Boolean flag = service.save(reagent);
        return new ResultVO<Boolean>(flag);
    }

}

