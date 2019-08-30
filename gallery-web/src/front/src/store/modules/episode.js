import {getEpisode} from '../api/episode'

const episode = {
    state: {
        episodeId: '',
        episodeName: '',
        episodeDescription: '',
        images: [],
    },
    mutations: {
        SET_EPISODE_ID: (state, episodeId) => {
            state.episodeId = episodeId;
        },

        SET_EPISODE_NAME: (state, episodeName) => {
            state.episodeName = episodeName;
        },

        SET_EPISODE_DESCRIPTION: (state, episodeDescription) => {
            state.episodeDescription = episodeDescription;
        },

        SET_EPISODE_IMAGES: (state, images) => {
            state.images = images;
        },
    },
    actions: {
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
