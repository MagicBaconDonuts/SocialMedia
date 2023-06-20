import './App.css';
import { Routes, Route } from 'react-router-dom';
import Home from './Routes/home/home.component';
import Login from './Components/login/login.component';
import PrivateRoute from './Components/private-route/private-route.component';

function App() {
  return (
    <Routes>
      <Route path='/' element={
      <PrivateRoute>
        <Home/>
      </PrivateRoute>}/>
      <Route path='/login' element={<Login/>}/>
    </Routes>
  );
}

export default App;
