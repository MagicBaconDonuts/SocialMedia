import axios from 'axios'
import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'

export default function Home() {
  let navigate = useNavigate();
  const [user, setUser] = useState({
    username:"",
    name:"",
    lastName:"",
    password:""
  })
  const{username,name,lastName,password} = user

  const onInputChange = (e) => {
    setUser({...user, [e.target.name]: e.target.value})
  }

  const onSubmit = async(e) => {
    e.preventDefault();
    await axios.post("create-user", user)
    navigate("/")
  }
  return (
    <div>
        <div>
            Home/Register
        </div>
        <form onSubmit={(e) => onSubmit(e)}>
            <div>
                <label>UserName</label>
                <input type='text' placeholder='Enter your Username' name='username' value={username} onChange={(e) => {onInputChange(e)}}/>
            </div>
            <div>
                <label>Name</label>
                <input type='text' placeholder='Enter your Name' name='name' value={name} onChange={(e) => {onInputChange(e)}}/>
            </div>
            <div>
                <label>Last Name</label>
                <input type='text' placeholder='Enter your Last name' name='lastName' value={lastName} onChange={(e) => {onInputChange(e)}}/>
            </div>
            <div>
                <label>Password</label>
                <input type='password' placeholder='Enter your Password' name='password' value={password} onChange={(e) => {onInputChange(e)}}/>
            </div>
            <button type='submit'>Submit</button>
        </form>
        
    </div>
  )
}
