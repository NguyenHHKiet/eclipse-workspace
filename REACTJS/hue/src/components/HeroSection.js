import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import Button from './Button'
import Popup from "reactjs-popup";
import './HeroSection.css'
import Video from './Video';


function HeroSection() {

    return (
        <div className='hero-container'>

            <h1>ADVENTURE AWAITS</h1>
            <p>What are you waiting for?</p>
            <div className='hero-btns'>
                <Button
                    className='btns'
                    buttonStyle='btn--outline'
                    buttonSize='btn--large'
                >
                    <Link to='/services'>GET START</Link>
                </Button>
                <Popup modal trigger={
                    <Button
                        className='btns'
                        buttonStyle='btn--primary'
                        buttonSize='btn--large'
                        onClick={console.log('hey')}
                    >
                        WATCH TRAILER<i className='far fa-play-circle' />
                    </Button>
                }>
                    {close => <Video close={close} />}
                    
                </Popup>
            </div>
        </div>
    )
}

export default HeroSection