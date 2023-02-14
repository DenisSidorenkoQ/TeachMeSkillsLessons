import axios from 'axios';
import {User} from "../model/UserState";

class UserService {
    getSession(): Promise<User[]> {
        return axios.get<User[]>(
            'http://localhost:8080/api/v1/users'
        ).then(response => response.data);
    }
}

export default new UserService();
