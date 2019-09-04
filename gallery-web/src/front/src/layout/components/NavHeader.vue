<template>
    <el-menu class="el-menu-demo" mode="horizontal" active-text-color="#F56C6C">
        <el-submenu index="1">
            <template slot="title">Gallery</template>
            <el-menu-item v-for="episode in episodes" :index="episode.episodeId">
                <router-link :to="episode.episodePath">{{episode.episodeName}}</router-link>
            </el-menu-item>
        </el-submenu>
        <el-menu-item index="2">
            <el-divider direction="vertical"></el-divider>
        </el-menu-item>
        <el-menu-item index="3">
            <router-link to="/guestbook">GuestBook</router-link>
        </el-menu-item>
    </el-menu>
</template>

<script>
    export default {
        name: "NavHeader",
        data() {
            return {
                episodes: []
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

        created () {
            this.fetchData()
        }
    }
</script>

<style scoped>
    li a {
        text-decoration: none;
        color: #909399
    }
    .router-link-active {
        color: #F56C6C !important;
    }

    .router-link-exact-active {
        color: #F56C6C !important;
    }
</style>