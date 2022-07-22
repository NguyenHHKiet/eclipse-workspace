import React from 'react';
import './App.css';
import { HashRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Home from './page/Home';
import Services from './page/Services';
import Histories from './page/Histories';
import SignUp from './page/SignUp';
import Footer from './components/Footer'
import ServicesDetail from './page/ServicesDetail';

function App() {
  return (
    <>
    <Router>
      <Navbar/>
      <Routes>
        <Route path='/' exact element={<Home/>} />
        <Route path='/services' element={<Services/>} />
        <Route path='/services/:id' element={<ServicesDetail/>} />
        <Route path='/histories' element={<Histories/>} />
        <Route path='/sign-up' element={<SignUp/>} />
      </Routes>
      <Footer/>
    </Router>
    </>
  );
}

export default App;
