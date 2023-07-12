import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { useLocalState } from '../../util/useLocalStorage';

export default function Home() {

    const [jwt, setJwt] = useLocalState("", "jwt");
    const [channels, setChannels] = useState(null);
    useEffect(() => {
      fetch("api/channels", {
        headers: {
          "Content-type": "application/json",
          "Authorization": `Bearer ${jwt}`
        },
        method: "GET"
      })
      .then((response) => {
        if (response.status === 200) return response.json();
      })
      .then((channelsData) => {
        console.log(channelsData);
        setChannels(channelsData);
      })
    })

    function createChannel(){
      fetch("/api/channels", {
        headers:{
          "Content-Type": "application/json",
          "Authorization": `Bearer ${jwt}`
        },
        "method": "POST"
      })
        .then((response) => {
          console.log(response);
          if (response.status === 200) return response.json();
        })
        .then((channel) => {
          // window.location.href = `/channels/${channel.id}`
          console.log(channel);
        });
    }

  return (
    <div>
        <div>
            Home Page
        </div>
        <div>
          {channels ? channels.map( (channel, i ) => <div key={i}>
            Channel Room Name: {channel.name};
          </div>)  : <></>}
        </div>
        <button onClick={() => {createChannel()}} >Create Channel</button>
    </div>
  )
}
