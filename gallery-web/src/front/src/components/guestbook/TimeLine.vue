<template>
    <el-timeline
            v-infinite-scroll="load"
            infinite-scroll-disabled="disabled">
        <el-timeline-item
                v-for="i in count"
                timestamp="2018/4/12" placement="top" color="#F56C6C">
            <el-card>
                <h4>Update Github template</h4>
                <p>Tom committed 2018/4/12 20:46</p>
            </el-card>
        </el-timeline-item>
    </el-timeline>
</template>

<script>
    export default {
        name: "TimeLine"
    }
</script>

<style scoped>

</style>