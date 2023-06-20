import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { useLocalState } from '../../util/useLocalStorage';

export default function Home() {

    const [jwt, setJwt] = useLocalState("", "jwt");

    useEffect(() => {
        console.log(`JWT is ${jwt}`);
    }, [jwt]);

  return (
    <div>
        <div>
            Home Page
            test
        </div>
    </div>
  )
}
