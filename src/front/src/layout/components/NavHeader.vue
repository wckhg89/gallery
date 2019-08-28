<template>
    <el-menu default-active="1" class="el-menu-demo" mode="horizontal" active-text-color="#F56C6C">
        <el-submenu index="1">
            <template slot="title">Gallery</template>
            <el-menu-item v-for="episode in episodes" :index="episode.episodeId">
                <router-link :to="episode.episodePath">{{episode.episodeName}}</router-link>
            </el-menu-item>
        </el-submenu>
        <el-menu-item>
            <el-divider direction="vertical"></el-divider>
        </el-menu-item>
        <el-menu-item index="2">
            <router-link to="/guestbook">GuestBook</router-link>
        </el-menu-item>
    </el-menu>
</template>

<script>
    export default {
        name: "NavHeader",
        data() {
            return {
                episodes: [
                    {
                        episodeId: '1-1',
                        episodePath: '/episode/1',
                        episodeName: 'Episode 1',
                        episodeDescription: '첫번째 에피소드',
                    },
                    {
                        episodeId: '1-2',
                        episodePath: '/episode/2',
                        episodeName: 'Episode 2',
                        episodeDescription: '두번째 에피소드',
                    },

                ]
            }
        },

        created () {
            // TODO: API 호출
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