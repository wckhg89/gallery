<template>
    <el-menu class="el-menu-demo"
             mode="horizontal"
             :router="true"
             :default-active="$route.path"
             active-text-color="#F56C6C">
        <el-menu-item index="/">Home</el-menu-item>
        <el-submenu index="/episode">
            <template slot="title">Gallery</template>
            <el-menu-item v-for="episode in episodes" :index="episode.episodePath">{{episode.episodeName}}</el-menu-item>
        </el-submenu>
        <el-menu-item index="/guestbook">GuestBook</el-menu-item>
    </el-menu>
</template>

<script>
    export default {
        name: "NavHeader",
        data() {
            return {
                episodes: [],
            }
        },

        methods: {
            fetchData() {
                this.$store.dispatch('getEpisodeInfos').then(() => {
                    this.episodes = this.$store.state.episode.info;
                });
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
    li a {
        text-decoration: none;
        color: #909399
    }

    /*.router-link-exact-active {*/
    /*    color: #F56C6C !important;*/
    /*}*/
</style>