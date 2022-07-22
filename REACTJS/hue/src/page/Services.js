import React from 'react'
import CardItem from '../components/CardItem'
import '../components/Cards.css'

function Services() {
  return (
    <>
    <div className='services'><h1>Services</h1></div>
    <div className='cards'>
      <h1>Attractive Hue's Tourism Services!</h1>
      <div className='cards__container'>
        <div className='cards__wrapper'>
          <ul className='cards__items'>
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658389405/thua%20thien%20-%20hue/image-come-to-the-ancient-capital-you-must-listen-to-hue-songs-on-the-huong-river-and-immerse-yourself-in-the-nostalgic-sounds-165225784928908_xwxtyl.jpg'
              text="Boating on the Perfume River - Listening to Hue songs on the Perfume River - It's a wonderful experience in The dragon boat drifts slowly on the Huong Giang river, visitors sitting on ..."
              label='Adventure'
              path='/services'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658389404/thua%20thien%20-%20hue/hue-royal-cuisine-3_mswgey.jpg'
              text="Hue Royal Cuisine - Hue royal cuisine is the quintessential part of Vietnamese cuisine that should be honored, preserved and promoted. It is not only the art of ..."
              label='Luxury'
              path='/services'
            />
          </ul>
          <ul className='cards__items'>
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658389403/thua%20thien%20-%20hue/26-3302-1625232252-13965_mt47ig.jpg'
              text="Watch Hue Royal Music(Nha Nhac) - It's a kind of “scholarly music” to create solemnity for rites and ceremonies in the royal court..."
              label='Mystery'
              path='/services'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658389400/thua%20thien%20-%20hue/cac-co-gai-hue-xinh-dep-sang-chanh-toan-a-hau-nguoi-mau-noi-tien-330bac_zbhbml.jpg'
              text='Narration Tour Guide - Hue Travel Guides: Khiem Cung narrative composed by King Tu Duc about this life, imperial causes, ...'
              label='Adventure'
              path='/services'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658389399/thua%20thien%20-%20hue/caption_hbamfq.jpg'
              text='Traveling Hue by TramCar -  Hue Private Excursions · Deluxe Group Tours · Hidden Land Travel · Adventure Journey · Hue'
              label='Adrenaline'
              path='/services'
            />
          </ul>
          {/* pic2 */}
          <ul className='cards__items'>
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390540/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-22_i5hsf4.jpg'
              text="Place to rest and stop when traveling to Hue"
              label='Adventure'
              path='/services'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390543/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-23_0_cjphdy.jpg'
              text="Vinpearl Hotel Hue 5 star standard"
              label='Luxury'
              path='/services'
            />
          </ul>
          <ul className='cards__items'>
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390540/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-01_0_nxfyen.jpg'
              text="Hue is one of the famous tourist lands, attracting the most tourists in Vietnam"
              label='Mystery'
              path='/services'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390540/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-2_1632726883_a8telh.jpg'
              text='Hue Imperial Citadel'
              label='Adventure'
              path='/services'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390540/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-03_asajow.jpg'
              text='Hue Mausoleum'
              label='Adrenaline'
              path='/services'
            />
          </ul>
          {/* pic03 */}
          <ul className='cards__items'>
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390539/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-04_zaytni.jpg'
              text="Truc Lam Bach Ma Zen Monastery"
              label='Adventure'
              path='/services'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390540/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-05_0_t412qt.jpg'
              text="Perfume River - A tourist destination in Hue that originates a lot of literature"
              label='Luxury'
              path='/services'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390540/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-06_wmjqf4.jpg'
              text="Vong Canh Hill - the destination to see the full beauty of Hue"
              label='Mystery'
              path='/services'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390540/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-01_1632724105_weznaf.jpg'
              text='Ngu Binh Mountain'
              label='Adventure'
              path='/services'
            />
          </ul>
          <ul className='cards__items'>
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390541/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-08_ipmwro.jpg'
              text="Trang Tien Bridge - The symbol of the ancient capital"
              label='Mystery'
              path='/services'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390541/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-09_jtpsbr.jpg'
              text='Hon Chen Palace - Hue tourist destination rich in history'
              label='Adventure'
              path='/services'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390541/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-02_1632724295_tm42lp.webp'
              text='Thien An Hill – Lake Thuy Tien'
              label='Adrenaline'
              path='/services'
            />
          </ul>
          {/* pic04 */}
          <ul className='cards__items'>
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390541/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-11_qtbljz.jpg'
              text="Bach Ma Mountain"
              label='Adventure'
              path='/services'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390541/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-04_1632724613_qnpyt1.jpg'
              text="Hue Quoc Hoc School - a hundred-year-old Hue tourist destination"
              label='Luxury'
              path='/services'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390541/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-13_kawt87.jpg'
              text="Hue Royal Fine Arts Museum"
              label='Adventure'
              path='/services'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390541/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-14_sjhd61.jpg'
              text="Ho Tinh Tam"
              label='Luxury'
              path='/services'
            />
            
          </ul>
          <ul className='cards__items'>
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390542/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-15_hr9gzm.jpg'
              text="Hue garden house - tourist destination symbolizing Hue culture"
              label='Mystery'
              path='/services'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390542/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-16_lckntu.jpg'
              text='The system of Tam Giang lagoons'
              label='Adventure'
              path='/services'
            />
          </ul>
          <ul className='cards__items'>
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390541/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-06_1632725007_sa5pa0.jpg'
              text='Dong Ba Market - the old market in the heart of the city'
              label='Adrenaline'
              path='/services'
            />
            <CardItem
              src='https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658390542/thua%20thien%20-%20hue/dia-diem-du-lich-Hue-20_hoqrhj.jpg'
              text='Nam Giao Dan'
              label='Adrenaline'
              path='/services'
            />
          </ul>
        </div>
      </div>
    </div>
    </>
  )
}

export default Services