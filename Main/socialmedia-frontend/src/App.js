import './App.css';
import { Routes, Route } from 'react-router-dom';
import Home from './Routes/home/home.component';

function App() {
  return (
    <Routes>
      <Route path='/' element={<Home/>}>

      </Route>
    </Routes>
  );
}

export default App;
