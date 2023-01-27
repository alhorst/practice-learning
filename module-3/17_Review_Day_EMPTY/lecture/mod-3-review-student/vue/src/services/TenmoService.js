import axios from 'axios';

export default {

  getBalance() {
    return axios.get('/account/balance')
  },

  getCustomers() {
    return axios.get('/customers') //remember to check backend for the correct endpoints and to check auth
  }

}
