<template>
    <el-container direction="vertical">
        <el-header>
            <nav-header></nav-header>
        </el-header>
        <el-main>
            <router-view></router-view>
        </el-main>
        <el-footer>Guppy</el-footer>
    </el-container>
</template>

<style scoped>
    footer {
        position: absolute;
        left: 0;
        bottom: 0;
        background: #f9fafa;
        border-top: 1px solid #eef0f0 !important;
        margin-top: -1px;
        display: block;
        text-align: center;
        padding: 13px 0;
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