import React from 'react';
import { useLocalState } from '../../util/useLocalStorage';
import { Navigate } from 'react-router-dom';
// We want the private route to allow us threw to render the children if we are authenticated and if we arn't login we want to rediret to login
const PrivateRoute = ({children}) => {
    const [jwt, setJwt] = useLocalState("", "jwt");
    return jwt ? children : <Navigate to="/login"/>;
};

export default PrivateRoute;