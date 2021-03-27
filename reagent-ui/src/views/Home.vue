<template>
  <div class="home">
    <el-container>
      <el-header>智能试剂箱管理系统</el-header>
      <el-main>
        <el-table
          :data="tableData"
          style="width: 100%"
          stripe
          border
          :default-sort="{ prop: 'date', order: 'descending' }"
        >
          <el-table-column type="expand">
            <template slot-scope="scope">
              <el-form label-position="left" inline class="demo-table-expand">
                <el-form-item label="设备ID">
                  <span>{{ scope.row.equipmentId }}</span>
                </el-form-item>
                <el-form-item label="试剂纯度">
                  <span>{{ scope.row.reagentPurity }}</span>
                </el-form-item>
                <el-form-item label="试剂含量">
                  <span>{{ scope.row.reagentContent }}</span>
                </el-form-item>
                <el-form-item label="试剂密度">
                  <span>{{ scope.row.reagentDensity }}</span>
                </el-form-item>
                <el-form-item label="试剂危险">
                  <span>{{ scope.row.reagentDanger }}</span>
                </el-form-item>
                <el-form-item label="试剂重量">
                  <span>{{ scope.row.reagentWeight }}</span>
                </el-form-item>
                <el-form-item label="试剂单价">
                  <span>{{ scope.row.reagentPrice }}</span>
                </el-form-item>
                <el-form-item label="生产厂家">
                  <span>{{ scope.row.manufacturer }}</span>
                </el-form-item>
                <el-form-item label="供货商家">
                  <span>{{ scope.row.supplierName }}</span>
                </el-form-item>
                <el-form-item label="商家电话">
                  <span>{{ scope.row.supplierPhone }}</span>
                </el-form-item>
                <el-form-item label="图像1">
                  <el-image
                    style="width: 100px; height: 100px"
                    :src="getImgSrc(scope.row.image1)"
                    height="70"
                    :preview-src-list="[getImgSrc(scope.row.image1)]"
                  />
                </el-form-item>
                <el-form-item label="图像2">
                  <el-image
                    style="width: 100px; height: 100px"
                    :src="getImgSrc(scope.row.image2)"
                    height="70"
                    :preview-src-list="[getImgSrc(scope.row.image2)]"
                  />
                </el-form-item>
                <el-form-item label="图像3">
                  <el-image
                    style="width: 100px; height: 100px"
                    :src="getImgSrc(scope.row.image3)"
                    height="70"
                    :preview-src-list="[getImgSrc(scope.row.image3)]"
                  />
                </el-form-item>
                <el-form-item label="试剂二维码">
                  <el-image
                    style="width: 100px; height: 100px"
                    :src="getImgSrc(scope.row.qrImage)"
                    height="70"
                    :preview-src-list="[getImgSrc(scope.row.qrImage)]"
                  />
                </el-form-item>
              </el-form>
            </template>
          </el-table-column>
          <el-table-column
            label="日期"
            prop="createTime"
            align="center"
            width="170"
            sortable
          ></el-table-column>
          <el-table-column
            label="试剂ID"
            prop="reagentId"
            align="center"
            width="100"
            sortable
          ></el-table-column>
          <el-table-column
            label="试剂名称"
            prop="reagentName"
            align="center"
          ></el-table-column>
          <el-table-column
            label="订单类型"
            prop="orderType"
            align="center"
          ></el-table-column>
          <el-table-column
            label="入库员工号"
            prop="operatorId"
            align="center"
            width="120"
            sortable
          ></el-table-column>
          <el-table-column
            label="入库员姓名"
            prop="operatorName"
            align="center"
          ></el-table-column>
        </el-table>
        <el-pagination
          class="pagination"
          background
          :total="totalCount"
          :current-page="currentPage"
          :page-size="pageSize"
          @current-change="handleCurrentChange"
          layout="total,prev,pager,next"
        ></el-pagination>
      </el-main>
      <el-footer>
        <el-divider><i class="el-icon-share"></i></el-divider>
        <a class="banquan">© 2021/</a>
        <el-link href="http://github.com/Damon-Zhangb" type="primary"
          >GitHub</el-link
        >
        <a class="banquan">/</a>
        <el-link
          href="http://github.com/Damon-Zhangb/reagent-table"
          type="primary"
          >ReagentTable</el-link
        >
      </el-footer>
    </el-container>
  </div>
</template>

<style>
body {
  margin-bottom: 40px;
  margin-top: 0px;
  margin-left: 0px;
  margin-right: 0px;
  padding: 0px;
}
.el-header {
  background-color: darkslategray;
  color: white;
  text-align: center;
  line-height: 70px;
  margin-top: 0%;
}
.pagination {
  margin-top: 10px;
  float: right;
}
.banquan {
  font-size: 14px;
}
.el-footer {
  text-align: center;
}
.demo-table-expand {
  font-size: 0;
}
.demo-table-expand label {
  width: 90px;
  color: #99a9bf;
}
.demo-table-expand .el-form-item {
  margin-right: 0;
  margin-bottom: 0;
  width: 50%;
}
</style>

<script>
import axios from "axios";
export default {
  name: "Home",
  data() {
    return {
      tableData: [],
      pageSize: 15,
      currentPage: 1,
      totalCount: 1,
    };
  },
  created() {
    this.getData();
  },
  methods: {
    getData() {
      axios
        .get(
          "http://127.0.0.1:10086/reagentTable/selectAll?page=" +
            this.currentPage
        )
        .then((res) => {
          if (res.data.code == 200) {
            this.tableData = res.data.data.records;
            this.currentPage = res.data.data.current;
            this.totalCount = res.data.data.total;
          }
        })
        .catch((err) => {
          console.error(err);
        });
    },
    handleCurrentChange(page) {
      this.currentPage = page;
      this.getData();
    },
  },
};
</script>


