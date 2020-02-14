import axios from 'axios'

export function getEpisodeInfos () {
    return axios.get('/api/episodes/info');
}

export function getEpisodeDetail(episodeId) {
    return axios.get('/api/episodes/' + episodeId);
}

export function saveEpisodeDetail(episodeId, imageIndex) {
    return axios.post('/api/episodes/' + episodeId + '/' + imageIndex);
}