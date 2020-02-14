import {
    getEpisodeDetail,
    saveEpisodeDetail,
    getEpisodeInfos,
} from '../api/episode'

const episode = {
    state: {
        info: [],
        detail: {},
    },
    mutations: {
        SET_EPISODE_INFO: (state, info) => {
            state.info = info;
        },

        SET_EPISODE_DETAIL: (state, detail) => {
            state.detail = detail;
        },
    },
    actions: {
        getEpisodeInfos({commit}) {
            return new Promise((resolve, reject) => {
                getEpisodeInfos()
                    .then(resp => {
                        if (resp.status !== 200) {
                            reject('Invalid status', resp.status);
                        }

                        commit('SET_EPISODE_INFO', resp.data);
                        resolve(resp);
                    })
                    .catch(err => {
                        reject(err);
                    });
            })
        },

        getEpisodeDetail({commit}, episodeId) {
            return new Promise((resolve, reject) => {
                getEpisodeDetail(episodeId)
                    .then(resp => {
                        if (resp.status !== 200) {
                            reject('Invalid status', resp.status);
                        }

                        commit('SET_EPISODE_DETAIL', resp.data);

                        resolve(resp);
                    })
                    .catch(err => {
                        reject(err);
                    });
            })
        },

        saveEpisodeDetail({commit}, params) {
            return new Promise((resolve, reject) => {
                saveEpisodeDetail(params.episodeId, params.imageId)
                    .then(resp => {
                        if (resp.status !== 200) {
                            reject('Invalid status', resp.status);
                        }

                        commit('SET_EPISODE_DETAIL', resp.data);

                        resolve(resp);
                    })
                    .catch(err => {
                        reject(err);
                    });
            })
        },
    },
};

export default episode
