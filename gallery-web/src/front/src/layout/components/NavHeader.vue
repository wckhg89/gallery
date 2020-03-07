<template>
    <el-menu class="el-menu-demo nav-style"
             v-bind:style="{width : navWidth}"
             mode="horizontal"
             :router="true"
             :default-active="$route.path"
             active-text-color="#F56C6C"
    >
        <el-menu-item index="/" class="root-menu">
            <i class="el-icon-s-home"></i>
        </el-menu-item>
        <el-submenu index="/episode">
            <template slot="title">갤러리</template>
            <el-menu-item v-for="episode in episodes" :index="episode.episodePath">{{episode.episodeName}}</el-menu-item>
        </el-submenu>
        <el-menu-item index="/guestbook" class="root-menu">방명록</el-menu-item>
        <el-menu-item index="/location" class="root-menu">오시는길</el-menu-item>
    </el-menu>
</template>

<script>
    export default {
        name: "NavHeader",
        data() {
            return {
                episodes: [],
                navWidth: '0px',
            }
        },

        methods: {
            fetchData() {
                this.$store.dispatch('getEpisodeInfos').then(() => {
                    this.episodes = this.$store.state.episode.info;
                });
                this.navWidth = window.innerWidth + 'px';
            },
        },

        beforeRouteUpdate (to, from, next) {
            next();
            this.fetchData();
        },

        mounted() {
            this.fetchData();

        }
    }
</script>

<style scoped>
    .nav-style {
        margin-left: -10px;
        overflow-x: auto;
        white-space:nowrap;
        display: inline-block;
    }

    root-menu li {
        float: none !important;
        display: inline-block;
    }
    li a {
        text-decoration: none;
        color: #909399
    }
</style>