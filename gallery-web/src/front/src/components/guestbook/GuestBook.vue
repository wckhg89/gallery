<template>
    <div class="block">
        <el-button icon="el-icon-edit" circle @click="open"></el-button>
        <el-timeline
                v-infinite-scroll="load"
                infinite-scroll-disabled="disabled">
            <el-timeline-item
                    v-for="(guestBook, idx) in guestBooks"
                    :timestamp="guestBook.createdAt" placement="top" color="#F56C6C">
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
                guestBooks : [
                    {
                        content: 'blah.blah.blah.blah.blah.blah.',
                        createdAt: '2019/09/05 20:46'
                    },
                    {
                        content: 'blah.blah.blah.blah.blah.blah.',
                        createdAt: '2019/09/05 20:46'
                    },
                    {
                        content: 'blah.blah.blah.blah.blah.blah.',
                        createdAt: '2019/09/05 20:46'
                    },
                    {
                        content: 'blah.blah.blah.blah.blah.blah.',
                        createdAt: '2019/09/05 20:46'
                    },
                ],
                loading: false
            }
        },
        computed: {
            noMore() {
                return true;
            },
            disabled() {
                return this.loading || this.noMore
            }
        },
        methods: {
            load() {
                this.loading = true;
                setTimeout(() => {
                    // this.guestBooks.length += 2;
                    this.loading = false
                }, 2000)
            },
            open() {
                this.$prompt('감상평을 남겨주세요', '방명록', {
                    confirmButtonText: '작성',
                    cancelButtonText: '취소',
                    // inputPattern: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/,
                    inputErrorMessage: '글을 작성해주세요'
                }).then(({value}) => {
                    console.log(value);
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
