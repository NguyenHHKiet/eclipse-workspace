import React from 'react'
import './Video.css'

function Video({close}) {
    return (
        <div className="modal">
            <a className="close" onClick={close}>
                &times;
            </a>
            <div className="content">
            {" "}
                <iframe src="https://player.vimeo.com/video/426874407?h=61a51f8a4a&title=0&byline=0&portrait=0" width="1280" height="720" frameborder="0" allow="autoplay; fullscreen; picture-in-picture" allowfullscreen></iframe>
            </div>
        </div>
    )
}

export default Video