<template>
    <el-menu class="el-menu-demo nav-style"
             v-bind:style="{width : navWidth}"
             mode="horizontal"
             :router="true"
             :default-active="$route.path"
             active-text-color="#F56C6C"
    >
        <el-menu-item index="/">
            <i class="el-icon-s-home"></i>
        </el-menu-item>
        <el-submenu index="/episode">
            <template slot="title">Gallery</template>
            <el-menu-item v-for="episode in episodes" :index="episode.episodePath">{{episode.episodeName}}</el-menu-item>
        </el-submenu>
        <el-menu-item index="/guestbook">GuestBook</el-menu-item>
        <el-menu-item index="/location">Location</el-menu-item>
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

    li {
        float: none !important;
        display: inline-block;
    }
    li a {
        text-decoration: none;
        color: #909399
    }
</style>