import React, { useState } from 'react';
import { useLocalState } from '../../util/useLocalStorage';

const Login = () => {

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");

    const [jwt, setJwt] = useLocalState("", "jwt");
    console.log(username)
    console.log(password)
    function sendLoginRequest(){
        const user = {
            username: username,
            password: password
        };
          
        fetch("/api/auth/login", {
            "headers": {
                "Content-Type" : "application/json"
            },
            "method": "post",
            "body": JSON.stringify(user)
        }).then((response) => {
            if(response.status === 200)
                return Promise.all([response.json(), response.headers]);
            else 
                return Promise.reject("Invalid login attempt");
        })
        .then(([body,headers]) => {
            setJwt(headers.get("authorization"));
            window.location.href = "/";
        }).catch((message) => {
            alert(message);
        });
    }

    return (
        <>
            <div>
                <label htmlFor='username'>Username</label>
                <input type='text' id='username' value={username} onChange={(e) => {setUsername(e.target.value)}}/>
            </div>
            <div>
                <label htmlFor='password'>Password</label>
                <input type='password' id='password' value={password} onChange={(e) => {setPassword(e.target.value)}}/>
            </div>
            <div>
                <button id='submit' type='button'onClick={() => {sendLoginRequest()}} >Submit</button>
            </div>
        </>
    );
};

export default Login;