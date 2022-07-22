import React from 'react'
import HeroSection from '../components/HeroSection'
import Cards from '../components/Cards'
import '../components/Cards.css'
import Gallery from './Gallery'
import PhotoAlbum from "react-photo-album"

function Home() {
  const hue = [
    {
        src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658404025/thua%20thien%20-%20hue/images_hhqddw.jpg",
        width: 700,
        height: 400
    },
    {
      src: "https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658404060/thua%20thien%20-%20hue/t%E1%BA%A3i_xu%E1%BB%91ng_1_pb45cy.jpg",
      width: 700,
      height: 400
  }];
  return (
    <>
      <HeroSection />
      <div className='desc'>
        <div className='cards'>
          <h1>Check in HUE !</h1>
          <div className='cards__container'>
            <div className='cards__wrapper'>
              <ul className='cards__items'>
                <div className='cards__item__info'>
                  <h2 className='cards__item__text'>
                    Hue is a city chock-full of stories. The Kings of the Nguyen Dynasty built their feudal capital along Hue’s fertile riverbanks and atop its forested hills, but their imperial legacy is just one of many reasons to visit. Hue’s refined cuisine is the stuff of legend, and its leafy streets are lined with mossy pagodas, art déco mansions, and eye-popping markets. Through the whole scene flows the Perfume River, setting a languid pace the rest of the city is happy to follow.<br/><br/>
                    Hue is one of the Buddhist sites, and vegetarian meals are much preferable at this place. The chefs try to reproduce the flavor of every dish in a different way. The non-vegetarian menu also comprises grilled meat and fish sauce. Seafoods are also tastier as the chefs maintain a salt balance, and add herbs, such as, citronella and mint. Though other places in Vietnam have also these foods, there is something diverse in Hue. The dessert lovers have also a good chance of enjoying sweet rice, sweet flavored bean soup or soup with lotus seeds. So, taste these royal foods, while listening to music.
                  </h2>
                </div>
              </ul>
              <ul className='cards__items'>
                <iframe className='cards__container' title="vimeo-player" src="https://player.vimeo.com/video/421421459?h=e915da8498" width="840" height="560" frameborder="0" allowfullscreen></iframe>
              </ul>
              <ul className='cards__items'>
                <div className='cards__container'>
                  <h4>Click the image below for a 360-degree tour of Hue</h4>
                  <a target="_blank" href="https://vietnam.travel/sites/default/files/360Tour/Hue/index.htm">
                    <img className='thumb' src="https://res.cloudinary.com/dhyyyqwaf/image/upload/v1658372819/thua%20thien%20-%20hue/socialThumbnail2_v7ik2o.jpg" />
                  </a>
                </div>
              </ul>
              <hr />
            </div>
            <h3><strong>Top things to do in Hue</strong></h3>
            <div className='col-text'>
              <p><strong>See Imperial Vietnam</strong></p>
              <p>Get acquainted with Vietnam’s last royal dynastic family by exploring what survives of their 143-year reign. Roam the palaces, pavilions and theatres of the Hue Citadel and make time to visit the tombs of emperors Tu Duc, Minh Mang and Khai Dinh.</p>
              <p><strong>Eat like a king</strong></p>
              <p>You’re never far from a world-class meal in Hue. Nose around the flapping-fresh produce at Dong Ba Market for a teaser, then whet your appetite with Hue’s much-loved snacks, such as Banh Khoai&nbsp;and Banh Beo.</p>
              <p><strong>Explore the city's Buddhist roots</strong></p>
              <p>Hue’s serene atmosphere is most penetrating in its pagodas and monasteries. See the iconic seven-tiered tower of Thien Mụ Pagoda, then pay a visit to Tu Hieu Monastery, where Thich Nhat Hanh spent his days as a novice monk.</p>
              <p><strong>Cycle in the rice paddies&nbsp;&nbsp;</strong></p>
              <p>Hue’s photogenic streets and lush countryside are a wonderland for casual cyclists. The ride to the tile-roofed Thanh Toan Bridge is one of Hue’s most captivating, winding past vegetable farms, footbridges, and flocks of ducks.</p>
              <p><strong>Revisit colonial history &nbsp;&nbsp;</strong></p>
              <p>Travellers with an eye for architecture will enjoy seeing what remains of French influence in Hue. Stroll down Le Loi to encounter the art déco lines of La Residence Hotel, and the stately crimson buildings of Quoc Hoc High School.</p>
              <hr />
            </div>
            <h5 className='title'><strong>Hue Weather</strong></h5>
            <div className='col-text' id="when-to-go">
              <p>Hue’s springtime months, from February to the end of April, show the historic capital in its best light. In June and July, prepare for scorching days as heat and humidity rise. The rains come in August and can last through January. Note that Hue often sees some flooding, usually from October to late in the year.</p>
            </div>
            <h5 className='title'><strong>Hue Transport</strong></h5>
            <div className='col-text' id="how-to-get-there">
              <p>Domestic flights from Hanoi and Ho Chi Minh City touchdown in Hue’s Phu Bai Airport, a 30-minute drive from the city. Travellers also can hitch a train to Hue on the Reunification Express line, ride the open bus or hire a private car from the international airport in Da Nang, two hours away. If you want to spend the day exploring the Citadel, riverside and central town just walk or consider hiring a cyclo for the day. For visiting the Imperial Tombs, taxis are available, or you can hop on a bicycle.</p>
              <PhotoAlbum layout="columns" photos={hue} />
              <hr />
              <p>&nbsp;</p>
            </div>
          </div>
        </div>
      </div>
      <Gallery/>
      <Cards />
    </>
  )
}

export default Home