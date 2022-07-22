import React from 'react'
import PhotoAlbum from "react-photo-album"
import '../components/Cards.css'
import './Gallery.css'

function Gallery() {
    const photos = [
        {
            src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658386438/thua%20thien%20-%20hue/gallery/Hue_Craft_Villages_Vietnam_Tourism_qztdjc.jpg",
            width: 900,
            height: 600
        },
        {
            src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658386438/thua%20thien%20-%20hue/gallery/Hue_Cuisine_Vietnam_Tourism_lvhnkn.jpg",
            width: 900,
            height: 600
        },
        {
            src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658386438/thua%20thien%20-%20hue/gallery/Gia_Long_Tomb_Hue_Vietnam_Tourism_ehp8y1.jpg",
            width: 900,
            height: 600
        },
        {
            src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658386438/thua%20thien%20-%20hue/gallery/Hue_Craft_Festival_Vietnam_Tourism_aw5v7g.jpg",
            width: 900,
            height: 600
        },
        {
            src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658386437/thua%20thien%20-%20hue/gallery/Tu_Duc_Tomb_Hue_Vietnam_Tourism_w36tmv.jpg",
            width: 900,
            height: 600
        },
        {
            src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658386437/thua%20thien%20-%20hue/gallery/Nguyen_Dynasty_Hue_Vietnam_Tourism_djxqvv.jpg",
            width: 900,
            height: 600
        },
        {
            src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658386437/thua%20thien%20-%20hue/gallery/Cyclo_Rides_Hue_Vietnam_Tourism_bxffug.jpg",
            width: 900,
            height: 600
        },
        {
            src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658386437/thua%20thien%20-%20hue/gallery/Minh_Mang_Tomb_Hue_Vietnam_Tourism_k7arfc.jpg",
            width: 900,
            height: 600
        },
        {
            src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658386437/thua%20thien%20-%20hue/gallery/Tu_Hieu_Pagoda_Hue_Vietnam_Tourism_q1zqde.jpg",
            width: 900,
            height: 600
        },
        {
            src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658386437/thua%20thien%20-%20hue/gallery/Khai_Dinh_Tomb_Hue_Vietnam_Tourism_lvcduv.jpg",
            width: 900,
            height: 600
        },
    ];
    return (
        <section id='gallery' data-module="gallery">
            <div className='container-fluid'>
                <div className='cards__container'>
                    <h2 className='section-heading text-uppercase gothambold'>Gallery</h2>
                    <PhotoAlbum layout="columns" photos={photos} />
                </div>
            </div>
        </section>
    )
}

export default Gallery