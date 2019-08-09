<template>
    <el-container direction="vertical">
        <el-header>
            <nav-header></nav-header>
        </el-header>
        <el-main>
            <router-view></router-view>
        </el-main>
    </el-container>
</template>

<style scoped>
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