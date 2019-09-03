import {getEpisode, getEpisodeInfos} from '../api/episode'

const episode = {
    state: {
        info: [],
        episode: {
            episodeId: '',
            episodeName: '',
            episodeDescription: '',
            images: [],
        },

    },
    mutations: {
        SET_EPISODE_INFO: (state, info) => {
            state.info = info;
        },
        SET_EPISODE_ID: (state, episodeId) => {
            state.episode.episodeId = episodeId;
        },

        SET_EPISODE_NAME: (state, episodeName) => {
            state.episode.episodeName = episodeName;
        },

        SET_EPISODE_DESCRIPTION: (state, episodeDescription) => {
            state.episode.episodeDescription = episodeDescription;
        },

        SET_EPISODE_IMAGES: (state, images) => {
            state.episode.images = images;
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

        getEpisode({commit}, episodeId) {
            return new Promise((resolve, reject) => {
                getEpisode(episodeId)
                    .then(resp => {
                        if (resp.status !== 200) {
                            reject('Invalid status', resp.status);
                        }

                        commit('SET_EPISODE_ID', resp.data.episodeId);
                        commit('SET_EPISODE_NAME', resp.data.episodeName);
                        commit('SET_EPISODE_DESCRIPTION', resp.data.episodeDescription);
                        commit('SET_EPISODE_IMAGES', resp.data.images);

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
