import axios from 'axios'

export function getGuestBooks (page) {
    return axios.get('/api/guestbooks', {
        params: {
            page: page,
            size: 10,
            sort: 'createdDate,DESC'
        }
    });
}

export function saveGuestBooks(content) {
    return axios({
        url: '/api/guestbooks',
        method: 'post',
        data : {
            content: content
        }
    });
}