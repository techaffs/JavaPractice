import { useParams } from 'react-router-dom';
import { useState } from 'react';
import './api/HelloWorldApiService';
// import { getHelloWorldBean } from './api/HelloWorldApiService';

export default function WelcomeComponent(){
    const {username} = useParams();

    const [message, setMessage] = useState(null);

    // function callHelloWorldRestAPI(){
    //     console.log('Called Hello World');
    //     getHelloWorldBean()
    //         .then(response => setMessage(response.data.message))
    //         .catch(error => console.log(error))
    //         .finally(()=>console.log('Finally called'));
    // }

    return( 
        <div className="welcome">
            <h1>Welcome {username} to Todo Management Application</h1>
            {/* <div>
                <button className='btn btn-success m-5' onClick={callHelloWorldRestAPI}>Call Hello World</button>
            </div> */}
            <div className='text-info'>
                <div>
                    {message}
                </div>
            </div>
        </div>
        
    )
}