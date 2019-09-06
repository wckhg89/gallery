import _ from 'lodash'
import {getGuestBooks, saveGuestBooks} from '../api/guestBook'

const guestBook = {
    state: {
        contents: [],
        isLast: false,
        page: 0,

    },
    mutations: {

        EMPTY_GUEST_BOOK_CONTENTS: (state) => {
            state.contents = [];
        },

        SET_GUEST_BOOK_CONTENTS: (state, contents) => {
            console.log(state.contents);
            state.contents = _.concat(state.contents, contents);
        },

        SET_GUEST_BOOK_IS_LAST: (state, isLast) => {
            state.isLast = isLast;
        },

        SET_GUEST_BOOK_PAGE: (state, page) => {
            if (!state.isLast) {
                state.page = page + 1;
            }
        },
    },
    actions: {
        saveGuestBooks({commit}, content) {
            return new Promise((resolve, reject) => {
                saveGuestBooks(content)
                    .then(resp => {
                        if (resp.status !== 200) {
                            reject('Invalid status', resp.status);
                        }

                        resolve(resp);
                    })
                    .catch(err => {
                        reject(err);
                    });
            })
        },

        getGuestBooks({commit}, page) {
            return new Promise((resolve, reject) => {
                getGuestBooks(page)
                    .then(resp => {
                        if (resp.status !== 200) {
                            reject('Invalid status', resp.status);
                        }

                        if (page === 0) {
                            commit('EMPTY_GUEST_BOOK_CONTENTS');
                        }

                        commit('SET_GUEST_BOOK_CONTENTS', resp.data.content);
                        commit('SET_GUEST_BOOK_IS_LAST', resp.data.last);
                        commit('SET_GUEST_BOOK_PAGE', resp.data.number);
                        resolve(resp);
                    })
                    .catch(err => {
                        reject(err);
                    });
            })
        },
    },
};

export default guestBook
