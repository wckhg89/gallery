<template>
    <div class="block">
        <el-button icon="el-icon-edit" circle @click="open"></el-button>
        <el-timeline
                v-infinite-scroll="load"
                infinite-scroll-disabled="disabled">
            <el-timeline-item
                    v-for="i in count"
                    timestamp="2018/4/12" placement="top" color="#F56C6C">
                <el-card>
                    <h4>Update Github template</h4>
                    <p>Tom committed 2018/4/12 20:46</p>
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
                count: 10,
                loading: false
            }
        },
        computed: {
            noMore() {
                return this.count >= 20
            },
            disabled() {
                return this.loading || this.noMore
            }
        },
        methods: {
            load() {
                this.loading = true;
                setTimeout(() => {
                    this.count += 2;
                    this.loading = false
                }, 2000)
            },
            open() {
                this.$prompt('감상평을 남겨주세요', '방명록', {
                    confirmButtonText: '작성',
                    cancelButtonText: '취소',
                    inputPattern: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/,
                    inputErrorMessage: '글을 작성해주세요'
                }).then(({value}) => {
                    this.$message({
                        type: 'success',
                        message: '감상평을 작성해주셔서 감사합니다.'
                    });
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '작성을 취소하였습니다.'
                    });
                });
            }
        }
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
