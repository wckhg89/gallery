<template>
    <el-container direction="vertical">
        <el-header>
            <nav-header></nav-header>
        </el-header>
        <el-main>
            <router-view></router-view>
        </el-main>
        <el-footer height="35px">ⓒ 2020. guppy.kang All Rights Reserved</el-footer>
    </el-container>
</template>

<style scoped>
    main {
        margin-bottom: 5%;
    }
    footer {
        font-size: 5px;
        position: fixed;
        bottom: 0;
        width: 100%;
        background: #f9fafa;
        border-top: 1px solid #eef0f0 !important;
        display: block;
        text-align: center;
        padding: 10px 0;
    }
</style>

<script>
    import NavHeader from './components/NavHeader'

    export default {
        name: 'Layout',
        components: {
            NavHeader,
        }
    };
</script>