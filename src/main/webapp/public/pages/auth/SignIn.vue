<template>
    <div>
        <div>this is template body abc</div>
        <div>{{msg}}</div>

        <el-row :gutter="20">
            <el-col :span="6">
                <el-input
                        placeholder="请输入内容"
                        v-model="input">
                </el-input>
            </el-col>
            <el-col :span="6">
                <el-input placeholder="请输入内容" v-model="input3">
                    <template slot="prepend">Http://</template>
                </el-input>
            </el-col>
            <el-col :span="6">
                <el-select v-model="select">
                    <el-option label="餐厅名" value="1"></el-option>
                    <el-option label="订单号" value="2"></el-option>
                    <el-option label="用户电话" value="3"></el-option>
                </el-select>
            </el-col>
            <el-col :span="6"><div class="grid-content bg-purple-light"></div></el-col>
        </el-row>



    </div>
</template>
<style>

</style>
<script>
    export default{
        data(){
            return{
                msg:'hello vue haha EFGHIGJ'
            }
        },
        components:{

        }
    }
</script>
