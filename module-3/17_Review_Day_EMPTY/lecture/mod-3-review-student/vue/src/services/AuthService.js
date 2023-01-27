import axios from 'axios';

export default {

  login(user) {
    return axios.post('/login', user) //pass along the user object
  },

  register(user) {
    return axios.post('/register', user)
  }

}
