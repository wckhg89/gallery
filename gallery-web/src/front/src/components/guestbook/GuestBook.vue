<template>
    <div class="block">
        <el-button icon="el-icon-edit" circle @click="open"></el-button>
        <el-timeline
                v-infinite-scroll="load"
                infinite-scroll-disabled="disabled"
                infinite-scroll-distance="10"
        >
            <el-timeline-item
                    v-for="(guestBook, idx) in guestBooks"
                    :timestamp="guestBook.createdDate" placement="top" color="#F56C6C">
                <el-card>
                    <h4>{{guestBook.content}}</h4>
                </el-card>
            </el-timeline-item>
        </el-timeline>
        <p v-if="loading" class="loading-text">Loading...</p>
        <p v-if="noMore" class="loading-text">No more</p>
    </div>
</template>

<script>
    export default {
        name: 'GuestBook',
        data() {
            return {
                guestBooks : [],
                loading: false
            }
        },
        computed: {
            noMore() {
                return this.$store.state.guestBook.isLast;
            },
            disabled() {
                return this.loading || this.noMore
            }
        },
        methods: {
            load(page) {
                this.loading = true;
                let pageParam = page === undefined ? this.$store.state.guestBook.page : page;
                console.log(pageParam);
                setTimeout(() => {
                    this.$store.dispatch('getGuestBooks', pageParam).then(() => {
                        this.guestBooks = this.$store.state.guestBook.contents;
                        this.loading = false;
                    });
                }, 2000)
            },

            inputValidation(value) {
                if (value === undefined || value.trim() === '') {
                    return false;
                }

                if (value.length > 20) {
                    return false;
                }

                return value.match(/(<([^>]+)>)/ig) === null;
            },

            open() {
                this.$prompt('감상평을 남겨주세요', '방명록', {
                    confirmButtonText: '작성',
                    cancelButtonText: '취소',
                    inputValidator: this.inputValidation,
                    inputErrorMessage: '잘못된 형식입니다.'
                }).then(({value}) => {
                    this.$store.dispatch('saveGuestBooks', value).then(() => {
                        this.load(0);
                        this.$message({
                            type: 'success',
                            message: '감상평을 작성해주셔서 감사합니다.'
                        });
                    });
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '작성을 취소하였습니다.'
                    });
                });
            }
        },

        mounted () {
            this.load(0);
        },

        beforeRouteUpdate (to, from, next) {
            next();
            this.load(0);
        },
    }
</script>

<style>
    .loading-text {
        text-align: center;
        color: #F56C6C;
    }

    .el-message-box {
        width: 300px !important;
    }

    .el-button--primary {
        background-color: #F56C6C !important;
        border-color: #F56C6C !important;
    }
</style>
