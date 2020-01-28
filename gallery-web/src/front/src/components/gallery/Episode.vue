<template>
    <div :v-loading=loading style="">
        <Waterfall :gutterWidth="10"
                   :gutterHeight="10"
                   :minCol="2"
                   :maxCol="8"
                   :resizable="true"
        >
            <WaterfallItem v-for="item in episode.images" :key="item.idx"
                           :width="150"
                           class="item fadeIn animated">
                <router-link :to="item.imagePath">
                    <img :src="item.src" alt="이미지 없음">
                </router-link>
            </WaterfallItem>
        </Waterfall>
    </div>
</template>

<script>
    import {Waterfall, WaterfallItem} from 'vue2-waterfall';

    export default {
        name: "Episode",
        components: {
            Waterfall,
            WaterfallItem
        },
        data() {
            return {
                loading: true,
                episode : {},
                itemWidth: undefined,
            }
        },
        methods: {
            fetchData() {
                this.loading = true;
                this.$store.dispatch('getEpisodeDetail', this.$route.params.id).then(() => {
                    this.episode = this.$store.state.episode.detail;
                }).then(() => {
                    this.setImagePath();
                });
                setTimeout(() => {
                    this.loading =false;
                }, 500);
            },

            setImagePath () {
                this.episode.images.map((it) => {
                    it.imagePath = this.$route.path + it.imagePath;
                })
            }
        },

        beforeRouteUpdate (to, from, next) {
            next();
            this.fetchData();
        },

        mounted() {
            this.fetchData();
        },
    }
</script>

<style scoped>
    * {
        padding: 0;
        margin: 0;
    }
    .item img {
        border-radius: 5px;
        width: 100%;
        display: block;
    }
    @-webkit-keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 10;
        }
    }
    @keyframes fadeIn {
        from {
            opacity: 0;
        }
        to {
            opacity: 10;
        }
    }

    .animated {
        -webkit-animation-duration: 3s;
        animation-duration: 3s;
        -webkit-animation-fill-mode: both;
        animation-fill-mode: both;
        -webkit-animation-direction: normal;
        animation-direction: normal;
    }
    .fadeIn {
        -webkit-animation-name: fadeIn;
        animation-name: fadeIn;
    }
</style>