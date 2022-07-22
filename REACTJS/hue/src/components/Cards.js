import React from 'react'
import CardItem from './CardItem'
import './Cards.css'

function Cards() {
  return (
    <div className='cards'>
      <h1>Check out these TrlHue Destinations!</h1>
      <div className='cards__container'>
        <div className='cards__wrapper'>
          <ul className='cards__items'>
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658369483/thua%20thien%20-%20hue/anh_hue_ve_dem_ptdfpq.jpg'
              text="Trang Tien Bridge - Hue's beautiful historical witness"
              label='Adventure'
              path='/histories'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658369482/thua%20thien%20-%20hue/Khamphahue_Quan-the-di-tich-co-do-hue_rhikcg.jpg'
              text="Hue Imperial Citadel - Discover the history of the Nguyen Dynasty's palace"
              label='Luxury'
              path='/histories'
            />
          </ul>
          <ul className='cards__items'>
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658367992/thua%20thien%20-%20hue/Best-things-to-do-in-Hue-Vietnam-Thien-Mu-Pagoda_zzhejb.jpg'
              text='Thien Mu Pagoda in Hue - Discover the 400-year-old sacred temple'
              label='Mystery'
              path='/histories'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658299938/thua%20thien%20-%20hue/Hue_Travel_Guide_Vietnam_Tourism_0_jcibmd.jpg'
              text='Tomb of Tu Duc - The unique beauty of the architecture of the Nguyen Dynasty'
              label='Adventure'
              path='/histories'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658371026/thua%20thien%20-%20hue/50021204548_707b68dc8e_h_AEBR_pkspfe.jpg'
              text='Ngo Mon Gate, Hue: Echoes of the Old Imperial Day'
              label='Adrenaline'
              path='/histories'
            />
          </ul>
        </div>
      </div>
    </div>
  )
}

export default Cards