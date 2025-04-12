import { createContext, useContext, useState } from "react";
import { executeJwtAuth } from "../api/AuthApiService";
import { apiClient } from "../api/ApiClient";

// Create a context for the authentication
const AuthContext = createContext();

const useAuth = () => {
    return useContext(AuthContext);
}

//Put some state in the context
//Share the created context with other components

const AuthProvider = ({ children }) => {
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [username, setUserName] = useState(null);
    const [token, setToken] = useState(null);

    // function login (username, password) {
    //     if(username === 'learningByDoing' && password === 'password'){
    //         setIsAuthenticated(true);
    //         setUserName(username);
    //         return true;
    //     }
    //     else{
    //         setIsAuthenticated(false);
    //         setUserName(null);
    //         return false;
    //     }
    // }

    // async function login(username, password) {

    //     const baToken = 'Basic ' + window.btoa(username + ":" + password);

    //     try{
    //         const response = await executeBasicAuth(baToken);
            
    //         if(response.status === 200){
    //             setIsAuthenticated(true);
    //             setUserName(username);
    //             setToken(baToken);

    //             apiClient.interceptors.request.use( // Once loggedin successfully, add the token to the request header                                                     
    //                 (config) => {                   // and every api call will have the token
    //                     config.headers.Authorization = baToken;
    //                     return config;
    //                 }
    //             );

    //             return true;
    //         }
    //         else{
    //             logout();
    //             return false;
    //         }
    //     }catch (error) {
    //         console.log(error);
    //         logout();
    //         return false;
    //     }
    // }

    async function login(username, password) {

        try{
            const response = await executeJwtAuth(username, password);
            
            if(response.status === 200){

                const jwtToken = 'Bearer ' + response.data.token;

                setIsAuthenticated(true);
                setUserName(username);
                setToken(jwtToken);

                apiClient.interceptors.request.use( // Once loggedin successfully, add the token to the request header                                                     
                    (config) => {                   // and every api call will have the token
                        config.headers.Authorization = jwtToken;
                        return config;
                    }
                );

                return true;
            }
            else{
                logout();
                return false;
            }
        }catch (error) {
            console.log(error);
            logout();
            return false;
        }
    }

    function logout () {
            setIsAuthenticated(false);
            setUserName(null);
            setToken(null);
    }
    
    return (
        <AuthContext.Provider value={{isAuthenticated, username, login, logout, token}}>
            {children}
        </AuthContext.Provider>
    )
}

export { AuthContext, AuthProvider, useAuth };