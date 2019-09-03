import axios from 'axios'

export function getEpisodeInfos () {
    return axios.get('/api/episodes/info');
}

export function getEpisode(episodeId) {
    return axios.get('/api/episodes/' + episodeId);
}