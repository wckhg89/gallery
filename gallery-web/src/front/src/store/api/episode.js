import axios from 'axios'

export function getEpisode(episodeId) {
    return axios.get('/api/episodes/' + episodeId);
}