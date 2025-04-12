import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useAuth } from './security/AuthContext';

export default function LoginComponent(){

    const [username, setUsername] =  useState('learningByDoing')

    const [password, setpassword] =  useState('password')

    const [showErrorMessage, setShowErrorMessage] =  useState(false)

    const navigate = useNavigate();

    const authContext = useAuth();

    function handleUsernameChange(event){
        setUsername(event.target.value);
    }

    function handlePasswordChange(event){
        setpassword(event.target.value);
    }

    async function handleSubmit(){
        if(await authContext.login(username, password)){
            navigate(`/welcome/${username}`);
        }
        else{
            setShowErrorMessage(true);
        }
    }

    return( 
        <div className="login">
            <div className='loginForm'>
                <div>
                    <label>User Name: </label>
                    <input type="text" id="username" className="username" value={username} onChange={handleUsernameChange} />
                </div>
                <div>
                    <label htmlFor="password">Password: </label>
                    <input type="password" id="password" className="password" value={password} onChange={handlePasswordChange}/>
                </div>
                <div>
                    <button className='loginbutton' onClick={handleSubmit}>Login</button>
                </div>
            </div>
            {showErrorMessage && <div className='errorMessage'> Authentication failed! Please check your credentials.</div>}
        </div>
    )
}