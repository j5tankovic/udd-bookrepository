import axios from 'axios';

export default () => {
  axios.interceptors.request.use(config => {
    const id = localStorage.userId;
    if (id) {
      config.headers.common['X-USER'] = id;
    }
    return config;
  }, error => Promise.reject(error));
}