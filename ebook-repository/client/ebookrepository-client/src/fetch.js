import axios from 'axios'

const BASE_URL = 'http://localhost:8080/api/';

export const get = (url, config = {}) => {
    url = getFullUrl(url)
    return axios.get(url, config);
}

export const post = (url, data, config = {}) => {
    url = getFullUrl(url)
    return axios.post(url, data, config);
}

export const postFile = (url, file, config = {}) => {
    Object.assign(config, {
        headers: {
            'Content-Type': 'multipart/form-data',
        }
    });
    const formData = new FormData();
    formData.append('file', file);
    return post(url, formData, config);
}

const getFullUrl = (relativeUrl) => `${BASE_URL}${relativeUrl}`